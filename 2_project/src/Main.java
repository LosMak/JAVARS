//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //    int[] ints=new int[5];
        //    ints[0]=10;
        //    ints[1]=11;
        //    ints[2]=12;
        //    ints[3]=13;
        //    ints[4]=14;
        //    System.out.println[2];
        // System.out.print(1,2,3.length);
        int a = 0;

        int[] matchesInBoxes = {59, 60, 66, 58, 61, -55, 63, 61, 58, -58};
        int [] deltas =new int[matchesInBoxes.length];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        boolean exidts = false;
        for (int i = 0; i < matchesInBoxes.length; i++) {
            int matchesInCurrentBox = matchesInBoxes[i];
            deltas[i]=60-matchesInCurrentBox;
            if (matchesInCurrentBox != 60){
                System.out.println("Boz"+i+"has"+ matchesInCurrentBox+"matches");
            }
            if (matchesInCurrentBox == 60){
                exidts = true;
                break;
            }
            sum += matchesInCurrentBox;
            if (matchesInCurrentBox > max) {
                max = matchesInCurrentBox;
                // System.out.println(matchesInBoxes[i]);
                //System.out.println("Box" + i);
                System.out.println("=====");
            }
        }
        System.out.println(max);
        System.out.println(sum);
        System.out.println(exidts? "There was standard box":"No box was standard");
        System.out.println(Arrays.toString(deltas));
    }
}