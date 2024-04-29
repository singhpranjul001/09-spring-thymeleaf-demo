package com.practice.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //create a controller method to show the form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //create a controller method to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //need a controller method to read form data and
    //also add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String upperCase(HttpServletRequest request, Model theModel){
        //read the request parameters from the HTML form
        String theName= request.getParameter("studentName");

        //convert to all uppercase
        theName.toUpperCase();

        //create a message
        String result="What's up! " +theName;

        //add the message to the model
        theModel.addAttribute("message",result);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String upperCaseVersion2(@RequestParam("studentName") String theName,
                                    Model theModel){
        //convert to all uppercase
        theName.toUpperCase();

        //create a message
        String result="What's up brother!!  " +theName;

        //add the message to the model
        theModel.addAttribute("message",result);

        return "helloworld";
    }
}
