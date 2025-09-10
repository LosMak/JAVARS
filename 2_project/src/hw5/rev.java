package hw5;

import org.w3c.dom.ls.LSOutput;

public class rev {
    public static void main(String[] args) {
// Conversion Types:
//%d: integers (decimal)
//%f: floating-point
//%e/%E: scientific notation
//%s/%S: strings
//%c: characters
//%b/%B: booleans
//%o: octal numbers
//%x/%X: hexadecimal
//%t/%T: date/time
//%%: literal %
//%n: platform-independent newline
// Person
        String name = "Alex";
        int age = 40;
        char sex = 'm';
        printPerson(name, age, sex);

        //Person object
        String ton = new String("TOM");
        ton.length();
        int[] a = {1, 2, 3};
        Person alex = new Person();
        alex.name;

    }
        static void printPerson(String name, int age, char sex) {
            System.out.printf("Person: %s, age: %d, sex: %s%n", name, age, sex);
            System.out.println();
            System.out.println("Person: " + name + ", age: " + age + ", sex: " + sex);
            System.out.println(String.format("Person: %s, age: %d, sex: %s", name, age, sex));
        }
}
