package com.wang108.chatservlet;
2222
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.jdom.Element;

public class Entry {

	private String ip;
	private Calendar time;
	private String content;
	
	public Entry( String ip, String content ) {
		this.ip = ip;
		this.time = Calendar.getInstance();
		this.content = content;
	}

	public Element toXMLElement(){
		
		Element ipElement = new Element("IP");
		ipElement.addContent(ip);
		
		Element timeElement = new Element("time");
		timeElement.addContent(getTimeInString());
		
		Element contentElement = new Element("content");
		contentElement.addContent(content);
		
		Element rootElement = new Element("Entry");
		rootElement.addContent(ipElement);
		rootElement.addContent(timeElement);
		rootElement.addContent(contentElement);
		
		return rootElement;
	}
	
	private String getTimeInString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(time.getTime());
	}
	
}
