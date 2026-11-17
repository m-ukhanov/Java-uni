package ua.opnu;

import java.util.function.Predicate;

public class MyOptional<T>{

    private T value;
    private boolean present;

    public MyOptional() {
        this.present = false;
    }

    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional don't accept null");
        }

        this.value = value;
        this.present = true;
    }

    public boolean isPresent() {
        return this.present;
    }

    public boolean isEmpty() {
        return !this.present;
    }

    public T get() {
        if (this.isEmpty()) {
            throw new IllegalStateException("No value");
        }
        return this.value;
    }

    public T orElse(T defaultValue) {
        return this.present ? this.value : defaultValue;
    }

    @Override
    public String toString() {
        return present ? "MyOptional[value="+value+"]" : "MyOptional[empty]";
    }

}
