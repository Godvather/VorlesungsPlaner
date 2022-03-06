package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.Semester;
import de.digitra.uniplaner.domain.StudyClass;
import de.digitra.uniplaner.domain.StudyProgram;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.IStudyProgramController;
import de.digitra.uniplaner.service.SemesterService;
import de.digitra.uniplaner.service.StudyProgramService;
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
@RequestMapping("/studyprograms")
public class StudyProgramController {
    @Autowired
    private StudyProgramService studyProgramService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("studyProgram", studyProgramService.findAll());
        return "studyprogram-list";
    }

    @GetMapping("/create")
    public String createStudyProgram(Model model) {
        model.addAttribute("studyProgram", new StudyProgram());
        return "create-studyProgram";
    }

    @PostMapping
    public String createStudyProgram(@Valid StudyProgram studyProgram, Errors errors) {
        if(errors.hasErrors()){
            return "create-studyprogram";
        }
        else{
            studyProgramService.save(studyProgram);
            return "redirect:/studyProgram";
        }
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        Optional<StudyProgram> studyProgramToEdit = studyProgramService.findOne(id);
        model.addAttribute("studyprogram", studyProgramToEdit);
        return "update-studyprogram";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @Valid StudyProgram studyProgram, Errors errors) {
        if(errors.hasErrors()){
            return "update-semester";
        }
        else{
            studyProgramService.delete(id);
            studyProgramService.save(studyProgram);
            return "redirect:/studyprogram";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        studyProgramService.delete(id);
        return "redirect:/studyprogram";
    }

    @GetMapping("/search")
    public String searchStudyProgram(Model model, @RequestParam(required = false) Optional<Boolean> completed) {
        List<StudyProgram> studyProgram = studyProgramService.findAll();
        model.addAttribute("studyprogram", studyProgram);
        return "redirect:/studyprogram";
    }

}
