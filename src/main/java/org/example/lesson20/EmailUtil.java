package org.example.lesson20;

public class EmailUtil {
    public static boolean isEmail(String email){
        if (email == null){
            return false;
        }
        return email.contains("@");
    }
}
