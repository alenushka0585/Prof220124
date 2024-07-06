package org.example.lesson18;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

Regex - Regular Expression
1. Проверка на соответствие шаблона
2. Разбиение строки по шаблону
3. Замена по шаблону
https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 */
public class RegexTester {
    public static void main(String[] args) {

        System.out.println("=== проверка соответствия шаблону ===");
        String string = "this a max temperature and it has a maximum";
        // встречается ли шаблон
        // где - в каком количестве и в каких позициях

        System.out.println(string);

        Pattern max = Pattern.compile("max"); //скомпилированный шаблон
        Matcher maxMatcher = max.matcher(string);// все совпадения с шаблоном в строке
        while (maxMatcher.find()) { // find находит следующее совпадение
            System.out.println(
                    "начало: " + maxMatcher.start() + ", конец: " + maxMatcher.end() + ", совпадение: " + maxMatcher.group()
            );
        }

        System.out.println("=== квантификаторы .*? ===");

        String telran = "https://www.telran/de";
        //есть внутри строки подстрока www

        System.out.println(
                telran.matches(".*www.*")
        );
        // . - один любой символ
        //* - 0 и более предыдущих символов
        // + - 1 и более
        //? - 0 или 1
        //{1,7} - от 1 до 7
        // {4,} - от 4
        // {,6} - до 6 символов
        //{3) ровно 3
        System.out.println(
                "hello".matches("hel.*")
        );

        System.out.println(
                telran.matches(".*w{3}.*")
        );

        System.out.println("=== | альтернатива ===");
        System.out.println(
                "max".matches("dima|alex|max|masha")
        );

        System.out.println(
                "maxmasha".matches(".*(dima|alex|max|masha).*")
        );

        System.out.println("=== [] перечисление ===");
        System.out.println(
                "a".matches("[abcdj123]")); // один из перечисленных символов


        System.out.println("abc".matches("[abcdefgx]*")); // true

        System.out.println("abc".matches("[abcdefgx]{3}"));
        System.out.println("abc".matches("[a-fgx]{3}")); //диапазон
        System.out.println("acf".matches("[a-fgx]{3}"));

        System.out.println("=== [^] отрицание ===");
        System.out.println(
                "a".matches("[^klm]")
        );

        System.out.println("=== \\s пробельные символы ==="); // \s

      //  String a1 = "\"; в строках явы не может быть одинарных обратных слэшей!

//\\s - пробельный
//\\d - цифра
//\\w - буква
        //\\. точка


        String a1 = "123 \n 456"; //\n - специальный символ перевода строки

        System.out.println("max        kotkov".matches("[a-z]+\\s+[a-z]+")); // true

       System.out.println("Max        Kotkov".matches("[A-Z][a-z]+\\s+[A-Z][a-z]+"));


        System.out.println("--- pin ---");
        System.out.println(isPinCode("1234")); // true
        System.out.println(isPinCode("12345678")); // false
        System.out.println(isPinCode("123456")); // true
        System.out.println(isPinCode("ABCD")); // false
        System.out.println(isPinCode("1")); // false

        System.out.println("--- hex ---");
        System.out.println(isHexNumber("0x1")); // true
        System.out.println(isHexNumber("123")); // false
        System.out.println(isHexNumber("0xb")); // true
        System.out.println(isHexNumber("0xbac123")); // true
        System.out.println(isHexNumber("abc")); // false
        System.out.println(isHexNumber("0x")); // false
        System.out.println(isHexNumber("0xabw")); // false


        System.out.println("--- german number ---");
        System.out.println(isGermanCarNumber("P 1234")); // true
        System.out.println(isGermanCarNumber("P 123")); // true
        System.out.println(isGermanCarNumber("1234")); // true
        System.out.println(isGermanCarNumber("AP 1234")); // true
        System.out.println(isGermanCarNumber("AB ABCV")); // false

        System.out.println("--- ipv4 address ---");
        System.out.println(isIpV4Address("0.0.0.0")); // true
        System.out.println(isIpV4Address("0.0.0.0.")); // false
        System.out.println(isIpV4Address("0.0.0.")); // false
        System.out.println(isIpV4Address("255.255.255.300")); // false
        System.out.println(isIpV4Address("255.255.255.a")); // false
        System.out.println(isIpV4Address("255.255.255.255")); // true

        System.out.println("=== разбиение ===");
        String line = "to be     or    not to   be";

        System.out.println(Arrays.toString(line.split("\\s+")));

        System.out.println("--- extension ---");
        System.out.println(getExtension("hello.txt")); // txt
        System.out.println(getExtension("pic.1.png")); // png
        System.out.println(getExtension("hello")); //

        System.out.println("=== () группировка ===");
        String people = "Max     Kotkov Lena Petrova        Igor    Fomin";
        String first, last;
//               все совпадение -         0 группа
//                                     1         2
        Pattern firstLast = Pattern.compile("(\\w+)\\s+(\\w+)");
        Matcher namesMatcher = firstLast.matcher(people);
        while (namesMatcher.find()){
            first = namesMatcher.group(1);
            last = namesMatcher.group(2);
            System.out.println("first: " + first + ", last: " + last);
        }

        System.out.println("=== замена ===");
        System.out.println("hello, i love you!".replaceAll("love", "hate"));

        String numbers = "one two three four zero";
        System.out.println(
                numbers.replaceAll("(t\\w+)", "_$1_")
        );

        System.out.println(
                "hello, i love you!"
                        .replaceAll("love", "hate")
                        .replaceAll("you", "myself")
        );

    }
    public static boolean isPinCode(String pin){
        return pin.matches("[0-9]{4}|[0-9]{6}");
    }

    public static boolean isHexNumber(String hex){
        return hex.matches("0x[0-9a-f]+");
    }

    public static boolean isGermanCarNumber(String n){
        return n.matches("[A-Z]{1,2}\\s[0-9]{4}");
//        return n.matches("[A-Z]{1,2}\\s\\d{4}");
    }

    public static boolean isIpV4Address(String a){
        String octet = "(\\d|\\d{2}|1\\d{2}|2[0-4]\\d|25[0-5])";
        return a.matches(octet + "\\." + octet + "\\." + octet + "\\." + octet);

        // 1-9         8.
        // 0-9 0-9     99.
        // 0-1 0-9 0-9 199.
        // 2 0-4 0-9   249.
        // 2 5 0-5     253.
    }

    public static String getExtension (String f){
        if (f == null){
            return "";
        }
        String []s = f.split("\\.");
        return s.length == 1? "" :s[s.length-1];
    }
}
