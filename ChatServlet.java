package com.wang108.chatservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChatServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3000652597264411394L;
	private ChatManager chatManager = new ChatManager();
	
	@Override
	public void doPost( HttpServletRequest request, HttpServletResponse response ){
		String ip = request.getRemoteAddr();
		String content = request.getParameter("content");
		chatManager.addEntry( new Entry(ip, content) );
	}

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException{
		PrintWriter writer = response.getWriter();
		writer.print(chatManager.getAllEntryInXML());
	}

}
