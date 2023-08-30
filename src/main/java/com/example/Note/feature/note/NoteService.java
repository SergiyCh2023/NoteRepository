package com.example.Note.feature.note;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Data
@RequiredArgsConstructor
@Service
public class NoteService {

        private final NoteRepository noteRepository;


        public List<Note> listAll() {
            return noteRepository.findAll();
        }


        public void add(Note note) {
            noteRepository.save(note);
        }


        public Note getById(long id) {
             return noteRepository.getReferenceById(id);
        }


        @Transactional
        public void update(Note note) {
            noteRepository.updateNotesByIds(note.getId(), note.getTitle(), note.getContent());
        }


        public void deleteById(long id) {
              noteRepository.deleteById(id);
        }

}
