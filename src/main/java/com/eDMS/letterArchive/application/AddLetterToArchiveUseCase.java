package com.eDMS.letterArchive.application;

import com.eDMS.letterArchive.domain.model.Letter;
import com.eDMS.letterArchive.domain.repository.LetterRepository;

public class AddLetterToArchiveUseCase {
    private final LetterRepository letterRepository;

    public AddLetterToArchiveUseCase(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    public void execute(Letter letter) {
        letterRepository.save(letter);
    }
}
