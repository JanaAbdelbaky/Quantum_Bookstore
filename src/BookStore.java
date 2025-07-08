import java.util.ArrayList;
import java.util.List;

import book.*;


public class BookStore {
	private List<Book> inventory = new ArrayList<>();

	public List<Book> getInventory() {
		return inventory;
	}

	public void setInventory(List<Book> inventory) {
		this.inventory = inventory;
	}
	
	public void add(Book book){
		inventory.add(book);
	}
	
	public List<Book> remove(int noOfYear){
		List<Book> outdatedBooks = new ArrayList<>();
		int currentYear = 2025;
		for(Book book: inventory){
			if((currentYear - book.getYear()) > noOfYear){
				outdatedBooks.add(book);
			}
		}
		inventory.removeAll(outdatedBooks);
		return outdatedBooks;
	}
	
	public double buy(String isbn, int quantity, String email, String address){
		Book book = null;
		for(Book b: inventory){
			if(b.getIsbn().equals(isbn)){
				book = b;
				break;
			}
		}
		if(book == null){
			throw new IllegalArgumentException(isbn + " is not found");
		}
		
		if(book instanceof DemoBook){
			throw new IllegalArgumentException("Book " + book.getTitle() + " is not for sale");
		}
		
		else if(book instanceof PaperBook){
			PaperBook paperBook = (PaperBook) book;
			if(paperBook.getStock() == 0){
				throw new IllegalArgumentException(book.getTitle() +  " is out of stock.");
			}
			if(paperBook.getStock() < quantity ){
				throw new IllegalArgumentException("Book " + book.getTitle() + " does not have enough quantity.");
			}
			ShippingService.ship(paperBook, address);
			paperBook.setStock(paperBook.getStock() - quantity);
			return paperBook.getPrice() * quantity;
		}
		
		else if(book instanceof EBook){
			EBook eBook = (EBook) book;
			MailService.sendEmail(eBook, email);
			return eBook.getPrice();
		}
		return -1;
	}


}
