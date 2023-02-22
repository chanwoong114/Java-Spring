package Terran;

import Unit.*;

public class Goliath extends Unit implements Terran {

    public Goliath() {
        super("Goliath", false, true, 5, 15);
    }

    @Override
    public String toString() {
        return this.name ;
    }
}
