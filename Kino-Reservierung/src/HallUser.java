import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HallUser extends JFrame{
	
	//Hier werden zwei HashMaps erstellt, in denen spaeter die 
	//Reihen als JPanels und die Sitze als JCheckboxen
	//gespeichert werden
	public static Map<String,JCheckBox> seatList = new HashMap<>();
	public static Map<String,JPanel> rowList = new HashMap<>();
	public static Map<String,Boolean> idList = new HashMap<>();

	
	//Die zwei Buttons...
	JButton save = new JButton("Auswahl reservieren");
	JButton discard = new JButton("Zurück");
	ScheduleUser userSchedule1 = null;
	
	
	//Objekt vom FileManager erstellen
	FileManager fm = new FileManager();

	//Laufvariable fuer die idList-HashMap
	String seatID = "0";
	
	//Instanzvariable fÃ¼r die zu waehlende Textdatei mit den Sitzen
	String show;
	
	public HallUser(String show, ScheduleUser userSchedule){
		
		//Standard-Kontruktor...
		super("Hall Overview");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLayout(new GridLayout(9,1));
		this.show = show;
		
		userSchedule1 = userSchedule;
		
		
		//Datei waehlen 
		fm.chooseFile(show);

		save.addActionListener(new SaveListener());

		//Erste For-Schleife: Hier werden die Reihen erstellt,
		//dann in die HashMap geladen und dem JFrame hinzugefuegt
		for(int i = 1; i <= 9 ; i++){
			
			String row = "row"+i;
			rowList.put(row, new JPanel());
			JPanel panel = rowList.get(row);
			panel.setBackground(Color.DARK_GRAY);
			add(panel);
			int k = 1;
			
			if(i<=8){
				
				JLabel label = new JLabel("Reihe "+i);
				label.setForeground(Color.BLACK);
				panel.add(label);
				
			} else { 
				
				save.setForeground(Color.BLACK);
				panel.add(save);
				discard.setForeground(Color.BLACK);
				panel.add(discard);
				discard.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
		           dispose();
		            }
		        });
				
			}
			
			//Verschachtelte For-Schleife: Hier werden die Sitze 
			//erstellt, in die HashMap geladen und dem JPanel hinzugefuegt111
			for(int j = k; j <= 13; j++){
				
				if(i==9){
					break; //"Reihe" 9 bleibt frei fuer die Buttons
				}
				
				//JCheckBox instanzieren und in SeatList packen
				String seatString = "seat"+i+j;
				seatList.put(seatString, new JCheckBox());
				
				//JCheckBox aus der SeatList holen
				JCheckBox checkBox = seatList.get(seatString);
				checkBox.setBackground(Color.BLACK);
				
				//idList-Eintrag erstellen und Laufvariable hochzaehlen
				String valueI = String.valueOf(i);
				String valueJ = String.valueOf(j);
			
				seatID = valueI + valueJ;
				idList.put(seatID, true);
				//seatID ++;
				
				//Ueberpruefen ob Sitz verfuegbar mittel methode aus dem FileManager
				String isGrey = fm.readFile();
				
				System.out.println("seatid=" + seatID + "   isgrey=" + isGrey);
				
				if(isGrey.equals(seatID)){
					checkBox.setEnabled(true);
					//System.out.println("passt");
				} else {
					checkBox.setEnabled(false);
					//checkBox.setLabel("G");
					//System.out.println("passt nicht");
				}

				//Checkbox hinzufuegen
				panel.add(checkBox);

			}			
		}
	}
	
	
	public void AcceptDialog() {
		final JDialog AcceptDialog = new JDialog();
		AcceptDialog.setTitle("");
		AcceptDialog.setSize(400,100);
		AcceptDialog.setModal(false);
		AcceptDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		AcceptDialog.setLayout(new FlowLayout());
		AcceptDialog.add(new JLabel("Ihre Reservierung war erfolgreich!"));
		JButton closeButton = new JButton("schließen");
		AcceptDialog.add(closeButton);
		AcceptDialog.setVisible(true);
		closeButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				AcceptDialog.dispose();	
			}
		});
	}
	
	//Dieser Action Listener uberpruft, welch Checkboxen ausgewÃ¤hlt sind
	public class SaveListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
	
			
			JCheckBox tempBox;
			fm.chooseFileWrite(show);
			System.out.println(show);

			for(int i = 1; i <= 8 ; i++){
				
				for(int j = 1; j <= 13; j++){
					
					tempBox = seatList.get("seat"+i+j);
					
					if(tempBox.isSelected() == true || tempBox.isEnabled() == false){
						
						try {
							fm.writeFile("00");
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
						
						//System.out.println("DIKKA");
					} else {
						
						String valueI = String.valueOf(i);
						String valueJ = String.valueOf(j);
						String valueIJ = valueI + valueJ;
						
						try {
							fm.writeFile(valueIJ);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
			
			AcceptDialog();
			dispose();
			userSchedule1.dispose();
			
			
		}
	}
	
	
}
