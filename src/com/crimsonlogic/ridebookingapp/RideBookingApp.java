package com.crimsonlogic.ridebookingapp;

import java.util.*;

abstract class Vehicle {

    protected int vehicleId;
    protected String model;
    protected String color;
    protected String licensePlateNumber;
    protected  String mileage;
    protected String owner;

    protected boolean isElectric;

    public Vehicle(int vehicleId, String model, String color, String licensePlateNumber, String mileage, String owner, boolean isElectric) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.color = color;
        this.licensePlateNumber = licensePlateNumber;
        this.mileage = mileage;
        this.owner = owner;
        this.isElectric = isElectric;
    }

    public abstract void displayDetails();
    public abstract void drive();
}

 interface PaymentGateway {
    void pay(double amount);
}

 interface Chargeable {
    void chargeBattery();
}
 class Bike extends Vehicle implements Chargeable {


    public Bike(int vehicleId, String model, String color, String licensePlateNumber, String mileage, String owner, boolean isElectric) {
        super(vehicleId, model, color, licensePlateNumber, mileage, owner, isElectric);
    }


    @Override
    public void displayDetails() {
        System.out.println(
                "Vehicle ID: " + vehicleId +
                        ", Model: " + model +
                        ", Color: " + color +
                        ", License Plate Number: " + licensePlateNumber +
                        ", Mileage: " + mileage +
                        ", Owner: " + owner +
                        ", Is Electric: " + isElectric
        );
    }

    @Override
    public void chargeBattery() {
        System.out.println("Charging Bike");
    }

    @Override
    public void drive(){
        System.out.println( " Is Driving.....");
    }
}
 class Cab extends Vehicle implements Chargeable {


    public Cab(int vehicleId, String model, String color, String licensePlateNumber, String mileage, String owner, boolean isElectric) {
        super(vehicleId, model, color, licensePlateNumber, mileage, owner, isElectric);
    }


    @Override
    public void displayDetails() {
        System.out.println(
                "Vehicle ID: " + vehicleId +
                        ", Model: " + model +
                        ", Color: " + color +
                        ", License Plate Number: " + licensePlateNumber +
                        ", Mileage: " + mileage +
                        ", Owner: " + owner +
                        ", Is Electric: " + isElectric
        );
    }

    @Override
    public void chargeBattery() {
        System.out.println("Charging Bike");
    }

    @Override
    public void drive(){
        System.out.println( " Is Driving.....");
    }
}

 class Auto extends Vehicle implements Chargeable {


    public Auto(int vehicleId, String model, String color, String licensePlateNumber, String mileage, String owner, boolean isElectric) {
        super(vehicleId, model, color, licensePlateNumber, mileage, owner, isElectric);
    }


    @Override
    public void displayDetails() {
        System.out.println(
                "Vehicle ID: " + vehicleId +
                        ", Model: " + model +
                        ", Color: " + color +
                        ", License Plate Number: " + licensePlateNumber +
                        ", Mileage: " + mileage +
                        ", Owner: " + owner +
                        ", Is Electric: " + isElectric
        );
    }

    @Override
    public void chargeBattery() {
        System.out.println("Charging Bike");
    }

    @Override
    public void drive(){
        System.out.println( " Is Driving.....");
    }
}

 class Driver {

    String driverName;
    String driverMail;
    String driverPhoneNo;

     public Driver(String driverName, String driverMail, String driverPhoneNo) {
         this.driverName = driverName;
         this.driverMail = driverMail;
         this.driverPhoneNo = driverPhoneNo;
     }

     public void acceptRide() {
        System.out.println("Driver :"+driverName +"  Ride Accepted");
    }

    public void rejectRide() {
        System.out.println("Driver :"+driverName +"  Ride Rejected");
    }
}

 class Customer {

    String custID;
    String custMail;
    String custPhoneNumber;

    String custName;

     public Customer(String custID, String custMail, String custPhoneNumber,String custName) {
         this.custID = custID;
         this.custMail = custMail;
         this.custPhoneNumber = custPhoneNumber;
         this.custName=custName;
     }

     public void bookRide() {
        System.out.println("Customer: "+custName+  "  Ride Booked");
    }

    public void makePayment(PaymentGateway gateway,
                            double amount) {

        gateway.pay(amount);
    }
}

 class UPI implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

 class Wallet implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Wallet");
    }
}

 class Card implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}




public class RideBookingApp {

    public static void main(String[] args) {



        Customer customer =
                new Customer("C101", "customer@gmail.com", "9876543210","Bharathwaj V");

        Driver driver =
                new Driver("Raj", "raj@gmail.com", "9999999999");

        Bike bike =
                new Bike(101, "Pulsar", "Black",
                        "MH12AB1234", "45", "Raj", true);

        Auto auto =
                new Auto(102, "Bajaj Auto", "Yellow",
                        "MH12CD5678", "30", "Ravi", false);

        Cab cab =
                new Cab(103, "Swift Dzire", "White",
                        "MH12EF9876", "20", "Suresh", false);



        Scanner sc = new Scanner(System.in);

        System.out.println("*****WELCOME TO UBER: "+customer.custName+"*****");

        System.out.println("Select Vehicle");
        System.out.println("1. Bike");
        System.out.println("2. Auto");
        System.out.println("3. Cab");

        int choice = sc.nextInt();

        Vehicle selectedVehicle;
        double rideAmount;

        switch (choice) {
            case 1:
                selectedVehicle = bike;
                rideAmount=100;
                break;
            case 2:
                selectedVehicle = auto;
                rideAmount=300;
                break;
            case 3:
                selectedVehicle = cab;
                rideAmount=600;
                break;
            default:
                System.out.println("Invalid Choice");
                return;
        }

        customer.bookRide();
        driver.acceptRide();
        System.out.println("Vehicle details: ");
        selectedVehicle.displayDetails();
        selectedVehicle.drive();

        System.out.println("Vehicle reached destination");

        System.out.println("Select Payment Method");
        System.out.println("1. UPI");
        System.out.println("2. Wallet");
        System.out.println("3. Card");

        int paymentChoice = sc.nextInt();

        PaymentGateway gateway;

        switch (paymentChoice) {
            case 1:
                gateway = new UPI();
                break;
            case 2:
                gateway = new Wallet();
                break;
            case 3:
                gateway = new Card();
                break;
            default:
                System.out.println("Invalid Payment Option");
                return;
        }

        customer.makePayment(gateway, rideAmount);

    }
}
