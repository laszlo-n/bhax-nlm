package hu.unideb.prog2;

import java.util.LinkedList;

public class Subject {
    private String name;
    private String subjectID;
    private Lecturer professor;
    private int credits;
    //private Enum<CompletionReq> requirements;
    private boolean signed;
    private int mark;
    private LinkedList<Course> availableCourses;

    public Subject(String name, Lecturer professor, int credits) {
        this.name = name;
        this.professor = professor;
        this.professor.addHeldSubject(this);
        this.credits = credits;
        this.availableCourses = new LinkedList<>();
    }

    public void attachCourse(Course course) {
        if (!availableCourses.contains(course)) {
            availableCourses.add(course);
        }
    }

    public LinkedList<Course> getAvailableCourses() {
        return availableCourses;
    }

    public void setAsComplete(int mark) {
        signed = true;
        this.mark = mark;
    }
}
