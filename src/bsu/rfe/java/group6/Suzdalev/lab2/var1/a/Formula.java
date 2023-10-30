package bsu.rfe.java.group6.Suzdalev.lab2.var1.a;
import java.lang.Math; 

public class Formula {
	private double sum = 0;
	
	public Double calculate1(double x, double y, double z) {
		return 0.0;
	}
	
	public Double calculate2(double x, double y, double z) {
		return Math.pow(1 + x*x, 1/y) / Math.pow(Math.E, Math.sin(z) + x);
	}

	public void addSum(double M) {
		sum += M;
	}
	
	public void clearSum() {
		sum = 0;
	}
	
	public Double getSum() {
		return sum;
	}
}
