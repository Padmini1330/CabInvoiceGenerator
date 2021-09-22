package CabInvoiceGenerator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest 
{
	InvoiceGenerator invoiceGenerator=new InvoiceGenerator();
	@Test
	public void givenDistanceAndTime_WhenProper_ShouldReturnTotalFare() 
	{
		double distance=2.0;
		int time=5;
		double fare=invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(25, fare, 0.0);
	}
	
}
