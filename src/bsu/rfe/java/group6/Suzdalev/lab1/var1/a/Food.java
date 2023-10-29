package bsu.rfe.java.group6.Suzdalev.lab1.var1.a;

public abstract class Food implements Consumable {
	String name = null;
	
	public Food(String name) {
		this.name = name;
	}
	
	public boolean equals(Object another) {
		if (!(another instanceof Food)) return false;
		if (name==null || ((Food)another).name==null) return false;
		return name.equals(((Food)another).name);
	}
	
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
