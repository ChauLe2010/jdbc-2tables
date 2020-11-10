package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.CustomerServiceImpl;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import com.codegym.service.ProvinceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService=new CustomerServiceImpl();
    IProvinceService provinceService=new ProvinceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                saveCustomer(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                showListCustomer(request,response);
                break;
        }
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("cusId"));
        String name=request.getParameter("cusName");
        String image=request.getParameter("cusImg");
        String provinceName=request.getParameter("provinceName");
        Province province=provinceService.getProvinceByName(provinceName);
        customerService.save(new Customer(id,name,image,province));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action=request.getParameter("action");
    if(action==null){
        action="";
    }
    switch (action){
        case "create":
            showCreateForm(request,response);
            break;
        case "edit":
            break;
        case "delete":
            break;
        default:
            showListCustomer(request,response);
            break;
    }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Province> provinces=provinceService.listProvince();
        request.setAttribute("provinces",provinces);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers=customerService.listCustomer();
        request.setAttribute("customers",customers);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
