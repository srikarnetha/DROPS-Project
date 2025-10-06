package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Database.Database;
import com.bean.User;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        System.out.println("rfhhhh");

	        String username = request.getParameter("username");
	        String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        String mobile=request.getParameter("mobile");
	        String gender=request.getParameter("gender");
	        String address=request.getParameter("address");

			User user=new User();
			user.setName(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setMobile(mobile);
			user.setGender(gender);
			user.setAddress(address);
			System.out.println("jnjkndjjn");
			try {
				int i=Database.register(user);
				if(i>0) {
					System.out.println("data Saved");
				}else {
					System.out.println("data not saved");
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
	        

	        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || mobile.isEmpty()|| gender.isEmpty() || address.isEmpty()) {
	            out.println("<p style='color:red;'>Please fill in all fields.</p>");
	        } else {
	            // Here you can perform database operations to store the registration data
	            // For demonstration purposes, just print the submitted data
	            out.println("<p style='color:green;'>Registration successful!</p>");
	            out.println("<p>Username: " + username + "</p>");
	            out.println("<p>Email: " + email + "</p>");
	            out.println("<p>Password: " + password + "</p>");
	        }
	        
	}

}
