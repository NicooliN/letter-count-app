package ru.charcount.testcount.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.charcount.testcount.model.Word;

@Getter
@Setter
@NoArgsConstructor
public class WordDTO {
    private Long id;
    private String value;

    public WordDTO(Word word) {
        WordDTO wordDTO = new WordDTO();
        wordDTO.setId(word.getId());
        wordDTO.setValue(word.getValue());
    }

}
