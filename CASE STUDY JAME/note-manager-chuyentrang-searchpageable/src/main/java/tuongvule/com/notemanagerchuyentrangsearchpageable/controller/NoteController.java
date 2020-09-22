package tuongvule.com.notemanagerchuyentrangsearchpageable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tuongvule.com.notemanagerchuyentrangsearchpageable.model.Note;
import tuongvule.com.notemanagerchuyentrangsearchpageable.service.NoteService;
import tuongvule.com.notemanagerchuyentrangsearchpageable.service.NoteTypeService;

@Controller
public class NoteController {
    @Autowired
    NoteService noteService;
    @Autowired
    NoteTypeService noteTypeService;

//    @GetMapping("/")
//    public ModelAndView listNote(@PageableDefault(3) Pageable pageable ){
//        Page<Note> listNote = noteService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("listNote","notes",listNote);
//        if (listNote.isEmpty()){
//            modelAndView.addObject("message", "Not found Note in Database");
//            return modelAndView;
//        }
//        return modelAndView;
//    }
//    @GetMapping("/")
//    public ModelAndView listNoteBySearch(@PageableDefault(3) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search ){
//        Page<Note> listNote = noteService.findAllSearch(search,pageable);
//        ModelAndView modelAndView = new ModelAndView("listNote","notes",listNote);
//        if (listNote.isEmpty()){
//            modelAndView.addObject("message", "Not found Note in Database");
//            return modelAndView;
//        }
//        modelAndView.addObject("search",search);
//        return modelAndView;
//    }

    @GetMapping("/")
    public ModelAndView listNote(@PageableDefault(2) Pageable pageable, @RequestParam(value = "search", defaultValue = "") String search){
//        Pageable pageable1 = PageRequest.of(0, 2);
        Page<Note> notes = noteService.searchAllByHSQL(search, pageable);
        ModelAndView modelAndView = new ModelAndView("listNote", "notes", notes);
        if (notes.isEmpty()) {
            modelAndView.addObject("message", "Not found Note in DB");
        } else {
            modelAndView.addObject("search", search);//để hiển thị lại trên ô tìm kiếm
        }
        return modelAndView;
    }
    @GetMapping("/note/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("create","note",new Note());
        modelAndView.addObject("noteTypes", noteTypeService.findAllNoteType());
        return modelAndView;
    }
    @PostMapping("/note/save")
    public String save(@ModelAttribute("note") Note note, RedirectAttributes attributes){
        attributes.addFlashAttribute("message", "saved note successfully");
        noteService.save(note);
        return "redirect:/";
    }
    @GetMapping("/note/{id}/edit")
    public ModelAndView edit(@PathVariable("id") int id){
        Note note = noteService.findNoteById(id);
        ModelAndView modelAndView = new ModelAndView("edit","note",note);
        if(note!=null){
            modelAndView.addObject("noteTypes", noteTypeService.findAllNoteType());
            return modelAndView;
        }else {
            return new ModelAndView("error.404");
        }

    }
    @PostMapping("/note/update")
    public String update(Note note, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message","updated note successfully");
        noteService.save(note);
        return "redirect:/";
    }
    @GetMapping("/note/{id}/delete")
    public ModelAndView delete(@PathVariable("id") int id){
        Note note = noteService.findNoteById(id);
        if(note!=null){
            return new ModelAndView("delete","note",note);
        }else {
            return new ModelAndView("error.404");
        }

    }
    @PostMapping("/note/delete")
    public String delete(Note note,RedirectAttributes redirectAttributes){
        noteService.deleteNote(note.getId());
        redirectAttributes.addFlashAttribute("message","deleted note successfully");
        return "redirect:/";
    }
    @GetMapping("/note/{id}/view")
    public ModelAndView view(@PathVariable("id") int id){
        return new ModelAndView("view","note",noteService.findNoteById(id));
    }
}
