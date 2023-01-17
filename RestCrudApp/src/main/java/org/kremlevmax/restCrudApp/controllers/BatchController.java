package org.kremlevmax.restCrudApp.controllers;

import org.kremlevmax.restCrudApp.DAO.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batch-update")
public class BatchController {
    PersonDAO dao;

    @Autowired
    public BatchController(PersonDAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public String getBatchTestPage() {
        return "batch/main";
    }

    @GetMapping("/without")
    public String testWithoutBatch() {
        dao.createWithoutBatch();
        return "redirect:/people";
    }

    @GetMapping("/with")
    public String testWithBatch() {
        dao.createWithBatch();
        return "redirect:/people";
    }
}
