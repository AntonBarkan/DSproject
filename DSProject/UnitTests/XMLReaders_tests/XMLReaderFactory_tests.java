package XMLReaders_tests;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import XMLReaders.HelloMessageReader;
import XMLReaders.SitePageReader;
import XMLReaders.XMLReadersFactory;


public class XMLReaderFactory_tests 
{

	@Before
	public void setUp() throws Exception 
	{
	}

	@Test
	public void testGetHtmlPageReader() throws ParserConfigurationException, SAXException, IOException 
	{
		String xmlString = "<?xml version=\"1.0\"?>"+
								"<message type=\"sitePage\">"+
								"</message>" ;
				
		assertEquals(XMLReadersFactory.getReader(xmlString).getClass(),SitePageReader.class);
	}
	
	@Test
	public void testHelloReader() throws ParserConfigurationException, SAXException, IOException 
	{
		String xmlString = "<?xml version=\"1.0\"?>"+
								"<message type=\"hello\">"+
								"</message>" ;
				
		assertEquals(XMLReadersFactory.getReader(xmlString).getClass(), HelloMessageReader.class);
	}

}
