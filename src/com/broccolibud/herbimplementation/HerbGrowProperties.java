package com.broccolibud.herbimplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class HerbGrowProperties {
	
	private Properties props;
	private String fileName = "conf/grow-config.properties";
	
	public HerbGrowProperties() throws Exception {
		props = new Properties();
		loadFromFile();
	}
	
	private void loadFromFile() throws Exception {
		InputStream is = null;
		 
	    // First try loading from the current directory
	    try {
	        File f = new File(fileName);
	        is = new FileInputStream(f);
	    } catch ( Exception e ) { is = null; }
	    
	    if (is == null) {
	    	throw new Exception("Error loading properties");
	    }
	    
	    props.load(is);
	 
	}
	
	public void saveToFile() {
		try {
	        File f = new File(fileName);
	        OutputStream out = new FileOutputStream(f);
	        props.store(out, "");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public double getOptimalTemperature() {
		return Double.parseDouble(props.getProperty("optimal_temperature"));
	}
	
	public void setOptimalTemperature(double temp) {
		props.setProperty("optimal_temperature", temp + "");
	}
	
	public double getAcceptableTemperatureChange() {
		return Double.parseDouble(props.getProperty("acceptable_temperature_change"));
	}
	
	public void setAcceptableTemperatureChange(double change) {
		props.setProperty("acceptable_temperature_change", change + "");
	}
	
	public double getOptimalHumidity() {
		return Double.parseDouble(props.getProperty("optimal_humidity"));
	}
	
	public void setOptimalHumidity(double humidity) {
		props.setProperty("optimal_humidity", humidity + "");
	}
	
	public double getAcceptableHumidityChange() {
		return Double.parseDouble(props.getProperty("acceptable_humidity_change"));
	}
	
	public void setAcceptableHumidityChange(double change) {
		props.setProperty("acceptable_humidity_change", change + "");
	}
	
	public int getGrowDays() {
		return Integer.parseInt(props.getProperty("grow_days"));
	}
	
	public void setGrowDays(int days) {
		props.setProperty("grow_days", days + "");
	}
	
	public int getSeedlingDays() {
		return Integer.parseInt(props.getProperty("seedling_days"));
	}
	
	public void setSeedlingDays(int days) {
		props.setProperty("seedling_days", days + "");
	}
	
	public int getVegetativeDays() {
		return Integer.parseInt(props.getProperty("vegetative_days"));
	}
	
	public void setVegetativeDays(int days) {
		props.setProperty("vegetative_days", days + "");
	}
	
	public int getFloweringDays() {
		return Integer.parseInt(props.getProperty("flowering_days"));
	}
	
	public void setFloweringDays(int days) {
		props.setProperty("flowering_days", days + "");
	}
	
	public int getSeedlingDayDuration() {
		return Integer.parseInt(props.getProperty("seedling_day_duration"));
	}
	
	public void setSeedlingDayDuration(int duration) {
		props.setProperty("seedling_day_duration", duration + "");
	}
	
	public int getVegetativeDayDuration() {
		return Integer.parseInt(props.getProperty("vegetative_day_duration"));
	}
	
	public void setVegetativeDayDuration(int duration) {
		props.setProperty("vegetative_day_duration", duration + "");
	}
	
	public int getFloweringDayDuration() {
		return Integer.parseInt(props.getProperty("flowering_day_duration"));
	}
	
	public void setFloweringDayDuration(int duration) {
		props.setProperty("flowering_day_duration", duration + "");
	}
	
	public double getPumpSpeed() {
		return Double.parseDouble(props.getProperty("pump_speed"));
	}

}
