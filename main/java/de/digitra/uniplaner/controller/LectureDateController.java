package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.Lecture;
import de.digitra.uniplaner.domain.LectureDate;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.ILectureDateController;
import de.digitra.uniplaner.service.LectureDateService;
import de.digitra.uniplaner.service.LectureService;
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
@RequestMapping("/lecturedates")
public class LectureDateController {
    @Autowired
    private LectureDateService lectureDateService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("lecturedates", lectureDateService.findAll());
        return "lecture-list";
    }

    @GetMapping("/create")
    public String createLectureDate(Model model) {
        model.addAttribute("lecturedate", new LectureDate());
        return "create-lecturedate";
    }

    @PostMapping
    public String createLectureDate(@Valid LectureDate lectureDate, Errors errors) {
        if(errors.hasErrors()){
            return "create-lecturedate";
        }
        else{
            lectureDateService.save(lectureDate);
            return "redirect:/lecturedates";
        }
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Long id, Model model) throws ResourceNotFoundException {
        Optional<LectureDate> lectureDateToEdit = lectureDateService.findOne(id);
        model.addAttribute("lecturedate", lectureDateToEdit);
        return "update-lecturedate";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @Valid LectureDate lectureDate, Errors errors) {
        if(errors.hasErrors()){
            return "update-lecturedate";
        }
        else{
            lectureDateService.delete(id);
            lectureDateService.save(lectureDate);
            return "redirect:/lecturedate";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        lectureDateService.delete(id);
        return "redirect:/lecturedate";
    }

    @GetMapping("/search")
    public String searchLectures(Model model, @RequestParam(required = false) Optional<Boolean> completed) {
        List<LectureDate> lectureDate = lectureDateService.findAll();
        model.addAttribute("lecturedate", lectureDate);
        return "redirect:/lecturedate";
    }

}
