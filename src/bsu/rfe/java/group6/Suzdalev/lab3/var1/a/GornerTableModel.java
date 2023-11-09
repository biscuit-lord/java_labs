package bsu.rfe.java.group6.Suzdalev.lab3.var1.a;

import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {
	private Double[] coefficients;
	private Double from;
	private Double to;
	private Double step;
	
	public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
		this.from = from;
		this.to = to;
		this.step = step;
		this.coefficients = coefficients;
	}
	public Double getFrom() {
		return from;
	}
	public Double getTo() {
		return to;
	}
	public Double getStep() {
		return step;
	}
	public int getColumnCount() {
		return 3;
	}
	public int getRowCount() {
		// Вычислить количество точек между началом и концом отрезка
		// исходя из шага табулирования
		return new Double(Math.ceil((to-from)/step)).intValue()+1;
	}
	public Object getValueAt(int row, int col) {
		// Вычислить значение X как НАЧАЛО_ОТРЕЗКА + ШАГ*НОМЕР_СТРОКИ
		double x = from + step*row;
		if (col==0) {
			return x;
		} else if(col==2) {
			double result = coefficients[coefficients.length - 1];
			for (int n = coefficients.length - 2; n >= 0; --n) {
				result = coefficients[n] + result * x;
			}
			return result>0;
		} else {
			double result = coefficients[coefficients.length - 1];
			for (int n = coefficients.length - 2; n >= 0; --n) {
				result = coefficients[n] + result * x;
			}
			return result;
		}
	}
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Значение X";
		case 2:
			return "Значение больше нуля?";
		default:
			return "Значение многочлена";
		}
	}
	public Class<?> getColumnClass(int col) {
		if (col==2) {
			return Boolean.class;
		}
		return Double.class;
	}
}
