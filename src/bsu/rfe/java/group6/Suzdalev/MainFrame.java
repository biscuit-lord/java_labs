package bsu.rfe.java.group6.Suzdalev;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainFrame extends JFrame {
	private static final int WIDTH = 700;
	private static final int HEIGHT = 500;
	private JMenuItem pauseMenuItem;
	private JMenuItem resumeMenuItem;
	private JMenuItem pauseSnowball;
	private JMenuItem startSnowball;
	private Field field = new Field();

	public MainFrame() {
		super("Программирование и синхронизация потоков");
		setSize(WIDTH, HEIGHT);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);

		setExtendedState(MAXIMIZED_BOTH);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu objectsMenu = new JMenu("Объекты");
		menuBar.add(objectsMenu);

		Action addBallAction = new AbstractAction("Добавить мяч") {
			public void actionPerformed(ActionEvent event) {
				field.addBall();
				if (!pauseMenuItem.isEnabled() && !resumeMenuItem.isEnabled()) {
					pauseMenuItem.setEnabled(true);
				}
			}
		};
		objectsMenu.add(addBallAction);

		JMenu controlMenu = new JMenu("Управление");
		menuBar.add(controlMenu);
		Action pauseAction = new AbstractAction("Приостановить движение") {
			public void actionPerformed(ActionEvent event) {
				field.pause();
				pauseMenuItem.setEnabled(false);
				resumeMenuItem.setEnabled(true);
			}
		};
		pauseMenuItem = controlMenu.add(pauseAction);
		pauseMenuItem.setEnabled(false);

		Action resumeAction = new AbstractAction("Возобновить движение") {
			public void actionPerformed(ActionEvent event) {
				field.resume();
				pauseMenuItem.setEnabled(true);
				resumeMenuItem.setEnabled(false);
			}
		};
		resumeMenuItem = controlMenu.add(resumeAction);
		resumeMenuItem.setEnabled(false);

		JMenu modesMenu = new JMenu("Режимы");
		menuBar.add(modesMenu);
		Action startSnowballAction = new AbstractAction("Включить режим 'Снежный ком'") {
			public void actionPerformed(ActionEvent event) {
				field.startSnowball();
				pauseSnowball.setEnabled(true);
				startSnowball.setEnabled(false);
			}
		};
		startSnowball = modesMenu.add(startSnowballAction);
		startSnowball.setEnabled(true);

		Action stopSnowballAction = new AbstractAction("Выключить режим 'Снежный ком'") {
			public void actionPerformed(ActionEvent event) {
				field.stopSnowball();
				pauseSnowball.setEnabled(false);
				startSnowball.setEnabled(true);
			}
		};
		pauseSnowball = modesMenu.add(stopSnowballAction);
		pauseSnowball.setEnabled(false);

		Action setSnowballAction = new AbstractAction("Параметры режима 'Снежный ком'") {
			public void actionPerformed(ActionEvent event) {
				String input = JOptionPane.showInputDialog(MainFrame.this, "Введите X и Y через пробел в формате целых положительных чисел: ");
				if (input != null) {
					String[] values = input.split(" ");
					try {
						field.setSnowballDistance(new Double(Double.parseDouble(values[0])).intValue());
						field.setSnowballValue(new Double(Double.parseDouble(values[1])).intValue());
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"Ошибка преобразования строки '" + values + "' в число типа Integer", "Ошибочный формат числа", 
								JOptionPane.WARNING_MESSAGE);}
				}
			}
		};
		modesMenu.add(setSnowballAction);

		getContentPane().add(field, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}