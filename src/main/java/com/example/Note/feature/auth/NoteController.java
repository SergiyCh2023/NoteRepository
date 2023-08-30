package com.example.Note.feature.auth;

import com.example.Note.feature.note.Note;
import com.example.Note.feature.note.NoteDTO;
import com.example.Note.feature.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.Note.feature.note.Access.isPublic;


/*
  Task #1
- Якщо користувач відкриває кореневу адресу, і він не авторизований - його перекидає на сторінку входу (/login).
- Якщо користувач відкриває кореневу адресу (/), і він авторизований у цьому браузері – його перекидає на список нотаток
 (/note/list).
- Імена користувачів зберігаються у базі даних. Допустиме ім'я користувача - будь-які символи латиниці та цифри.
Довжина імені – від 5 до 50 символів включно.
- Пароль користувача включає будь-які символи від 8 до 100 символів включно. У БД не зберігаємо паролі користувачів,
 лише хеші паролів.

*******************************************************************************************************************
 Task #4
- Вгорі пишеться Мої нотатки - кількість нотатків. Приклад - Мої нотатки - 3 шт.
- треба зробити як у прикладі (кнопки, вміст)
- Якщо доступ публічний, тоді кожен може переглядати цю нотатку. Якщо доступ приватний, тоді кожен не зможе
 переглядати цю нотатку.
- Зробити кнопку "Створити", яка буде перекидати на сторінку створення нотаток

 */

@RequestMapping ("/note")
@RequiredArgsConstructor
@Controller
public class NoteController {


    private final NoteService noteService;

//    public List<Note> listNotes = Stream.of(
//
//            new Note(1l, "some title note #1", "some context note#1"),
//            new Note(2l, "some title note #2", "some context note#2"),
//            new Note(3l, "some title note #3", "some context note#3")).collect(Collectors.toList());



    @GetMapping("/list")
    public ModelAndView getAll() {
    ModelAndView result = new ModelAndView("index");
    result.addObject("notes", noteService.listAll());
        return result;
    }


    @GetMapping("/share/{id}")
    public ModelAndView getFindNoteById(@PathVariable long id) {
    ModelAndView result = new ModelAndView("share");
        Note note = noteService.getById(id);
        System.out.println(note.getAccess().toString());
        if (note.getAccess().equals(isPublic)) {
            result.addObject("note", note);
           } else {
            return new ModelAndView("forbidden");
        }
        return result;
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteNote (@PathVariable("id") long id) {
        ModelAndView result = new ModelAndView("index");
        noteService.deleteById(id);
        result.addObject("notes", noteService.listAll());
        return result;
    }


    @GetMapping("/edit")
    public ModelAndView getEditNote(@RequestParam("id") long id) {
        ModelAndView result = new ModelAndView("edit");
        result.addObject("note", noteService.getById(id));
        return result;
    }


    @PostMapping ("/edit")
    public ModelAndView getEditNote(@ModelAttribute("noteDTO") NoteDTO noteDTO) {
        ModelAndView result = new ModelAndView("index");
        Note note =  NoteDTO.fromDTO(noteDTO);
        noteService.update(note);
        result.addObject("notes", noteService.listAll());
        return result;
    }


    @GetMapping("/create")
    public ModelAndView openFormForSave() {
        ModelAndView result = new ModelAndView("begin");
        return result;
    }

    @PostMapping ("/create")
    public ModelAndView saveInBase(@ModelAttribute("note") Note note) {
        ModelAndView result = new ModelAndView("index");
        noteService.add(note);
        result.addObject("notes", noteService.listAll());
        return result;
    }
}



























