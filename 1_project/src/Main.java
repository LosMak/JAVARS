//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        int x = 55;
        int y = 40;
        if (x + y < 50 || (y > 50 || x > 10) ) {
            System.out.print("X меньше 50");
        } else{
            System.out.println(", but more 30");
        }
        for (int i = 0; i <= 5; i++) {

            System.out.println("i = " + i);
        }

        while (x == 100) {
            System.out.println(x);
            x = x + 1;
        }

             do {
            System.out.println(x);
        } while (x != 100);
    }
}