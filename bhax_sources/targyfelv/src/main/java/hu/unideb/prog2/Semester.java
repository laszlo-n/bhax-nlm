package hu.unideb.prog2;

import java.util.LinkedList;

public class Semester {
    private String period;
    private String training;
    private boolean sponsored;
    private LinkedList<Subject> appliedSubjects;

    public Semester(String period, boolean sponsored) {
        this.period = period;
        this.sponsored = sponsored;
        this.appliedSubjects = new LinkedList<>();
    }

    public void addSubject(Subject subject) {
        if (!appliedSubjects.contains(subject)) {
            appliedSubjects.add(subject);
        }
    }

    public String getPeriod() {
        return period;
    }
}
