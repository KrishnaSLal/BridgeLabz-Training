package universitycourseenrollmentsystem;

class Enrollment {
    private Student student;
    private Course course;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void showEnrollment() {
        System.out.println(student.getTranscript());
        System.out.println("Enrolled in: " + course.getCourseDetails());
    }
}
