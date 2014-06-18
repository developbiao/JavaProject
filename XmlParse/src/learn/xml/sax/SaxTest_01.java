/**
 * @Describetion:SAX解析xml分析
 * @Author:GongBiao
 * @Date:2014/05/18
 */
package learn.xml.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxTest_01 {
	public static void main(String[] args) throws Exception{
		
		//step1:获得SAX解析器工厂实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//step2:获得SAX解析器实例
		SAXParser parser = factory.newSAXParser();
		
		//step3:开始进行解析
		parser.parse(new File(".\\document\\Student.xml"), new MyHandler());
	}
}
