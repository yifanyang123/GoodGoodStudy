#include "DigitalClock.h"
#include "ClockTimer.h"
#include <iostream>
using namespace std;

DigitalClock::DigitalClock(){
};
DigitalClock::DigitalClock(ClockTimer* s){
  //Upon instantiation, attaches itself to a ClockTimer
  _subject = s;
  _subject->Attach(this);
};
DigitalClock::~DigitalClock(){
  //Upon destruction, detaches itself from its ClockTimer      
  _subject->Detach(this);
};
void DigitalClock::Update(){
  display();
}; 
void DigitalClock::display(){
  int hour = _subject->getHour();
  int minute = _subject->getMinute();
  int second = _subject->getSecond();
  cout << hour << ":" << minute << ":" << second << endl;
};
