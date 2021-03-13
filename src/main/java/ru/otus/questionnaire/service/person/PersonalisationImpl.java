package ru.otus.questionnaire.service.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.questionnaire.dto.Student;
import ru.otus.questionnaire.service.view.Interactive;

@AllArgsConstructor
@Service
public class PersonalisationImpl implements Personalisation {
    private final Interactive interactive;

    @Override
    public Student getStudent() {
        interactive.print("Please write you firstName: ");
        String firstName = interactive.ask();
        interactive.print("Please write you lastName: ");
        String lastName = interactive.ask();
        Student student = new Student(firstName, lastName, 0);
        return student;
    }
}
