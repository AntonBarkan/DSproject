package XMLReaders;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public abstract class XMLReader {

	public abstract void execute() throws ParserConfigurationException, SAXException, IOException;


}