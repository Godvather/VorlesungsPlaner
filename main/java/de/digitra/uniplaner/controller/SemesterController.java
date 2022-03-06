package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.Lecturer;
import de.digitra.uniplaner.domain.Semester;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.ISemesterController;
import de.digitra.uniplaner.service.LecturerService;
import de.digitra.uniplaner.service.SemesterService;
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
@RequestMapping("/semesters")
public class SemesterController {
    @Autowired
    private SemesterService semesterService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("semester", semesterService.findAll());
        return "semester-list";
    }

    @GetMapping("/create")
    public String createSemester(Model model) {
        model.addAttribute("semester", new Semester());
        return "create-semester";
    }

    @PostMapping
    public String createSemester(@Valid Semester semester, Errors errors) {
        if(errors.hasErrors()){
            return "create-semester";
        }
        else{
            semesterService.save(semester);
            return "redirect:/semester";
        }
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        Optional<Semester> semesterToEdit = semesterService.findOne(id);
        model.addAttribute("semester", semesterToEdit);
        return "update-semester";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @Valid Semester semester, Errors errors) {
        if(errors.hasErrors()){
            return "update-semester";
        }
        else{
            semesterService.delete(id);
            semesterService.save(semester);
            return "redirect:/semester";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        semesterService.delete(id);
        return "redirect:/semester";
    }

    @GetMapping("/search")
    public String searchSemester(Model model, @RequestParam(required = false) Optional<Boolean> completed) {
        List<Semester> semester = semesterService.findAll();
        model.addAttribute("semester", semester);
        return "redirect:/semester";
    }

}
