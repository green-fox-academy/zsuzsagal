import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class RainbowBoxFunction {
    public static void mainDraw(Graphics graphics) {
        // Create a square drawing function that takes 2 parameters:
        // The square size, and the fill color,
        // and draws a square of that size and color to the center of the canvas.
        // Create a loop that fills the canvas with rainbow colored squares.

        Color[] colors = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta};

        int size = WIDTH;
        for (int i = 0; i < colors.length; i++) {
            fillRainbow(graphics, size, colors[i]);
            size -= WIDTH/colors.length;
        }
    }


    public static void fillRainbow(Graphics graphics, int size, Color color) {
        int x1 = WIDTH / 2 - size / 2;
        int y1 = HEIGHT / 2 - size / 2;

        graphics.setColor(color);
        graphics.fillRect(x1, y1, size, size);
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