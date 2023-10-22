package bsu.rfe.java.group6.Suzdalev.lab1.var1.c;

public class Main {
	public static void main(String[] args) throws Exception {
		Food[] breakfast = new Food[20];
		for (int itemsSoFar = 0;itemsSoFar < 10; ++itemsSoFar) {
			breakfast[itemsSoFar] = new Tea();
		}
		
		for (Food item: breakfast)
			if (item!=null)
				item.consume();
			else
				break;
		System.out.println("Program ended well.");
	}
}
