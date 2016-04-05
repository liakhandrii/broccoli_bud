package com.broccolibud.interfaces;

import com.broccolibud.enums.DigitalDeviceState;
import com.broccolibud.enums.SecurityCondition;
import com.broccolibud.enums.SoilWaterState;
import com.broccolibud.enums.WaterTankState;

public interface EnvironmentInfoSource {
	
	/**
	 * This method is used to get the environment temperature at the moment
	 * @return double temperature in Cº
	 */
	public double getTemperature();
	
	//TODO humidity units
	/**
	 * This method is used to get the environment humidity at the moment
	 * @return double humidity in units
	 */
	public double getHumidity();
	
	/**
	 * This method is used to get the main light state
	 * @return On, Off or Unavailable
	 */
	public DigitalDeviceState getMainLightState();
	
	/**
	 * This method is used to get the side light state
	 * @return On, Off or Unavailable
	 */
	public DigitalDeviceState getSideLightState();
	
	/**
	 * This method is used to get the water tank state
	 * @return Full, Half or Empty
	 */
	public WaterTankState getWaterTankState();
	
	/**
	 * This method is used to get the soil water state
	 * @return Wet, Dry or Overflow
	 */
	public SoilWaterState getSoilWaterState();
	
	/**
	 * This method is used to get the main ventilation state
	 * @return On, Off or Unavailable
	 */
	public DigitalDeviceState getMainVentilationState();
	
	/**
	 * This method is used to get the secondary (internal) ventilation state
	 * @return On, Off or Unavailable
	 */
	public DigitalDeviceState getAdditionalVentilationState();
	
	/**
	 * This method is optional (return Secure if not implemented)
	 * The method is used to provide security.
	 * Secure - everything is OK.
	 * CloseDanger - turn off when security switch fires.
	 * Insecure - turned off.
	 * @return Secure, CloseDanger, Insecure
	 */
	public SecurityCondition getSecurityConditions();
	
	/**
	 * This method is used to get the security switch state
	 * @return On, Off or Unavailable
	 */
	public DigitalDeviceState getSecuritySwitchState();
	
	/**
	 * This method is optional and should return voltage of the system power source (120/220/230V for most countries)
	 * Used to turn everything off when voltage value is unsuitable
	 * @return double voltage or -404 if unimplemented
	 */
	public double getVoltage();
	
	/**
	 * This method is optional and should return the overall system current power in amps
	 * @return double current in amps or -404 if not implemented
	 */
	public double getCurrent();
	
}
