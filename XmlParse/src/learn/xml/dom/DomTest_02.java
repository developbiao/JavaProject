package learn.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomTest_02 {
	
	public static void main(String[] args) throws Exception{
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();    //DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();                   //DocumentBilder   
		Document document = db.parse(new File(".\\document\\candidate.xml"));   //DocumentBilder
		
		NodeList list = document.getElementsByTagName("PERSON");
		
		for (int i = 0; i < list.getLength(); i++){
			
			Element element = (Element)list.item(i);
			
			String content = element.getElementsByTagName("NAME").item(0).getFirstChild().getNodeValue();
			System.out.println("name:" + content);
			
			content = element.getElementsByTagName("ADDRESS").item(0).getFirstChild().getNodeValue();
			System.out.println("address:" + content);
			
			content = element.getElementsByTagName("TEL").item(0).getFirstChild().getNodeValue();
			System.out.println("tel:" + content);
			
			content = element.getElementsByTagName("FAX").item(0).getFirstChild().getNodeValue();
			System.out.println("fax:" + content);
			
			content = element.getElementsByTagName("EMAIL").item(0).getFirstChild().getNodeValue();
			System.out.println(content);
			
			System.out.println("--------------------------");
			
		}
		
		System.out.println("is ok !");
	}

}
