package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException {
		if(currentReading<previousReading || previousReading<0 ||currentReading<0) {
			throw new InvalidReadingException();
		}
		else if(!(type.equals("Domestic") || type.equals("Commercial"))){
			throw new InvalidConnectionException();
			
		}
		else {
		return true;
		}
		}
	public float calculateBillAmt(int currentReading, int previousReading, String type)  {
	boolean result=false;
	float bill=0.0f;
		try {
	 result=validate(currentReading, previousReading, type);
	} catch (InvalidReadingException e) {
		return -1;
	}
	catch(InvalidConnectionException ce) {
		return -2;
	}
		if(result==true) {
			if(type.equals("Domestic")){
				Domestic domestic=new Domestic(previousReading, currentReading, new float[] {2.3f,4.2f,5.5f});
				bill=domestic.computeBill();
			}
			else if(type.equals("Commercial")) {
				Commercial commercial=new Commercial( previousReading,currentReading, new float[] {5.2f,6.8f,8.3f} );
				bill=commercial.computeBill();
			}
		}
	return bill;
	
	}

         public String generateBill(int currentReading, int previousReading, String type) throws InvalidReadingException, InvalidConnectionException {
        	 float result=calculateBillAmt(currentReading, previousReading, type);
        	 
        	 if(result==-1) {
        		 throw new InvalidReadingException();
        	 }
        	 else if(result==-2) {
        		 throw new InvalidConnectionException();
        	 }
        	 else {
        	return "amount to be paid : "+result;	 
        	 }
	
}
}