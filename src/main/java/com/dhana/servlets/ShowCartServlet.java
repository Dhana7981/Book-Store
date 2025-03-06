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
@WebServlet(name="show",urlPatterns="/showMyCart")
public class ShowCartServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
		System.out.println("----ShowCartServlet----");
		// Collect input data
		// Do Processing
		String page="showCart.jsp";
		// Forward
		RequestDispatcher rd=req.getRequestDispatcher(page);
		rd.forward(req,res);
	}
}
