package ru.job4j.search;

import java.util.LinkedList;

/**
 * Класс описывает работу простейшей очереди по приоритету, которая работает
 * по принципу FIFO (first in - first out) *
 * @author DIMA KAZUMU
 * @version 1.0
 */
public class PriorityQueue {

    /**
     * Хранение задание осуществляется в коллекции типа LinkedList
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод принимает на вход заявку и добавляет ее в очередь.
     * Если встречаются 2 задания с одинаковым приоритетом, то в очереди
     * они распределяются по принципу FIFO.
     *
     * @param task задача которая добавляется в очередь
     *             Task task = new Task(String desc, int priority); /список задач и день с указанием их важности
     *             <p>
     *             task.add(int priority, String desc, );
     */
    public void put(Task task) {
        int index = 0;
        for (Task element : tasks) {
            if (element.getPriority() > task.getPriority()) {

                break;
            }
            index++;
        }
        this.tasks.add(index, task);
    }

    /**
     * Метод позволяет получить первую задачу в очереди
     * @return возвращает задачу из головы очереди или null если очередь пуста
     */
    public Task take() {
        return tasks.poll();
    }
}
