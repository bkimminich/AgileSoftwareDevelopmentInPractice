package de.kimminich.agile.lecture3.lawofdemeter;

public class A {
	
	private B b;
	
	public void a1(C c) {
		D d = new D();
		a2(); 					// ok, own class
		b.b();					// ok, associated class
		c.c();					// ok, parameter
		d.d();					// ok, created object
		b.getX().x();			// not ok
		c.getX().getY().y();	// not ok
	}
	
	public void a2() {}

}
