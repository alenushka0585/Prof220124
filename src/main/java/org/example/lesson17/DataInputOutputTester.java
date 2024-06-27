package org.example.lesson17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputTester {
    public static void main(String[] args) {
//        write();
        read();
    }
    public static void read(){
        try(
                FileInputStream fis = new FileInputStream("data.bin");
                DataInputStream dis = new DataInputStream(fis);
        )
        {
            double pi = dis.readDouble();
            boolean b = dis.readBoolean();
            int age = dis.readInt();
            String name = dis.readUTF();
            System.out.printf(
                    "%f %b %d %s\n",
                    pi, b, age, name
            );

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void write(){
        try(
                FileOutputStream fos = new FileOutputStream("data.bin");
                DataOutputStream dos = new DataOutputStream(fos);
                )
        {
            dos.writeDouble(3.14);
            dos.writeBoolean(true);
            dos.writeInt(22);
            dos.writeUTF("Hello, world");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
