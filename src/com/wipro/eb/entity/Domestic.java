package com.wipro.eb.entity;

public class Domestic extends Connection  {
	public Domestic(int previousReading, int currentReading,float slabs[]) {
		super(previousReading, currentReading, slabs);
	}

	public float computeBill() {
	 float amount=0;
	 int consumed=currentReading-;
	 if(consumed<=50) {
		 amount=consumed*slabs[0];
	 }
	 else if(consumed>50||consumed<=100) {
		 amount=50*slabs[0]+(consumed-50)*slabs[1];
	 }
	 else {
		 amount=50*slabs[0]+50*slabs[1]+(consumed-100)*slabs[2];
	 }
	 return amount;
	}

}
