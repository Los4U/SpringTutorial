package tutorial.demo;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import tutorial.demo.entity.Student;

import javax.validation.Valid;

@Controller
@RequestMapping("student")
public class StudentController {

    @GetMapping("/showForm")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("student")
                                          Student theStudent, BindingResult bindingResult) {

        System.out.println("Binding Result" + bindingResult);
        if (bindingResult.hasErrors()){
            return "student-form";
        }else{
            if(theStudent.getPostCode().length() == 5){
                String part1 = theStudent.getPostCode().substring(0, 2);
                String part2 = theStudent.getPostCode().substring(2, 5);

                theStudent.setPostCode( part1 + "-" + part2);
            }

            return "student-confirmation";
        }
    }

    @InitBinder
    public void initBinding(WebDataBinder databinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        databinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


}


