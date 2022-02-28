package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.StudyProgram;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.IStudyProgramController;
import de.digitra.uniplaner.service.StudyProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studyprograms")
public class StudyProgramController implements IStudyProgramController {


    @Override
    public ResponseEntity<StudyProgram> createStudyProgram(StudyProgram studyprogram) throws BadRequestException, URISyntaxException {
        return null;
    }

    @Override
    public ResponseEntity<StudyProgram> updateStudyProgram(StudyProgram studyprogram) throws BadRequestException {
        return null;
    }

    @Override
    public ResponseEntity<StudyProgram> updateStudyProgram(Long id, StudyProgram studyprogramDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<StudyProgram> getAllstudyprograms() {
        return null;
    }

    @Override
    public ResponseEntity<StudyProgram> getStudyProgram(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteStudyProgram(Long id) {
        return null;
    }
}
