#include<iostream>
#include<string>
using namespace std;


class Light{

private:
	string name;

public:
	Light(string name):name(name){};
	void lighting();
	~Light(){}

};


void Light::lighting()
{
	cout<<name<<endl;
}


class Camera{

private:
	string name;

public:
	Camera(string name):name(name){};
	void cameraing();
	~Camera(){}

};


void Camera::cameraing()
{
	cout<<name<<endl;
}


class Sensor{

private:
	string name;

public:
	Sensor(string name):name(name){};
	void sensoring();
	~Sensor(){}

};


void Sensor::sensoring()
{
	cout<<name<<endl;
}

class Alarm{

private:
	string name;

public:
	Alarm(string name):name(name){};
	void alarming();
	~Alarm(){}

};


void Alarm::alarming()
{
	cout<<name<<endl;
}


class FacadeServer{

private:
	Light light;
	Sensor sensor;
	Alarm alarm;
	Camera camera;

public:
	FacadeServer(	Light light,Sensor sensor,Alarm alarm,Camera camera):light(light),sensor(sensor),alarm(alarm),camera(camera){}
	void facading();
	~FacadeServer(){}

};

void FacadeServer::facading()
{
	cout<<"facading"<<endl;
	light.lighting();
	sensor.sensoring();
	alarm.alarming();
	camera.cameraing();
}
int main()
{
	Light light("light");
	Sensor sensor("sensor");
	Alarm alarm("alarm");
	Camera camera("camera");

	FacadeServer facadeServer(light,sensor,alarm,camera);
	facadeServer.facading();

	return 0;
}
