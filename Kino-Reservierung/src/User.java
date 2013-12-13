import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class User {
	private String firstName;
	private String name;
	private String email;
	private String userName;
	private String birthday;
	private String pw;									
	private String filename;
	FileManager fm = new FileManager();

	//‹bergabe der Userdaten im Konstruktor
	public User(String firstName, String name, String birthday, String email, String userName, String pw){
	  //this.ID = ID;
		this.firstName = firstName;
		this.name = name;
		this.birthday = birthday;
		this.email = email;
		this.userName = userName;
		this.pw = pw;
		createUser();
	}
	
	
	public void createUser(){				
		filename = userName;
		
		if (fm.searchFile(filename + ".txt") == true){
			userDialog();
		}
		else {
			fm.createFile(filename + ".txt");
			System.out.println("Datei " + filename + ".txt erstellt");
			sendUserData(firstName, name, birthday, email, userName, pw);
			String ftpUser = "user/" + filename + ".txt";
			System.out.println(ftpUser);
			new UploadDownload(true,ftpUser);
			Register.finishedDialog();

		}
	}
	
	public void userDialog() {
		final JDialog userDialog = new JDialog();
			userDialog.setTitle("Fehler");
			userDialog.setSize(400,100);
			userDialog.setModal(false);
			//userDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
			userDialog.setLayout(new GridLayout(2,1));
			userDialog.add(new JLabel("Der Username existiert bereits"));    
	        JButton closeButton = new JButton("schlieﬂen");
	        userDialog.add(closeButton);       
	        userDialog.setVisible(true);
	        closeButton.addActionListener(new ActionListener(){
	       
	        	public void actionPerformed(ActionEvent e) {
	        		userDialog.dispose();	
	        	}
	        });  
	 }
	

	public void sendUserData(Object object1, Object object2, Object object3, Object object4, Object object5, Object object6){

		try (final PrintWriter userWriter = new PrintWriter(FileManager.file);) {
		//	userWriter.println(ID);
			userWriter.println(object1);
			userWriter.println(object2);
			userWriter.println(object3);
			userWriter.println(object4);
			userWriter.println(object5);
			userWriter.println(object6);
			userWriter.close();
		}
		catch (FileNotFoundException e) {
			
		}
		
	}
	
	
/*	public static void main (String[] args){
		new User("Wurst", "Hans", "mist@wurst.de");	
		new User("Arte", "Tom", "tom@arte.de");	
		
	}
*/	
}
//neu
