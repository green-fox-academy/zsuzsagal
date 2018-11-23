package clonable;

public class Student implements Cloneable {
//    Every Object has a clone() method, so all of your classes, even though the implementation is empty, it doesn't do anything
//    Get your Student class from the Greenfox Organization Exercise
//    Override and implement the clone() method, so it clones the student
//    Instantiate John, a 20 years old male from BME
//    Clone him into jonhTheClone

    String name;
    int age;
    String gender;
    String previousOrganization;
    int skippedDays;
    private java.lang.Object Object;

    public Student(String name, int age, String gender, String previousOrganization) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.previousOrganization = previousOrganization;
        skippedDays = 0;
    }

    public void getGoal() {
        System.out.println("My goal is: Be a junior software developer.");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " from " + previousOrganization + " who skipped " + skippedDays + " days from the course already.");
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }

    @Override
    public Student clone() {
        Student clonedStudent = null;
        try {
            clonedStudent = (Student) super.clone();

        } catch (CloneNotSupportedException e) {
            System.out.println("Could not clone");
        }
        return clonedStudent;
    }

    public String toString() {
        return name + " " + age;
    }
}

