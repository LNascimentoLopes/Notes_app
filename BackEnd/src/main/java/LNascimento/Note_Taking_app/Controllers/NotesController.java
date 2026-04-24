package LNascimento.Note_Taking_app.Controllers;

import LNascimento.Note_Taking_app.DTOs.NoteRequest;
import LNascimento.Note_Taking_app.Models.Notes;
import LNascimento.Note_Taking_app.Services.NotesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesServices services;

    @PostMapping
    public ResponseEntity CreateNote(@RequestBody NoteRequest request){
        try {
            Notes note = services.saveNote(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(note);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid parameters");
        }
    }
    @GetMapping
    public ResponseEntity GetAllNotes(){
        try {
            List<Notes> allNotes = services.getAllNotes();
            return ResponseEntity.status(HttpStatus.OK).body(allNotes);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or inexistent parameters");
        }
    }

    @GetMapping("/{uuid}")
    public ResponseEntity GetNoteByid(@PathVariable UUID uuid){
        try {
            Notes noteById = services.getNoteById(uuid);
            return ResponseEntity.status(HttpStatus.OK).body(noteById);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or inexistent parameters");
        }
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity DeleteNoteByid(@PathVariable UUID uuid){
        try {
            services.deleteNoteById(uuid);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or inexistent parameters");
        }
    }
}
