package ru.kudrin.estore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kudrin.estore.entity.Shop;
import ru.kudrin.estore.service.ShopService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final ShopService service;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("shops", service.findAll());
        return "index.html";
    }
}
