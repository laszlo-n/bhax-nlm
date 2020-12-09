package hu.unideb.prog2;

import java.util.LinkedList;

public class Student extends Person {
    private String program;
    private LinkedList<Semester> semesters;

    public Student(String name, String program) {
        super(name);
        this.semesters = new LinkedList<>();
    }

    public void addSemester(Semester semester) {
        semesters.add(semester);
    }

    public Semester getSemesterByPeriod(String period) {
        return semesters.stream().filter(elem -> elem.getPeriod().equals(period)).findFirst().orElse(null);
    }
}
