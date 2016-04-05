package com.broccolibud.interfaces;

public interface EnvironmentRegulator {
	
	public void toggleMainLights(boolean on);
	public void toggleSideLights(boolean on);
	public void pumpWater(int milliliters);
	public void toggleMainVentiltion(boolean on);
	public void toggleAdditionalVentilation(boolean on);
	
	/**
	 * Used to swich everything off (in my case) when Insecure
	 */
	public void performSecurityActions();

}
