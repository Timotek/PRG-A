import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;


	public class Register extends JFrame {

		//Organisation
		
		// Variablen für Klasse User
		String firstName;
		String name;
		String birthday;
		String email;
		String userName;       						  
		String pw;  
		String pw2;

		
		private JLabel firstNameLabel = new JLabel();
		private JLabel nameLabel = new JLabel();
		private JLabel birthdayLabel = new JLabel();
		private JLabel emailLabel = new JLabel();
		private JLabel userNameLabel = new JLabel();    	   
		private JLabel pwLabel = new JLabel();    
		private JLabel pw2Label = new JLabel();  
		
		public JPanel northPanel;
		public JPanel westPanel;
		public JPanel eastPanel;
		public JPanel southPanel;

		public JTextField firstNameTF = new JTextField(25);
		public JTextField nameTF = new JTextField(25);
		public JTextField birthdayTF = new JTextField(25);
		public JTextField emailTF = new JTextField(25);
		public JTextField userNameTF = new JTextField(25);				
		public JPasswordField pwTF = new JPasswordField(25);	
		public JPasswordField pw2TF = new JPasswordField(25);

		public static JButton closeButton;
		
		////////////////////////////////////////////////////////////////////////////////

		public Register(){
			super("Registrierung");
			//Auskommentiert, damit sich nur das Register Fenster, jedoch nicht das gesamte Programm schließt.
			
			setSize(542,270);
			setLayout(new BorderLayout());
			firstNameLabel.setForeground(Color.WHITE);
			nameLabel.setForeground(Color.WHITE);
			birthdayLabel.setForeground(Color.WHITE);
			emailLabel.setForeground(Color.WHITE);
			userNameLabel.setForeground(Color.WHITE);
			pwLabel.setForeground(Color.WHITE);
			pw2Label.setForeground(Color.WHITE);

			//Formular-Panel
			westPanel = new JPanel(new GridLayout(8,0));
			add(westPanel, BorderLayout.WEST);
			westPanel.setBackground(Color.DARK_GRAY);

			eastPanel = new JPanel(new GridLayout(8,0));
			add(eastPanel, BorderLayout.EAST);
			eastPanel.setBackground(Color.DARK_GRAY);

			//southPanel = new JPanel(new FlowLayout());
			//add(southPanel, BorderLayout.SOUTH);

			firstNameLabel.setText(" Vorname: ");
			nameLabel.setText(" Name: ");
			userNameLabel.setText(" Username:");									
			pwLabel.setText(" Passwort");	
			pw2Label.setText(" Passwort wiederholen:");
			birthdayLabel.setText(" Geburtsdatum:  (TT.MM.JJJJ)");
			emailLabel.setText(" Email-Adresse:  (mustermann@domain.de)");
			
			westPanel.add(firstNameLabel);
			westPanel.add(nameLabel);
			westPanel.add(userNameLabel);						
			westPanel.add(pwLabel);	
			westPanel.add(pw2Label);	
			westPanel.add(birthdayLabel);
			westPanel.add(emailLabel);

			eastPanel.add(firstNameTF);	
			eastPanel.add(nameTF);
			eastPanel.add(userNameTF);							
			eastPanel.add(pwTF);	
			eastPanel.add(pw2TF);
			eastPanel.add(birthdayTF);
			eastPanel.add(emailTF);

			//Actionlistener für Registerbutton
			JButton registerButton = new JButton("Registrieren");
			registerButton.addActionListener (new DataActionListener (firstNameTF, nameTF, birthdayTF, emailTF, userNameTF, pwTF, pw2TF));
			westPanel.add(registerButton);
			JButton abortButton = new JButton("Zurück");
			//Button zum Abbrechen eingefügt
			eastPanel.add(abortButton);
			abortButton.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent e) {
		            dispose();
		            }
		        });
			
		}

		/////////////////////////////////////////////////////////////////////////////////
		
		//ActionListener für 5 Usereingaben
		
		//ActionEvents für UserDaten
		public class DataActionListener implements ActionListener {

			private JTextField firstNameTF;
			private JTextField nameTF;
			private JTextField birthdayTF;
			private JTextField emailTF;
			private JTextField userNameTF;
			private JPasswordField pwTF;
			private JPasswordField pw2TF;

			public DataActionListener (JTextField firstNameTF, JTextField nameTF, JTextField birthdayTF, JTextField emailTF, JTextField userNameTF, JPasswordField pwTF2, JPasswordField pw2tf2){
				this.firstNameTF = firstNameTF;
				this.nameTF = nameTF;
				this.birthdayTF = birthdayTF;
				this.emailTF = emailTF;
				this.userNameTF = userNameTF;
				this.pwTF = pwTF2;
				this.pw2TF = pw2tf2;
			}
			@Override
			public void actionPerformed (ActionEvent e){
				firstName = firstNameTF.getText();
				name = nameTF.getText();
				birthday = birthdayTF.getText();
				email = emailTF.getText();
				userName = userNameTF.getText();
				pw = String.valueOf(pwTF.getPassword());
				pw2 = String.valueOf(pw2TF.getPassword());
				System.out.println (firstName);
				System.out.println (name);
				System.out.println(birthday);
				System.out.println (email);
				System.out.println (userName);
				System.out.println (pw);
				System.out.println (pw2);
				if(comparePassword()==true && checkIfFilledIn()==true){
					sendData();
					//Fenster schließen.
					dispose();
					
				
					
				}
			}
		}

		//Vergleich der Passworteingabe
		public boolean comparePassword(){
			if(pw.equals(pw2)) {
			    System.out.println("gleich");
			    return true;
			}
			 else {
				 System.out.println("ungleich");
				 pwDialog();  
			     return false;
			    }
			}
		
		
		//Überprüfen, ob alle Felder ausgefüllt
		public boolean checkIfFilledIn(){
			if (firstName.equals("") | name.equals("") | birthday.equals("") | email.equals("") | 
					userName.equals("") | pw.equals("") | pw2.equals("")){
				filledInDialog();
				return false;
			}
			else {
				return true;
			}
		}
		
		//JDialog Fester, falls nicht alle Daten ausgefüllt wurden
		public void filledInDialog(){
			final JDialog filledInDialog = new JDialog();
			filledInDialog.setTitle("Fehler!");
			filledInDialog.setSize(200,100);
			filledInDialog.setModal(false);
			//filledInDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
			filledInDialog.setLayout(new GridLayout(2,1));
			filledInDialog.add(new JLabel(" Bitte füllen Sie alle Felder aus!"));    
		    JButton closeButton = new JButton("Zurück");
		    filledInDialog.add(closeButton);
		    filledInDialog.setVisible(true);
		    closeButton.addActionListener(new ActionListener(){
		    
		    public void actionPerformed(ActionEvent e) {
		    	filledInDialog.dispose();	
		    }
		    }); 		
		}
		
		//Dialog wenn Registrierung erfolgreich war.
		public static void finishedDialog(){
			final JDialog filledInDialog = new JDialog();
			filledInDialog.setTitle("Registrierung erfolgreich!");
			filledInDialog.setSize(400,100);
			filledInDialog.setModal(false);
			filledInDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
			filledInDialog.setLayout(new GridLayout(2,1));
			filledInDialog.add(new JLabel("Sie haben sich erfolgreich registriert!"));    
		    JButton closeButton = new JButton("schließen");
		    filledInDialog.add(closeButton);       
		    filledInDialog.setVisible(true);

		    closeButton.addActionListener(new ActionListener(){
		    
		    public void actionPerformed(ActionEvent e) {
		    	filledInDialog.dispose();	
		    }
		    }); 		
		}
		
		
		
		//JDialog Fenster falls das Passwort falsch ist
		public void pwDialog() {
			final JDialog pwDialog = new JDialog();
	        pwDialog.setTitle("Achtung");
	        pwDialog.setSize(200,200);
	        pwDialog.setModal(false);
	        pwDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	        pwDialog.setSize(200,200);
	        pwDialog.setLayout(new FlowLayout());
	        pwDialog.add(new JLabel("Passwörter nicht identisch!"));    
	        JButton closeButton = new JButton("Zurück");
	        pwDialog.add(closeButton);       
	        pwDialog.setVisible(true);
	        closeButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e) {
	        		pwDialog.dispose();	
	        	}
	        });  
	    }
		
	   //Übergabe der Userdaten an User.java
		public void sendData(){
			new User(firstName, name, birthday, email, userName, pw);
			System.out.println("SendData wurde ausgeführt");	
		}
		
		/////////////////////////////////////////////////////////////////////

		public static void main (String[] args){
			Register app = new Register();
			app.setVisible(true);
		}
	}
	
	//neu