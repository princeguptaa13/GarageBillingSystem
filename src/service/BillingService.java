package service;

import entity.Invoice;

import java.sql.SQLException;
import java.util.List;

public class BillingService {

    public CustomerService customerService = new CustomerService();
    public InvoiceService invoiceService = new InvoiceService();

    public void createInvoice(int customerId , int vehicleId , List<Integer> serviceIds) throws SQLException {
        for(int serviceId : serviceIds){
             invoiceService.addInvoice(new Invoice(0 , customerId , vehicleId , serviceId));
        }
        System.out.println("Invoice Created Successfully !");
    }
     public void showAllInvoices() throws SQLException{
        List<Invoice> invoices = invoiceService.getAllInvoice();
        for(Invoice invoice : invoices){
            System.out.println(invoice);
        }

     }
}
