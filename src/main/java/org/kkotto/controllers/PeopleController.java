package org.kkotto.controllers;

import org.kkotto.dao.PersonDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao personDao;

    /*Autowired неявно*/
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    /*Список всех людей*/
    /*Получение всех людей из ДАО и передача на отображение в представлении*/
    @GetMapping
    public String printPeople(Model model) {
        model.addAttribute("people", personDao.getPeople());
        return "people/people";
    }

    /*Во время запуска приложение в {id} помещается любое число,
    которое также помещается в аргумент @PathVariable("id").
    С помощью аннотации @PathVariable id извлекается из URL*/
    /*Получение человека из ДАО по id и передача на отображение в представление*/
    @GetMapping("/{id}")
    public String printPerson(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.getPerson(id));
        return "people/person";
    }
}
