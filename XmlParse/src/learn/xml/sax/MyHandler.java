package learn.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
	
	@Override
	public void startDocument() throws SAXException {
		
		System.out.println("parser began");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("parse finished");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("start elemnt");
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("finish element");
	}
}
