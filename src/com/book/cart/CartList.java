package com.book.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.books.dao.BookDao;
import com.books.dao.BookDaoImp;
import com.books.pojo.Books;

public class CartList{

	Books books=new Books();
	Map<String,Books> cart=new HashMap<>();
	private BookDao dao = new BookDaoImp();
	private int count=0;
	
	public int getCount() {
		return count;
	}

	public void addBookToCart(String bookName)
	{
		boolean flag=true;
		
		count++;
		
		for(Books book: cart.values())
		{
			if(book.getBookName().equals(bookName))
			{
				book.setBookCount(book.getBookCount()+1);
				flag= false;
				break;
			}
		}
		if(flag)
		{
			for(Books book: dao.viewAllBooks())
			{
				if(book.getBookName().equals(bookName))
				{
					cart.put(book.getBookName(), book);
					break;
				}
			}
		}
		
	}
	
	public Collection<Books> displayCart()
	{
		return cart.values();
		
	}

	public void removeFromCart(String removedBook) {
		
		count--;
		for(Books book: cart.values())
		{
			if(book.getBookName().equals(removedBook) && book.getBookCount()==1)
			{
				cart.remove(book.getBookName());
				break;
			}
			if(book.getBookName().equals(removedBook) && book.getBookCount()>1)
			{
				book.setBookCount(book.getBookCount()-1);
				break;
			}
		}
		
				
	}
	
}
