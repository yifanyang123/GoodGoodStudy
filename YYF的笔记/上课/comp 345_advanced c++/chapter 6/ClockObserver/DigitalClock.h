#pragma once
#include "Observer.h"
#include "ClockTimer.h"

class DigitalClock : public Observer {
  public:
	DigitalClock();
	DigitalClock(ClockTimer* s);
	~DigitalClock();
	void Update(); 
	void display(); 
  private:
	ClockTimer *_subject;
};
