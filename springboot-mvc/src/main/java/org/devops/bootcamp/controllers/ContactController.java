package org.devops.bootcamp.controllers;

import org.devops.bootcamp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/read-contact")
    public String showReadContactPage(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return "reading contacts";
    }

}
