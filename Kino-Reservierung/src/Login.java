import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{

	
//Inititalisierung der Swing-Komponenten
JLabel userLabel = new JLabel("Username");
JLabel passLabel = new JLabel("Password");



JTextField userField = new JTextField();
JPasswordField passField = new JPasswordField();

JButton loginButton = new JButton("Login");
JButton logoutButton = new JButton("Logout");
JButton registerButton = new JButton("Register");
JButton schließenButton = new JButton("Schließen");


String userName;
String pw;

FileManager fileM = new FileManager(); // Filemanager neues Objekt

	public Login(){

		//Standard-Konstruktor
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //das muessen wir spaeter wohl rausnehmen, hab gelesen, dass das stoeren kann, wenn man den jframe im browser darstellen moechte
		setSize(450,150);
		setLayout(new GridLayout(4,2));
		//Hinzufuegen der Komponenten zum JFrame
		userLabel.setOpaque(true);
		userLabel.setBackground(Color.DARK_GRAY);
		userLabel.setForeground(Color.WHITE);
		
		add(userLabel);
		add(userField);
		
		passLabel.setOpaque(true);
		passLabel.setBackground(Color.DARK_GRAY);
		passLabel.setForeground(Color.WHITE);
		add(passLabel);
		add(passField);
		loginButton.addActionListener (new UserNameActionListener (userField, passField));	
		add(loginButton);
		registerButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
                Register register = new Register();
                register.setVisible(true);
            }
        });
		
		add(logoutButton);
		logoutButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose();
                logoutDialog();
                
                
			}});
		
		
		
		add(schließenButton);
		schließenButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
                dispose();
			}});
		add(registerButton);
		
		
		
	}


	//Login Erweiterung, Vergleich des Passworts in der user.txt
	//actionlistener für login button

	public class UserNameActionListener implements ActionListener {

		private JTextField userField;
		private JPasswordField passField;

		public UserNameActionListener (JTextField userField, JPasswordField passField){
			this.userField = userField;
			this.passField = passField;

	}
		
		public void actionPerformed (ActionEvent e){
			userName = userField.getText();
			pw = String.valueOf(passField.getPassword());
			System.out.println (userName);
			System.out.println(pw);
			searchUserData();
			//compareUserData();	
			
			if(userName.equals("admin")){
				System.out.println("DU bist admin");
				if (compareUserData() == true){
					ScheduleAdmin adminSchedule = new ScheduleAdmin();
					adminSchedule.setVisible(true);	
				}
			}
			
			else if (userName != ("admin")){
				System.out.println("Du bist User");
				if (compareUserData() == true){
					ScheduleUser userSchedule = new ScheduleUser();
					userSchedule.setVisible(true);	
				}
			}
		}
	}

	ArrayList userList = new ArrayList<Double>();
	//Scannen der txt Datei, Schreiben der Zeilen in ArrayList

	public void searchUserData(){	
		try { //Pfad zeigt auf User-Verzeichnis im Projektverzeichnis
			//Bevor die Datei lokal gesucht wird, muss sie auf dem FTP-Server gefunden und runtergeladen werden
			//Dies erledigt UploadDownload.java
			
			String userFileFTPPath = "User/"+userName+".txt";
			UploadDownload uploadDownload = new UploadDownload(false, userFileFTPPath);	//false, da ein Download in UploadDownload.java stattfinden soll
			
			//if (uploadDownload.download() == false) {
			
	//--------------------------------------------------------------------------------
			//FÜR LOKALE SUCHE:
			
			Scanner scan = new Scanner(new File("User\\"+userName + ".txt"));
			while(scan.hasNextLine()) {
				userList.add(scan.nextLine());
			}
			scan.close();	
			Iterator it = userList.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
	//--------------------------------------------------------------------------------
		
		catch(FileNotFoundException e) {
			System.out.println("Fehler: Quelldatei existiert nicht");
			loginDialog();
		}
		catch(Exception e) {
			System.out.println("Fehler: Ein unbekannter Fehler ist aufgetreten");
			System.exit(1);
		}
	}
	

	//nächster Schritt: arraylist durchsuchen nach eingegebenem Passwort

	public boolean compareUserData(){

		if(pw.equals(userList.get(5)) ){
			System.out.println("Passwörter sind gleich!");
			System.out.println("Eingegebenes Passwort: " + pw);
			System.out.println("Gespeichertes Passwort: " + userList.get(5));
			return true;
			
		}
		else {
			System.out.println("Passwörter nicht gleich!");
			loginDialog();
			return false;
		}
	}

	public void loginDialog() {
		final JDialog loginDialog = new JDialog();
		loginDialog.setTitle("");
		loginDialog.setSize(400,100);
		loginDialog.setModal(false);
		loginDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		loginDialog.setLayout(new FlowLayout());
		loginDialog.add(new JLabel("Das Passwort oder der Benutzername ist nicht korrekt"));
		JButton closeButton = new JButton("schließen");
		loginDialog.add(closeButton);
		loginDialog.setVisible(true);
		closeButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				loginDialog.dispose();	
			}
		});
	}
	
	public void logoutDialog() {
		final JDialog logoutDialog = new JDialog();
		logoutDialog.setTitle("");
		logoutDialog.setSize(260,100);
		logoutDialog.setBackground(Color.DARK_GRAY);
		logoutDialog.setModal(false);
		logoutDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		logoutDialog.setLayout(new FlowLayout());
		logoutDialog.add(new JLabel("Sie haben sich erfolgreich ausgeloggt!"));
		JButton closeButton = new JButton("schließen");
		JButton neuAnmelden = new JButton("Neu anmelden");
		logoutDialog.add(neuAnmelden);
		logoutDialog.add(closeButton);
		logoutDialog.setVisible(true);
		closeButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				logoutDialog.dispose();	
			}
		});
		
		neuAnmelden.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				logoutDialog.dispose();	
				Login login = new Login();
                login.setVisible(true);
			}
		});
	}


	public static void main(String[]args){
		Login app = new Login();
		app.setVisible(true);


	}
}

//neu