package xpath;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

public class PeopleXMLReader {

	Document doc;
    XPath xpath;

    /**
     * Method to load XML file
     *
     * @param xmlFilepath
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    public void loadXML(String xmlFilepath) throws ParserConfigurationException, SAXException, IOException {

    	// Instantiate new factory
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);

        // Build new document give file path
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        doc = builder.parse(xmlFilepath);

        // Create Xpath object
        buildXPath();
    }

    /**
     * Build Xpath object
     *
     * @return XPath
     */
    public XPath buildXPath() {

        XPathFactory factory = XPathFactory.newInstance();
        xpath = factory.newXPath();

        return xpath;
    }

    /**
     * Print HealthProfile to console given person ID.
     *
     * @param personId
     * @throws XPathExpressionException
     */
    public void printHealthProfile(int personId) throws XPathExpressionException {
    	
    	System.out.println("Person " + personId + " HealthProfile:");

    	// Get HealthProfile node
    	Node node = getHealthProfile(personId);    	

    	// Print node
        printNode(node, 0);
    }

    /**
     * Method to print all people in XML file
     *
     * @throws XPathExpressionException
     */
    public void printAllPeople() throws XPathExpressionException {
    	
    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person");
        NodeList people = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        // For each person: print node
        for (int i = 0; i < people.getLength(); i++) {
        	Node person = people.item(i);
        	printNode(person, 0);
        }
    }

    /**
     * Method to print people by given weight and operator (eg. >60)
     *
     * @param weight
     * @param op
     * @throws XPathExpressionException
     */
    public void printByWeight(int weight, char op) throws XPathExpressionException {
    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[healthprofile[weight" + op + weight +"]]");
        NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        // For each person: print node
        for (int i = 0; i < nodeList.getLength(); i++) {
        	Node person = nodeList.item(i);
        	printNode(person, 0);
        }
    }

    /**
     * Get first name by person Id
     *
     * @param personId
     * @return String
     * @throws XPathExpressionException
     */
    public String getFirstName(int personId) throws XPathExpressionException {

    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[@id='" + personId + "']/firstname");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        return node.getTextContent();
    }

    /**
     * Get last name by person Id
     *
     * @param personId
     * @return String
     * @throws XPathExpressionException
     */
    public String getLastName(int personId) throws XPathExpressionException {

    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[@id='" + personId + "']/lastname");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        return node.getTextContent();
    }

    /**
     * Get birth date by person Id
     *
     * @param personId
     * @return String
     * @throws XPathExpressionException
     */
    public String getBirthdate(int personId) throws XPathExpressionException {

    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[@id='" + personId + "']/birthdate");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        return node.getTextContent();
    }

    /**
     * Get last update by person Id
     *
     * @param personId
     * @return String
     * @throws XPathExpressionException
     */
    public String getLastUpdate(int personId) throws XPathExpressionException {

    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[@id='" + personId + "']/healthprofile/lastupdate");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        return node.getTextContent();
    }

    /**
     * Get weight by person Id
     *
     * @param personId
     * @return String
     * @throws XPathExpressionException
     */
    public String getWeight(int personId) throws XPathExpressionException {

    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[@id='" + personId + "']/healthprofile/weight");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        return node.getTextContent();
    }

    /**
     * Get height by person Id
     *
     * @param personId
     * @return String
     * @throws XPathExpressionException
     */
    public String getHeight(int personId) throws XPathExpressionException {

    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[@id='" + personId + "']/healthprofile/height");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        return node.getTextContent();
    }

    /**
     * Get bmi by person Id
     *
     * @param personId
     * @return String
     * @throws XPathExpressionException
     */
    public String getBmi(int personId) throws XPathExpressionException {

    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[@id='" + personId + "']/healthprofile/bmi");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        return node.getTextContent();
    }

    /**
     * Method to get HealthProfile Node given person ID.
     * Return HealthProfile node.
     *
     * @param personId
     * @return Node
     * @throws XPathExpressionException
     */
    private Node getHealthProfile(int personId) throws XPathExpressionException {

    	// Define xpath expression and get result node
        XPathExpression expr = xpath.compile("//person[@id='" + personId + "']/healthprofile");
        Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);

        return node;
    }

    /**
     * Helper method to recursively print node values
     *
     * @param node
     * @param l
     */
    private void printNode(Node node, int l) {
    	// Pretty output
    	String tab = new String(new char[l + 1]).replace("\0", "\t");
    	if (l == 0)
    		System.out.print("\n");

    	// If the node has Element children: recursively print them
    	if (hasElementChild(node)) {
    		// Get node name
    		String nodeName = node.getNodeName();

    		// Get node attributes
    		String attributes = "";
    		NamedNodeMap attributesNode = node.getAttributes();
    		for (int i = 0; i < attributesNode.getLength(); i++) {
    	        Node attr = attributesNode.item(i);
    	        attributes += attr.getNodeName() + "=" + attr.getNodeValue() + ",";
    		}
    		attributes = rtrim(attributes, ',');
    		if (attributes != "")
    			attributes = "[" + attributes + "]";

    		// Print node name[attributes]
    		System.out.print(" - " + nodeName + attributes + ":\n" + tab);
    		
    		// Recursively print child nodes
    		NodeList childNodes = node.getChildNodes();
    		for (int i = 0; i < childNodes.getLength(); i++) {
    			printNode(childNodes.item(i), l + 1);
    		}

    	} else {
    		// If node has no Element child: print node content
    		// Print node
    		String nodeName = node.getNodeName();

    		tab = new String(new char[l]).replace("\0", "\t");
        	if (nodeName != "#text") 
        		System.out.print(" - " + nodeName + ": " + node.getTextContent() + "\n" + tab);
    	}
    }

    /**
     * Helper method to check if Node has Element children
     *
     * @param node
     * @return boolean
     */
    private boolean hasElementChild(Node node) {
    	// Get all children
    	NodeList childNodes = node.getChildNodes();

    	// If one Element is found: return true
		for (int i = 0; i < childNodes.getLength(); i++) {
			if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
				return true;
			}
		}
	
		// Otherwise return false
		return false;
    }

    /**
     * Helper method to remove last character from string
     *
     * @param str
     * @param ch
     * @return
     */
    private String rtrim(String str, char ch) {
    	// Rtrim char from string
        if (str.length() > 0 && str.charAt(str.length()-1) == ch) {
          str = str.substring(0, str.length()-1);
        }

        return str;
    }
}
