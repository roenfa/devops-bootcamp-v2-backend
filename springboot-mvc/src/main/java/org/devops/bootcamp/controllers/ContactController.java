package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.ContactEntry;
import org.devops.bootcamp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/getAllContacts")
    public ModelAndView getAllContactEntries() {
        ModelAndView mv= new ModelAndView();
        List<ContactEntry> entries= contactService.findAll();
        mv.addObject("entries", entries);
        mv.setViewName("getAllContacts.jsp");

        return mv;
    }

}
