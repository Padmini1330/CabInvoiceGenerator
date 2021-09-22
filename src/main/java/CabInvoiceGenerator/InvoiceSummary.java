package CabInvoiceGenerator;

public class InvoiceSummary 
{

	private int numOfRides;
	private double totalFare;
	private Object averageFare;

	public InvoiceSummary(int numOfRides, double totalFare) 
	{
		this.numOfRides=numOfRides;
		this.totalFare=totalFare;
		this.averageFare=this.totalFare/this.numOfRides;
	}

	public int getNumOfRides() {
		return numOfRides;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public Object getAverageFare() {
		return averageFare;
	}

	@Override
	public String toString() {
		return "InvoiceSummary [numOfRides=" + numOfRides + ", totalFare=" + totalFare + ", averageFare=" + averageFare
				+ "]";
	}
	
}
