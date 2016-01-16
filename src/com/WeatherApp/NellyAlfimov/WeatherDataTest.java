package com.WeatherApp.NellyAlfimov;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class WeatherDataTest {
	
	WeatherData test;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		test=WeatherData.getInstance();
	}

	@Test
	public void testGetTemrature() {
		
		test.setTemrature(34.2);;
		assertEquals((Double)34.2,test.getTemrature());
	
	}

	@Test
	public void testGetWindspeed() {
		
		test.setWindspeed(4.6);
		assertEquals((Double)4.6,test.getWindspeed());
		
		
	}

	@Test
	public void testGetHumidity() {
	 
		test.setHumidity(7.5);
		assertEquals((Double)7.5,test.getHumidity());
	}

	@Test
	public void testGetPressure() {
		test.setPressure(3.4);
		assertEquals((Double)3.4,test.getPressure());
	}

	@Test
	public void testGetDescription() {
		test.setDescription("rain");
		assertEquals("rain",test.getDescription());
	}

	@Test
	public void testToString() throws WeatherDataServiceException{
		
		Location loc=new Location("barcelona","spain");
		test.getWeatherData(loc);
		assertTrue(test.toString().contains("ES"));
	}

	@Test
	public void testGetInstance() throws WeatherDataServiceException{
	     
		WeatherData test1=WeatherData.getInstance();
		
		assertTrue(test.hashCode()==test1.hashCode());
		
	}

	@Test
	public void testGetWeatherData() throws WeatherDataServiceException {
		
		Location loc=new Location("holon","israel");
		test.getWeatherData(loc);
		assertTrue(test.getLocation().getCountry().equals("IL"));
		
	}

}
