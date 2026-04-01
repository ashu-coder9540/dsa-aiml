import java.util.*;

public class Level3 {
    static class Student {
        int marks;
        String name;

        Student(int marks, String name) {
            this.marks = marks;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student(90, "A");
        Student s2 = new Student(70, "B");  
        Student s3 = new Student(90, "C");
        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.sort((a, b) -> a.marks - b.marks);
        System.out.println("Sorted by marks: " + list.stream().map(s -> s.name + ":" + s.marks).toList());
    }
}
