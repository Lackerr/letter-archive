package com.eDMS.letterArchive.domain.repository;

import com.eDMS.letterArchive.domain.model.Letter;
import com.eDMS.letterArchive.domain.model.LetterId;
import org.springframework.data.repository.CrudRepository;

public interface LetterRepository extends CrudRepository<Letter, LetterId> {
}
