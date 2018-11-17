package teacherStudent;

public class Student {
    //    Create Student class.
    //    - learn()
    //    - question(teacher) -> calls the teachers answer method

    public Student() {
    }

    public void learn() {
        System.out.println("Student is learning.");
    }

    public void question(Teacher t) {
        t.answer();
    }
}
