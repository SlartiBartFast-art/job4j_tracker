package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
       /* public ArrayList<Person> find(String key) {
            ArrayList<Person> result = new ArrayList<>();
            for (Person son : persons) {
            if (son.getName().contains(key)
                    || son.getAddress().contains(key)
                    || son.getSurname().contains(key)
                    || son.getPhone().contains(key)) {
                result.add(son);

            }
        }
            return result;
        }*/

       /* public ArrayList<Person> find1(String key) {
            Predicate<Person> combine = new Predicate<Person>() {
                @Override
                public boolean test(Person person) {
                    return person.getName().contains(key)
                            || person.getPhone().contains(key)
                            || person.getSurname().contains(key)
                            || person.getAddress().contains(key);
                }
            };*/

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine1 = person -> person.getName().contains(key);
        Predicate<Person> cobbine2 = person -> person.getSurname().contains(key);
        Predicate<Person> combine3 = person -> person.getAddress().contains(key);
        Predicate<Person> combine4 = person -> person.getPhone().contains(key);
        Predicate<Person> combine =  combine1.or(cobbine2).or(combine3).or(combine4);
        ArrayList<Person> rsl = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}
