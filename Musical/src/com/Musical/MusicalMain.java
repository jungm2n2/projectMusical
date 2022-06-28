package com.Musical;

import java.util.HashMap;
import java.util.Iterator;

public class MusicalMain {

	public static void main(String[] args) {

		DataImpl di = new DataImpl();
		
		
		
		ManagerImpl implM = new ManagerImpl(di.getCustomerMap(), di.getTitleMap());
		CustomerImpl implC = new CustomerImpl(di.getCustomerMap(), di.getTitleMap());
		
			
	}
	

}
