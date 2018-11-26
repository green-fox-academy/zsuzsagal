package aircraft;

public class F16 extends Aircraft {
//  Max ammo: 8
//  Base damage: 30

    public F16() {
        super("F16", 8, 30);
    }

    public boolean isPriority() {
        return false;
    }
}
