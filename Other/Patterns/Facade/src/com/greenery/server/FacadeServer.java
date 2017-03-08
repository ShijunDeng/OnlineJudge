package com.greenery.server;

import com.greenery.object.Alarm;
import com.greenery.object.Camera;
import com.greenery.object.Light;
import com.greenery.object.Sensor;

public class FacadeServer {

	private Light light;
	private Sensor sensor;
	private Alarm alarm;
	private Camera camera;


	public FacadeServer(Light light, Sensor sensor, Alarm alarm, Camera camera) {
		super();
		this.light = light;
		this.sensor = sensor;
		this.alarm = alarm;
		this.camera = camera;
	}


	public void facading() {
		System.out.println("facading");
		light.lighting();
		sensor.sensoring();
		alarm.alarming();
		camera.cameraing();
	}

}
