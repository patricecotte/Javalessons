package com.sdz.observer;
/**

 * <b>Observable:	interface from the Observer pattern that models implement </b>
 * <ul>
 * <li> - Clock, the model for Window1
 * <li>	- to be specified
 * </ul>
 * @author			Patrice Cotte
 * @version			1.0
 */
public interface Observable {
	 // Note a class that implements Observable must redefine every method in this class
	  public void addObserver(Observer obs);
	  public void updateObserver();
	  public void delObserver();
	  public void notifyObserver(String string);
	  
	}
