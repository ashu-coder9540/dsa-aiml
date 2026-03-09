import java.util.*;

//1. Comparable Interface
/* Belongs to java.lang package.
Provides natural ordering of objects.
A class implements Comparable<T> and overrides the compareTo() method. */

/* class Student implements Comparable<Student> {
    int rollNo;
    String name;
    int marks;
    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
    //neg -> no swap
    //pos -> swap
    //zero -> objects are equal
//    [A, B, C]
    @Override
    public int compareTo(Student that){
//        this , that
        if(this.rollNo < that.rollNo){
            return -100; //no swap req
        }else{
            return 1; //swap
        }
    }

}
public class CompareObjects {
     public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Amit",50));
        list.add(new Student(1, "Ravi",70));
        list.add(new Student(2, "Neha",80));

        Collections.sort(list);
        for (Student s : list) {
            System.out.println(s.rollNo + " " + s.name);
        }
    }
} */

//2. Comparator Interface
/*Belongs to java.util package.
Used when we want multiple or custom sorting logics.
Defines the method compare().*/
/*public interface Comparator<T> {
    public int compare(T o1, T o2);
}
 */

/* class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}

class MyCustomComparator implements Comparator<Student>{
    // decreasing
    @Override
    public int compare(Student s1, Student s2){
        if(s1.marks < s2.marks){
            return 1;
        }else{
            return -1;
        }
    }
}


public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
            list.add(new Student(3, "Amit",50));
            list.add(new Student(1, "Ravi",70));
            list.add(new Student(2, "Neha",80));

            Collections.sort(list, new MyCustomComparator());

        for (Student s : list) {
            System.out.println(s.marks + " " + s.name);
        }
    }
} */

import java.util.*;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}

// Example: Sort Students by marks (Descending) and 
// if marks is same then sort in increasing order of roll number.
public class ComparatorTrickDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Amit",50));
        list.add(new Student(1, "Ravi",70));
        list.add(new Student(2, "Neha",80));
        list.add(new Student(4, "Priya",80));

        //(first, second)
        // dec -> second - first
        //inc -> first - second
        // Using Comparator with Anonymous Class
        Collections.sort(list, new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
                // cond -> sort in dec order of marks.
                // if marks is same then sort in increasing order of rollNo.
                if(s1.marks == s2.marks){
                    return s1.rollNo - s2.rollNo;
                }

               return s2.marks - s1.marks;

            }
        });

        for (Student s : list) {
            System.out.println(s.marks + " " + s.name);
        }
    }
}
// Lambda Expressions in Java (Introduced in Java 8)
/* code with anonymous class:

Collections.sort(list, new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return s2.marks - s1.marks; // descending
    }
});
code with lambda

Collections.sort(list, (s1, s2) -> s2.marks - s1.marks); */


/*//Full Code with lambda: (decreasing order of marks and if marks are same then increasing order of roll no.)

import java.util.*;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
}

public class ComparatorLambdaDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Amit",50));
        list.add(new Student(1, "Ravi",70));
        list.add(new Student(2, "Neha",80));
        list.add(new Student(4, "Priya",80));

        //(first, second)
        // dec -> second - first
        //inc -> first - second
        // Using Comparator with Lambda expression

        // cond -> sort in dec order of marks.
        // if marks is same then sort in increasing order of rollNo.
        Collections.sort(list, (s1,s2) -> {
            if(s1.marks == s2.marks){
                return s1.rollNo - s2.rollNo;
            }
            return s2.marks - s1.marks;
        });
        for (Student s : list) {
            System.out.println(s.marks + " " + s.name);
        }
    }
}
 */

/*When to Use?
Comparable → Use when there is a default / natural ordering (e.g., roll number, ID, price).

Comparator → Use when:

You need multiple sorting criteria (e.g., by name, by roll number, by marks).

You don’t want to modify the original class. */