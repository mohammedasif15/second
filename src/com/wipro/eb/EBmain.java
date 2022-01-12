package com.wipro.eb;

import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;
import com.wipro.eb.service.ConnectionService;

public class EBmain {
	public static void main(String[] args) throws InvalidReadingException, InvalidConnectionException {
		System.out.println(new ConnectionService().generateBill(130,100,"Commercial"));
	}

}
