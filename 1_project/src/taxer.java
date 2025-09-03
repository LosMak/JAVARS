import java.util.Scanner;
    public class taxer {
        public static void main(String[] args) {
            int price = readInt("Enter price");
            double taxPercent = readDouble("Enter tax in %");
            double result = price + price * taxPercent / 100;
            System.out.println("Total: " + result);
        }
        static Scanner keyboard = new Scanner(System.in);
        private static int readInt(String message) {
            System.out.print(message + ": ");
            return keyboard.nextInt();
        }

        private static double readDouble(String message) {
            System.out.print(message + ": ");
            return keyboard.nextDouble();
        }
    }
