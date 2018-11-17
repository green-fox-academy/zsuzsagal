package counter;

public class Counter {
//    Create Counter class
//    which has an integer field value
//    when creating it should have a default value 0 or we can specify it when creating
//    we can add(number) to this counter another whole number
//    or we can add() without parameters just increasing the counter's value by one
//    and we can get() the current value
//    also we can reset() the value to the initial value

    int value;
    int currentValue;

    public Counter() {
        this.value = 0;
        this.currentValue = value;
    }

    public Counter(int number) {
        this.value = number;
        this.currentValue = value;
    }

    public void add(int number) {
        currentValue += number;
    }

    public void add() {
        currentValue += 1;
    }

    public int get() {
        return currentValue;
    }

    public void reset() {
        currentValue = value;
    }
}
