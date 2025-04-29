package icet.edu.service;
import icet.edu.dto.Employe;
import java.util.List;
public interface EmployeService {

    void addEmploye(Employe employe);
    void deleteEmploye(Integer id);
    void updateEmploye();
    List<Employe> getEmployes();
    List<Employe> searchByName(String name);

}
