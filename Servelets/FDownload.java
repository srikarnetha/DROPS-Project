package com.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Encrypt;


import com.Database.Database;

/**
 * Servlet implementation class FDownload
 */
@WebServlet("/FDownload")
public class FDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FDownload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out=response.getWriter();
		// TODO Auto-generated method stub
		try {
			String fid = request.getParameter("fid");
			System.out.println(fid);
			Connection con = Database.getConnection();
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select * from upload where fid='"+ fid + "'");
			OutputStream o = response.getOutputStream();
			//PrintWriter out=response.getWriter();
			if (r.next()) {
				response.setContentType(r.getString(6));
				/*o.write(r.getBytes(4));
				o.write(r.getBytes(5));
				o.write(r.getBytes(6));
				o.write(r.getBytes(7));*/
				StringBuffer sb=new StringBuffer();
				sb.append(r.getBytes(4));
				sb.append(r.getBytes(5));
				sb.append(r.getBytes(6));
				sb.append(r.getBytes(7));
				String encytext=Encrypt.encrypt(sb.toString(), "Java");
				//o.write(Byte.parseByte(encytext));
				
				  String example = "Convert Java String";
				  byte[] bytes = encytext.getBytes();
				//out.print(encytext);
				o.write(bytes);
				
			}
			o.flush();
			o.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
