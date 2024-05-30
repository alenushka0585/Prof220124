package org.example.lesson9;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeChecker {
    //    паллиндром - когда фразза читается одинаково как с начала, так и с конца
    public static void main(String[] args) {
        System.out.println(isPalindrome("alla"));
        System.out.println(isPalindrome("alal")); // false
        System.out.println(isPalindrome("а роза упала на лапу азора")); // true

    }

    public static boolean isPalindrome(String s){
        Deque<Character> chars = new ArrayDeque<>();
        s=s.replace(" ","");
        for (Character c: s.toCharArray()){
            chars.add(c);
        }
        while (chars.size()>1) {
            if (!chars.removeFirst().equals(chars.removeLast())) {
                return false;
            }
        }

        if(chars.size() == 0 || chars.size() == 1){
            return true;
        }

        return true;
    }
}
