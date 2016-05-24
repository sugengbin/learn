package info.sugengbin.learn.common.test.date;

import info.sugengbin.learn.common.utils.MyDateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class DateTestCase {

	@Test
	public void testXMLGregorianCalendar() throws DatatypeConfigurationException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		XMLGregorianCalendar time = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);
		System.out.println(time);//2016-05-04T10:30:00.492+08:00
	}
	
	@Test
	public void testDatePeriod(){
		Date startDate = MyDateUtils.parseDate("2016-05-21 09:02:39", MyDateUtils.FORMAT_PATTERN_YMDHMS);
		Date endDate = MyDateUtils.parseDate("2016-05-21 15:02:39", MyDateUtils.FORMAT_PATTERN_YMDHMS);
		Assert.assertEquals("09:02-15:02", MyDateUtils.datePeriod(startDate, endDate));
		
	    startDate = MyDateUtils.parseDate("2016-05-21 04:20:39", MyDateUtils.FORMAT_PATTERN_YMDHMS);
	    endDate = MyDateUtils.parseDate("2016-05-21 09:02:39", MyDateUtils.FORMAT_PATTERN_YMDHMS);
		Assert.assertEquals("04:20-09:02", MyDateUtils.datePeriod(startDate, endDate));
		
		startDate = MyDateUtils.parseDate("2016-05-21 12:20:39", MyDateUtils.FORMAT_PATTERN_YMDHMS);
		endDate = MyDateUtils.parseDate("2016-05-21 15:02:39", MyDateUtils.FORMAT_PATTERN_YMDHMS);
		Assert.assertEquals("12:20-15:02", MyDateUtils.datePeriod(startDate, endDate));
		
	}
}
