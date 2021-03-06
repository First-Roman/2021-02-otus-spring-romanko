package ru.otus.questionnaire.convertor;

import org.springframework.core.convert.converter.Converter;
import ru.otus.questionnaire.dto.Question;

import java.util.ArrayList;
import java.util.List;

public class ConverterListArrayStringToListQuestion implements Converter<List<String[]>, List<Question>> {

    @Override
    public List<Question> convert(List<String[]> stringList) {
        List<Question> questions = new ArrayList<>();
        for (String[] strings : stringList) {
            Question question = parseStringToQuestion(strings);
            if (question != null) {
                questions.add(question);
            }
        }
        return questions;
    }

    private Question parseStringToQuestion(String[] strings) {
        Question question = new Question();
        if (strings.length  <= 1) {
            return null;
        }
        question.setQuestion(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            question.addVariables(strings[i]);
        }

        return question;
    }
}
