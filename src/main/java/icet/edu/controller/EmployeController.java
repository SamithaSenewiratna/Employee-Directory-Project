package icet.edu.controller;

import icet.edu.dto.Employe;
import icet.edu.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/employe")
public class EmployeController {


    final EmployeService service;


    @GetMapping("/get-All")
    public List<Employe> getAll() {
        return service.getEmployes();
    }

    @PostMapping("/add")
    public void addEmploye(@RequestBody Employe employe) {
        service.addEmploye(employe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmploye(@PathVariable Integer id) {
        service.deleteEmploye(id);
    }

    @PutMapping("/update")
    public void updateEmploye() {
        service.updateEmploye();
    }

    @GetMapping("/searchById/{id}")
    public String searchEmploye(@PathVariable Integer id) {
        return "hello";
    }

    @GetMapping("/searchByName/{name}")
    public List<Employe> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }
    @GetMapping("/searchById/{id}")
    public List<Employe> searchById(@PathVariable Integer id) {
        return service.searchById(id);
    }


}