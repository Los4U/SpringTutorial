package tutorial.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        if (bindingResult.hasErrors()){
            return "student-form";
        }else{
            return "student-confirmation";
        }
    }
}


