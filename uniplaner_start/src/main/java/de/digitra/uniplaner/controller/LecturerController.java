package de.digitra.uniplaner.controller;

import de.digitra.uniplaner.domain.Lecturer;
import de.digitra.uniplaner.exceptions.BadRequestException;
import de.digitra.uniplaner.exceptions.DuplicateEmailException;
import de.digitra.uniplaner.exceptions.ResourceNotFoundException;
import de.digitra.uniplaner.interfaces.ILecturerController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/lecturers")
public class LecturerController implements ILecturerController {
    @Override
    public ResponseEntity<Lecturer> createLecturer(Lecturer lecturer) throws BadRequestException, DuplicateEmailException, URISyntaxException {
        return null;
    }

    @Override
    public ResponseEntity<Lecturer> updateLecturer(Lecturer lecturer) throws BadRequestException {
        return null;
    }

    @Override
    public ResponseEntity<Lecturer> updateLecturer(Long id, Lecturer lecturerDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<Lecturer> getAlllecturers() {
        return null;
    }

    @Override
    public ResponseEntity<Lecturer> getLecturer(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteLecturer(Long id) {
        return null;
    }
}
