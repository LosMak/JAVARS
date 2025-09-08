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
                System.out.println(array[i] + " больше 5  ");
/*Задача №3
необходимо увеличить все значения массива на 15
*/	
            array[i] = array[i] + 15;
            System.out.println("увеличено на 15--> " + array[i]);			
			
			
		}
        System.out.println("______________");

/*Задача №3
необходимо увеличить все значения массива на 15
*/		
		
	}	
}
