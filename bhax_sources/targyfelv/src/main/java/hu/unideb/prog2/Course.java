package hu.unideb.prog2;

public class Course {
    private String courseID;
    //private Enum<CourseKind> type;
    private String location;
    private String time;
    private Lecturer lecturer;

    public Course(String location, String time, Lecturer lecturer) {
        this.location = location;
        this.time = time;
        this.lecturer = lecturer;
        this.courseID = String.format("%d", (int) (Math.random() * 10000));
    }
}
