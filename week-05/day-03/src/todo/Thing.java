package todo;

public class Thing implements Comparable<Thing> {
//  It should compare the completed field first
//  Then the description

    private String name;
    private boolean completed;

    public Thing(String name) {
        this.name = name;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + name;
    }

    @Override
    public int compareTo(Thing t) {
        if (this.completed) {
            return -1;
        } else if (this.completed) {
            return 1;
        } else {
            return 0;
        }
    }
}


