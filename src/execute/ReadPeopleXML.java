package execute;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import xpath.PeopleXMLReader;

public class ReadPeopleXML {

	public static void main(String[] args) throws ParserConfigurationException,
		SAXException, IOException, XPathExpressionException {
	
		PeopleXMLReader reader = new PeopleXMLReader();
		reader.loadXML("src/xml/people.xml");

		System.out.println("\n===============================");
		System.out.println("Print all people");
		System.out.println("--------------------------------");
		reader.printAllPeople();
		
		System.out.println("\n===============================");
		System.out.println("Print health profile person 5");
		System.out.println("--------------------------------");
		reader.printHealthProfile(5);

		System.out.println("\n===============================");
		System.out.println("Print people with weight > 90");
		System.out.println("--------------------------------");
		reader.printByWeight(90, '>');
	}
}
