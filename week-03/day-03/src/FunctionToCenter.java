import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void mainDraw(Graphics graphics) {
        // Create a line drawing function that takes 2 parameters:
        // The x and y coordinates of the line's starting point
        // and draws a line from that point to the center of the canvas.
        // Fill the canvas with lines from the edges, every 20 px, to the center.

        int x1 = 0;
        int y1 = 0;

        for (int i = 0; i <= WIDTH / 20; i++) {
            linesToCenter(graphics, x1, y1);
            x1 += 20;
        }

        for (int i = 0; i <= HEIGHT / 20; i++) {
            linesToCenter(graphics, x1, y1);
            y1 += 20;
        }

        for (int i = WIDTH / 20; i >= 0; i--) {
            linesToCenter(graphics, x1, y1);
            x1 -= 20;
        }

        for (int i = HEIGHT / 20; i >= 0; i--) {
            linesToCenter(graphics, x1, y1);
            y1 -= 20;
        }
    }


    public static void linesToCenter(Graphics graphics, int x1, int y1) {
        graphics.setColor(Color.BLUE);
        graphics.drawLine(x1, y1, WIDTH / 2, HEIGHT / 2);
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