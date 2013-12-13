
public class UploadDownload {
	
	boolean connected;		//wenn boolean upload == true, dann wird upload-Methode aufgerufen
	SimpleFTPClient f;		//upload == false bedeutet download
	
	
	UploadDownload(boolean upload){			
		
	//Ftp-Server initialisieren
		f = new SimpleFTPClient ();
		f.setHost("tks.square7.ch");
		f.setUser("tks_prg");
		f.setPassword("wennsImArschloch3*Knallt!");
		f.setRemoteFile("/test/testupload.txt");
		f.connect();
		
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
		  if (f.uploadFile("testupload.txt"))
		    // display the message of success if uploaded
		  System.out.println(f.getLastSuccessMessage ());
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
			  if (f.downloadFile("dl.txt"))
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
	//	new UploadDownload();
	//}
}
