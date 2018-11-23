package clonable;

public class Main {
    public static void main(String[] args) {

        Student studentToClone = new Student("John", 20, "male", "BME");
        Object jonhTheClone = (Student) studentToClone.clone();

        System.out.println(studentToClone);
        System.out.println(jonhTheClone);
    }
}



