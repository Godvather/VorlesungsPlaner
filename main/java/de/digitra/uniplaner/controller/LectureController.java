package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.Lecture;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.ILectureController;
import de.digitra.uniplaner.service.LectureService;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lectures")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("lectures", lectureService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createLecture(Model model) {
        model.addAttribute("lecture", new Lecture());
        return "create-lecture";
    }

    @PostMapping
    public String createLecture(@Valid Lecture lecture, Errors errors) {
        if(errors.hasErrors()){
            return "create-lecture";
        }
        else{
            Lecture createLecture = lectureService.create(lecture);
            return "redirect:/lectures";
        }
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        Optional<Lecture> lectureToEdit = lectureService.findOne(id);
        model.addAttribute("lecture", lectureToEdit);
        return "edit-lecture";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @Valid Lecture lecture, Errors errors) {
        if(errors.hasErrors()){
            return "edit-lecture";
        }
        else{
            lectureService.update(id, lecture);
            return "recirect:/lectures";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        lectureService.delete(id);
        return "redirect:/lectures";
    }

    @GetMapping("/search")
    public String searchLectures(Model model, @RequestParam(required = false) Optional<Boolean> completed) {
        List<Lecture> lecture = lectureService.findAll();
        model.addAttribute("lectures", lecture);
        return "redirect:/lectures";
    }
}
