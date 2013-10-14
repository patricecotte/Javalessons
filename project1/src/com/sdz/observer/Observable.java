package com.sdz.observer;
/*
 * Observable:	interface that Clocks implements
 */
public interface Observable {
	  public void addObserver(Observer obs);
	  public void updateObserver();
	  public void delObserver();
	}
