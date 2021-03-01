package ru.otus.questionnaire.dao;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.core.convert.converter.Converter;
import ru.otus.questionnaire.dto.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionNotesDAO implements QuestionNotes {
    private final String name;
    private final Converter converter;

    public QuestionNotesDAO(Converter converter, String name) {
        this.name = name;
        this.converter = converter;
    }

    @Override
    public List<Question> getAllQuestion() {
        List<String[]> stringList = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(name)), ';', '"', 0);
            String[] line;
            while ((line = reader.readNext()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (List<Question>) converter.convert(stringList);
    }
}
