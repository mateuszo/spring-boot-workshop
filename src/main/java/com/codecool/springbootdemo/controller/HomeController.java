package com.codecool.springbootdemo.controller;

import com.codecool.springbootdemo.model.Guest;
import com.codecool.springbootdemo.repository.GuestRepository;
import com.codecool.springbootdemo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/add/{name}")
    String add(@PathVariable String name, Model model){

        Guest guest = new Guest();
        guest.setName(name);

        guestRepository.save(guest);

        model.addAttribute("name", greetingService.greet(name));
        return "layout";
    }

    @GetMapping("/list")
    String list(Model model){
        List<Guest> guestList = guestRepository.findAll();
        model.addAttribute("guests", guestList);
        return "guestList";
    }

    @GetMapping("/list/{start}")
    String listByName(@PathVariable String start, Model model){
        List<Guest> guestList = guestRepository.findByNameStartingWith(start);
        model.addAttribute("guests", guestList);
        return "guestList";
    }
}
