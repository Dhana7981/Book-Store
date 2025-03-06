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
@WebServlet(name="add",urlPatterns="/addToCart")
public class AddToCartServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		System.out.println("----AddToCartServlet----");
		// Collect input data
		String bname=req.getParameter("bname");
		System.out.println(bname);
		// Do Processing
		String page="showBooks.jsp";
		HttpSession session=req.getSession();
		List<String> mycart=(List<String>)session.getAttribute("MyCart");
		if(mycart==null) {
		mycart=new ArrayList<>();
		}
		mycart.add(bname);
		session.setAttribute("MyCart", mycart);
		System.out.println(mycart);
		// Forward
		RequestDispatcher rd=req.getRequestDispatcher(page);
		rd.forward(req,res);
	}
}
