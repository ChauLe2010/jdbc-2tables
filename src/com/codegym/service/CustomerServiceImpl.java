package com.codegym.service;

import com.codegym.ConnectDB;
import com.codegym.model.Customer;
import com.codegym.model.Province;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    Connection connection= ConnectDB.getConnect();
    private String SELECT_ALL_CUSTOMER = "select * from customer";
    private String INSERT_CUSTOMER = "insert into customer values (?,?,?,?)";
    @Override
    public List<Customer> listCustomer() {
        IProvinceService provinceService=new ProvinceServiceImpl();
        List<Customer> customers=new ArrayList<>();
        try {
            PreparedStatement ps=connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("customerId");
                String name=rs.getString("customerName");
                String image=rs.getString("customerImage");
                int provinceId=rs.getInt("provinceId");
                Province province=provinceService.getProvinceById(provinceId);
                customers.add(new Customer(id,name,image,province));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public String getCustomerNameById(int id) {
        return null;
    }

    @Override
    public void save(Customer customer) {
        try {
            PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER);
            ps.setInt(1,customer.getId());
            ps.setString(2,customer.getName());
            ps.setString(3,customer.getImage());
            ps.setInt(4,customer.getProvince().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Customer newCustomer) {

    }

    @Override
    public void delete(int id) {

    }
}
