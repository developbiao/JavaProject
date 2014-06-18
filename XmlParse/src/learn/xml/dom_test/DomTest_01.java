/**
 * @Desribeion:DOM 解析XML文档学习
 * @Date:2014/05/14
 * @Author:GongBiao
 */
package learn.xml.dom_test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DomTest_01 {
	
		public static void main(String[] args) throws Exception{
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(".\\document\\Student.xml"));
			
			
			//获得元素根结点
			Element root = doc.getDocumentElement();
			
			System.out.println(root.getTagName());
			
			//获得子元素ChildNodes
			NodeList list = root.getChildNodes();
			System.out.println(list.getLength());
			
			for (int i = 0; i < list.getLength(); i++){
				System.out.println(list.item(i).getNodeName());
			}
			
			System.out.println("-----------------------------");
			
			//获得元素的类型
			
			for (int i = 0; i < list.getLength(); i++){
				Node n = list.item(i);
				System.out.println(n.getNodeType() + " : " + n.getNodeName());
			}
			
			System.out.println("------------------------------");
			
			//获得元素的TextContent
			for (int i = 0; i < list.getLength(); i ++){
				Node n = list.item(i);
				System.out.println(n.getTextContent());
			}
			
			System.out.println("-----------------------------");
			
			
			//获得属性
			
			NodeList nodelist = doc.getElementsByTagName("学生");
			for (int i = 0; i < nodelist.getLength(); i++){
				
				NamedNodeMap nnm = nodelist.item(i).getAttributes(); 
				String attrName = nnm.item(0).getNodeName();
				System.out.print(attrName);
				System.out.print("=");
				
				String attrValue = nnm.item(0).getNodeValue();
				System.out.println(attrValue);
			}
			
			
			
			System.out.println("is ok ");
		}

}
