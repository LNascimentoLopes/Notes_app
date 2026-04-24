package LNascimento.Note_Taking_app.Models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String Title;

    @Column(columnDefinition = "TEXT")
    private String ContentMarkdown;

    @Column(columnDefinition = "TEXT")
    private String ContentHtml;


}
