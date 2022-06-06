import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class whatapp {
    public static void main(String[] args) {
        Window();
    }

    public static void Window() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(0, 0, 500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button = new JButton("Open the WhatApp");
        button.setBounds(200, 200, 150, 150);
        frame.add(button);
        frame.setVisible(true);
        button.addActionListener((even) -> {
            frame.dispose();
            OpenTheWhatApp();
        });
    }

    public static void OpenTheWhatApp() {
        int second =1000;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Eliyahu toronto\\Dropbox\\PC\\Downloads\\Eli\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");

        Thread t = new Thread(()->{
            while (true){
                boolean b = driver.getPageSource().contains("כדי להשתמש ב-WhatsApp במחשב שלך:");
                if(!b){
                   Window();
                   break;
                }
               
            }
        });
        t.start();
    }

}
