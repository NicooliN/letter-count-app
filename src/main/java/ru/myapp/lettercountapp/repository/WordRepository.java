package ru.charcount.testcount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.charcount.testcount.model.Word;

public interface WordRepository
        extends JpaRepository<Word, Long> {
}
