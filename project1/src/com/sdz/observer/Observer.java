package com.sdz.observer;
/**
 * <b>Observer:	interface that keeps views posted of changes </b>
 * <ul>
 * <li> - Window1
 * <li>	- to be specified
 * </ul>
 * @author			Patrice Cotte
 * @version			1.0
 */
public interface Observer {
	 // update is mandatory in the Observer  
	 public void update(String string);
}
