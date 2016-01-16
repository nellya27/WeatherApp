package com.WeatherApp.NellyAlfimov;

import java.util.Observer;

public interface IWeatherDataService extends Observer {
	
	public void getWeatherData(Location location)
			throws WeatherDataServiceException;
	
	

}
