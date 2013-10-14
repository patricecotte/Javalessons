package com.sdz.model;

import java.util.ArrayList;
import java.util.Calendar;
import com.sdz.observer.*;		// interfaces 

/*
 * The Clock class is a low-level class that is instantiated
 * by the Window1 high level class. Window1 and Clock communicate
 * through the Observer and Observable interfaces.
 */

public class Clock implements Observable{
  //We retrieve the clock time from the calendar
  private Calendar cal;
  private String hour = "";
  
  // Create an array of Observers
  private ArrayList<Observer> listObserver = new ArrayList<Observer>();
  
  public void run() {
    while(true){
    //On each execution of the loop we get an instance of the calendar
    //and the clock time.

    this.cal = Calendar.getInstance();
    this.hour =  									//hours
      this.cal.get(Calendar.HOUR_OF_DAY) + " : "
      + 
      (    											//minutes
        this.cal.get(Calendar.MINUTE) < 10
        ? "0" + this.cal.get(Calendar.MINUTE)
        : this.cal.get(Calendar.MINUTE)
      )
      + " : "
      +
      (    											//seconds
        (this.cal.get(Calendar.SECOND)< 10) 
        ? "0"+this.cal.get(Calendar.SECOND) 
        : this.cal.get(Calendar.SECOND)
      );
     //Keep the observers posted of the new hour
      this.updateObserver();
      try {
        Thread.sleep(1000);							//timer
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  } // end of run
  
 // These 3 methods work on the list of Observers  
public void addObserver(Observer obs) { 
	// add an boserver to the array
	this.listObserver.add(obs);
}
 
 
public void delObserver() {
	// reinitialize the array (?)
	this.listObserver = new ArrayList<Observer>();
}

public void updateObserver() {
	//keep observers updated of an update of the hour string
	    for(Observer obs : this.listObserver)
	      obs.update(this.hour);
	}
  
} // End of Clock class
