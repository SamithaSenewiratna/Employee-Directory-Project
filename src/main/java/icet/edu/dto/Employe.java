package icet.edu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employe {


    private Long id;
    private String name;
    private String email;
    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
