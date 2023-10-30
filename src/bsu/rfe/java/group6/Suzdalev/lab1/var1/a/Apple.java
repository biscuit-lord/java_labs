package bsu.rfe.java.group6.Suzdalev.lab1.var1.a;

public class Apple extends Food{
	
	private String size;
	public Apple(String size) {
		super("Apple");
		this.size = size;
	}
	
	public Apple() {
		super("Apple");
		this.size = "-42";
	}
	
	public void consume() {
		System.out.println(this + " consumed.");
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String toString() {
		return super.toString() + " of size '" + size.toUpperCase() + "'.";
	}
}
