package jaxb;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;

public class CustomValidationEventHandler implements ValidationEventHandler {
	
	/**
	 * Handle event
	 *
	 * @param event
	 * @return
	 */
	public boolean handleEvent(ValidationEvent event) {
		// If WARNING: return
		if (event.getSeverity() == ValidationEvent.WARNING) {
			return true;
		}

		// If ERROR: print error message
		if ((event.getSeverity() == ValidationEvent.ERROR)
				|| (event.getSeverity() == ValidationEvent.FATAL_ERROR)) {

			System.out.println("Validation Error:" + event.getMessage());

			ValidationEventLocator locator = event.getLocator();
			System.out.println("at line number:" + locator.getLineNumber());
			System.out.println("Unmarshalling Terminated");
			return false;
		}

		return true;
	}
}
