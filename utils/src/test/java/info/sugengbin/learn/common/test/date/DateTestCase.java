package info.sugengbin.learn.common.test.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Test;

public class DateTestCase {

	@Test
	public void testXMLGregorianCalendar() throws DatatypeConfigurationException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		XMLGregorianCalendar time = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);
		System.out.println(time);//2016-05-04T10:30:00.492+08:00
	}
}
