/* Задача №1
 Необходимо создать целочисленные переменные a и b,
 присвоить произвольные значения переменным на ваш выбор
 и вывести результаты следующих операций с этими переменными:
 сложение, умножение, вычитание, деление и остаток от деления.
 Также сделать проверку на четность этих переменных и вывести результат. 
 */
import java.util.Scanner;
public class HW2_1 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = readInt("Enter the first number: ");
        int b = readInt("Enter the second number: ");


//	    System.out.println("a + b = " a + b);
//      System.out.println(a - b);
//      System.out.println(a * b);
//      System.out.println(a * 1.0 / b); //деление результат дробное число
//      System.out.println(a % b);    //остаток от деления
//      System.out.println(a / 2 * 2 && a) ;// оператор И
//      System.out.println(a / 2 * 2 || a) ;// оператор ИЛИ
//      System.out.println(a / 2 * 2 ! a) ;// оператор НЕ
        System.out.println(a % 2 == 0);//проверка на четность
        System.out.println(b % 2 == 0);
    }
    static Scanner keyboard = new Scanner(System.in);
    private static int readInt(String message) {
        System.out.print(message);
        return keyboard.nextInt();        
    }
}
