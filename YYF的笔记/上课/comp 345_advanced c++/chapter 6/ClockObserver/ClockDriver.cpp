#include "ClockTimer.h"
#include "DigitalClock.h"
#include <iostream>
using namespace std;

int main(void) {
  //Create a ClockTimer to be observed
  ClockTimer *timer = new ClockTimer;

  //Create a DigitalClock that is connected to the ClockTimer  
  DigitalClock *digitalClock = new DigitalClock(timer); 

  //Advancing the ClockTimer updates the DigitalClock
  //as Tick() calls Update() after it changed its state
  int secs;
  cout << "Enter number of seconds to count: ";
  cin >> secs;
  timer->start(secs);

  int j;  cin >> j;

  return 0;
}
