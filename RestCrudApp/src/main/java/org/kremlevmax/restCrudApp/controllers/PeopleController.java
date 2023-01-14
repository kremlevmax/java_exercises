package org.kremlevmax.restCrudApp.controllers;

import org.kremlevmax.restCrudApp.DAO.PersonDAO;
import org.kremlevmax.restCrudApp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String createNewPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        } else {
            dao.save(person);
            return "redirect:/people";
        }
    }

    @GetMapping("/{id}/edit")
    public String getEditPersonForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", dao.getPersonById(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String editPerson(@PathVariable("id") int id, @ModelAttribute("person") @Valid Person person,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        dao.updatePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        dao.deletePerson(id);
        return "redirect:/people";
    }

}
