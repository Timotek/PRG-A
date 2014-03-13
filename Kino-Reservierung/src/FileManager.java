import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class FileManager {
	
	String filename;
	static File file;
	String line;
	FileReader fileReader;
	BufferedReader bufferedReader;
	
	PrintWriter printWriter = null;
	BufferedWriter bufferedWriter = null;
	
	public FileManager(){
		/*
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	
	public void chooseFile(String filename){
		
		this.filename = filename;
		
		//Datei muss zuerst vom FTP-Server downgeloaded werden
		new UploadDownload(false, this.filename);
		
		file = new File(filename);
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//zweit chooseFile methode fuer writeFile
	public void chooseFileWrite(String filename){
		
		this.filename = filename;		
		file = new File(filename);
		
		try {

			printWriter = new PrintWriter(file);
			bufferedWriter = new BufferedWriter(printWriter);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	
	public String readHall(){

		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return line;
	}
	

	public String readFile(){

		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //int stringToInt = Integer.parseInt(line);
		//return stringToInt;
		return line;
	}
	
	//writeFile schreibt mit einem buffered Writer in Textdateien, 
	//die vorher ueber chooseFileWrite ausgewaehlt werden
	public void writeFile(String value) throws IOException{
		
		String writerValue = value;
		bufferedWriter.write(value);
	    bufferedWriter.write(System.getProperty("line.separator"));
		bufferedWriter.flush();
	
	}
	

	//createFile-Methode erstellt die User-Dateien im User-Ordner des Hauptverzeichnisses
	public void createFile(String filename){
		file = new File("User\\"+filename);
		try (final PrintWriter fileWriter = new PrintWriter(file);) {
		
		}
		catch (FileNotFoundException e) {
			
		}
		
	}
	
	
	//searchFile durchsucht Userordner im Projekthauptverzeichnis nach bestimmter Datei
	//hier: durchsucht, ob ein Username bei Registrierung schon vorhanden ist
	public boolean searchFile(String Filename){
		filename = "User\\"+Filename;
		System.out.println("Dateiname, nach dem gesucht wird: "+filename);
		File f = new File("User\\");
		File[] fileArray = f.listFiles();
		
		for (int i = 0; i < fileArray.length; i++){
			String arrayFileName = fileArray[i].getPath().toString();
			System.out.println(arrayFileName);
			if (arrayFileName.equalsIgnoreCase(filename)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public void writeLine(String search, String write){
		String temp1 = search;
		String temp2 = write;
		
		
		System.out.println(temp1 + temp2);
		
	}
	
	
}