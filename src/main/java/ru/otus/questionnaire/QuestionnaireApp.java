package ru.otus.questionnaire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.questionnaire.service.exam.Examination;
import ru.otus.questionnaire.service.question.QuestionnaireService;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan
public class QuestionnaireApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(QuestionnaireApp.class);
        Examination examination = context.getBean(Examination.class);
        examination.startExamination();
    }
}
