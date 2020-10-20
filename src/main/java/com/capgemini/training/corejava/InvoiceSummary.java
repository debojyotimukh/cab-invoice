package com.capgemini.training.corejava;

public class InvoiceSummary {

	private final int noOfRides;
	private final double totalFare;
	private final double averageFare;

	public InvoiceSummary(final int noOfRides, final double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare / this.noOfRides;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (noOfRides != other.noOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceSummary [averageFare=" + averageFare + ", noOfRides=" + noOfRides + ", totalFare=" + totalFare
				+ "]";
	}

}
