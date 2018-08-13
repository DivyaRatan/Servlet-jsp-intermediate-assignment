package com.books.dao;


import java.util.Collection;

import com.books.pojo.Books;

public interface BookDao {

	void addBook(Books books);
	
	Collection<Books> viewAllBooks();
	
	Books getBookByName(String bookName);
	
}
