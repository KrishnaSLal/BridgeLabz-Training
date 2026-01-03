package universitycourseenrollmentsystem;

public class MainUniversityEnrollmentApp {
    public static void main(String[] args) {

        Student s1 = new Undergraduate(101, "Amit");
        Student s2 = new Postgraduate(201, "Neha", "AI");

        Course c1 = new Course("CS101", "Data Structures");
        Course c2 = new Course("AI501", "Artificial Intelligence");

        Faculty f1 = new Faculty("Dr. Rao");

        f1.assignGrade(s1, 360, 4);
        f1.assignGrade(s2, 400, 4);

        Enrollment e1 = new Enrollment(s1, c1);
        Enrollment e2 = new Enrollment(s2, c2);

        e1.showEnrollment();
        System.out.println("----------------");
        e2.showEnrollment();
    }
}
