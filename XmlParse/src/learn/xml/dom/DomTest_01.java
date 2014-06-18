/**
 * @Descrption: 解析xml流程
 * @Author: GongBiao
 * @Date: 2014/05/12
 */
package learn.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomTest_01 {
	public static void main(String[] args) throws Exception{
		
		//set1 :获得dom解析工厂(工作的作用是用于具体的解析器)
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		//set2 :获得具体的dom解析器
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		//set3: 解析一个xml文档,获得Document对象(根结点)
		
		Document document = db.parse(new File(".//document//candidate.xml"));
		
		NodeList list = document.getElementsByTagName("PERSON");
		
//		Element element1 = (Element)list.item(3);
//		String str = element1.getElementsByTagName("NAME").item(0).getFirstChild().getNodeValue();
		
//		System.out.println("--->>>>>" + str);
		
		for (int i = 0; i < list.getLength(); i++){
			
			Element element = (Element)list.item(i);
			
			String content = element.getElementsByTagName("NAME").item(0).getFirstChild().getNodeValue();
			System.out.println("name:" + content);
			
			content = element.getElementsByTagName("ADDRESS").item(0).getFirstChild().getNodeValue();
			System.out.println("address:" + content);
			
			content = element.getElementsByTagName("TEL").item(0).getFirstChild().getNodeValue();
			System.out.println("tel:" + content);
			
			content = element.getElementsByTagName("FAX").item(0).getFirstChild().getNodeValue();
			System.out.println(content);
			
			content = element.getElementsByTagName("EMAIL").item(0).getFirstChild().getNodeValue();
			System.out.println("fax:" + content);
			
			System.out.println("-------------------------------------------");
			
			
		}
		
		System.out.println("is ok !");
	}
}
