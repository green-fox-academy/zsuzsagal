package sharpieSet;

public class Sharpie {
// Create Sharpie class
// We should know about each sharpie their color (which should be a string),
// width (which will be a floating point number), inkAmount (another floating point number)
// When creating one, we need to specify the color and the width
// Every sharpie is created with a default 100 as inkAmount
// We can use() the sharpie objects which decreases inkAmount

    String color;
    double width;
    double inkAmount;

    public Sharpie(String color, double width, double inkAmount) {
        this.color = color;
        this.width = width;
        this.inkAmount = inkAmount;
    }

    public void use() {
        inkAmount -= 1;
    }

    public String toString() {
        return "color is: " + color + ", width is: " + width;
    }
}
