package bsu.rfe.java.group6.Suzdalev.lab1.var1.c;

public class Main {
	public static void main(String[] args) throws Exception {
		Food[] breakfast = new Food[20];
		int itemsSoFar = 0;
		for (String arg: args) {
			String[] entered_line = arg.split("/");
			if (entered_line[0].equals("Tea")) {
				breakfast[itemsSoFar] = new Tea();
			}
			itemsSoFar++;
		}
		
		for (Food item: breakfast)
			if (item!=null)
				item.consume();
			else
				break;
		System.out.println("Program ended well.");
	}
}
