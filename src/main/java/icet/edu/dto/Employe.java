package icet.edu.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("createAt")
    private LocalDateTime createdAt;
    @JsonProperty("updateAt")
    private LocalDateTime updatedAt;
}
