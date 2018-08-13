package com.cg.shoopingcart;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.books.pojo.Books;
import com.books.service.BookServiceImp;

@WebServlet("*.app")
public class ShoppingAppController extends HttpServlet {

	BookServiceImp service = new BookServiceImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Collection<Books> cartList = service.displayCart();
		session.setAttribute("cartList", cartList);
		session.setAttribute("count", service.getCount());
	
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/welcome.app":
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
			dispatcher.forward(request, response);

			break;
			
		case "/refresh.app":
		
			service.addNewBook();

			Collection<Books> book = service.viewAllBooks();
			request.setAttribute("books", book);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("home.jsp");
			dispatcher1.forward(request, response);

			break;
			
		case "/addtocart.app":

			String bookName=request.getParameter("bookName");
			service.addBooksToCart(bookName);
			response.sendRedirect("refresh.app");
			break;
			
		case "/cart.app":

			

			cartList.stream().forEach(System.out::println);

			
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("cart.jsp");
			dispatcher2.forward(request, response);
			break;
		case "/delete.app":
			
			String removedBook=request.getParameter("bookName");
			System.out.println(removedBook);
			service.removeFromCart(removedBook);
			service.displayCart();
			response.sendRedirect("cart.app");
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
