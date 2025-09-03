/*Задача №1
 Дан массив:
int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
необходимо вывести все нечетные числа из массива
*/
public class HW4 {
	public static void main(String[] args) {
		int[] array = {9, 2, 6, 4, 5, 12, 7, 8, 6};
		for (int i = 0; i < array.length; i++) {
            int arraybox = array[i];
            if (arraybox % 2 != 0)
                System.out.println("нечетные числа " + i + " " + arraybox);
/*Задача №2
необходимо вывести все нечетные числа из массива больше 5
*/
            if (arraybox > 5)
                System.out.println("больше 5  " + array[i]);
/*Задача №3
необходимо увеличить все значения массива на 15
*/		int[] arram = {9, 2, 6, 4, 5, 12, 7, 8, 6};
		for (int i = 0; i < arram.length; i++) {
            int arraybox = arram[i] * 15;
           	System.out.println("увеличить на 15 " + arraybox);			
			
			
		}
        System.out.println("______________");

/*Задача №3
необходимо увеличить все значения массива на 15
*/		
		
	}	
}
