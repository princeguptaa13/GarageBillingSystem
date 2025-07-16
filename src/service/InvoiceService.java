package service;

import config.DbConfig;
import entity.Customer;
import entity.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {
    public void addInvoice(Invoice invoice) throws SQLException {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO invoice (customer_id , vehicle_id , service_id) VALUES (? , ? , ? )");
        ps.setInt(1, invoice.getVehicleId());
        ps.setInt(2, invoice.getServiceId());
        ps.setInt(3, invoice.getCustomerId());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public List<Invoice> getAllInvoice() throws SQLException {
        List<Invoice> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from customer");
        while (rs.next()) {
            list.add(new Invoice(rs.getInt("id")
                    , rs.getInt("customer_id")
                    , rs.getInt("vehicle_id")
                    , rs.getInt("service_id")));
        }
        return list;
    }
}
