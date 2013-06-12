package XMLReaders;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class SitePageReader extends XMLReader 
{

	public String read(String xml) throws ParserConfigurationException, SAXException, IOException 
	{
		DocumentBuilder builder  = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		Document doc = builder.parse(is);
		NodeList text =  doc.getElementsByTagName("site");
		text = ((Element) text.item(0)).getElementsByTagName("page");
		return text.item(0).getTextContent();
	}
	
	

}
