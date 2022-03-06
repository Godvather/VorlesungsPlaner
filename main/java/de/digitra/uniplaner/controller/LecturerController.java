package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.LectureDate;
import de.digitra.uniplaner.domain.Lecturer;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.DuplicateEmailException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.ILecturerController;
import de.digitra.uniplaner.service.LectureDateService;
import de.digitra.uniplaner.service.LecturerService;
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
@RequestMapping("/lecturers")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("lecturedates", lecturerService.findAll());
        return "lecturer-list";
    }

    @GetMapping("/create")
    public String createLecturer(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        return "create-lecturer";
    }

    @PostMapping
    public String createLecturer(@Valid Lecturer lecturer, Errors errors) {
        if(errors.hasErrors()){
            return "create-lecturer";
        }
        else{
            lecturerService.save(lecturer);
            return "redirect:/lecturer";
        }
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        Optional<Lecturer> lecturerToEdit = lecturerService.findOne(id);
        model.addAttribute("lecturer", lecturerToEdit);
        return "update-lecturer";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @Valid Lecturer lecturer, Errors errors) {
        if(errors.hasErrors()){
            return "update-lecturer";
        }
        else{
            lecturerService.delete(id);
            lecturerService.save(lecturer);
            return "redirect:/lecturer";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        lecturerService.delete(id);
        return "redirect:/lecturer";
    }

    @GetMapping("/search")
    public String searchLecturers(Model model, @RequestParam(required = false) Optional<Boolean> completed) {
        List<Lecturer> lecturer = lecturerService.findAll();
        model.addAttribute("lecturer", lecturer);
        return "redirect:/lecturer";
    }

}
