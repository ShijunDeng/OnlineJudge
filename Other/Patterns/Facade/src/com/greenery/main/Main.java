package com.greenery.main;

import com.greenery.object.Alarm;
import com.greenery.object.Camera;
import com.greenery.object.Light;
import com.greenery.object.Sensor;
import com.greenery.server.FacadeServer;

public class Main {

	public static void main(String[] args) {

		Light light=new Light("light");
		Sensor sensor=new Sensor("sensor");
		Alarm alarm=new Alarm("alarm");
		Camera camera=new Camera("camera");

		FacadeServer facadeServer=new FacadeServer(light,sensor,alarm,camera);
		facadeServer.facading();
	}

}
