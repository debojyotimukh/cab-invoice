package com.capgemini.training.corejava;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

public class InvoiceServiceTest {

    public InvoiceService invoiceService;
    public RideRepository repository;
    public Ride[] rides;
    InvoiceSummary expectedInvoiceSummry;

    @Before
    public void init() {
        repository = new RideRepository();
        invoiceService = new InvoiceService(repository);
        rides = new Ride[] { new Ride(CabRides.NORMAL, 2.0, 5), new Ride(CabRides.PREMIUM, 0.1, 1),
                new Ride(CabRides.PREMIUM, 0.1, 1) };
        expectedInvoiceSummry = new InvoiceSummary(3, 65.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_shouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnInvoiceSummary() {
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedInvoiceSummry, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
        String userId = "bgb.com";
        invoiceService.addRides(userId, rides);
        Ride[] rides1 = new Ride[] { new Ride(CabRides.NORMAL, 2.0, 5), new Ride(CabRides.PREMIUM, 0.1, 1),
            new Ride(CabRides.PREMIUM, 0.1, 1) };
        invoiceService.addRides(userId, rides1);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummry = new InvoiceSummary(6, 130.0);
        Assert.assertEquals(expectedInvoiceSummry, invoiceSummary);
    }
}
