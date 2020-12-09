package hu.unideb.prog2;

public class App {
    public static void main(String[] args) {
        // we create a Student and a Professor
        Student me = new Student("Nagy László Mihály", "PTI");
        Lecturer prof = new Lecturer("Kiss Pista", "IK", "dékánhelyettes");

        // we create a subject and add a course to it
        Subject prog2 = new Subject("prog2", prof, 6);
        Course szerdaiProg2 = new Course("IK-201", "2020-12-09, 16:00 - 18:00", prof);

        // we create a semester then assign the semester to me
        Semester osz2020 = new Semester("2020H2", true);
        me.addSemester(osz2020);

        // tárgyfelvétel
        me.getSemesterByPeriod("2020H2").addSubject(prog2);
    }
}
