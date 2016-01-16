package com.WeatherApp.NellyAlfimov;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class WeatherController implements Observer{

	WeatherData model;
	ViewData view;
	
	
	public WeatherController(WeatherData model, ViewData view) {
	
		this.model =model;
		this.view = view;
		this.view.addListener(new buttonListener());
		
	}



	public class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			Location location=new Location(view.cityText.getText(),view.countryText.getText());
			try {
		       
				model.getWeatherData(location);
			} catch (WeatherDataServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}

	}




	@Override
	public void update(Observable arg0, Object arg) {
		
		view.textResult.setText(model.toString());
		
	  
		
	}
	
	
	
	
	

}
