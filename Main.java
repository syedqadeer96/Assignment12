package com.company;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String engDepartment;
    private int yearOfEnrollment;
    private double perTillDate;

    Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }
    public void displayInfo(){
        System.out.print("\nid:"+this.id+"\nname:"+this.name+"\nage:"+this.age+"\ngender:"+this.gender);
        System.out.println("\nengDepartment:"+this.engDepartment+"\nyearOfEnrollment:"+this.yearOfEnrollment+"\nperTilldate:"+this.perTillDate);
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    public String getEngDepartment() {
        return engDepartment;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }


}



public class Main {

    public static void main(String[] args) {
	ArrayList<Student> studentObject=new ArrayList<Student> ();
    studentObject.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentObject.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentObject.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentObject.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentObject.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentObject.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentObject.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentObject.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentObject.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentObject.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentObject.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentObject.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentObject.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentObject.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentObject.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentObject.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentObject.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

Stream<String> dName=studentObject.stream().map(Student::getEngDepartment);

        System.out.println("1st ouput ");
        dName.forEach(System.out::println);



        Stream<String> studentNames = studentObject.stream()
                .filter(q->q.getYearOfEnrollment()>2018)
                .map(Student::getName);
        System.out.println("\n2nd output");
        studentNames.forEach(System.out::println);

    List<Student> malesInCse=studentObject.stream()
            .filter(i->i.getEngDepartment()=="Computer Science"&&i.getGender()=="Male")
            .collect(Collectors.toList());
        System.out.println("\n3rd output");
        malesInCse.forEach(Student::displayInfo);
Map<String,Long> numberOfMalesAndFemales =studentObject.stream()
        .collect((Collectors.groupingBy(g-> g.getGender(),Collectors.counting())));
        System.out.println("\n4th output");
        System.out.println (numberOfMalesAndFemales);

        Map<String,Double>average=studentObject.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.averagingDouble(Student::getAge)));
        System.out.println("\n5th output");
        System.out.println(average);

        Optional<Student> highest= studentObject.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getPerTillDate)));
        System.out.println("\n6th output");
        highest.get().displayInfo();

        Map<String,Long> numberOfStudentsInEachDept= studentObject.stream()
                .collect(Collectors.groupingBy(i->i.getEngDepartment(),Collectors.counting()));
              System.out.println("\n7th output");
        System.out.println(numberOfStudentsInEachDept);
        Map<String,Double> avgPercentageInEachDept= studentObject.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment,Collectors.averagingDouble(Student::getPerTillDate)));
        System.out.println("\n8th output");
        System.out.println(avgPercentageInEachDept);

        Optional<Student> youngestMaleStudentElectronicDept =studentObject.stream()
                .filter(i->i.getEngDepartment()=="Electronic"&&i.getGender()=="Male")
                .collect(Collectors.minBy(Comparator.comparing(Student::getAge)));
        System.out.println("\n9th output");
        youngestMaleStudentElectronicDept.get().displayInfo();

        Map<String,Long> numberOfMaleAndFemaleInComputerScience= studentObject.stream()
                .filter(i->i.getEngDepartment()=="Computer Science")
                .collect(Collectors.groupingBy(i->i.getGender(),Collectors.counting()));
        System.out.println("\n7th output");
        System.out.println(numberOfMaleAndFemaleInComputerScience);
    }

}


