package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceGenerator implements InvoiceGeneratorIF
{

	private static final int NORMAL_COST_PER_TIME = 1;
	private static final double NORMAL_COST_PER_KILOMETER = 10;
	private static final double NORMAL_MINIMUM_FARE = 5;
	private static final int PREMIUM_COST_PER_TIME = 2;
	private static final double PREMIUM_COST_PER_KILOMETER = 15;
	private static final double PREMIUM_MINIMUM_FARE = 20;

	public double calculateFare(double distance, int time, RideType rideType) 
	{
		if(rideType.equals(RideType.NORMAL_RIDE))
		{
			double totalFare= distance*NORMAL_COST_PER_KILOMETER + time*NORMAL_COST_PER_TIME;
			return Math.max(totalFare,NORMAL_MINIMUM_FARE);
		}
		double totalFare= distance*PREMIUM_COST_PER_KILOMETER + time*PREMIUM_COST_PER_TIME;
		return Math.max(totalFare,PREMIUM_MINIMUM_FARE);
	}
		
	public InvoiceSummary calculateInvoice(int userId,HashMap<Integer, ArrayList<Ride>> rideRepository,RideType rideType)
	{
		double totalFare=0;
		for(Ride ride:rideRepository.get(userId))
		{
			totalFare+=this.calculateFare(ride.distance,ride.time,rideType);
		}
		return new InvoiceSummary(rideRepository.get(userId).size(), totalFare);
	}
}
