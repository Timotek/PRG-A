import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScheduleUser extends JFrame{
	
	FileManager fm = new FileManager();
	
	String txtName;
	String movieTitle1;
	String movieTitle2;
	String movieTitle3;
	
	JComboBox<String> hall1comboBox;
	JComboBox<String> hall2comboBox;
	JComboBox<String> hall3comboBox;
	
	JButton zurueck = new JButton("Zurück");
	
	public ScheduleUser(){
		
		super("Schedule");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,400);
		setLayout(new GridLayout(5,0));
		
		JPanel titlePanel = new JPanel();
		JPanel hall1Panel = new JPanel();
		JPanel hall2Panel = new JPanel();
		JPanel hall3Panel = new JPanel();
		JPanel zurueckPanel = new JPanel();
		
		JButton hall1ok = new JButton("Auswaehlen");
		JButton hall2ok = new JButton("Auswaehlen");
		JButton hall3ok = new JButton("Auswaehlen");
		
		hall1ok.addActionListener(new hall1ChooseListener());
		hall2ok.addActionListener(new hall2ChooseListener());
		hall3ok.addActionListener(new hall3ChooseListener());
		
		titlePanel.setBackground(Color.DARK_GRAY);
		hall1Panel.setBackground(Color.DARK_GRAY);
		hall2Panel.setBackground(Color.DARK_GRAY);
		hall3Panel.setBackground(Color.DARK_GRAY);
		zurueckPanel.setBackground(Color.DARK_GRAY);

		
		add(titlePanel);
		add(hall1Panel);
		add(hall2Panel);
		add(hall3Panel);
		add(zurueckPanel);
		zurueck.setForeground(Color.BLACK);

		zurueckPanel.add(zurueck);
		zurueck.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
           dispose();
            }
        });
		
		
		//Anzahl der Datums pro Saal
		int saal1 = 0;
		int saal2 = 0;
		int saal3 = 0;
		
		JLabel title = new JLabel("Vorstellung auswählen:");
		title.setForeground(Color.BLACK);

		titlePanel.add(title);

		fm.chooseFile("hall1.txt");
		
		movieTitle1 = fm.readHall();
		JLabel hall1Label = new JLabel("Saal 1: " + movieTitle1);
		hall1Label.setForeground(Color.BLACK);

		hall1Panel.add(hall1Label);
		hall1comboBox = new JComboBox<String>();
		hall1comboBox.setForeground(Color.BLACK);

		while(fm.readHall().equals("DATUM")){
			hall1comboBox.addItem(fm.readHall());
			saal1 ++;
		}
		hall1Panel.add(hall1comboBox);
		hall1ok.setForeground(Color.BLACK);

		hall1Panel.add(hall1ok);
		//nur testweise
		System.out.println(saal1);
		
		/////////////////////////////////////////
		
		fm.chooseFile("hall2.txt");
		
		movieTitle2 = fm.readHall();
		JLabel hall2Label = new JLabel("Saal 2: " + movieTitle2);
		hall2Label.setForeground(Color.BLACK);

		hall2Panel.add(hall2Label);
		hall2comboBox = new JComboBox<String>();
		hall2comboBox.setForeground(Color.BLACK);

		while(fm.readHall().equals("DATUM")){
			hall2comboBox.addItem(fm.readHall());
			saal2 ++;
		}
		hall2Panel.add(hall2comboBox);
		hall2ok.setForeground(Color.BLACK);

		hall2Panel.add(hall2ok);
		//nur testweise

		System.out.println(saal2);


		
		//////////////////////////////////////////
		
		fm.chooseFile("hall3.txt");
		
		movieTitle3 = fm.readHall();
		JLabel hall3Label = new JLabel("Saal 3: " + movieTitle3);
		hall3Label.setForeground(Color.BLACK);

		hall3Panel.add(hall3Label);
		hall3comboBox = new JComboBox<String>();
		hall3comboBox.setForeground(Color.BLACK);

		while(fm.readHall().equals("DATUM")){
			hall3comboBox.addItem(fm.readHall());
			saal3++;
		}
		hall3Panel.add(hall3comboBox);
		hall3ok.setForeground(Color.BLACK);

		hall3Panel.add(hall3ok);
		//nur testweise

		System.out.println(saal3);		
		
		
	}
	
	public class hall1ChooseListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtName = "seatssaal" + 1 +"-"+ hall1comboBox.getSelectedIndex()  + ".txt";
			HallUser UserHall = new HallUser(txtName);
			UserHall.setVisible(true);
		}
	}
	public class hall2ChooseListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtName = "seatssaal" + 2 + "-"+ hall2comboBox.getSelectedIndex()  + ".txt";

		}
	}public class hall3ChooseListener implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtName = "seatssaal" + 3 +"-"+ hall3comboBox.getSelectedIndex()  + ".txt";
			System.out.println(txtName);
		}
	}
	
	public static void main(String[]args){
		
		ScheduleUser app = new ScheduleUser();
		app.setVisible(true);
	}
}

//neu