package ru.charcount.testcount.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.charcount.testcount.dto.WordDTO;
import ru.charcount.testcount.service.WordService;

import java.util.List;

@RestController
@RequestMapping("/word")
@Tag(name = "Слово",
        description = "Контроллер для работы со словом")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
    this.wordService = wordService;}


    @Operation(description = "Получить слово по ID", method = "getOneById")
        @GetMapping(value = "/getOneById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WordDTO> getOneById(@RequestParam(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                // .body(genericRepository.findById(id).orElseThrow(() -> new NotFoundException("Данных с переданным ID не найдено")));
                .body(wordService.getOne(id));
    }
        @Operation(description = "Получить все слова", method = "getAll")
        @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<WordDTO>> getAll() {
            return ResponseEntity.status(HttpStatus.OK).body(wordService.listAll());
        }

        @Operation(description = "Создать новое слово", method = "create")
        @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<WordDTO> create(@RequestBody WordDTO newEntity) {
            return ResponseEntity.status(HttpStatus.CREATED).body(wordService.create(newEntity));
        }

        @Operation(description = "Обновить запись", method = "update")
        @PutMapping(value = "/update",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<WordDTO> update(@RequestBody WordDTO updatedEntity,
                @RequestParam(value = "id") Long id) {
            updatedEntity.setId(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(wordService.update(updatedEntity));
        }


        @Operation(description = "Удалить запись по ID", method = "delete")
        @DeleteMapping(value = "/delete/{id}")
        public void delete(@PathVariable(value = "id") Long id) {
            wordService.delete(id);
        }
}

