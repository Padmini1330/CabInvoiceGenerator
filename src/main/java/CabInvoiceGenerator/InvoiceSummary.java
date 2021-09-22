package CabInvoiceGenerator;

public class InvoiceSummary 
{

	private int numberOfRides;
	private double totalFare;
	private Object averageFare;

	public InvoiceSummary(int numberOfRides, double totalFare) 
	{
		this.numberOfRides=numberOfRides;
		this.totalFare=totalFare;
		this.averageFare=this.totalFare/this.numberOfRides;
	}

	public int getNumberOfRides() 
	{
		return numberOfRides;
	}

	public double getTotalFare() 
	{
		return totalFare;
	}

	public Object getAverageFare() 
	{
		return averageFare;
	}

	@Override
	public String toString() 
	{
		return "InvoiceSummary [numberOfRides=" + numberOfRides + ", totalFare=" + totalFare + ", averageFare=" + averageFare
				+ "]";
	}
	
}
