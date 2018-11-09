import javax.swing.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {
    public static void mainDraw(Graphics graphics){
        // draw four different size and color rectangles.
        // avoid code duplication.

        Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray,
                Color.green, Color.lightGray, Color.magenta, Color.magenta,
                Color.orange, Color.pink, Color.red, Color.white, Color.yellow};

        int x1 = (int)(Math.random() * 100);
        int y1 = (int)(Math.random() * 100);

        for(int i=0; i<4; i++){
            int width = (int)(Math.random() * 90);
            int height = (int)(Math.random() * 90);

             Random rand = new Random();
             int random = rand.nextInt(12);

            graphics.setColor(colors[random]);
            graphics.drawRect(x1, y1, width, height);
        }
    }

    // Don't touch the code below
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}