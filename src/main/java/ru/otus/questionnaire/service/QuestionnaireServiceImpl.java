package ru.otus.questionnaire.service;

import ru.otus.questionnaire.dao.QuestionNotes;
import ru.otus.questionnaire.dto.Question;

import java.util.List;
import java.util.Scanner;


public class QuestionnaireServiceImpl implements QuestionnaireService {
    private final QuestionNotes questionNotes;
    private final Scanner scanner;

    public QuestionnaireServiceImpl(QuestionNotes questionNotes) {
        this.questionNotes = questionNotes;
        scanner = new Scanner(System.in);
    }

    @Override
    public void startExamination() {
        List<Question> questions = getQuestions();
        questions.forEach(question -> {
            printQuestion(question);
            String answer = getAnswer();
            System.out.println("Your answer is " + answer);
        });
        System.out.println("The End. Thank you!");
    }

    private List<Question> getQuestions() {
        return questionNotes.getAllQuestion();
    }

    private void printQuestion(Question question) {
        int count = 1;
        System.out.println("<****************************| Question |**************************>");
        System.out.println(question.getQuestion());
        for (String variable : question.getVariables()) {
            System.out.println(count + " " + variable);
            count++;
        }
    }

    private String getAnswer() {
        System.out.print("Please write your answer :");
        return scanner.next();
    }

}
