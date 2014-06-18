/**
 * @Describetion:SAX����xml����
 * @Author:GongBiao
 * @Date:2014/05/18
 */
package learn.xml.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxTest_01 {
	public static void main(String[] args) throws Exception{
		
		//step1:���SAX����������ʵ��
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//step2:���SAX������ʵ��
		SAXParser parser = factory.newSAXParser();
		
		//step3:��ʼ���н���
		parser.parse(new File(".\\document\\Student.xml"), new MyHandler());
	}
}
