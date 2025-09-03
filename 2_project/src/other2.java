import java.util.Arrays;

public class other2 {
    public static void main(String[] args) {
        int[] a = {10, 11, 12};
        //int[] b = a;
        int[] b =Arrays.copyOf(a, a.length);
        System.out.println("Before change");
        System.out.println("a=" + Arrays.toString(a));
        System.out.println("b=" + Arrays.toString(b));

        a[0] = 110;
        System.out.println("After change");
        System.out.println("a=" + Arrays.toString(a));
        System.out.println("b=" + Arrays.toString(b));
    }
}
