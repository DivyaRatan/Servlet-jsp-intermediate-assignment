package com.books.service;

import java.util.Collection;

import com.book.cart.CartList;
import com.books.dao.BookDao;
import com.books.dao.BookDaoImp;
import com.books.pojo.Books;

public class BookServiceImp implements BookService{

	private BookDao dao = new BookDaoImp();
	private CartList cart= new CartList();
	
	@Override
	public void addNewBook() {
		dao.addBook(new Books("Java Headfirst",400,1,"Java Fundamentals","Stephenie Meyer"));	

		dao.addBook(new Books("Let us C",350,1,"C Fundam,entals","Stephenie Meyer"));	

		dao.addBook(new Books("Word Power",600,1,"For learner of English","Stephenie Meyer"));	

		dao.addBook(new Books("Breaking Dawn Part 1",500,1,"Part 4 of the Saga","Stephenie Meyer"));	

			

	}

	@Override
	public Collection<Books> viewAllBooks() {
		
		return dao.viewAllBooks();
	}

	@Override
	public Books getBookByName(String bookName) {
		
		return dao.getBookByName(bookName);
	}
	
	public void addBooksToCart(String bookName)
	{
		
		cart.addBookToCart(bookName);
	}

	public Collection<Books> displayCart() {
		
		return cart.displayCart();
	}

	public void removeFromCart(String removedBook) {
		
		cart.removeFromCart(removedBook);
	}

	public int getCount()
	{
		return cart.getCount();
	}
}
