package tutorial.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HelloWorldController {

    @GetMapping(value = "/")
    public String start(){
        System.out.println("main site");
        return "start";
    }

    @GetMapping(value = "/showForm")
    public String showForm(){
        return "helloworld-form";
    }


    @GetMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent){
        System.out.println(theStudent);
        return "helloworld";
    }


//    @GetMapping("/processForm")
//    public String processForm(@RequestParam("studentName") String thaName, Model model){
//        String result = "hej:" + thaName.toUpperCase();
//        model.addAttribute("message", result);
//        return "helloworld";
//    }


//    @GetMapping("/processForm")
//    public String processForm(HttpServletRequest request, Model model){
//        String result = request.getParameter("studentName").toUpperCase();
//        model.addAttribute("message", result);
//        return "helloworld";
//    }
}
