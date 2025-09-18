package hw5;

public class Person {
    private String name;
    private int age;
    private char sex;
    private double weight;
    private static double pi = 3.14;

    void printPerson() {
         System.out.printf("Person: %s, age: %d, sex: %c, weight: %.2f%n", name, age, sex, weight);

    }
}

