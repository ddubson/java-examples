package pkg;

/**
 * Created by pivotal on 3/3/17.
 */
public class Todo {
    private String value;

    public Todo() {}

    public Todo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
