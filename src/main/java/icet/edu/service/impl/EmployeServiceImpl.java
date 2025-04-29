package icet.edu.service.impl;

import icet.edu.dto.Employe;
import icet.edu.repository.EmployeRepository;
import icet.edu.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeServiceImpl implements EmployeService {


    final EmployeRepository repository;
    final ModelMapper mapper;

    @Override
    public void addEmploye(Employe employe) {

    }

    @Override
    public void deleteEmploye(Integer id) {

    }

    @Override
    public void updateEmploye() {

    }

    @Override
    public List<Employe> getEmployes() {
        return List.of();
    }

    @Override
    public List<Employe> searchByName(String name) {
        return List.of();
    }
}
