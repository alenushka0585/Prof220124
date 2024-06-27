package org.example.lesson17;

import org.example.lesson14.Emp;
import org.example.lesson15.Order;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputTester {
    public static void main(String[] args) {
//        write();
        read();
    }

    private static void read() {
        try(
                FileInputStream fis = new FileInputStream("emp.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);
        )
        {

            Object o = ois.readObject();
            if(o instanceof Emp){
                Emp max = (Emp) o;
                System.out.println("max " + max);
            }
        }
        catch (Exception e) {
            //
        }
    }

    public static void write() {
        Emp max = new Emp("Max Kotkv", 27, "analyst");

        try (FileOutputStream fos = new FileOutputStream("emp.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(max);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
