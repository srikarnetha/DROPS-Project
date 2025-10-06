package com.servlet;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import utils.SplitNumber;


import com.Database.Database;
import com.algorithms.RandomeString;
import com.dao.Test;

/**
 * Servlet implementation class Upload
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part filepart=request.getPart("file");
    	String fname=request.getParameter("fname");
		
    	HttpSession ses=request.getSession(false);
    	String uid=(String)ses.getAttribute("uid");
    	Part filepart1=request.getPart("file");
    	
		InputStream inputStream, input,input1, input2,input3;
		FileOutputStream filePart;
		String file=filepart1.getName();
		int fileSize = (int) filepart1.getSize();
		System.out.println(fileSize);
		int PART_SIZE = (int)fileSize/2;
		int nChunks = 0, read = 0, readLength = PART_SIZE;
		String num=RandomeString.getFid();
		byte[] byteChunkPart, byteChunkPart1;
		String key=RandomeString.getSaltString();
		try {
		Connection con=Database.getConnection();
		Statement st=con.createStatement();
		input1 = filepart.getInputStream();
		input = filepart.getInputStream();
		input2 = filepart.getInputStream();
		input3 = filepart.getInputStream();
		  String result1 = new BufferedReader(new InputStreamReader(input))
	        .lines().collect(Collectors.joining("\n"));
		  System.out.println(result1);
		  int length=result1.length();
		   
		   int a[]=SplitNumber.splitIntoParts(length,5);
		   System.out.println(a.length);
		   for(int i : a) {
			   System.out.println("values from array"+i);
		   }
		   HashSet<String> set=new HashSet<>();
		  
		   for(int i=0;i<a.length;i++) {
			    
			   set.add(result1.substring(0,100));
		   }
		   
		  for(String s1: set) {
			  System.out.println("set values"+s1);
		  }
		  
		   
		   String s1=result1.substring(101,170);
		   String h1=  GFG2.getHash(s1);
		   if(s1!=null) {
			int i=   Database.node1(num,uid, s1,h1);
		   }
		   else {
			   System.out.println("data not inserted");
		   }
		  
		   String s2=result1.substring(171,250);
		   String h2=  GFG2.getHash(s2);
		   if(s2!=null) {
				int i=   Database.node2(num,uid, s2,h2);
			   }
			   else {
				   System.out.println("data not inserted");
			   } 
			  
		   String s4=result1.substring(251,320);
		   String h4=  GFG2.getHash(s4);
		   if(s4!=null) {
				int i=   Database.node3(num,uid, s4,h4);
			   }
			   else {
				   System.out.println("data not inserted");
			   }
			  
		   String s5=result1.substring(321,400);
		   String h5=  GFG2.getHash(s5);
		   if(s1!=null) {
				int i=Database.node4(num,uid, s5,h5);
			   }
			   else {
				   System.out.println("data not inserted");
			   }
			  
		   String s6=result1.substring(401);
		   String h6=  GFG2.getHash(s6);
		   if(s1!=null) {
				int i= Database.node5(num,uid, s6,h6);
			   }
			   else {
				   System.out.println("data not inserted");
			   }
		   System.out.println(s1+"first node");
		   System.out.println(s2+"second node");
		   System.out.println(s4+"third node");
		   System.out.println(s5+"Fourth node");
		   System.out.println(s6+"fifth node");
		   String s8[]=new String[5];
		   s8[0]=s1;s8[1]=s2;s8[2]=s4;s8[3]=s5;
		   s8[4]=s6;
		String type=filepart.getContentType();
		System.out.println(num);
		
		String sql ="insert into upload values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		String hashValue=  GFG2.getHash(fname);
		filePart = new FileOutputStream(fname);
		ps.setString(1, num);
		ps.setString(2, uid);
		ps.setString(3, fname);
		ps.setBinaryStream(4, input1);
		ps.setString(5, type);
		/* ps.setString(6, fdes); */
		ps.setString(6, key);
		
		ps.setString(7, hashValue);
		int i = ps.executeUpdate();
		
      
        
        
        
		 
		   
		/*System.out.println(i+" "+file);
			inputStream = filepart1.getInputStream();
			int ji=0;
			while (fileSize > 0) {
				ji++;
				if (fileSize <= 5) {
					readLength = fileSize;
				}
				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, readLength);
				fileSize -= read;
				String text = new String(byteChunkPart);
				String key1 = RandomeString.getSaltString();
				String enc = Test.encryption(text, key1);
				byteChunkPart1 = enc.getBytes();
				String tx = new String(byteChunkPart1);
				System.out.println(tx);
				PreparedStatement ps2=con.prepareStatement("update upload set part"+ji+"=?, f"+ji+"key=? where fid=?");	
				PreparedStatement ps1=con.prepareStatement("update upload1 set f"+ji+"key=? where fid=?");
				assert (read == byteChunkPart.length);
				nChunks++;
				File nf=new File("temp.txt");
				//Use SHA-1 algorithm
			//	MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
				 
				//SHA-1 checksum 
				//String shaChecksum = getFileChecksum(shaDigest, file);
			
			
				filePart.write(byteChunkPart1);
				ps2.setBinaryStream(1, new FileInputStream(nf), fileSize);
				ps2.setString(2, key1);
				ps2.setString(3, num);
				ps1.setString(1, key1);
				ps1.setString(2, num);
				int i2=ps2.executeUpdate();
				i2 = ps1.executeUpdate();
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;
				byteChunkPart1 = null;
				System.out.println(nChunks+" "+i2) 
			}
			inputStream.close();*/
		if(i!=-1){
			request.setAttribute("result", s8);
		RequestDispatcher	requestDispatcher=request.getRequestDispatcher("upload.jsp");
		
            requestDispatcher.forward(request, response);
		//	response.sendRedirect("upload.jsp?Uploaded Data Has Stored Successfully in The Database");
			System.out.println("completed");
		}else{
			response.sendRedirect("upload.jsp?Failed to upload");
			System.out.println("error");
		}
			
		} catch (IOException | SQLException exception) {
			exception.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
