//Задача №2

//Необходимо создать целочисленные переменные a и b,
// присвоить им произвольные значения,
// а потом поменять значения местами
// (значение переменной a должно оказаться в переменной b и наоборот).


public class HW2_2 {
    public static void main(String[] args) {
        int a = 15;
        int b = 6;
        int c = a;
        c = a;
        a = b;
        b = c;
        System.out.print("a = ");
        System.out.println(a);
        System.out.print("b = ");
        System.out.println(b);

    }
}
