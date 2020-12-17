package ru.job4j.tracker;
/** записывает строковые данные в объект класса StrigBuilderю.
 * который имеет сходство соString и хорош для соединения (кокантенации) строк.
 * */
public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(Object obj) {
        if (obj != null) {
            buffer.append(obj.toString());
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
