package aircraft;

public class F35 extends Aircraft {
//  Max ammo: 12
//  Base damage: 50

    public F35() {
        super("F35", 12, 50);
    }


    public boolean isPriority() {
        return true;
    }
}
