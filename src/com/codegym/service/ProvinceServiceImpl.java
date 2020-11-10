package com.codegym.service;

import com.codegym.ConnectDB;
import com.codegym.model.Province;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceServiceImpl implements IProvinceService{
    Connection connection= ConnectDB.getConnect();
    private String SELECT_ALL_PROVINCE = "select * from province";
    private String SELECT_PROVINCE_BY_ID = "select * from province where provinceId=?";
    private String SELECT_PROVINCE_BY_NAME = "select * from province where provinceName=?";

    @Override
    public List<Province> listProvince() {
        List<Province> provinces=new ArrayList<>();
        try {
            PreparedStatement ps=connection.prepareStatement(SELECT_ALL_PROVINCE);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("provinceId");
                String name=rs.getString("provinceName");
                boolean status=rs.getBoolean("provinceStatus");
                provinces.add(new Province(id,name,status));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return provinces;
    }

    @Override
    public Province getProvinceById(int id) {
        Province province=null;
        try {
            PreparedStatement ps=connection.prepareStatement(SELECT_PROVINCE_BY_ID);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String name=rs.getString("provinceName");
                Boolean status=rs.getBoolean("provinceStatus");
                province=new Province(id,name,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return province;
    }

    @Override
    public Province getProvinceByName(String provinceName) {
        Province province=null;
        try {
            PreparedStatement ps=connection.prepareStatement(SELECT_PROVINCE_BY_NAME);
            ps.setString(1,provinceName);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt("provinceId");
                String name=rs.getString("provinceName");
                Boolean status=rs.getBoolean("provinceStatus");
                province=new Province(id,name,status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return province;
    }

    @Override
    public void save(Province province) {

    }

    @Override
    public void update(int id, Province newProvince) {

    }

    @Override
    public void delete(int id) {

    }
}
