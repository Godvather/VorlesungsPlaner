package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.Lecturer;
import de.digitra.uniplaner.domain.Semester;
import de.digitra.uniplaner.domain.StudyClass;
import de.digitra.uniplaner.domain.StudyProgram;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.DuplicateEmailException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.IStudyProgramController;
import de.digitra.uniplaner.service.SemesterService;
import de.digitra.uniplaner.service.StudyProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
/*Rest*/
/*implements IStudyProgramController*/
@Controller
@RequestMapping("/studyprograms")
public class StudyProgramController implements IStudyProgramController{
    @Autowired
    private StudyProgramService studyProgramService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("studyProgram", studyProgramService.findAll());
        return "studyprogram-list";
    }

    @GetMapping("/create")
    public String createStudyProgram(Model model) {
        model.addAttribute("studyprogram", new StudyProgram());
        return "create-studyprogram";
    }

    @PostMapping
    public String createStudyProgram(@Valid StudyProgram studyProgram, Errors errors) {
        if(errors.hasErrors()){
            return "create-studyprogram";
        }
        else{
            studyProgramService.save(studyProgram);
            return "redirect:/studyprogram";
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
            return "update-studyprogram";
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
    //_______________________________________________________________________________________________________________
    @RequestMapping(value="/post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StudyProgram> createStudyProgram(@RequestBody StudyProgram studyprogram) throws BadRequestException, URISyntaxException {
        StudyProgram sProg = null;
        if(studyprogram.getId() == null) {
            try {
                sProg = studyProgramService.save(studyprogram);
            } catch(Error e){
                e.printStackTrace();
                throw new BadRequestException("Couldnt Save!");
            }
            return ResponseEntity.ok(sProg);
        }
        return ResponseEntity.ok(sProg);
    }

    @RequestMapping(value="/updateStudyProgram", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<StudyProgram> updateStudyProgram(StudyProgram studyprogram) throws BadRequestException {
        StudyProgram studyProgram = null;
        if(studyprogram.getId() != null){
            try {
                studyProgram = studyProgramService.save(studyprogram);
            }
            catch(Error e) {
                throw new BadRequestException("Couldn't Update StudyClass");
            }
        }
        else{
            throw new BadRequestException("ID exists");
        }
        return ResponseEntity.ok(studyProgram);
    }

    @RequestMapping(value="/updateStudyProgramByID", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<StudyProgram> updateStudyProgram(Long id, StudyProgram studyprogramDetails) throws ResourceNotFoundException {
        StudyProgram studyProgram = null;
        if(studyProgramService.findOne(id).isPresent()){
            try {
                studyProgram = studyProgramService.save(studyprogramDetails);
            }
            catch(Error e) {
                throw new ResourceNotFoundException("Couldn't Update StudyClass");
            }
        }
        else{
            throw new ResourceNotFoundException("ID exists");
        }
        return ResponseEntity.ok(studyProgram);
    }

    @RequestMapping(value="/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<StudyProgram>> getAllstudyprograms() {
       List<StudyProgram> ls = null;
        ls = studyProgramService.findAll();
        return ResponseEntity.ok(ls);
    }

    @RequestMapping(value="/getStudyProgram", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<StudyProgram> getStudyProgram(Long id) throws ResourceNotFoundException {
        StudyProgram ls = null;
        try {
            ls = studyProgramService.findOne(id).get();
        }catch(Error e){
            throw new ResourceNotFoundException("StudyClass not found!");
        }
        return ResponseEntity.ok(ls);
    }

    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteStudyProgram(Long id) {
        studyProgramService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    //----------------------------------------------------------------------------------------------------------

}
