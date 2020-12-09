package hu.unideb.prog2;

import java.util.LinkedList;

public class Lecturer extends Person {
    private LinkedList<Course> heldCourses;
    private LinkedList<Subject> heldSubjects;
    private String faculty;
    private String rank;

    public Lecturer(String name, String faculty, String rank) {
        super(name);
        this.faculty = faculty;
        this.rank = rank;
        this.heldSubjects = new LinkedList<>();
        this.heldCourses = new LinkedList<>();
    }

    public void addHeldCourse(Course course) {
        if (!heldCourses.contains(course)) {
            heldCourses.add(course);
        }
    }

    public void addHeldSubject(Subject subject) {
        if (!heldSubjects.contains(subject)) {
            heldSubjects.add(subject);
        }
    }
}
