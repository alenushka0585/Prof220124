package org.example.lesson17;

import com.google.gson.Gson;
import org.example.lesson14.Emp;

import java.io.FileReader;
import java.io.FileWriter;

public class GsonEmp {
    public static void main(String[] args) {
//        write();
        read();
    }

    private static void read() {
        try(FileReader fr = new FileReader("emp.json.txt"))
        {
            Gson gson = new Gson();
            Emp max = gson.fromJson(fr, Emp.class);
            System.out.println("Max: " + max);

        }catch (Exception  e){
            System.out.println(e);
        }
    }

    private static void write() {
        Emp max = new Emp("Max Kotkov", 27, "analyst");
        try(FileWriter fw = new FileWriter("emp.json.txt");

        ) {
            Gson gson = new Gson();
            gson.toJson(max, fw);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
