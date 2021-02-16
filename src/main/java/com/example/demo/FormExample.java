package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class FormExample {
    @GetMapping(value = "/form-test")
    public String renderForm() {
        return "form";
    }

    @GetMapping(value="/list")
    @ResponseBody
    public ArrayList renderList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        list.add("orange");

        // This list gets returned as json!
        return list;
    }

    @GetMapping(value = "hello-world")
    public String renderHelloWorld() {
        return "hello-world.html";
    }

    @GetMapping(value = "/product")
    public String renderProduct(Model model) {
        String title = "Television";
        int price = 1000;
        ArrayList<String> features = new ArrayList<>();
        features.add("HD");
        features.add("Smart TV");
        features.add("Netflix");

        model.addAttribute("title", title);
        model.addAttribute("price", price);
        model.addAttribute("features", features);

        return "product.html";
    }
}
