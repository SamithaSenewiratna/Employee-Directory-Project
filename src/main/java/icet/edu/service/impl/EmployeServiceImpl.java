package icet.edu.service.impl;

import icet.edu.dto.Employe;
import icet.edu.entity.EmployeEntity;
import icet.edu.repository.EmployeRepository;
import icet.edu.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeServiceImpl implements EmployeService {


    private final EmployeRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addEmployee(Employe employe) {
        repository.save(mapper.map(employe, EmployeEntity.class));
    }

    @Override
    public List<Employe> getAllEmployees() {
        List<EmployeEntity> all = repository.findAll();
        return all.stream()
                .map(entity -> mapper.map(entity, Employe.class))
                .toList();
    }

    @Override
    public void deleteEmployee(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Employee with ID " + id + " not found");
        }
    }

    @Override
    public void updateEmployee(Employe employe) {
        repository.save(mapper.map(employe, EmployeEntity.class));
    }

    @Override
    public Employe getEmployeeById(Long id) {
        EmployeEntity employeEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with ID " + id + " not found"));
        return mapper.map(employeEntity, Employe.class);
    }

    @Override
    public List<Employe> searchByName(String name) {
        List<EmployeEntity> entities = repository.findByName(name);
        return entities.stream()
                .map(entity -> mapper.map(entity, Employe.class))
                .toList();
    }}
