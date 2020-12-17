package ru.job4j.tracker;
/**делает вывод строк в консоль
 * */
public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
