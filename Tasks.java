
package ToDoList;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

    List<String> tasks = new ArrayList<>();

    public void add(String task) {
        tasks.add(task);
    }

    public Tasks() {
    }

    String[] allocateResult() {
        return new String[tasks.size()];
    }

    public String[] getAsArray() {
        return tasks.toArray(allocateResult());
    }

    public String removeTask(int index) {
        if (index < 0 || index > tasks.size() - 1) {
            return "No such task";
        }
        tasks.remove(index);
        return "OK";
    }

    public String edit(int index, String details) {
        if (index < 0 || index > tasks.size() - 1) {
            return "No such task";
        }
        tasks.remove(index);
        tasks.add(index, details);
        return "OK";
    }

    public String getTask(int index) {
        if (index < 0 || index > tasks.size() - 1) {
            return "No such task";
        }
        return tasks.get(index);
    }

}
