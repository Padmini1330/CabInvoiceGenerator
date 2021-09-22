package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public interface InvoiceGeneratorIF 
{
	public double calculateFare(double distance, int time, RideType rideType);
	
	public InvoiceSummary calculateInvoice(int userId,HashMap<Integer, ArrayList<Ride>> rideRepository,RideType rideType);
}
