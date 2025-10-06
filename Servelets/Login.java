package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database.Database;
import com.bean.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

       
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       
        User u=new User();
        u.setEmail(email);
        u.setPassword(password);
        HttpSession session = request.getSession();
		
			session.setAttribute("uid", email);
			/*
			 * if ( email.isEmpty() || password.isEmpty()) {
			 * out.println("<p style='color:red;'>Please fill in all fields.</p>"); } else {
			 * // Here you can perform database operations to store the registration data //
			 * For demonstration purposes, just print the submitted data
			 * out.println("<p style='color:green;'>Login successful!</p>");
			 * 
			 * out.println("<p>Email: " + email + "</p>"); out.println("<p>Password: " +
			 * password + "</p>"); }
			 */
        try {
			ResultSet rs=Database.Login(u);
			if(rs.next()) {
				System.out.println("sucessfully Logined");
				response.sendRedirect("loinhome.jsp");
			}else {
				System.out.println("not logined");
				response.sendRedirect("Loin.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
