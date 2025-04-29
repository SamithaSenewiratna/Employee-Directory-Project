package icet.edu.service.impl;

import icet.edu.dto.Employe;
import icet.edu.entity.EmployeEntity;
import icet.edu.repository.EmployeRepository;
import icet.edu.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
    }

    @Override
    public byte[] generateReport() throws IOException {
        List<EmployeEntity> employees = repository.findAll();
        List<Employe> employesList = employees.stream()
                .map(entity -> mapper.map(entity, Employe.class))
                .collect(Collectors.toList());

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();

        contentStream.newLineAtOffset(25, 750);
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.showText("Employee Report");
        contentStream.newLine();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.showText("Total Employees: " + employesList.size());
        contentStream.newLine();
        contentStream.newLine();

        for (Employe employe : employesList) {
            contentStream.showText("Name: " + employe.getName());
            contentStream.newLine();
            contentStream.showText("Email: " + employe.getEmail());
            contentStream.newLine();
            contentStream.showText("Department: " + employe.getDepartment());
            contentStream.newLine();
            contentStream.showText("Created At: " + employe.getCreatedAt());
            contentStream.newLine();
            contentStream.showText("Updated At: " + employe.getUpdatedAt());
            contentStream.newLine();
            contentStream.newLine();
        }

        contentStream.endText();
        contentStream.close();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.save(byteArrayOutputStream);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }


}
