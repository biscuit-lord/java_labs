package bsu.rfe.java.group6.Suzdalev.lab1.var1.a;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Food[] breakfast = new Food[20];
		Scanner istream = new Scanner(System.in);
		
		System.out.println("What will be in breakfast?");
		int itemsSoFar = 0;
		for (String product: istream.nextLine().split(" ")) {
			String[] detailed_product = product.toLowerCase().split("-");
			if (detailed_product[0].equals("tea")) {
				if (detailed_product.length > 1 && detailed_product[1].length() > 0) { breakfast[itemsSoFar] = new Tea(detailed_product[1]); }
				else { breakfast[itemsSoFar] = new Tea(); }
			}
			else if (detailed_product[0].equals("apple")) {
				if (detailed_product.length > 1 && detailed_product[1].length() > 0) { breakfast[itemsSoFar] = new Apple(detailed_product[1]); }
				else { breakfast[itemsSoFar] = new Apple(); }
			}
			else if (detailed_product[0].equals("cheese")) {
				breakfast[itemsSoFar] = new Cheese();				
			}
			++itemsSoFar;
		}
		
		int count = 0;
		Food sample_product = new Tea();
		for (Food product: breakfast) {
			if (product == null){break;}
			if (product.equals(sample_product)) {++count;}
		}
		System.out.println(sample_product.name + " count: " + count + " in breakfast.");
		
		for (Food item: breakfast)
			if (item!=null)
				item.consume();
			else
				break;
		
		istream.close();
	}
}
