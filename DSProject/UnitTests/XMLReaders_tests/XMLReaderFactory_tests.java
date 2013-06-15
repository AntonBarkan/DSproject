package XMLReaders_tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import net.jxta.endpoint.Message;
import net.jxta.endpoint.MessageElement;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import XMLReaders.HelloMessageReader;
import XMLReaders.SitePageReader;
import XMLReaders.XMLReadersFactory;


public class XMLReaderFactory_tests 
{
	
	Message message;

	@Before
	public void setUp() throws Exception 
	{
		this.message = mock(Message.class);
	}

	@Test
	public void testGetHtmlPageReader() throws ParserConfigurationException, SAXException, IOException 
	{
		String xmlString = "<?xml version=\"1.0\"?>"+
								"<message type=\"sitePage\">"+
								"</message>" ;
		
		MessageElement me = mock(MessageElement.class);
		when(me.getBytes(true)).thenReturn( xmlString.getBytes() );
		when(message.getMessageElement("Msg")).thenReturn( me );
				
		assertEquals(XMLReadersFactory.getReader(message).getClass(),SitePageReader.class);
	}
	
	@Test
	public void testHelloReader() throws ParserConfigurationException, SAXException, IOException 
	{
		String xmlString = "<?xml version=\"1.0\"?>"+
								"<message type=\"hello\">"+
								"</message>" ;
		
		MessageElement me = mock(MessageElement.class);
		when(me.getBytes(true)).thenReturn( xmlString.getBytes() );
		when(message.getMessageElement("Msg")).thenReturn( me );
		
		assertEquals(XMLReadersFactory.getReader(message).getClass(), HelloMessageReader.class);
	}

}
