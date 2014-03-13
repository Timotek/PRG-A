import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HallAdmin extends JFrame{
	
	//Hier werden zwei HashMaps erstellt, in denen spaeter die 
	//Reihen als JPanels und die Sitze als JCheckboxen
	//gespeichert werden
	public static Map<String,JCheckBox> seatList = new HashMap<>();
	public static Map<String,JPanel> rowList = new HashMap<>();
	
	//Die zwei Buttons...
	JButton save = new JButton("Speichern");
	JButton discard = new JButton("Zurueck");
	
	public HallAdmin(){
		
		//Standard-Kontruktor...
		super("Hall Overview - Admin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLayout(new GridLayout(9,1));

		//Erste For-Schleife: Hier werden die Reihen erstellt,
		//dann in die HashMap geladen und dem JFrame hinzugefuegt
		for(int i = 1; i <= 9 ; i++){
			
			String row = "row"+i;
			rowList.put(row, new JPanel());
			JPanel panel = rowList.get(row);
			add(panel);
			
			if(i<=8){
				
				JLabel label = new JLabel("Reihe"+i);
				panel.add(label);
				
			} else { 
				
				panel.add(save);
				panel.add(discard);
				
			}
			
			
			//Verschachtelte For-Schleife: Hier werden die Sitze 
			//erstellt, in die HashMap geladen und dem JPanel hinzugefuegt
			for(int j = 1; j <= 13; j++){
				
				if(i==9){
					break; //"Reihe" 9 bleibt frei fuer die Buttons
				}
				String seat = "seat"+j;
				seatList.put(seat, new JCheckBox());
				panel.add(seatList.get(seat));
				
			}			
		}
	}
	
}
