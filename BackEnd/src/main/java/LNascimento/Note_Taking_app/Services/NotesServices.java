package LNascimento.Note_Taking_app.Services;

import LNascimento.Note_Taking_app.DTOs.NoteRequest;
import LNascimento.Note_Taking_app.Models.Notes;
import LNascimento.Note_Taking_app.Repositories.NoteRepository;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotesServices {

    private NoteRepository repository;
    private Parser parser;
    private HtmlRenderer renderer;

    public NotesServices(NoteRepository repository, Parser parser, HtmlRenderer renderer) {
        this.repository = repository;
        this.parser = parser;
        this.renderer = renderer;
    }

    public Notes saveNote (NoteRequest request){
        Notes note = new Notes();

        note.setTitle(request.title());
        note.setContentMarkdown(request.Content());

        String Markdown = note.getContentMarkdown();
        String Html = renderer.render(parser.parse(Markdown));
        note.setContentHtml(Html);

        return repository.save(note);
    }

    public Notes getNoteById(UUID id){
        return repository.findById(id).orElseThrow();
    }
    public List<Notes> getAllNotes(){
        return repository.findAll();
    }
    public void deleteNoteById(UUID id){
       repository.deleteById(id);
    }
}
