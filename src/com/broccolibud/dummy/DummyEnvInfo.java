package com.broccolibud.dummy;

import com.broccolibud.enums.DigitalDeviceState;
import com.broccolibud.enums.SecurityCondition;
import com.broccolibud.enums.SoilWaterState;
import com.broccolibud.enums.WaterTankState;
import com.broccolibud.interfaces.EnvironmentInfoSource;

public class DummyEnvInfo implements EnvironmentInfoSource {

	@Override
	public double getTemperature() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHumidity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DigitalDeviceState getMainLightState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DigitalDeviceState getSideLightState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WaterTankState getWaterTankState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SoilWaterState getSoilWaterState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DigitalDeviceState getMainVentilationState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DigitalDeviceState getAdditionalVentilationState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecurityCondition getSecurityConditions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DigitalDeviceState getSecuritySwitchState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getVoltage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCurrent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
