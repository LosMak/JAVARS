import java.util.Arrays;

public class STR2 {
    public static void main(String[] args) {
        String str = "d fAghhj;fABCk'";
        System.out.println("abc".equalsIgnoreCase("Abc"));// Игнорирование регистра
        System.out.println(str.toLowerCase());//  строка в нижний регистр
        System.out.println(str.toUpperCase());//  строка в Верхнем регистре
        System.out.println(str.substring(str.length() - 3));
        System.out.println(str.substring(0, 3));
        System.out.println(str.indexOf('A')); //'' символ
        System.out.println(str.lastIndexOf('A'));
        System.out.println(str.indexOf("ABC")); //""- Строка
        System.out.println(str.indexOf("ABCX"));// вернет -1
        System.out.println(str.contains("ABC")); //вернёт boolean   true
        System.out.println(str.contains("ABCX")); //вернёт boolean    false
        System.out.println(
                Arrays.toString(
                        str.split("f"))); //разделить строку в массив по f
        System.out.println(String.join("++", "a", "b"));//
        System.out.println("10" + 10); //прибавление к строке
        System.out.println(3 + 3 + "10" + 10); //прибавление к строке
    }
}
