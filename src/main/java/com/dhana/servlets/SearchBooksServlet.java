package com.dhana.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name="search",urlPatterns="/searchBooks")
public class SearchBooksServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		System.out.println("----SearchBooksServlet----");
		// Collect input data
		String cat=req.getParameter("category");
		System.out.println(cat);
		// Do Processing
		HttpSession session=req.getSession();
		session.setAttribute("CAT",cat);
		// Make Empty Cart Ready
		List<String> mycart1 = (List<String>) session.getAttribute("MyCart");
		if(mycart1==null) {
			List<String> mycart=new ArrayList<>();
			session.setAttribute("Mycart", mycart);
		}
		List<String> blist=new ArrayList<>();
		String msg="";
		String page="";
		if(cat==null || cat.length()==0) {
			msg="Please Select category";
			req.setAttribute("MSG", msg);
			page="index.jsp";
		}else if(cat.equals("Java")) {
			blist.add("Master Java8");
			blist.add("Master Spring5");
			blist.add("Master Hibernate5");
			blist.add("Master Spring Boot");
			blist.add("Master MicroServices");
			session.setAttribute("BooksList", blist);
			page="showBooks.jsp";
		}else if(cat.equals("Web")) {
			blist.add("Learn Java Script");
			blist.add("Learn Angular");
			blist.add("Learn React");
			blist.add("Learn Nod JS");
			session.setAttribute("BooksList", blist); // IMP
			page = "showBooks.jsp";
		}else if(cat.equals("Python")) {
			msg="Sorry, No Books For"+cat;
			req.setAttribute("MSG", msg);
			page="index.jsp";
		}
		// Forward
		RequestDispatcher rd=req.getRequestDispatcher(page);
		rd.forward(req,res);
	}
}
