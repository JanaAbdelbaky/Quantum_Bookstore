import book.PaperBook;


public class ShippingService {
	
	public static void ship(PaperBook paperBook, String address){
		System.out.println(paperBook.getTitle() +" will be shipped to " +address);	
	}
}
