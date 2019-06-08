package com.ystu.web_first.Model;

import java.util.ArrayList;

public class Data {
    private static Data data = null;

    public static Data getInstance() {
        if(data == null) {
            data = new Data();
        }
        return data;
    }

    private Data() {
        initData();
    }

    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Order> orders = new ArrayList<Order>();


    public  Customer getCustomerByLogPas(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass)) ){
                return cusLP;
            }
        }
        return null;
    }

    public  long getIdCustomerByLogPas(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass)) ){
                return cusLP.getId();
            }
        }
        return 0;
    }


    public  boolean getLogin(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass))){
                return false;
            }
        }
        return true;
    }


    public String addCustomers(long id,String name, String pass,String email) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(name))){
                return "Этот логин занят! Попробуйте другой!";
            }
        }
        customers.add(new Customer(id,name,pass,email));
        return "Вы зарегистрированы! Войдите на сайт!";
    }


    public int getSizeCustomers()
    {
        return customers.size();
    }


    public  ArrayList<Product> getProducts() {
        return products;
    }


    public  Product getProductById(long id) {
        for (Product product : products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }


    public  void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }


    public  Order getOrderById(long id) {
        for (Order or : orders){
            if (or.getId() == id){
                return or;
            }
        }
        return new Order();
    }


    public  Order getOrderByCustomer(long idCust) {
        for (Order or : orders){
            if (or.getCustomer_id() == idCust){
                return or;
            }
        }
        return new Order();
    }


    public void initData()
    {

        customers.add(new Customer(2,"admin","admin", "2sss@sss"));
        customers.add(new Customer(3,"Nat","1234", "3sss@sss"));

        products.add(new Product(1,"Apple",100));
        products.add(new Product(2,"Tomato",124));
        products.add(new Product(3,"Banana",78));
        products.add(new Product(4,"Potato",65));
        products.add(new Product(5,"Lemon",93));
        products.add(new Product(6,"Melon",147));
        products.add(new Product(7,"Cucumber",71));
        products.add(new Product(8,"Corn",90));

    }

}
