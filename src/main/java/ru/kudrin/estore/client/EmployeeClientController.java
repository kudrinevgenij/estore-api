package ru.kudrin.estore.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kudrin.estore.entity.Employee;
import ru.kudrin.estore.service.EmployeeService;

import java.util.Optional;


@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeClientController {

    private final EmployeeService service;

    @GetMapping
    public String getEmployeesPage(Model model) {
        Optional<Employee> bestEmployee = service.findBestSmartWatchSeller();
        System.out.println(bestEmployee.orElse(null));
        model.addAttribute("employees", service.findAllWithShopAndPosition());
        System.out.println(bestEmployee.isPresent());
        if (bestEmployee.isPresent()) {
            model.addAttribute("bestEmployee", bestEmployee.orElse(null));
        } else {
            model.addAttribute("noBestEmployee", "Нет младших продавцов консультантов, продававших умные часы.");
        }
        return "employees.html";
    }
}
