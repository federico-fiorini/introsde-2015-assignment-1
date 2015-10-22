package execute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import jaxb.JAXBMarshaller;
import people.People;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

public class MarshalPeople {

	public static void main(String[] argv) throws IOException {
		
		/*
		 * MARSHALLING XML
		 *****************/

		// New factory
		people.ObjectFactory factory = new people.ObjectFactory();

		// Create people element
		People people = factory.createPeople();

		// Create new person
		People.Person person = createPerson(
			factory,
			1,
			"Pippo",
			"Pluto",
			"1985-09-14 14:00:00",
			"2000-09-14 09:30:00",
			180,
			75
		);

		// Add person to list
		List<People.Person> personList = people.getPerson();
		personList.add(person);

		// Create new person
		person = createPerson(
			factory,
			2,
			"Jon",
			"Snow",
			"1995-01-14 12:00:00",
			"2015-05-15 09:30:00",
			175,
			80
		);

		// Add person to list
		personList.add(person);

		// Create new person
		person = createPerson(
			factory,
			3,
			"Tizio",
			"Caio",
			"1990-04-10 10:00:00",
			"2005-07-14 05:30:00",
			180,
			75
		);

		// Add person to list
		personList.add(person);

		// Create xml document
		String xmlDocument = "src/xml/marshalled_people.xml";

		System.out.println("\n===============================");
		System.out.println("Marshaling people in " + xmlDocument + " document");
		System.out.println("--------------------------------");

		// Marshall people to xml document
		JAXBMarshaller jaxbMarshaller = new JAXBMarshaller();
		jaxbMarshaller.marshalToXML(new File(xmlDocument), people, "people");

		// Print file content
		BufferedReader in = new BufferedReader(new FileReader(xmlDocument));
		String line;
		while((line = in.readLine()) != null)
		{
		    System.out.println(line);
		}
		in.close();

		/*
		 * UNMARSHALLING XML
		 *******************/

		System.out.println("\n===============================");
		System.out.println("Unmarshaling people from " + xmlDocument + " document");
		System.out.println("--------------------------------");

		// Unmarshal xml
		String schemaFile = "src/xml/people.xsd";
		People unmarshalledPeople = (People) jaxbMarshaller.unMarshallFromXML(new File(xmlDocument), new File(schemaFile), "people");
		
		// Print unmarshalled people
		List<People.Person> unmarshalledPersonList = unmarshalledPeople.getPerson();
		for (int i = 0; i < unmarshalledPersonList.size(); i++) {

			People.Person pers = (People.Person) unmarshalledPersonList.get(i);

			System.out.println("Person Id: " + pers.getId());
			System.out.println("First name: " + pers.getFirstname());
			System.out.println("Last name: " + pers.getLastname());
			System.out.println("Birthdate: " + pers.getBirthdate());
			System.out.println("Last update: " + pers.getHealthprofile().getLastupdate());
			System.out.println("height: " + pers.getHealthprofile().getHeight());
			System.out.println("weight: " + pers.getHealthprofile().getWeight());
			System.out.println("bmi: " + pers.getHealthprofile().getBmi() + "\n");
		}

		/*
		 * MARSHALLING JSON
		 *******************/

		// Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		// Adding the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        
		// Configure as necessary
		mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        // Serialize to json string
        String result = mapper.writeValueAsString(people);

        // Write to console and to file
        String jsonDocument = "src/json/marshalled_people.json";

        System.out.println("\n===============================");
		System.out.println("Marshaling people in " + jsonDocument + " document");
		System.out.println("--------------------------------");
        System.out.println(result);

        mapper.writeValue(new File(jsonDocument), people);
	}

	/**
	 * Helper method to create a person
	 *
	 * @param factory
	 * @param firstName
	 * @param lastName
	 * @param birthDate
	 * @param lastUpdate
	 * @param height
	 * @param weight
	 * @return person
	 */
	public static People.Person createPerson(
		people.ObjectFactory factory,
		int id,
		String firstName,
		String lastName,
		String birthDate,
		String lastUpdate,
		int height,
		int weight
	) {
		// Create a new person
		People.Person person = factory.createPeoplePerson();
		person.setId(new BigDecimal(String.valueOf(id)));
		person.setFirstname(firstName);
		person.setLastname(lastName);
		person.setBirthdate(birthDate);
		
		// Create person health profile
		People.Person.Healthprofile healthProfile = factory.createPeoplePersonHealthprofile();
		healthProfile.setLastupdate(lastUpdate);
		healthProfile.setHeight(height);
		healthProfile.setWeight(new BigDecimal(String.valueOf(weight)));
		float bmi = (float) (weight/(Math.pow(height, 2)));
		healthProfile.setBmi(bmi);
		person.setHealthprofile(healthProfile);

		return person;
	}
}
