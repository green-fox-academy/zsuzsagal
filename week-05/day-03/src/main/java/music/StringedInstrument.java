package main.java.music;

public abstract class StringedInstrument extends Instrument {
//    introduces numberOfStrings and
//    sound() method what's implementation is yet unknown
//    but with the help of the sound(), the play() method is fully implementable

    public int numberOfStrings;

    public StringedInstrument() {

    }

    public StringedInstrument(String name, int numberOfStrings) {
        super(name);
        this.numberOfStrings = numberOfStrings;
    }


    public abstract String sound();

    @Override
    public void play() {
        System.out.println(name + "" + numberOfStrings + " stringed instrument that goes" + sound());

    }
}
