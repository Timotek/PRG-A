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
JButton registerButton = new JButton("New Here? Sign up!");


String userName;
String pw;

FileManager fileM = new FileManager(); // Filemanager neues Objekt

	public Login(){
//test
		//Standard-Konstruktor
		setDefaultCloseOperation(EXIT_ON_CLOSE); //das muessen wir spaeter wohl rausnehmen, hab gelesen, dass das stoeren kann, wenn man den jframe im browser darstellen moechte
		setSize(400,100);
		setLayout(new GridLayout(3,2));

		//Hinzufuegen der Komponenten zum JFrame
		add(userLabel);
		add(userField);
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
		@Override
		public void actionPerformed (ActionEvent e){
			userName = userField.getText();
			pw = String.valueOf(passField.getPassword());
			System.out.println (userName);
			System.out.println(pw);
			saveUserData();
			compareUserData();	
			
			if(userName.equals("admin")){
				System.out.println("DU bist admin");
				
				ScheduleAdmin adminSchedule = new ScheduleAdmin();
				adminSchedule.setVisible(true);
				
			}
			else{
			ScheduleUser userSchedule = new ScheduleUser();
			userSchedule.setVisible(true);
			}
			}
		}

	ArrayList userList = new ArrayList<Double>();
	//Scannen der txt Datei, Schreiben der Zeilen in ArrayList

	public void saveUserData(){	
		try { //Pfad zeigt auf User-Verzeichnis im Projektverzeichnis
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

	public void compareUserData(){

		if(pw.equals(userList.get(5)) ){
			System.out.println("Passwörter sind gleich!");
			System.out.println("Eingegebenes Passwort: " + pw);
			System.out.println("Gespeichertes Passwort: " + userList.get(5));
		}
		else {
			System.out.println("Passwörter nicht gleich!");
			loginDialog();
		}
		// eigentliche Funktion: Weiterleitung zur entsprechenden Seite bei erfolgreichem Login
		// bzw. bei fehlgeschlagenem Login JDialog Meldung
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






	public static void main(String[]args){
		Login app = new Login();
		app.setVisible(true);

	}
}

//neu