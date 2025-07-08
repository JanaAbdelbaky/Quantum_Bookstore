import java.util.List;

import book.*;


public class Main {
	
	public static void main(String[] args) {

        

        BookStore store = new BookStore();

        // Add books
        PaperBook paperBook1 = new PaperBook("ISBN001", "Clean Code", 2010, 45.0, 10);
        EBook ebook1 = new EBook("ISBN002", "Effective Java", 2018, 30.0, "PDF");
        DemoBook demoBook1 = new DemoBook("ISBN003", "Demo Only", 2005);

        store.add(paperBook1);
        store.add(ebook1);
        store.add(demoBook1);

        System.out.println("Books added to inventory.");

        // Remove outdated books
        System.out.println(" Removing outdated books...");
        List<Book> outdatedBooks = store.remove(30);
        for (Book b : outdatedBooks) {
            System.out.println("Removed outdated book - " + b.getTitle());
        }

        // Try buying a paper book
        try {
            System.out.println("Buying paper book...");
            double total = store.buy("ISBN001", 2, "user@example.com", "123 Main St");
            System.out.println("Purchase successful. Paid amount: $" + total);
        } catch (Exception e) {
            System.out.println("Error - " + e.getMessage());
        }

        // Try buying an eBook
        try {
            System.out.println(" Buying eBook...");
            double total = store.buy("ISBN002", 1, "ebookuser@example.com", "N/A");
            System.out.println(" Purchase successful. Paid amount: $" + total);
        } catch (Exception e) {
            System.out.println("Error - " + e.getMessage());
        }

        // Try buying a demo book (should throw error)
        try {
            System.out.println(" Trying to buy demo book...");
            store.buy("ISBN003", 1, "demo@example.com", "N/A");
        } catch (Exception e) {
            System.out.println(" Error - " + e.getMessage());
        }

      
    }
}
