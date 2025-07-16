import entity.Customer;
import service.BillingService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BillingService billingService = new BillingService();

        while(true){
            System.out.println("1. Add Customer : \n2. Generate Invoice : \n3. Show Invoice : \n4.Exit ");
            int ch = sc.nextInt();
            switch (ch)
            {
                case 1 :
                    System.out.print("Customer Name : ");
                    String name = sc.next();
                    System.out.print("Phone No : ");
                    String phone = sc.next();
                    System.out.print("Adhaar Details : ");
                    int adhaar = sc.nextInt();
                    billingService.customerService.addCustomer(new Customer(0 , name , phone ,adhaar));
                    break;

                case 2 :
                    System.out.print("Enter Customer ID : ");
                    int ci = sc.nextInt();
                    System.out.print("Enter Vehicle ID : ");
                    int vi = sc.nextInt();
                    System.out.print("Enter Number of Services : ");
                    int si = sc.nextInt();
                    List<Integer> sids = new ArrayList<>();
                    for(int i=0 ; i<si ; i++){
                        System.out.println("Enter Service ID : ");
                        sids.add(sc.nextInt());
                    }
                    billingService.createInvoice(ci , vi , sids);
                    break;

                case 3 :
                    billingService.showAllInvoices();
                    break;
                case 4 :
                    System.exit(0);
                default:
                    System.out.println("Not a valid choice !");
            }

        }
    }
}
