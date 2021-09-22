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
		double fare=invoiceGenerator.calculateFare(distance,time,RideType.NORMAL_RIDE);
		Assert.assertEquals(25, fare, 0.0);
	}
	
	@Test
	public void givenDistanceAndTime_WhenLess_ShouldReturnMinimumFare() 
	{
		double distance=0.1;
		int time=1;
		double fare=invoiceGenerator.calculateFare(distance,time,RideType.NORMAL_RIDE);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenUserId_WhenProper_ShouldVerifyNumberOfRidesTakenByTheUser() 
	{
		ArrayList<Ride> rides=new ArrayList<Ride>();
		HashMap<Integer, ArrayList<Ride>> rideRepository=new HashMap<Integer, ArrayList<Ride>>();
		rides.add(new Ride(2.0,5));
		rides.add(new Ride(0.1,1));
		rideRepository.put(200, rides);
		InvoiceSummary invoiceSummary=invoiceGenerator.calculateInvoice(200,rideRepository,RideType.PREMIUM_RIDE);
		InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,60.0);
		Assert.assertEquals(expectedInvoiceSummary.getNumberOfRides(),invoiceSummary.getNumberOfRides());
	}
	
	@Test
	public void givenUserID_WhenProper_ShouldReturnInvoiceSummary() 
	{
		ArrayList<Ride> rides=new ArrayList<Ride>();
		HashMap<Integer, ArrayList<Ride>> rideRepository=new HashMap<Integer, ArrayList<Ride>>();
		rides.add(new Ride(2.0,5));
		rideRepository.put(110, rides);
		InvoiceSummary invoiceSummary=invoiceGenerator.calculateInvoice(110,rideRepository,RideType.PREMIUM_RIDE);
		InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(1,40.0);
		Assert.assertEquals(expectedInvoiceSummary.toString(),invoiceSummary.toString());
	}
	
	@Test
	public void givenRideType_WhenNormal_ShouldReturnInvoiceSummary() 
	{
		ArrayList<Ride> rides=new ArrayList<Ride>();
		HashMap<Integer, ArrayList<Ride>> rideRepository=new HashMap<Integer, ArrayList<Ride>>();
		rides.add(new Ride(2.0,5));
		rides.add(new Ride(0.1,1));
		rideRepository.put(100, rides);
		InvoiceSummary invoiceSummary=invoiceGenerator.calculateInvoice(100,rideRepository,RideType.NORMAL_RIDE);
		InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedInvoiceSummary.toString(),invoiceSummary.toString());
	}
	
	@Test
	public void givenRideType_WhenPremium_ShouldReturnInvoiceSummary() 
	{
		ArrayList<Ride> rides=new ArrayList<Ride>();
		HashMap<Integer, ArrayList<Ride>> rideRepository=new HashMap<Integer, ArrayList<Ride>>();
		rides.add(new Ride(2.0,5));
		rides.add(new Ride(0.1,1));
		rideRepository.put(100, rides);
		InvoiceSummary invoiceSummary=invoiceGenerator.calculateInvoice(100,rideRepository,RideType.PREMIUM_RIDE);
		InvoiceSummary expectedInvoiceSummary=new InvoiceSummary(2,60.0);
		Assert.assertEquals(expectedInvoiceSummary.toString(),invoiceSummary.toString());
	}
}
