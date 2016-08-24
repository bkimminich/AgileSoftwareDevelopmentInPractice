package de.kimminich.agile.examples.lecture3.lawofdemeter;

public class C {

    private X x;

    public void c() {
        x.x();          // ok, associated class
        x.getY().y();   // not ok
    }

    public X getX() {
        return x;
    }

}
