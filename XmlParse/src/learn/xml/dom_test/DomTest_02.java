/**
 * @Descretion:DOM��������xml�ĵ�
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
		
		//����������
		DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = bdf.newDocumentBuilder();
		Document doc = db.parse(new File(".\\document\\Student.xml"));
		
		//��ø�Ԫ��
		Element root = doc.getDocumentElement();
		parseElement(root);
		
		
		
		System.out.println("is ok !");
	}

	private static void parseElement(Element element) {
		// ����Ԫ�صķ���
		
		String tagName = element.getNodeName();
		
		NodeList children = element.getChildNodes();
		
		System.out.print("<" + tagName);
		
		//elementԪ�ص��������������ɵ�NamedNodeMap����, ��Ҫ��������ж�
		NamedNodeMap map = element.getAttributes();
		
		//���Ԫ�ش�������
		if (null != map){
			for (int i = 0; i < map.getLength(); i++){
				//����θ�Ԫ�ص�ÿһ������
				Attr attr = (Attr)map.item(i);
				
				String attrName = attr.getName();
				String attrValue = attr.getValue();
				
				System.out.println(" " + attrName + "=\"" + attrValue + "\"");
			}
		}
		System.out.print(">");
		
		for (int i = 0; i < children.getLength(); i++){
				Node node = children.item(i);
				
				//��ýڵ������
				short nodeType = node.getNodeType();
				
				if (nodeType == node.ELEMENT_NODE){
					//��Ԫ�أ������ݹ�
					parseElement((Element)node);
				}else if (nodeType == node.TEXT_NODE){
					//�ݹ����
					System.out.print(node.getNodeValue());
				}else if (nodeType == Node.COMMENT_NODE){
					System.out.print("<!--");
					Comment comment = (Comment)node;
					
					//Commnetע������
					String data = comment.getData();
					System.out.print(data);
					System.out.print("-->");
					
				}
		}
		
		System.out.println("</" + tagName + ">");
	}

}
