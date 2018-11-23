package main.java.music;

public abstract class Instrument {
//    it reserves (e.g. protected) the name of the instrument
//    it should provide a play() method.
//    with the help of the sound(), the play() method is fully implementable

    protected String name;

    public Instrument() {

    }

    public Instrument(String name) {
        this.name = name;
    }

    public abstract void play();

}
