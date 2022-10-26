package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.ContactEntry;
import org.devops.bootcamp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/list-contacts")
    public ModelAndView getAllContactEntries() {
        ModelAndView mv = new ModelAndView();
        List<ContactEntry> contacts = contactService.findAll();
        mv.addObject("contacts", contacts);
        mv.setViewName("list-contacts");

        return mv;
    }

    @RequestMapping("/create-contact")
    public String showCreateContactPage(Model model) {
        model.addAttribute("command", new ContactEntry());
        return "create-contact";
    }

    @RequestMapping(value = "/create-contact", method = RequestMethod.POST)
    public String createContact(@ModelAttribute("contact") ContactEntry contact) {
        contactService.saveContact(contact);
        return "redirect:/list-contacts";
    }

    @RequestMapping(value = "/delete-contact/{id}", method = RequestMethod.GET)
    public String deleteContact(@PathVariable("id") Integer id){
        contactService.deleteById(id);
        return "redirect:/list-contacts";
    }
}
