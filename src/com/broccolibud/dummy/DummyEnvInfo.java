package com.broccolibud.dummy;

import java.util.Random;

import com.broccolibud.enums.DigitalDeviceState;
import com.broccolibud.enums.SecurityCondition;
import com.broccolibud.enums.SoilWaterState;
import com.broccolibud.enums.WaterTankState;
import com.broccolibud.interfaces.EnvironmentInfoSource;

public class DummyEnvInfo implements EnvironmentInfoSource {
	
	public static Random r = new Random();
	
	// state of digital devices change here
	
	boolean mainLight = true;
	boolean sideLight = true;
	boolean mainVentilation = true;
	boolean additionVentilation = true;
	boolean securitySwitch = true;
	
	// state of security conditions change here
	
	boolean securityConditions = true;
	
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
		
		if(mainLight == true) {return DigitalDeviceState.On;}
		else if (mainLight == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		
		//should be On || Off || Unavaliable
	}

	@Override
	public DigitalDeviceState getSideLightState() {
		
		if(sideLight == true){return DigitalDeviceState.On;}
		else if (sideLight == false){return DigitalDeviceState.Off;}
		else{return DigitalDeviceState.Unavailable;}
		
		//should be On || Off || Unavaliable
	}

	@Override
	public WaterTankState getWaterTankState() {
		
		int tank = 100;
		int tankCondition = 0;
		
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
		
		if(tankCondition == tank){return SoilWaterState.Wet;}
		else{return SoilWaterState.Dry;}
		
		//should be Wet || Dry
	}

	@Override
	public DigitalDeviceState getMainVentilationState() {
		
		if(mainVentilation == true) {return DigitalDeviceState.On;}
		else if (mainVentilation == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		
		//should be On || Off || Unavaliable 
	}

	@Override
	public DigitalDeviceState getAdditionalVentilationState() {
		
		if(additionVentilation == true) {return DigitalDeviceState.On;}
		else if (additionVentilation == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		
		//should be On || Off || Unavaliable
	}

	@Override
	public SecurityCondition getSecurityConditions() {
		
		if(securityConditions == true) {return SecurityCondition.Secure;}
		else if (securityConditions == false) {return SecurityCondition.Insecure;}
		else {return SecurityCondition.CloseDanger;}
		
		//should be CloseDanger || Insecure || Secure
	}

	@Override
	public DigitalDeviceState getSecuritySwitchState() {
		
		if(securitySwitch == true) {return DigitalDeviceState.On;}
		else if (securitySwitch == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		
		//should be On || Off || Unavaliable
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
