package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.Semester;
import de.digitra.uniplaner.domain.StudyClass;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.IStudyClassController;
import de.digitra.uniplaner.service.SemesterService;
import de.digitra.uniplaner.service.StudyClassService;
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
@RequestMapping("/studyclass")
public class StudyClassController {

    @Autowired
    private StudyClassService studyClassService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("studyclass", studyClassService.findAll());
        return "studyclass-list";
    }

    @GetMapping("/create")
    public String createStudyClass(Model model) {
        model.addAttribute("studyclass", new StudyClass());
        return "create-studyclass";
    }

    @PostMapping
    public String createStudyClass(@Valid StudyClass studyClass, Errors errors) {
        if(errors.hasErrors()){
            return "create-studyclass";
        }
        else{
            studyClassService.save(studyClass);
            return "redirect:/studyclass";
        }
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        Optional<StudyClass> studyClassToEdit = studyClassService.findOne(id);
        model.addAttribute("studyclass", studyClassToEdit);
        return "update-studyclass";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @Valid StudyClass studyClass, Errors errors) {
        if(errors.hasErrors()){
            return "update-studyclass";
        }
        else{
            studyClassService.delete(id);
            studyClassService.save(studyClass);
            return "redirect:/studyclass";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        studyClassService.delete(id);
        return "redirect:/studyclass";
    }

    @GetMapping("/search")
    public String searchSemester(Model model, @RequestParam(required = false) Optional<Boolean> completed) {
        List<StudyClass> studyClass = studyClassService.findAll();
        model.addAttribute("studyClass", studyClass);
        return "redirect:/studyclass";
    }

}
