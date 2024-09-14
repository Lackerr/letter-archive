package com.eDMS.letterArchive.application.rest;

import com.eDMS.letterArchive.application.AddLetterToArchiveUseCase;
import com.eDMS.letterArchive.domain.model.Letter;
import com.eDMS.letterArchive.domain.model.LetterId;
import com.eDMS.letterArchive.domain.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/letters")
public class LetterController {
    @Autowired
    private LetterRepository letterRepository;

    @GetMapping("/{id}")
    public Letter show(@PathVariable String id) throws HttpClientErrorException {
        final LetterId letterId = new LetterId(UUID.fromString(id));
        final Optional<Letter> letter = letterRepository.findById(letterId);

        if (letter == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return letter.get();
    }

    @PostMapping()
    public void create(@RequestBody Letter letter) {
        AddLetterToArchiveUseCase addLetterToArchiveUseCase = new AddLetterToArchiveUseCase(letterRepository);
        addLetterToArchiveUseCase.execute(letter);
    }
}
