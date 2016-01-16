package com.WeatherApp.NellyAlfimov;


import java.util.Observable;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;

public class WeatherData extends Observable  implements IWeatherDataService {
	
	
   
	
	private Location location=new Location();
	private Double temprature;
	private Double windspeed;
	private Double humidity;
	private Double pressure;
	private String description;
	
	private static WeatherData instance=null;
	
	


  

	public WeatherData() {
		// TODO Auto-generated constructor stub
	}


	public WeatherData(Location location, Double temrature, Double windspeed, Double humidity, Double pressure,
			String description) {
	
		this.location = location;
		this.temprature = temrature;
		this.windspeed = windspeed;
		this.humidity = humidity;
		this.pressure = pressure;
		this.description = description;
	}





   public Double getTemrature() {
	return temprature;
   }


 public void setTemrature(Double temrature) {
	this.temprature = temrature;
 }


	public Double getWindspeed() {
		return windspeed;
	}

	
	public void setWindspeed(Double windspeed) {
		this.windspeed = windspeed;
	}
    

	public Double getHumidity() {
		return humidity;
	}


	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}


	public Double getPressure() {
		return pressure;
	}


	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	protected void getJsonData(Location location) throws WeatherDataServiceException {
		try {
		
		
		JsonObject json =null;
		URLConnection data=new URL("http://api.openweathermap.org/data/2.5/weather?q="+location.getCountry()+","+location.getCity()+"&appid=744d5642b137b117299d4c2be8a22aa4&units=metric").openConnection();
		JsonStreamParser parser = new JsonStreamParser(new InputStreamReader(data.getInputStream()));

		if (parser.hasNext())
			json = parser.next().getAsJsonObject();
		parseJsonData(json);
		}
		catch (Exception e) {
			throw new WeatherDataServiceException(location);
		}
		
		
		
		
	}
	
	
      protected void parseJsonData(JsonObject json)throws WeatherDataServiceException
      {
    	  
    	
    	  
    			String countryJson = json.getAsJsonObject("sys").get("country").getAsString();
    			String cityJson = json.get("name").getAsString();
                   
    	        this.setTemrature(json.getAsJsonObject("main").get("temp").getAsDouble());
    			this.setHumidity(json.getAsJsonObject("main").get("humidity").getAsDouble());
    			this.setDescription(((JsonObject) json.getAsJsonArray("weather").get(0)).get("description").getAsString());
    			this.setWindspeed(json.getAsJsonObject("wind").get("speed").getAsDouble());
    			this.setPressure(json.getAsJsonObject("main").get("pressure").getAsDouble());
    			
  
    			this.location.setCity(cityJson);
    			this.location.setCountry(countryJson);
    	  
    		  	    
    		    
    		  	  
    	  }
      
		
    	  
    	  
    @Override
	public String toString() {
		
	StringBuilder sb = new StringBuilder();
	sb.append("\nLocation:");
	sb.append(this.location.getCountry());
	sb.append("\n\nCurrent:\nTemperature:");
	sb.append(String.format("%.3f", this.getTemrature()));
	sb.append("\nDescription:");
	sb.append(this.getDescription());
	sb.append("\nhumidity:");
	sb.append(this.getHumidity());
	sb.append("\nWind Speed:");
	sb.append(this.getWindspeed());
	sb.append("\nPressure:");
	sb.append(this.getPressure());
	
	return sb.toString();
		
}
    
public static WeatherData getInstance() {
		if(instance != null){
			return instance;
		}
		instance = new WeatherData();
		return instance;
			
	}



	public Location getLocation() {
		return this.location;
	}


  @Override
	public void getWeatherData(Location location) throws WeatherDataServiceException  {
	  
	    
	  WeatherData.getInstance();
	 
	  if (location.getCity().length() == 0 || location.getCountry().length() == 0)
			throw new WeatherDataServiceException("City and country are required!");
	else
	{
			this.getJsonData(location);
	        setChanged();
	        notifyObservers();
	        
	}
  }

@Override
public void update(Observable o, Object arg) {
	
}





	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
