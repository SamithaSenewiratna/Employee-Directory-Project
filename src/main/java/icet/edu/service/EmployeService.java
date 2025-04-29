package icet.edu.service;
import icet.edu.dto.Employe;

import java.io.IOException;
import java.util.List;
public interface EmployeService {


    void addEmployee(Employe employe);

    List<Employe> getAllEmployees();

    void deleteEmployee(Long id);

    void updateEmployee(Employe employe);

    Employe getEmployeeById(Long id);

    List<Employe> searchByName(String name);

    byte[] generateReport() throws IOException; // in interface


}
