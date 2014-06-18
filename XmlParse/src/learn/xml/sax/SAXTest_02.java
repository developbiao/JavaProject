/**
 * @Describetion:SAXParserDemo
 * @Date:2014/05/18
 * @Author:GongBiao
 */
package learn.xml.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXTest_02 {
	
	// π”√SAXΩ‚Œˆ
	//SAX:Simple APIS for XML
	
	public static void main(String[] args) throws Exception{
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(new File(".\\document\\Student.xml"), new MyHandler2());
		
		System.out.println("is ok !");
	}

}

