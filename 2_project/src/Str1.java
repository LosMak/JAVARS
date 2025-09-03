public class Str1 {
    public static void main(String[] args) {
        String a = "ab10";//String - это класс создаёт внутри себя массив с символами
        int b = 10;
        String str1 = "abc";
        String str2 = new String(new char[]{'a', 'b', 'c'});

        System.out.println(a);
        System.out.println(b);
        for (int i = 0; i < a.length(); i++) {
            if (i % 2 == 0) {

            }

            System.out.println(a.charAt(i));
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(str1 == str2);
            System.out.println(str1.equals(str2)); //Если начинается с большой буквы, то используем equals
                                                   // equals сравнивает содержимое объектов
            Integer u = Integer.valueOf(12);
            Integer i1 = Integer.valueOf(12);
            System.out.println(u==i1);
        }
    }
}
