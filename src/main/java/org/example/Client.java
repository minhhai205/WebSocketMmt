package org.example;

import java.io.*;
import java.net.*;
import java.util.regex.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Server connected successfully!");
            String date;

            // Regular expression to check date in dd/MM/yyyy format
            String regex = "^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/(\\d{4})$";
            Pattern pattern = Pattern.compile(regex);

            while (true) {
                System.out.print("Enter solar date (dd/MM/yyyy) or 'exit' to exit: ");
                date = userInput.readLine();

                if ("exit".equalsIgnoreCase(date)) {
                    break;
                }

                Matcher matcher = pattern.matcher(date);
                if (matcher.matches()) {
                    out.println(date);
                    String response = in.readLine();
                    System.out.println("Response from server: " + response);
                } else {
                    System.out.println("Invalid date. Please re-enter in correct format dd/MM/yyyy!");
                }
            }
            System.out.println("Connection closed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
