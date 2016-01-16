package com.WeatherApp.NellyAlfimov;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WeatherDataServiceException extends Exception {

	public WeatherDataServiceException(String string) {
		JOptionPane.showMessageDialog(new JFrame(), string, "Warning",
				JOptionPane.ERROR_MESSAGE);
	}

	public WeatherDataServiceException(Location location) {
		 
		String message =  "City: " +location.getCity()+"  or Country : "+location.getCountry()+" does not exist!";
		JOptionPane.showMessageDialog(new JFrame(), message, "Warning",
				JOptionPane.ERROR_MESSAGE);
	}

}
