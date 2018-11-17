package teacherStudent;

public class Teacher {
    // create a Teacher class.
    //    - teach(student) -> calls the students learn method
    //    - answer()

    public Teacher() {
    }

    public void teach(Student s) {
        s.learn();
    }

    public void answer() {
        System.out.println("Teacher is answering a question.");
    }
}
