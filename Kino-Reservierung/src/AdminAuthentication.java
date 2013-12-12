import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminAuthentication extends JFrame{
	
	//
	
	
	JButton btnok2 = new JButton("OK");
	JLabel hint2 = new JLabel("Hinweis");
	JLabel subtext2 = new JLabel("�nderungen erfolgreich gespeichert");
	
	public AdminAuthentication(){
		
		
		super("Admin Best�tigung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLayout(new GridLayout(10, 1));

		
		for(int i = 1; i <= 10 ; i++){
			
			JPanel panel = new JPanel();
			add(panel);
			
			if(i==4){
				
				panel.add(hint2);
				hint2.setFont(new Font("Arial", Font.PLAIN, 22));
				
			}
				else if(i==5){
					panel.add(subtext2);
					subtext2.setFont(new Font("Arial", Font.ITALIC, 12));
					
			}
				else if(i==6){
					panel.add(btnok2);
			}
			
				
			 
		
			
		}
	}
	
	
	public static void main(String [] args){
		
		//AdminAuthentication adminWindow = new AdminAuthentication();
		//adminWindow.setVisible(true);
	}
	
}

//neu