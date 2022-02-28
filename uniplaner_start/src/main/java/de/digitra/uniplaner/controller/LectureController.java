package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.Lecture;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.ILectureController;
import de.digitra.uniplaner.service.LectureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lectures")
public class LectureController implements ILectureController {


    @Override
    public ResponseEntity<Lecture> createLecture(Lecture lecture) throws BadRequestException, URISyntaxException {
        return null;
    }

    @Override
    public ResponseEntity<Lecture> updateLecture(Lecture lecture) throws BadRequestException {
        return null;
    }

    @Override
    public ResponseEntity<Lecture> updateLecture(Long id, Lecture lectureDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    @GetMapping("/create")
    public List<Lecture> getAlllectures() {
        List<Lecture> lecture = new ArrayList<Lecture>(){{new Lecture();}};
        return lecture;

    }

    @Override
    public ResponseEntity<Lecture> getLecture(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteLecture(Long id) {
        return null;
    }
}
