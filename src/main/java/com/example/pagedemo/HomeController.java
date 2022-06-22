package com.example.pagedemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "home";
    }

    @RequestMapping("/pagedemo")
    public String jspPage(Model model){
//        model.addAttribute("name", "springboot1234");

        return "home";
    }
}
