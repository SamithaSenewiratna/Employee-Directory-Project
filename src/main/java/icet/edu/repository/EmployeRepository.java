package icet.edu.repository;
import icet.edu.entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRepository extends JpaRepository<EmployeEntity, Long> {

List<EmployeEntity> findByName(String name);

}
