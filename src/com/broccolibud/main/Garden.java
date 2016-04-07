package com.broccolibud.main;

import com.broccolibud.dummy.DummyEnvInfo;
import com.broccolibud.herbimplementation.HerbGrowManager;
import com.broccolibud.herbimplementation.HerbGrowProperties;
import com.broccolibud.interfaces.EnvironmentInfoSource;
import com.broccolibud.interfaces.EnvironmentRegulator;

public class Garden {
	
	private EnvironmentInfoSource infoSource = new DummyEnvInfo();
	private HerbGrowManager hgm;
	
	public static void main(String[] args) throws Exception {
		Garden g = new Garden();
		g.hgm  = new HerbGrowManager();
		
		while (true) {
			double temp = g.infoSource.getTemperature();
			System.out.println(temp);
			
			g.hgm.respondToTemperatureChange(temp);
			
			Thread.sleep(1000);
		}
	}

}
