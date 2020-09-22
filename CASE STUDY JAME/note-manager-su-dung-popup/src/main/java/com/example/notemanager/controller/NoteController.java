package com.example.notemanager.controller;

import com.example.notemanager.model.Note;
import com.example.notemanager.service.NoteService;
import com.example.notemanager.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;
    @Autowired
    NoteTypeService noteTypeService;

    @GetMapping("/")
    public ModelAndView listNote(@PageableDefault (5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("listNote");
        modelAndView.addObject("notes", noteService.findAllNote(pageable));
        modelAndView.addObject("noteTypes", noteTypeService.findAllNoteType());
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute("note") Note note, RedirectAttributes redirectAttributes){
        noteService.save(note);
        redirectAttributes.addFlashAttribute("message", "New Note saved successfully");
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") Note note, RedirectAttributes redirectAttributes){
        noteService.save(note);
        redirectAttributes.addFlashAttribute("message", "Note you chose edited successfully");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") int id,  RedirectAttributes redirectAttributes){
        noteService.deleteNote(id);
        redirectAttributes.addFlashAttribute("message", "Note you chose edited successfully");
        return "redirect:/";
    }


}
