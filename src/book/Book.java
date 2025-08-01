package book;

public abstract class Book {
	private String isbn;
	private String title;
	private int year;
	private double price;
	
	public Book(String isbn, String title, int year, double price){
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
