package icet.edu.service.impl;

import icet.edu.dto.Employe;
import icet.edu.entity.EmployeEntity;
import icet.edu.repository.EmployeRepository;
import icet.edu.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeServiceImpl implements EmployeService {


    final EmployeRepository repository;
    final ModelMapper mapper;

    @Override
    public void addEmploye(Employe employe) {
      repository.save(mapper.map(employe, EmployeEntity.class));

    }

    @Override
    public void deleteEmploye(Integer id) {
       if (repository.existsById(Long.valueOf(id))) {
            repository.deleteById(Long.valueOf(id));
        } else {
            throw new RuntimeException("Employe with ID " + id + " not found");
        }
    }

    @Override
    public void updateEmploye() {
      repository.save(mapper.map(new Employe(), EmployeEntity.class));

    }

    @Override
    public List<Employe> getEmployes() {
        Iterable<EmployeEntity> all = repository.findAll();
        List<Employe> list = new ArrayList<>();

        all.forEach(EmployeEntity -> {
            list.add(mapper.map(EmployeEntity, Employe.class));
        });

        return list;
    }

    @Override
    public List<Employe> searchById(Integer id) {
        EmployeEntity employeEntity = repository.findById(Long.valueOf(id)).orElse(null);
        List<Employe> employes = new ArrayList<>();

        if (employeEntity != null) {
            employes.add(mapper.map(employeEntity, Employe.class));
        }
        return employes;
    }

    @Override
    public List<Employe> searchByName(String name) {
        List<EmployeEntity> employeEntities = repository.findByName(name);
        List<Employe> employes = new ArrayList<>();

        for (EmployeEntity entity : employeEntities) {
            employes.add(mapper.map(entity, Employe.class));
        }

        return employes;
    }
}
