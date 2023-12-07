package ru.charcount.testcount.service;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.charcount.testcount.dto.WordDTO;
import ru.charcount.testcount.model.Word;
import ru.charcount.testcount.repository.WordRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordService {

    protected final WordRepository repository;

    public WordService(WordRepository repository) {
        this.repository = repository;
    }

    public WordDTO getOne(Long id) {
        Word word = repository.findById(id).orElseThrow(() -> new NotFoundException("Word is not found"));
        return new WordDTO(word);
    }

    public List<WordDTO> listAll() {
        List<Word> listWord = repository.findAll()
                .stream().toList();
        List<WordDTO> wordDTOS = new ArrayList<>();
            for (Word word: listWord) {
                wordDTOS.add(new WordDTO(word));
        }
            return wordDTOS;
    }

    public WordDTO create(WordDTO newEntity) {
        Word word = new Word(newEntity.getId(),
                newEntity.getValue());
        return new WordDTO(repository.save(word));
    }

    public WordDTO update(WordDTO updatedEntity) {
        Word word = repository.findById(updatedEntity.getId()).orElseThrow(()-> new NotFoundException("Word is not found"));
        word.setValue(updatedEntity.getValue());
        return new WordDTO(repository.save(word));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
