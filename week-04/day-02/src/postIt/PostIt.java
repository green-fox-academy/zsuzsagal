package postIt;

public class PostIt {
//    Create a PostIt class that has
//    a backgroundColor
//    a text on it
//    a textColor

    String backgroundColor;
    String copy;
    String textColor;

    public PostIt(String backgroundColor, String copy, String textColor) {
        this.backgroundColor = backgroundColor;
        this.copy = copy;
        this.textColor = textColor;
    }
        public String toString() {
            return "Background color: " + backgroundColor + " ,the text on it is: " + copy + ", the text color is: " + textColor;
        }
}
