package main.java.music;

public class ElectricGuitar extends StringedInstrument {

    public ElectricGuitar() {
        super("Electric guitar", 6);
    }

    public ElectricGuitar(int numberOfStrings) {
        super("Electric guitar", numberOfStrings);
    }

    @Override
    public String sound() {
        return "Twang";
    }
}
