package com.broccolibud.herbimplementation;

import com.broccolibud.enums.SoilWaterState;
import com.broccolibud.interfaces.EnvironmentRegulator;
import com.broccolibud.interfaces.GrowManager;

public class HerbGrowManager implements GrowManager {
	
	HerbGrowProperties props;
	
	public HerbGrowManager() throws Exception {
		// TODO Auto-generated constructor stub
		props = HerbGrowProperties.sharedInstance();
	}
	
	public HerbGrowManager(EnvironmentRegulator envReg) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void respondToTemperatureChange(double temperature) {
		double okTemp = props.getOptimalTemperature();
		double change = props.getAcceptableTemperatureChange();
		
		if (temperature > okTemp + change) {
			System.out.println("Temperature too high");
		} else if (temperature < okTemp - change) {
			System.out.println("Temperature too low");
		} else {
			System.out.println("Temperature is great");
		}
		
	}

	@Override
	public void respondToHumidityChange(double humidity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respondToSoilWaterStateChange(SoilWaterState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respondToVoltageChange(double voltage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void respondToCurrentChange(double current) {
		// TODO Auto-generated method stub
		
	}

}
