/**
 * @Descretion:DOM解析任意xml文档
 * @Date:2014/05/14
 * @Author:GongBiao
 */
package learn.xml.dom_test;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest_02 {
	
	public static void main(String[] args) throws Exception{
		
		//解析三步曲
		DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = bdf.newDocumentBuilder();
		Document doc = db.parse(new File(".\\document\\Student.xml"));
		
		//获得根元素
		Element root = doc.getDocumentElement();
		parseElement(root);
		
		
		
		System.out.println("is ok !");
	}

	private static void parseElement(Element element) {
		// 解析元素的方法
		
		String tagName = element.getNodeName();
		
		NodeList children = element.getChildNodes();
		
		System.out.print("<" + tagName);
		
		//element元素的所有属性所构成的NamedNodeMap对象, 需要对其进行判断
		NamedNodeMap map = element.getAttributes();
		
		//如果元素存在属性
		if (null != map){
			for (int i = 0; i < map.getLength(); i++){
				//获得廖该元素的每一个属性
				Attr attr = (Attr)map.item(i);
				
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				
				System.out.println(" " + attrName + "=\"" + attrValue + "\"");
			}
		}
		System.out.print(">");
		
		for (int i = 0; i < children.getLength(); i++){
				Node node = children.item(i);
				
				//获得节点的类型
				short nodeType = node.getNodeType();
				
				if (nodeType == node.ELEMENT_NODE){
					//是元素，继续递归
					parseElement((Element)node);
				}else if (nodeType == node.TEXT_NODE){
					//递归出口
					System.out.print(node.getNodeValue());
				}else if (nodeType == Node.COMMENT_NODE){
					System.out.print("<!--");
					Comment comment = (Comment)node;
					
					//Commnet注释内容
					String data = comment.getData();
					System.out.print(data);
					System.out.print("-->");
					
				}
		}
		
		System.out.println("</" + tagName + ">");
	}

}
