package XMLReaders_tests;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import XMLReaders.SitePageReader;

public class SitePageReader_tests {
	
	private SitePageReader reader;
		
	@Before
	public void setUp() throws Exception 
	{
		this.reader = new SitePageReader();
	}

	@Test
	public void test() throws ParserConfigurationException, SAXException, IOException {
		String xml = 			"<site id=\"1\" modified=\"17:50 12/06/2013\" >"+
									"<page id=\"1\" modified=\"17:50 12/06/2013\">"+
										"<![CDATA["+
										"<!DOCTYPE html>"+
										"<html>"+
										"<body>"+
										"<h1>My First Sendet Page</h1>"+
										"</body>"+
										"</html>"+
										"]]>"+
									"</page>"+
								"</site>";

		
		String expected = "<!DOCTYPE html>"+
							"<html>"+
							"<body>"+
							"<h1>My First Sendet Page</h1>"+
							"</body>"+
							"</html>";
		
		assertEquals(expected, this.reader.read(xml));
	}

}
