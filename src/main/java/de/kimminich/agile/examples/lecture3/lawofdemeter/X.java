package de.kimminich.agile.examples.lecture3.lawofdemeter;

public class X {

    private Y y;

    public void x() {
        y.y();      // ok, associated class
    }

    public Y getY() {
        return y;
    }

}
