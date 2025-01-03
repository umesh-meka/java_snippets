package methods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
public class ComparatorMethods {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Student s1 = new Student("Umesh", 1);
        Student s3 = new Student("Hello", 10);
        Student s2 = new Student("Umi", 8);
        Student s4 = new Student("Umi", 4);
        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);
        List<Student> studentLisOf = List.of(s1, s2, s3, s4);

        System.out.println("studentList : "+ studentList);
        System.out.println("studentLisOf : "+ studentLisOf);
        
        List<Integer> list = List.of(2, 6, 4);

        // sorting by default natural sorting based on Comparable Object
        System.out.println("sorting by default natural sorting based on Comparable Object");
        list.stream().sorted().forEach(System.out::print);
        System.out.println();

        System.out.println("sorting by default natural sorting based on Comparable Object");
        list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::print);
        System.out.println();

        System.out.println("sorting by revrse of default natural sorting based on Comparable Object");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();

        System.out.println("sorting by default natural sorting based on Comparable Object");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println();
        
        System.out.println("sorting List of Student objects by default natural sorting");
        studentList.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::print);
        System.out.println();
        
        System.out.println("sorting List of Student objects by reverse of default natural sorting");
        studentList.stream().sorted(Comparator.comparing(Student::getName, Comparator.reverseOrder())).forEach(System.out::print);
        System.out.println();

        System.out.println("sorting List of Student objects by reverse of default natural sorting");
        studentList.stream().sorted(Comparator.comparing(Student::getName).reversed()).forEach(System.out::print);
        System.out.println();

        System.out.println("sorting List of Student objects by default natural sorting");
        studentList.stream().sorted(Comparator.comparingInt(Student::getStringLength)).forEach(System.out::print);
        System.out.println();

        System.out.println("sorting List of Student objects by multiple fields");
        studentList.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getAge)).forEach(System.out::print);
        System.out.println();
    }
}

class Student {

    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    
    public int getStringLength() {
    	return name.length();
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}