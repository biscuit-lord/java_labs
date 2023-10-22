package bsu.rfe.java.group6.Suzdalev.lab1.var1.c;
import java.util.Random;

public class Tea extends Food{
	private String color;
	
	public Tea(String color) {
		super("Tea");
		if (color != "green" || color != "black") {
			throw new IllegalArgumentException("You can provide black or green colors only.");
		}
		this.color = color;
	}
	
	public Tea() {
		super("Tea");
		Random rand = new Random();
		int choose_color = rand.nextInt(2);
		if (choose_color == 1) {
			this.color = "black";
		} else
			this.color = "green";
		
	}
	
	public void consume() {
		System.out.println(this + " had been drinken.");
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		if (color != "green" || color != "black") {
			throw new IllegalArgumentException("You can provide black or green colors only.");
		}
		this.color = color;
	}
	
	public boolean equals(Object another) {
		if (super.equals(another)) {
			if (!(another instanceof Tea)) return false; 
				return color.equals(((Tea)another).color); 
		} else
			return false;
	}

	public String toString() {
		return super.toString() + " color '" + color.toLowerCase() + "'";
	}
}
