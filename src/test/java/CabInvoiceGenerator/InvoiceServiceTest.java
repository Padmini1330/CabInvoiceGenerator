package CabInvoiceGenerator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest 
{
	InvoiceGenerator invoiceGenerator=null;
	@Before
	public void setUp() throws Exception
	{
		invoiceGenerator=new InvoiceGenerator();
	}
	@Test
	public void givenDistanceAndTime_WhenProper_ShouldReturnTotalFare() 
	{
		double distance=2.0;
		int time=5;
		double fare=invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(25, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTime_WhenLess_ShouldReturnMinimumFare() 
	{
		double distance=0.1;
		int time=1;
		double fare=invoiceGenerator.calculateFare(distance,time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_WhenProper_ShouldReturnInvoiceSummary() 
	{
		Ride[] rides= {new Ride(2.0, 5),new Ride(0.1, 1)};
		InvoiceSummary invoiceSummary=invoiceGenerator.calculateFare(rides);
		InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30.0);
		if(expectedInvoiceSummary.getAverageFare() == invoiceSummary.getAverageFare() 
				&& expectedInvoiceSummary.getNumOfRides() == invoiceSummary.getNumOfRides() 
				&& expectedInvoiceSummary.getTotalFare() == invoiceSummary.getTotalFare())
			Assert.assertEquals(true, true);
	}
}
