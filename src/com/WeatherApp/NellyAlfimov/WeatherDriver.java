package com.WeatherApp.NellyAlfimov;

public class WeatherDriver {
	public static void main(String[] args) {

		ViewData theView = new ViewData();
		
		WeatherData theModel = WeatherData.getInstance();
		theModel.addObserver(theView);
		
		new WeatherController(theModel, theView);
		
	
	}
}
