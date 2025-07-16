package service;

import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CustomerService {

    public void addCustomer(Customer customer) throws SQLException {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO customer (name , phone , adhardetails) VALUES (? , ? , ? )");
        ps.setString(1 ,customer.getName());
        ps.setString(2 ,customer.getPhone());
        ps.setInt(3 , customer.getAdhaar());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public List<Customer> getAllCustomer() throws SQLException{
     List<Customer> list = new ArrayList<>();
     Connection conn = DbConfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from customer");
        while(rs.next())
        {
            list.add(new Customer(rs.getInt("id")
                    ,rs.getString("name")
                    ,rs.getString("phone")
                    ,rs.getInt("adhaar")));
        }
        return list ;
    }
}


