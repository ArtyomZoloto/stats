package ru.sbrf.dog900.stats.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.dog900.stats.dao.*;

@Controller
public class HttpController {

    @Value("${query.metrics}")
    private String metrics;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    private Dao dao;

    public HttpController(Dao dao) {
        this.dao = dao;
    }


    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping("/metrics")
    public String metrics(Model model,
                          @RequestParam("dateFrom") String dateFrom,
                          @RequestParam("dateTo") String dateTo) {
        model.addAttribute("metrics", dao.get(dateFrom, dateTo
        ));
        return "metrics";
    }

    @GetMapping("/period")
    public String period() {
        return "period";
    }
}
