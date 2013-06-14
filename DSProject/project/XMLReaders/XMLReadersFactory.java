package XMLReaders;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLReadersFactory 
{
	
	public static XMLReader getReader(String xmlString) throws ParserConfigurationException, SAXException, IOException
	{
		
		DocumentBuilder builder  = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xmlString));
		Document doc = builder.parse(is);
		NodeList nodeList =  doc.getElementsByTagName("message");
		//String type = nodeList.item(0).getAttributes().getNamedItem("type").getNodeValue();
		switch (nodeList.item(0).getAttributes().getNamedItem("type").getNodeValue()) 
		{
			case "sitePage":
				return new SitePageReader();
				
			case "hello":
				return new HelloMessageReader();
				
			default:
				return null;
		}
	}
}
