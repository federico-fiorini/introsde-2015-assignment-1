package jaxb;

import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JAXBMarshaller {
	
	/**
	 * Marshal Object and write it to provided XML file
	 *
	 * @param xmlDocument
	 * @param jaxbElement
	 * @param instanceName
	 */
	public void marshalToXML(
		File xmlDocument,
		Object jaxbElement,
		String instanceName
	) {
		try {
			// New instance
			JAXBContext jaxbContext = JAXBContext.newInstance(instanceName);

			// New Marshaller
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty("jaxb.formatted.output", new Boolean(true));

			// Marshal object to xml document
			marshaller.marshal(jaxbElement, new FileOutputStream(xmlDocument));

		} catch (IOException e) {
			System.out.println(e.toString());

		} catch (JAXBException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Unmarshal xmlDocument and return Object
	 *
	 * @param xmlDocument
	 * @param schemaFile
	 * @param instanceName
	 * @return
	 */
	public Object unMarshallFromXML(
		File xmlDocument,
		File schemaFile,
		String instanceName
	) {
		try {
			// New instance
			JAXBContext jaxbContext = JAXBContext.newInstance(instanceName);

			// Create Unmarshaller
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");

			// Set xsd schema
			Schema schema = schemaFactory.newSchema(schemaFile);
			unMarshaller.setSchema(schema);

			// Set event handler
			CustomValidationEventHandler validationEventHandler = new CustomValidationEventHandler();
			unMarshaller.setEventHandler(validationEventHandler);

			// Unmarshall xml document to Object
			@SuppressWarnings("unchecked")
			Object jaxbElement = unMarshaller.unmarshal(xmlDocument);

			return jaxbElement;

		} catch (JAXBException e) {
			System.out.println(e.toString());
		} catch (SAXException e) {
			System.out.println(e.toString());
		}

		return null;
	}

//	public void marshalToJSON(
//			File jsonDocument,
//			Object jaxbElement,
//			String instanceName
//		) {
//			try {
//				// New instance
//				JAXBContext jaxbContext = JAXBContext.newInstance(instanceName);
//
//				// New Marshaller
//				Marshaller marshaller = jaxbContext.createMarshaller();
//				marshaller.setProperty(MarshallerProperties.MEDIA_TYPE,"application/json");
//
//				// Marshal object to xml document
//				marshaller.marshal(jaxbElement, new FileOutputStream(xmlDocument));
//
//			} catch (IOException e) {
//				System.out.println(e.toString());
//
//			} catch (JAXBException e) {
//				System.out.println(e.toString());
//			}
//		}
}
