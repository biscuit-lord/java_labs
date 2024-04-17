package bsu.rfe.java.group6.Suzdalev;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Field extends JPanel {
	private boolean paused;
	private boolean snowball_started;
	private int snowball_distance = 100;
	private int snowball_value = 1;
	private ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>(10);
	private Timer repaintTimer=new Timer(10,new ActionListener(){public void actionPerformed(ActionEvent ev){
		repaint();}});

	public Field() {
		setBackground(Color.WHITE);
		repaintTimer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D canvas = (Graphics2D) g;
		for (BouncingBall ball : balls) {
			ball.paint(canvas);
		}
	}

	public void addBall() {
		balls.add(new BouncingBall(this));
	}
	
	public synchronized void startSnowball() {
		snowball_started = true;
	}

	public synchronized void stopSnowball() {
		snowball_started = false;
	}
	
	public void setSnowballDistance(int meow) {
		snowball_distance = meow;
	}

	public void setSnowballValue(int meow) {
		snowball_value = meow;
	}
	
	public synchronized void pause() {
		paused = true;
	}

	public synchronized void resume() {
		paused = false;
		notifyAll();
	}
	
	public synchronized void canMove(BouncingBall ball) throws InterruptedException {
		if (paused) {
			wait();
		} else if (snowball_started) {
			if (ball.getDistanceTraversed() >= snowball_distance) {
				ball.setDistanceTraversed(0);
				ball.setRadius(ball.getRadius() + snowball_value);
				ball.recalculateSpeed();
			}
		}
	}
}
