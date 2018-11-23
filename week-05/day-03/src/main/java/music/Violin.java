package main.java.music;

public class Violin extends StringedInstrument {

    public Violin() {
        this.name = "Violin";
        this.numberOfStrings = 2;
    }


    @Override
    public String sound() {
        return "Screech";
    }
}
