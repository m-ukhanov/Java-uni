package ua.opnu;

import java.util.function.Consumer;

public class Student {
    private String name;
    private String group;
    private int[] marks;

    public Student(int[] marks, String group, String name) {
        this.marks = marks;
        this.group = group;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }
}
