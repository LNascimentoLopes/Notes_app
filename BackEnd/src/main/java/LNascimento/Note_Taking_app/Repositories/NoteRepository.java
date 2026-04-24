package LNascimento.Note_Taking_app.Repositories;

import LNascimento.Note_Taking_app.Models.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<Notes, UUID> {
}
