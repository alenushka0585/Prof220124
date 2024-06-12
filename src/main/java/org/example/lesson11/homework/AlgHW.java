package org.example.lesson11.homework;

public class AlgHW {

//    Решите задачу: Расставьте в алфавитном порядке буквы. Разрешается использование техники Разделяй и властвуй. Полученные данные напечатайте.
//👉👉👉  На вход строка: "poiuytrewqlkjhgfdsamnbvcxz"
//    На выходе должно быть: ABCDEFGHIJKLMNOPQRSTUVWXYZ (с большой буквы)

    private static void quickSort(char[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(char[] array, int low, int high) {
        char pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        char temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        String input = "poiuytrewqlkjhgfdsamnbvcxz";
        char[] charArray = input.toCharArray();


        quickSort(charArray, 0, charArray.length - 1);

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = Character.toUpperCase(charArray[i]);
        }

        String sortedString = new String(charArray);

        System.out.println(sortedString);
    }
}
