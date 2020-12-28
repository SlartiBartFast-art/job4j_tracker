package ru.job4j.search;

import java.util.LinkedList;
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**напишем каркас очереди с приоритетами.
     * В методе put вам нужно найти индекс нужного элемента.-кому нужно-для чего нужного?
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     * Task task = new Task(String desc, int priority); /список задач и день с указанием их важности
     *
     *    task.add(int priority, String desc, );
     */
    public void put(Task task) {
        int index = 0;
        //tasks.add(task);

            for (Task element : tasks) {
                if (element.getPriority() < task.getPriority()) {
                    tasks.add(element.getPriority(), task);
                    index++;

                    break;
                }

            }

        this.tasks.add(index, task);
    }

    public Task take() {
        return tasks.poll();
    }
}
