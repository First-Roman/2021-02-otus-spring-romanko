package ru.otus.questionnaire;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.questionnaire.service.QuestionnaireService;

public class QuestionnaireApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionnaireService questionnaireService = context.getBean(QuestionnaireService.class);
        questionnaireService.startExamination();
    }
}
