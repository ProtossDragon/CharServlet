package com.wang108.chatservlet;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class ChatManager {

	private static final int MAX_ENTRY_NUM = 100;
	private Queue<Entry> entryGroup = new LinkedList<Entry>();
	
	public void addEntry( Entry entry ){
		if ( entryGroup.size() == MAX_ENTRY_NUM )
			entryGroup.poll();
		entryGroup.offer(entry);
	}
	
	public String getAllEntryInXML(){
		Iterator<Entry> entryIterator = entryGroup.iterator();
		Element rootElement = new Element("EntryGroup");
		while ( entryIterator.hasNext() ){
			Entry entry = entryIterator.next();
			rootElement.addContent(entry.toXMLElement());
		}
		XMLOutputter xml = new XMLOutputter();
		return xml.outputString(rootElement);
	}

}
