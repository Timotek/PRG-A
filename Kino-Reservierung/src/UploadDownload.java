
public class UploadDownload {
	
	String ftpFile;
	boolean connected;		//wenn boolean upload == true, dann wird upload-Methode aufgerufen
	SimpleFTPClient f;		//upload == false bedeutet download
	
	
	UploadDownload(boolean upload, String ftpFile){		
		
	//Ftp-Server initialisieren
		this.ftpFile = ftpFile;
		f = new SimpleFTPClient ();
		f.setHost("tks.square7.ch");
		f.setUser("tks_prg");
		f.setPassword("wennsImArschloch3*Knallt!");
		f.setRemoteFile(ftpFile);
		System.out.println(ftpFile);
		connected = f.connect();
		
		if (upload == true) {
			upload();
		}
		else {
			download();	
		}
	}
	
	void upload(){
		if ( connected){
		  // Upload a file from your local drive, lets say in “c:/ftpul/u.txt”
		  if (f.uploadFile(ftpFile)){
		    // display the message of success if uploaded
		  System.out.println(f.getLastSuccessMessage ());
		  }
		  else
		    System.out.println(f.getLastErrorMessage ());
		  }
		  else
		  // Display any connection exception, if any
		    System.out.println(f.getLastErrorMessage ()); 
	}
	
	void download(){
		if ( connected){
			  // The downloaded file to be saved to the local drive
			  // as mydl.txt and in the subfoler c:\ftpdownloads
			  if (f.downloadFile(ftpFile))
			    // display the message of success if uploaded
			    System.out.println(f.getLastSuccessMessage ());
			  else
			    System.out.println(f.getLastErrorMessage ());
			}
			else
			  // Display any connection exception, if any
			  System.out.println(f.getLastErrorMessage ());
	}
	
	
	//public static void main (String[] args){
	//	new UploadDownload(true, "User/test.txt");
	//}
}
