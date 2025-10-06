package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Database.Database;


@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Download() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String fid=request.getParameter("fid");	
			Connection con=Database.getConnection();
			Statement st=con.createStatement();
			ResultSet r=st.executeQuery("select * from upload where fid='"+fid+"'");
			
			OutputStream o = response.getOutputStream();
			if(r.next())
			{                                              
			
				response.setContentType(r.getString(5));
				
				o.write(r.getBytes(4));
			}
			o.flush();
			o.close();
			}catch (Exception exception){
				exception.printStackTrace();
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
