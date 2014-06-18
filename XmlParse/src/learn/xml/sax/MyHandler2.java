package learn.xml.sax;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler2 extends DefaultHandler {

	// ����stack����
	private Stack<String> stack = new Stack<String>();
	private String name;
	private String gender;
	private String age;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		stack.push(qName);

		for (int i = 0; i < attributes.getLength(); i++) {

			String attrName = attributes.getQName(i);
			String attrValue = attributes.getValue(i);

			System.out.println(attrName + "=" + attrValue);
		}

	}
	
	
	public void characters(char[] ch, int start, int length) throws SAXException{
		
		String tag = stack.peek();
		if ("����".equals(tag)){
			name = new String (ch, start, length);
		}else if ("�Ա�".equals(tag)){
			gender = new String (ch, start, length);
		}else if ("����".equals(tag)){
			age = new String (ch, start, length);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		stack.pop(); //��ʾ��Ԫ���Ѿ�������ϣ���Ҫ��stack�е���
		
		if ("ѧ��".equals(qName)){
			System.out.println("����: " + name);
			System.out.println("�Ա�: " + gender);
			System.out.println("����: " + age);
			
			System.out.println();
		}
	}
	

}
