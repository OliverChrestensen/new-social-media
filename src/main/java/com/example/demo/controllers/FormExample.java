package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class FormExample {
    private ArrayList<String> stringArrayList = new ArrayList<>();
    // Showing how to create a form using thymeleaf
    @GetMapping(value = "/submit")
    public String renderForm() {
        return "form";
    }

    @PostMapping(value = "/submit-post")
    public String createNewPost(@RequestParam ("title") String title, RedirectAttributes attributes) {
        attributes.addAttribute("title",title);
        //stringArrayList.add(title);
        return ("redirect:/dashboard");
    }

    @GetMapping(value="/dashboard")
    @ResponseBody
    public String renderList(@RequestParam String title) {
        // This list gets returned as json!
        return "The title of the post is: " + title;
    }
}
