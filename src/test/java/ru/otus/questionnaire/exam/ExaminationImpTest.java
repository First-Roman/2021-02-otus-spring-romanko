package ru.otus.questionnaire.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import ru.otus.questionnaire.dao.QuestionNotes;
import ru.otus.questionnaire.dto.Question;
import ru.otus.questionnaire.service.exam.Examination;
import ru.otus.questionnaire.service.exam.ExaminationImpl;
import ru.otus.questionnaire.service.person.Personalisation;
import ru.otus.questionnaire.service.person.PersonalisationImpl;
import ru.otus.questionnaire.service.question.QuestionnaireService;
import ru.otus.questionnaire.service.question.QuestionnaireServiceImpl;
import ru.otus.questionnaire.service.view.Interactive;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Тестируем сервис экзамена")
public class ExaminationImpTest {

    private Interactive interactive;
    private QuestionNotes questionNotes;
    private Personalisation personalisation;
    private QuestionnaireService questionnaireService;
    @Spy
    private Examination examination;
    private List<Question> questionList;

    @BeforeEach
    public void setup() {
        questionList = new ArrayList<>();
        Question question = new Question();
        question.setQuestion("My name");
        question.addVariables("Dan");
        question.addVariables("Nik");
        question.addVariables("Roman");
        questionList.add(question);
        interactive = Mockito.mock(Interactive.class);
        questionNotes = Mockito.mock(QuestionNotes.class);
        questionnaireService = new QuestionnaireServiceImpl(questionNotes, interactive);
        personalisation = new PersonalisationImpl(interactive);
        examination = new ExaminationImpl(personalisation, questionnaireService, interactive);
    }

    @Test
    public void startExamination() {
        Mockito.doReturn("Roman").doReturn("First").when(interactive).ask();
        Mockito.doReturn(questionList).when(questionNotes).getAllQuestion();
        examination.startExamination();
        Mockito.verify(questionNotes, Mockito.times(1)).getAllQuestion();
    }
}
