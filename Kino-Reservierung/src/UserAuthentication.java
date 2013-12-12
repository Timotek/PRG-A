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

public class UserAuthentication extends JFrame{
	
	//
	
	
	
	JButton btnok = new JButton("OK");
	JLabel hint = new JLabel("Hinweis");
	JLabel subtext = new JLabel("Sitzplatz erfolgreich gebucht");
	
	public UserAuthentication(){
		
		//
		super("User Bestätigung");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLayout(new GridLayout(10, 1));

		//
		for(int i = 1; i <= 10 ; i++){
			
			JPanel panel = new JPanel();
			add(panel);
			
			if(i==4){
				
				panel.add(hint);
				hint.setFont(new Font("Arial", Font.PLAIN, 22));
				
			}
				else if(i==5){
					panel.add(subtext);
					subtext.setFont(new Font("Arial", Font.ITALIC, 12));
					
			}
				else if(i==6){
					panel.add(btnok);
			}
			
				
			 
		
			//
		}
	}
	
	
	public static void main(String [] args){
		
		UserAuthentication userWindow = new UserAuthentication();
		userWindow.setVisible(true);
	}
	
}

//neu
