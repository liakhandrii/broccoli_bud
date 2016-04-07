package com.broccolibud.dummy;

import java.util.Random;

import com.broccolibud.enums.DigitalDeviceState;
import com.broccolibud.enums.SecurityCondition;
import com.broccolibud.enums.SoilWaterState;
import com.broccolibud.enums.WaterTankState;
import com.broccolibud.interfaces.EnvironmentInfoSource;

public class DummyEnvInfo implements EnvironmentInfoSource {
	
	public static Random r = new Random();
	public int tankState;
	@Override
	public double getTemperature() {
		//generating random double of temperature from 18°C to 40°C
		double temperature = 0.0;
		
		double minT = 18.0;
		double maxT = 40.0;
		
		temperature = minT + (maxT - minT) * r.nextDouble();
		return temperature;// + "°C"
		
	}

	@Override
	public double getHumidity() {
		//generating random double of humidity from 0% to 100%
		double humidity = 0.0;
		
		double minH = 0.0;
		double maxH = 1.0;
		
		humidity = (minH + (maxH - minH) * r.nextDouble())*100;
		return humidity;// + "%"
	}

	@Override
	public DigitalDeviceState getMainLightState() {
		
		return null;//should be on || off
	}

	@Override
	public DigitalDeviceState getSideLightState() {
		
		return null;//should be on || off
	}

	@Override
	public WaterTankState getWaterTankState() {
		int tank = 100;
		int tankCondition = 0;
		
		int full = 1;
		int poor = 2;
		int empty = 3;
		
		tankCondition = tank - r.nextInt(100);
		
		if(tankCondition == tank){tankState = full;}
		else if(tankCondition == (tank/2)){tankState = poor;}
		else{tankState = empty;}
		return WaterTankState.Full;//should be full || poor || empty
	}

	@Override
	public SoilWaterState getSoilWaterState() {
		int tank = 100;
		int tankCondition = 0;
		
		tankCondition = tank - r.nextInt(100);
		
		
		return null;//should be full || poor || empty
	}

	@Override
	public DigitalDeviceState getMainVentilationState() {
		
		return null;//should be on || off
	}

	@Override
	public DigitalDeviceState getAdditionalVentilationState() {
		
		return null;//should be on || off
	}

	@Override
	public SecurityCondition getSecurityConditions() {
		
		return null;//should be on || off
	}

	@Override
	public DigitalDeviceState getSecuritySwitchState() {
		
		return null;//should be on || off
	}

	@Override
	public double getVoltage() {
		
		return 0;
	}

	@Override
	public double getCurrent() {
		
		return 0;
	}

}
