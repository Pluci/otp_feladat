package com;

import DTOs.Customer;
import DTOs.Identification;
import DTOs.Payment;
import Repository.Customer.CustomerRepository;
import Repository.Identification.IdentificationRepository;
import Repository.Payment.PaymentRepository;
import Services.DataProcessService;
import Services.Interfaces.IDataProcessService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static IDataProcessService Service;

    public static void main(String args[]) {
        Service = new DataProcessService(
                new CustomerRepository(new LinkedList<Customer>()),
                new PaymentRepository(new LinkedList<Payment>()),
                new IdentificationRepository(new LinkedList<Identification>())
        );

        try {
            readAndCreateCustomersFromCsvFile();
            readAndCreatePaymentsFromCsvFile();
            Service.createReportByUser();
            Service.createReportByWebshop();
        } catch (FileNotFoundException | ParseException e ) {
            e.printStackTrace();
        } catch (NoSuchFileException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void readAndCreateCustomersFromCsvFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("Data/customer.csv"));
        sc.useDelimiter("\\r?\\n");
        while(sc.hasNext()){
            Service.createCustomer(sc.next());
        }
        sc.close();
    }

    private static void readAndCreatePaymentsFromCsvFile() throws FileNotFoundException, ParseException {
        Scanner sc = new Scanner(new File("Data/payments.csv"));
        sc.useDelimiter("\\r?\\n");
        while(sc.hasNext()){
            Service.createPayment(sc.next());
        }
        sc.close();
    }
}
