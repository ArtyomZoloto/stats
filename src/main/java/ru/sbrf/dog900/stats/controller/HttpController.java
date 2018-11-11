package ru.sbrf.dog900.stats.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.dog900.stats.service.StatsService;

@Controller
public class HttpController {

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    StatsService service;

    public HttpController(StatsService service) {
        this.service = service;
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
        model.addAttribute("metrics", service.get(dateFrom, dateTo
        ));
        return "metrics";
    }

    @GetMapping("/period")
    public String period() {
        return "period";
    }
}
