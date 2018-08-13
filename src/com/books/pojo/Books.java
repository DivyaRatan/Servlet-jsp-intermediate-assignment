package com.books.pojo;

public class Books {
	
	private String bookName;
	private int price;
	private int bookCount;
	private String description;
	private String author;
	public Books()
	{
		
	}

	public Books(String bookName, int price, int bookCount, String description, String author) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.bookCount = bookCount;
		this.description = description;
		this.author = author;
	}





	public String getBookName() {
		return bookName;
	}


	public int getPrice() {
		return price;
	}






	public String getDescription() {
		return description;
	}






	public String getAuthor() {
		return author;
	}






	@Override
	public String toString() {
		return "Books [bookName=" + bookName + ", price=" + price + "]";
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	

	

}
