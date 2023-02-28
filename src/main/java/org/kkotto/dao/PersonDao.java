package org.kkotto.dao;

import org.kkotto.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int peopleCounter; /*Глобальная переменная - т.к. значение явно не инициализируется, неявно присваивается 0*/
    private List<Person> people; /*Аналог БД*/

    /*Динамический блок инициализации - используется в данном случае вместо конструктора*/ {
        people = new ArrayList<>();
        people.add(new Person(++peopleCounter, "Denny"));
        people.add(new Person(++peopleCounter, "Merry"));
        people.add(new Person(++peopleCounter, "Arthur"));
        people.add(new Person(++peopleCounter, "Wendy"));
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }
}
