import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScheduleAdmin extends JFrame{
	
	FileManager fm = new FileManager();
	JComboBox<String> hall1comboBox = new JComboBox<String>();

	int saal1zaehler = -1;
	int saal2zaehler = -1;
	int saal3zaehler = -1;
	
	
	public class Hall1DeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			fm.chooseFile("hall1.txt");
			String temp = fm.readHall();
			String temp2 = (String) hall1comboBox.getSelectedItem();
			
			System.out.println(temp2);
		}
		
		
	}
	
	
	
	public ScheduleAdmin(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450,700);
		setLayout(new GridLayout(4,0));
		
		JPanel titlePanel = new JPanel();
		JPanel hall1Panel = new JPanel();
		JPanel hall2Panel = new JPanel();
		JPanel hall3Panel = new JPanel();
				
		JButton hall1delete = new JButton("Loeschen");
		JButton hall2delete = new JButton("Loeschen");
		JButton hall3delete = new JButton("Loeschen");
		
		
		
		JButton hall1saveDate = new JButton("Datum speichern");
		hall1saveDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				saal1zaehler ++;
				String saal1txt = "seats" + "saal1" + "-" + saal1zaehler +".txt";
				File file = new File(saal1txt);
				try {
					final PrintWriter fileWriter = new PrintWriter(file);

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
				fm.chooseFileWrite(saal1txt);

				

				
				for(int i = 1; i <= 8 ; i++){
					
					for(int j = 1; j <= 13; j++){
						

						String valueI = String.valueOf(i);
						String valueJ = String.valueOf(j);
						String valueIJ = valueI + valueJ;
							
						try {
							fm.writeFile(valueIJ);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				
				
				
					
				
				
				
			}
	
				
				
				
			
        });		
		
		JButton hall2saveDate = new JButton("Datum speichern");
		hall2saveDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				saal2zaehler ++;
				String saal2txt = "seats" + "saal2" + "-" + saal2zaehler +".txt";
				File file = new File(saal2txt);
				try {
				final PrintWriter fileWriter = new PrintWriter(file);


				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				fm.chooseFileWrite(saal2txt);

				

				
				for(int i = 1; i <= 8 ; i++){
					
					for(int j = 1; j <= 13; j++){
						

						String valueI = String.valueOf(i);
						String valueJ = String.valueOf(j);
						String valueIJ = valueI + valueJ;
							
						try {
							fm.writeFile(valueIJ);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				
				
				
					
				
				
				
			}
	
				
				
			
        });	
		
		JButton hall3saveDate = new JButton("Datum speichern");
		hall3saveDate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				saal3zaehler ++;
				String saal3txt = "seats" + "saal3" + "-" + saal3zaehler +".txt";
				
				File file = new File(saal3txt);
				try {
					final PrintWriter fileWriter = new PrintWriter(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				fm.chooseFileWrite(saal3txt);

				

				
				for(int i = 1; i <= 8 ; i++){
					
					for(int j = 1; j <= 13; j++){
						

						String valueI = String.valueOf(i);
						String valueJ = String.valueOf(j);
						String valueIJ = valueI + valueJ;
							
						try {
							fm.writeFile(valueIJ);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
				
				
				
					
				
				
				
			}
        });	
		
		JButton hall1saveTitle = new JButton("Titel speichern");
		JButton hall2saveTitle = new JButton("Titel speichern");
		JButton hall3saveTitle = new JButton("Titel speichern");
		
		JTextField hall1changeTitle = new JTextField("Hier Filmtitel eingeben");
		JTextField hall2changeTitle = new JTextField("Hier Filmtitel eingeben");
		JTextField hall3changeTitle = new JTextField("Hier Filmtitel eingeben");

		JTextField hall1newDate = new JTextField("Hier neues Datum eingeben");
		JTextField hall2newDate = new JTextField("Hier neues Datum eingeben");
		JTextField hall3newDate = new JTextField("Hier neues Datum eingeben");
				
		add(titlePanel);
		add(hall1Panel);
		add(hall2Panel);
		add(hall3Panel);
		
		String movieTitle1;
		String movieTitle2;
		String movieTitle3;
		
		JLabel title = new JLabel("Bitte waehlen Sie einen Film:");
		titlePanel.add(title);

		//////////////////////////////////////
		
		fm.chooseFile("hall1.txt");
		
		//hall1Panel.setLayout(new GridLayout(3,3));
		
		movieTitle1 = fm.readHall();
		JLabel hall1Label = new JLabel("Saal 1: " + movieTitle1);
		hall1Panel.add(hall1Label);
		//JComboBox<String> hall1comboBox = new JComboBox<String>();
		while(fm.readHall().equals("DATUM")){
			hall1comboBox.addItem(fm.readHall());
			
			
		}
		hall1Panel.add(hall1comboBox);
		hall1Panel.add(hall1delete);
		hall1delete.addActionListener(new Hall1DeleteListener());
		hall1Panel.add(hall1newDate);
		hall1Panel.add(hall1saveDate);
		hall1Panel.add(hall1changeTitle);
		hall1Panel.add(hall1saveTitle);

		/////////////////////////////////////////
		
		fm.chooseFile("hall2.txt");
		
		movieTitle2 = fm.readHall();
		JLabel hall2Label = new JLabel("Saal 2: " + movieTitle2);
		hall2Panel.add(hall2Label);
		JComboBox<String> hall2comboBox = new JComboBox<String>();
		while(fm.readHall().equals("DATUM")){
			hall2comboBox.addItem(fm.readHall());
			
		}
		hall2Panel.add(hall2comboBox);
		hall2Panel.add(hall2delete);
		hall2Panel.add(hall2newDate);
		hall2Panel.add(hall2saveDate);
		hall2Panel.add(hall2changeTitle);
		hall2Panel.add(hall2saveTitle);

		
		//////////////////////////////////////////
		
		fm.chooseFile("hall3.txt");
		
		movieTitle3 = fm.readHall();
		JLabel hall3Label = new JLabel("Saal 3: " + movieTitle3);
		hall3Panel.add(hall3Label);
		JComboBox<String> hall3comboBox = new JComboBox<String>();
		while(fm.readHall().equals("DATUM")){
			hall3comboBox.addItem(fm.readHall());
		}
		hall3Panel.add(hall3comboBox);
		hall3Panel.add(hall3delete);
		hall3Panel.add(hall3newDate);
		hall3Panel.add(hall3saveDate);
		hall3Panel.add(hall3changeTitle);
		hall3Panel.add(hall3saveTitle);
		
	}
	
	
	
	
	public static void main (String[]args){
		
		ScheduleAdmin app  = new ScheduleAdmin();
		app.setVisible(true);
		
	}
}

//neu