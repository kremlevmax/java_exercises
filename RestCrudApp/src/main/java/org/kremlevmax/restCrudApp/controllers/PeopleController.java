package org.kremlevmax.restCrudApp.controllers;

import org.kremlevmax.restCrudApp.DAO.PersonDAO;
import org.kremlevmax.restCrudApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    final static String VIEW_PREFIX = "people";
    final PersonDAO dao;

    @Autowired
    public PeopleController(PersonDAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String index(Model model) {
        List<Person> people = dao.getAllPersons();
        model.addAttribute("people", people);
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", dao.getPersonById(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String showNewPersonForm(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String createNewPerson(@ModelAttribute("person") Person person) {
        dao.save(person);
        return "redirect:/people";
    }
}
