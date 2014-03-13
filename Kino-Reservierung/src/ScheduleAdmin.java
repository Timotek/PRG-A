import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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
	
	JTextField hall1changeTitle = new JTextField("Hier Filmtitel eingeben",15);
	JTextField hall2changeTitle = new JTextField("Hier Filmtitel eingeben",15);
	JTextField hall3changeTitle = new JTextField("Hier Filmtitel eingeben",15);

	JTextField hall1newDate = new JTextField("Hier neues Datum eingeben");
	JTextField hall2newDate = new JTextField("Hier neues Datum eingeben");
	JTextField hall3newDate = new JTextField("Hier neues Datum eingeben");
	
	public class Hall1DeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			fm.chooseFile("hall1.txt");
			String temp = fm.readHall();
			String temp2 = (String) hall1comboBox.getSelectedItem();	
			System.out.println(temp2);
		}
	}
	
	
	
	
	public class SaveTitleListenerHall1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int temp1 = 0;
			int temp2 = 0;
			String [] hallArray = new String[8];
			fm.chooseFile("hall1.txt");
			
			while(temp1 < 8){
				hallArray [temp1]= fm.readHall();
				temp1 = temp1 + 1;
			}
			
			hallArray[0] = hall1changeTitle.getText();
			
			fm.chooseFileWrite("hall1.txt");
			
			while(temp2 < 8){
				try {
					fm.writeFile(hallArray[temp2]);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				temp2 = temp2 + 1;
			}	
			new UploadDownload(true, "hall1.txt");
			
		}		
	}
	
	public class SaveTitleListenerHall2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int temp1 = 0;
			int temp2 = 0;
			String [] hallArray = new String[8];
			fm.chooseFile("hall2.txt");
			
			while(temp1 < 8){
				hallArray [temp1]= fm.readHall();
				temp1 = temp1 + 1;
			}
			
			hallArray[0] = hall2changeTitle.getText();
			
			fm.chooseFileWrite("hall2.txt");
			
			while(temp2 < 8){
				try {
					fm.writeFile(hallArray[temp2]);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				temp2 = temp2 + 1;
			}	
			new UploadDownload(true, "hall2.txt");
			
		}		
	}
	public class SaveTitleListenerHall3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int temp1 = 0;
			int temp2 = 0;
			String [] hallArray = new String[8];
			fm.chooseFile("hall3.txt");
			
			while(temp1 < 8){
				hallArray [temp1]= fm.readHall();
				temp1 = temp1 + 1;
			}
			
			hallArray[0] = hall3changeTitle.getText();
			
			fm.chooseFileWrite("hall3.txt");
			
			while(temp2 < 8){
				try {
					fm.writeFile(hallArray[temp2]);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				temp2 = temp2 + 1;
			}	
			new UploadDownload(true, "hall3.txt");
			
		}		
	}

	
	
	
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	
	
	
	
	public class DateListenerHall1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			////////////////////////
			////////////////////////
			//Datum zu txt hinfufuegen
			
			int temp1 = 0;
			int temp2 = 0;
			fm.chooseFile("hall1.txt");
			
			//List initialisieren
			List<String> hallList = new ArrayList<>();
			
			//List mit Inhalt aus txt befuellen
			while(temp1 < hallList.size()){
				hallList.add(fm.readHall());
				temp1 = temp1 + 1;
			}
			
			//Neues Datum hinzufuegen
			hallList.add(0, hall1newDate.getText());
			
			fm.chooseFileWrite("hall1.txt");
			
			//txt mit inhalt aus List befuellen
			while(temp2 < hallList.size()){
				try {
					fm.writeFile(hallList.get(temp2));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				temp2 = temp2 + 1;
			}	
		}		
	}
	
	
	public void confirmDialog() {
		final JDialog confirmDialog = new JDialog();
		confirmDialog.setTitle("");
		confirmDialog.setSize(400,100);
		confirmDialog.setModal(false);
		confirmDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		confirmDialog.setLayout(new FlowLayout());
		confirmDialog.add(new JLabel("Sie haben den Film erfolgreich eingetragen!"));
		JButton closeButton = new JButton("schließen");
		confirmDialog.add(closeButton);
		confirmDialog.setVisible(true);
		closeButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				confirmDialog.dispose();	
				
			}
		});
	}
	
	public ScheduleAdmin(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550,600);
		setLayout(new GridLayout(5,0));
		
		JPanel titlePanel = new JPanel();
		JPanel hall1Panel = new JPanel();
		JPanel hall2Panel = new JPanel();
		JPanel hall3Panel = new JPanel();
		JPanel backPanel = new JPanel();
				
	//	JButton hall1delete = new JButton("Loeschen");
	//	JButton hall2delete = new JButton("Loeschen");
	//	JButton hall3delete = new JButton("Loeschen");
		
		
		//////////////////////////////////////////////////
		//////////////////////////////////////////////////

		
		JButton hall1save = new JButton("Speichern");
		
		hall1save.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				saal1zaehler ++;
				String saal1txt = "seats" + "saal1" + "-" + saal1zaehler +".txt";
				System.out.println(saal1txt);
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
				new UploadDownload(true, saal1txt);
				
				
			}
			
        });	
		hall1save.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
                
                confirmDialog();    
			}});
		
		
		
		JButton hall2save = new JButton("Speichern");
		hall2save.addActionListener(new java.awt.event.ActionListener() {
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
				new UploadDownload(true, saal2txt);
			}
	
        });	
		hall2save.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
                
                confirmDialog();    
			}});
		
		
		JButton hall3save = new JButton("Speichern");
		hall3save.addActionListener(new java.awt.event.ActionListener() {
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
				new UploadDownload(true, saal3txt);
			}
        });	
		hall3save.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
                
                confirmDialog();    
			}});
		
		
		
		//////////////////////////////////////////////////
		//////////////////////////////////////////////////
		
		
		//JButton hall1saveTitle = new JButton("Titel speichern");
		//JButton hall2saveTitle = new JButton("Titel speichern");
		//JButton hall3saveTitle = new JButton("Titel speichern");	
				
		JButton backButton= new JButton("zurück");
		backPanel.add(backButton);
		backButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
           dispose();
           Login login = new Login();
           login.setVisible(true);
            }
        });
		
		
		add(titlePanel);
		add(hall1Panel);
		add(hall2Panel);
		add(hall3Panel);
		add(backPanel);
		
		String movieTitle1;
		String movieTitle2;
		String movieTitle3;
		
		JLabel title = new JLabel("Bitte waehlen Sie einen Film:");
		titlePanel.add(title);
		
		//++++++++++++++++++++++++++++++++++++++++++++++++
		
		
		
		hall1save.addActionListener(new SaveTitleListenerHall1());
		hall2save.addActionListener(new SaveTitleListenerHall2());
		hall3save.addActionListener(new SaveTitleListenerHall3());
		

		
		//++++++++++++++++++++++++++++++++++++++++++++++++

		//////////////////////////////////////
		new UploadDownload (false, "hall1.txt");
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
		
		hall1Panel.add(hall1changeTitle);
		hall1Panel.add(hall1save);
		

		/////////////////////////////////////////
		new UploadDownload (false, "hall2.txt");
		fm.chooseFile("hall2.txt");
		
		movieTitle2 = fm.readHall();
		JLabel hall2Label = new JLabel("Saal 2: " + movieTitle2);
		hall2Panel.add(hall2Label);
		JComboBox<String> hall2comboBox = new JComboBox<String>();
		while(fm.readHall().equals("DATUM")){
			hall2comboBox.addItem(fm.readHall());
			
		}
		hall2Panel.add(hall2comboBox);
		
		hall2Panel.add(hall2changeTitle);
		hall2Panel.add(hall2save);
		
		
		
		

		
		//////////////////////////////////////////
		new UploadDownload (false, "hall3.txt");
		fm.chooseFile("hall3.txt");
		
		movieTitle3 = fm.readHall();
		JLabel hall3Label = new JLabel("Saal 3: " + movieTitle3);
		hall3Panel.add(hall3Label);
		JComboBox<String> hall3comboBox = new JComboBox<String>();
		while(fm.readHall().equals("DATUM")){
			hall3comboBox.addItem(fm.readHall());
		}
		hall3Panel.add(hall3comboBox);
		
		hall3Panel.add(hall3changeTitle);
		hall3Panel.add(hall3save);
		
		
		
	}
	
	
	//main rausnehmen
	
	public static void main (String[]args){
		
		ScheduleAdmin app  = new ScheduleAdmin();
		app.setVisible(true);
		
	}
}

//neu