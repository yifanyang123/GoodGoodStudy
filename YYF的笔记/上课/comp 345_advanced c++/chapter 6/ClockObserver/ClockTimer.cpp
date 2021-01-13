#include "ClockTimer.h"

ClockTimer::ClockTimer(): hour(0), minute(0), second(0) {
};
ClockTimer::~ClockTimer(){
};
void ClockTimer::start(int time){

	for (int i = 1; i <= time; i++)
		tick();
};
void ClockTimer::tick(){
	second++;
	if (second >= 60){
		minute++;
		second = 0;
		if (minute >= 60){
			hour++;
			minute = 0;
			if (hour >= 24){
				hour = 0;
			}
		}
	};
	// The Observable object notifies all its registered observers       
	Notify();
};
