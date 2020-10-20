package com.capgemini.training.corejava;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;

public class InvoiceServiceTest {

    public InvoiceService invoiceService;

    @Before
    public void init() {
        invoiceService = new InvoiceService();
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
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        InvoiceSummary invoiceSummary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummry = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummry, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
        String userId = "bgb.com";
        Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
        invoiceService.addRides(userId, rides);
        Ride[] rides1 = { new Ride(2.0, 5), new Ride(0.1, 1) };
        invoiceService.addRides(userId, rides1);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummry = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoiceSummry, invoiceSummary);
    }
}
