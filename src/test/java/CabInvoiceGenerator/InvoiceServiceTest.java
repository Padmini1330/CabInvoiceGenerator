package CabInvoiceGenerator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

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
	public void givenUserID_WhenProper_ShouldReturnInvoiceSummaryFromRideRepository() 
	{
		ArrayList<Ride> rides=new ArrayList<Ride>();
		HashMap<Integer, ArrayList<Ride>> rideRepository=new HashMap<Integer, ArrayList<Ride>>();
		rides.add(new Ride(2.0,5));
		rides.add(new Ride(0.1,1));
		rideRepository.put(100, rides);
		InvoiceSummary invoiceSummary=invoiceGenerator.calculateInvoice(100,rideRepository);
		InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedInvoiceSummary.toString(),invoiceSummary.toString());
	}
}
