package org.example.lesson17;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

public class HttpTester {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        String address = "https://api.frankfurter.app/latest?amount=10&from=GBP&to=USD";

        try
        {
            URL url = new URL(address);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            try(
                    InputStream is = connection.getInputStream();
                    Reader reader = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(reader)

                    )  {
                br.lines().forEach(line -> builder.append(line));
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("builder: " + builder.toString());

        Gson gson = new Gson();
        Rate rate = gson.fromJson(builder.toString(), Rate.class);
        System.out.println("Rate: " + rate);
    }
}
