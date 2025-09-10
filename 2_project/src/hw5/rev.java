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
 //       array.length;
        Person alex = new Person();
 //       alex.name;
        alex.name = "Alex";
        alex.age = 40;
        alex.sex = 'm';
        alex.weight= 70.33;
        Person olga = new Person();
        olga.name = "Olga";
        olga.age = 20;
        olga.sex = 'f';
        olga.weight=42.3;

//        printPerson(alex.name, alex.age, alex.sex);
//        printPerson(olga.name, olga. age, olga.sex);

        alex.printPerson();
        olga.printPerson();

    }
        static void printPerson(String name, int age, char sex) {
            System.out.printf("Person: %s, age: %d, sex: %s%n", name, age, sex);
            System.out.println();
            System.out.println("Person: " + name + ", age: " + age + ", sex: " + sex);
            System.out.println(String.format("Person: %s, age: %d, sex: %s", name, age, sex));
        }
}
