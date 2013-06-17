package XMLReaders;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import GUI.LogFrame;
import GUI.MainScrean;

public class HelloMessageReader extends XMLReader {
	
	private Document xml;

	public HelloMessageReader(Document textContent) 
	{
		this.xml = textContent;
	}

	@Override
	public void execute() throws ParserConfigurationException, SAXException, IOException 
	{
		String userName = "";
		
		LinkedList<Object[]> sites = new  LinkedList<>();
		
		
		DocumentBuilder builder  = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
		NodeList nodesName =  xml.getElementsByTagName("name");
		userName = nodesName.item(0).getTextContent();
		NodeList nodes = xml.getElementsByTagName("sites");
		nodes = ((Element) nodes.item(0)).getElementsByTagName("site");
		
		for  ( int i = 0 ; i < nodes.getLength() ; i++  )
		{
			Object[] object = new Object[2];
			object[0] = (((Element) nodes.item(i)).getElementsByTagName("name")).item(0).getTextContent();
			object[1] = (((Element) nodes.item(i)).getElementsByTagName("id")).item(0).getTextContent();
			sites.add(object);
		}
		
		MainScrean.getInstance().addToTree( userName , sites );

	
	}
}
