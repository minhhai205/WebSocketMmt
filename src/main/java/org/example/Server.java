package org.example;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.example.date.Lunar;
import org.example.date.Solar;
import org.example.service.LunarSolarConverter;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is running...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected successfully!");

                    String dateInput;

                    while ((dateInput = in.readLine()) != null) {
                        try {
                            LocalDate date = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                            Solar solar = new Solar(date.getDayOfMonth(), date.getMonthValue(), date.getYear());

                            Lunar lunarDate = LunarSolarConverter.SolarToLunar(solar);

                            out.println(lunarDate);
                        } catch (Exception e) {
                            out.println("Conversion failed: " + e.getMessage());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
