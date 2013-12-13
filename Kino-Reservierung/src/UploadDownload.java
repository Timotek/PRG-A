
public class UploadDownload {
	
	//Ftp-Server initialisieren
	UploadDownload(){
		SimpleFTPClient f = new SimpleFTPClient ();
		f.setHost("tks.square7.ch");
		f.setUser("tks_prg");
		f.setPassword("wennsImArschloch3*Knallt!");
		f.setRemoteFile("/test/testupload.txt");
		boolean connected=f.connect();
	
/*	//Upload
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
*/	
	//Download
		//f.setRemoteFile("test/dl.txt");
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
	
	public static void main (String[] args){
		new UploadDownload();
	}
}
