import java.util.Arrays;

public class STR2 {
    public static void main(String[] args) {
        String str = "d fAghfhj;f ABCk";
        System.out.println("abc".equalsIgnoreCase("Abc"));// Игнорирование регистра
        System.out.println(str.toLowerCase());//  строка в нижний регистр
        System.out.println(str.toUpperCase());//  строка в Верхнем регистре
        System.out.println(str.substring(str.length() - 3));
        System.out.println(str.substring(0, 3));// получение подстроки
        System.out.println(str.indexOf('A')); // кавычки тип char выводит число с какого символа начинается
        System.out.println(str.lastIndexOf('A'));// Последнее вхожднения
        System.out.println(str.indexOf("ABC")); //""- Строка
        System.out.println(str.indexOf("ABCX"));// вернет -1 не найдено
        System.out.println(str.contains("ABC")); //вернёт boolean находит выражение true
        System.out.println(str.contains("ABCX")); //вернёт boolean ненаходит выражение  false
		System.out.println(str.startsWith("a")); //вернёт boolean начинается строка   false
		System.out.println(str.endsWith("k")); //вернёт boolean заканчивается   true
		System.out.println(str.replace ("A" , "X")); //замена буквы А на X
        System.out.println(
                Arrays.toString(
                        str.split("f"))); //разделить строку в массив по f
        System.out.println(String.join("++", "a", "b"));//соединение  
		System.out.println("с"+"a"+"b");//соединение  
        System.out.println("10" + 10); //прибавление к строке
        System.out.println(3 + 3 + "10" + 10); //прибавление к строке
    }
}
