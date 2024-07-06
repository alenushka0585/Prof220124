package org.example.lesson17;

/*
ipv4 0-255.0-255.0-255.0-255  - 147.12.16.33
ipv6
domain name system: www.nytimes.com -> 15.1.66.129
port: 0-65535 /protocol (tcp, udp)
443/tcp - web-server
80/tcp - web-server
25/tcp - почта
53/udp - доменная система имен
*/


import java.io.*;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) {
        //http://colormind.io/list
        //протокол  сервер     раздел
        //80/tcp
        int port = 80;
        String server = "colormind.io";
        String chapter = "/list";

        try (Socket socket = new Socket(server, port); // соединение
             OutputStream os = socket.getOutputStream(); // чтобы отправлять что-то на сервер
             OutputStreamWriter osw = new OutputStreamWriter(os);
             InputStream is = socket.getInputStream(); // чтобы читать с сервера
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);
        ){
            osw.write("GET http://colormind.io/list/ HTTP/1.0\n\n");
            osw.flush();
            br.lines().forEach(
                    line -> System.out.println("line: " + line)
            );

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
