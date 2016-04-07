package com.broccolibud.interfaces;

import com.broccolibud.enums.SoilWaterState;

public interface GrowManager {
	
	public void respondToTemperatureChange(double temperature);
	
	public void respondToHumidityChange(double humidity);
	
	public void respondToSoilWaterStateChange(SoilWaterState state);
	
	public void respondToVoltageChange(double voltage);
	
	public void respondToCurrentChange(double current);
	
	
}
