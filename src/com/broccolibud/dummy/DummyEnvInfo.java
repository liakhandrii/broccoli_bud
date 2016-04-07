package com.broccolibud.dummy;

import java.util.Random;

import com.broccolibud.enums.DigitalDeviceState;
import com.broccolibud.enums.SecurityCondition;
import com.broccolibud.enums.SoilWaterState;
import com.broccolibud.enums.WaterTankState;
import com.broccolibud.interfaces.EnvironmentInfoSource;

public class DummyEnvInfo implements EnvironmentInfoSource {
	
	private double temperature = 20;
	private double humidity = 0.3;
	
	private static Random r = new Random();
	
	// state of digital devices change here
	
	private boolean mainLight = true;
	private boolean sideLight = true;
	private boolean mainVentilation = true;
	private boolean additionVentilation = true;
	private boolean securitySwitch = true;
	
	// state of security conditions change here
	
	private boolean securityConditions = true;
	
	private int rDataGen(){
		int i = r.nextInt(3);
		switch(i){
		case 1: return 1;
		case 2: return 0;
		case 3: return -1;
		}
		return 0;
	}
	
	private static DigitalDeviceState stateCheck(boolean a){
		if(a == true) {return DigitalDeviceState.On;}
		else if (a == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		
	}
	
	@Override
	public double getTemperature() {
		temperature =  temperature + rDataGen() ;
		return temperature;// + "°C"
		
	}

	@Override
	public double getHumidity() {
		humidity = humidity + (rDataGen())/100;
		return humidity;// + "%"
	}

	@Override
	public DigitalDeviceState getMainLightState() {
		/*
		if(mainLight == true) {return DigitalDeviceState.On;}
		else if (mainLight == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		*/
		return stateCheck(mainLight);
		//should be On || Off || Unavaliable
	}

	@Override
	public DigitalDeviceState getSideLightState() {
		/*
		if(sideLight == true){return DigitalDeviceState.On;}
		else if (sideLight == false){return DigitalDeviceState.Off;}
		else{return DigitalDeviceState.Unavailable;}
		*/
		return stateCheck(sideLight);
		//should be On || Off || Unavaliable
	}

	@Override
	public WaterTankState getWaterTankState() {
		
		int tank = 100;
		int tankCondition = 0;
		
		tankCondition = tank - r.nextInt(100);
		
		if(tankCondition == tank) {return WaterTankState.Full;}
		else {return WaterTankState.Empty;}
		
		//should be Full || Empty
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
		/*
		if(mainVentilation == true) {return DigitalDeviceState.On;}
		else if (mainVentilation == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		*/
		return stateCheck(mainVentilation);
		//should be On || Off || Unavaliable 
	}

	@Override
	public DigitalDeviceState getAdditionalVentilationState() {
		/*
		if(additionVentilation == true) {return DigitalDeviceState.On;}
		else if (additionVentilation == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		*/
		return stateCheck(additionVentilation);
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
		/*
		if(securitySwitch == true) {return DigitalDeviceState.On;}
		else if (securitySwitch == false) {return DigitalDeviceState.Off;}
		else {return DigitalDeviceState.Unavailable;}
		*/
		return stateCheck(securitySwitch);
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
