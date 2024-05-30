package org.example.lesson9;

import java.util.Queue;
import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println(isBalanced("{}[]"));
        System.out.println(isBalanced("{[]()}"));
        System.out.println(isBalanced("[}"));
        System.out.println(isBalanced("{{{)}]")); // false
        System.out.println(isBalanced("{()()[[()]()]}")); // true
        System.out.println(isBalanced("}{")); // false

    }

    private static boolean isBalanced(String s) {
        Stack<Character> chars = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                chars.push(c);
            } else if (c == ')' && !chars.isEmpty() && chars.peek() == '(' ||
                    c == ']' &&!chars.isEmpty() && chars.peek() == '[' ||
                    c == '}' && !chars.isEmpty() && chars.peek() == '{'
            )
            {
                chars.pop();
            }
        }
        return chars.size() == 0;
    }
}
