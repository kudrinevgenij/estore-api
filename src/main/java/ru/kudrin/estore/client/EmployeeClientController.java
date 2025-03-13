package ru.kudrin.estore.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kudrin.estore.service.EmployeeService;
import ru.kudrin.estore.service.ShopService;


@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeClientController {

    private final EmployeeService service;

    @GetMapping
    public String getEmployeesPage(Model model) {
        model.addAttribute("employees", service.findAll());
        return "employees.html";
    }
}
