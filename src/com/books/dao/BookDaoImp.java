package com.books.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.books.pojo.Books;

public class BookDaoImp implements BookDao{

	public static Map<String, Books> bookDB = new HashMap<>();
	
	@Override
	public void addBook(Books books) {
		
		bookDB.put(books.getBookName(), books);
		
	}

	@Override
	public Collection<Books> viewAllBooks() {
		
		return bookDB.values();
		
	}

	@Override
	public Books getBookByName(String bookName) {
		
		return bookDB.get(bookName);
		
	}

}
