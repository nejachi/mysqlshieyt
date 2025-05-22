/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql_java_oh_no;

/**
 *
 * @author WINDOWS
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class captcha {

    public static Random randomizer = new Random();
    public static StringBuilder maxstring = new StringBuilder();
    public static String validcharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!=+-_";
    public static int chooserindex = (int) (randomizer.nextFloat() * validcharacters.length());
    
    public static String generatetext() {
        maxstring.setLength(0);
        while (maxstring.length() < 5) {
            chooserindex = (int) (randomizer.nextFloat() * validcharacters.length());
            System.out.println("Randomizer" + chooserindex);
            maxstring.append(validcharacters.charAt(chooserindex));
        }
        return maxstring.toString();
    }

    public static BufferedImage createimage(String captchaText) {
        int width = 150;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D garphic = image.createGraphics();

        garphic.setColor(Color.WHITE);
        garphic.fillRect(0, 0, width, height);

        garphic.setFont(new Font("Arial", Font.BOLD, 30));
        garphic.setColor(Color.BLACK);
        garphic.drawString(captchaText, 20, 35);

        Random rand = new Random();
        garphic.setColor(Color.GRAY);
        for (int i = 0; i < 15; i++) {
            int x1 = rand.nextInt(width);
            int y1 = rand.nextInt(height);
            int x2 = rand.nextInt(width);
            int y2 = rand.nextInt(height);
            garphic.drawLine(x1, y1, x2, y2);
        }

        garphic.dispose();
        return image;
    }
    
    //thisentire code feels so scuffed lmao
}

