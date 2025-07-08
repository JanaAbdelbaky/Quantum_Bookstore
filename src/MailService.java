import book.EBook;


public class MailService {
	
	public static void sendEmail(EBook eBook, String email){
		System.out.println(eBook.getTitle() +":"+ eBook.getFileType() +" will be sent to " + email);		
	}
}
