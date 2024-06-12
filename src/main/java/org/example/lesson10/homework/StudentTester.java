package org.example.lesson10.homework;

import java.util.*;

public class StudentTester {

    public static void main(String[] args) {
        //    1. Создайте класс Student с полями
//    String name
//    int age
//    String major
//    Добавьте геттеры/сеттеры и конструктор со всеми полями
//    Сделайте так, чтобы коллекции студентов могли без компаратора сортироваться по имени.


        List<Student> students = new ArrayList<>(
                List.of(new Student("Ivnov Ivan", 22, "Economy"),
                        new Student("Petrov Petr", 22, "History"),
                        new Student("Anisimov Pavel", 22, "Astronomy"),
                        new Student("Andrienko Iliay", 24, "Biology"),
                        new Student("Smith John", 23, "Human Resources"),
                        new Student("Smith John", 23, "Geography"),
                        new Student("Smith John", 24, "Geography")
                )
        );
        System.out.println("Before sort: " + students);

        Collections.sort(students);
        System.out.println("After comparable sort: ");
        print(students);

//    2. Отсортируйте коллекцию студентов по убыванию возраста и по возрастанию специальности (major)
//

        Comparator<Student> studentAgeComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        Comparator<Student> studentMajorComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getMajor().compareTo(o2.getMajor());
            }
        };


        Collections.sort(students, studentAgeComparator.reversed().thenComparing(studentMajorComparator));
        System.out.println("________________________________________________");
        System.out.println("After age and major sort: ");
        print(students);


//** 3. Напишите метод, принимающий на вход коллекцию студентов и массив их компраторов
//    Внутри метода отсортируйте коллекцию, создав сложный компаратор из всех переданных в массиве
//    public static void sort(Collection<Student> students, Comparator<Student> [] comps)

        Comparator<Student> studentNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<Student>[] comps = new Comparator[]{studentNameComparator, studentMajorComparator, studentAgeComparator};

        sort(students, comps);
        System.out.println("________________________________________________");
        print(students);

    }

    public static void sort(Collection<Student> students, Comparator<Student>[] comps) {
        Comparator<Student> comparator = comps[0];
        for (int i = 1; i < comps.length; i++) {
            comparator = comparator.thenComparing(comps[i]);
        }
        List<Student> list = new ArrayList<>(students);
        Collections.sort(list, comparator);
        students.clear();
        students.addAll(list);
    }

    public static void print(Collection<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
