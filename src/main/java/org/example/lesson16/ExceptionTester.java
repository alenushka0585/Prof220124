package org.example.lesson16;

public class ExceptionTester {
    public static void main(String[] args) {

    // https://media.geeksforgeeks.org/wp-content/uploads/20230613122108/Exception-Handling-768.png

       solution(0);
       solution(2);

        System.out.println("Hello");

    }

    public static void solution (int n){
        try { // try-block
        int x = 10/n;
        int[] a = new int[n];
        a[x] = 10;
        }
        catch (ArithmeticException e){
            System.err.println("ArithmeticException: " + e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("something happend: " + e);
        }
    }
}
