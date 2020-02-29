package org.example;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @RequestMapping("/")
    public ModelAndView main(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }
    @PostMapping("/put-message")
    public void post(@RequestBody String someMessage){
        String some = someMessage;
    }
}
