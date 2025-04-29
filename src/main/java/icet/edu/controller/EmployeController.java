package icet.edu.controller;



import icet.edu.dto.Employe;
import icet.edu.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/employe")
public class EmployeController {


    final EmployeService service;


    @GetMapping("/get-All")
    public List<Employe> getAll() {
        return service.getAllEmployees();
    }

    @PostMapping("/add")
    public void addEmploye(@RequestBody Employe employe) {
        service.addEmployee(employe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmploye(@PathVariable Integer id) {
        service.deleteEmployee(Long.valueOf(id));
    }

    @PutMapping("/update")
    public void updateEmploye( @RequestBody Employe employe) {
        service.updateEmployee(employe);
    }

    @GetMapping("/searchByName/{name}")
    public List<Employe> searchByName(@PathVariable String name) {
        return service.searchByName(name);
    }
    @GetMapping("/searchById/{id}")
    public List<Employe> searchById(@PathVariable Integer id) {
        return service.searchByName(String.valueOf(id));
    }


}