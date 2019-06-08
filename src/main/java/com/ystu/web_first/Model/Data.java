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

    //получить покупателя по логину и паролю
    public  Customer getCustomerByLogPas(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass)) ){
                return cusLP;
            }
        }
        return null;
    }

    //получить id покупателя по логину и паролю
    public  long getIdCustomerByLogPas(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass)) ){
                return cusLP.getId();
            }
        }
        return 0;
    }

    //проверка на правильность логина и пароля
    public  boolean getLogin(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass))){
                return false;
            }
        }
        return true;
    }

    //добавить нового пользователя
    public String addCustomers(long id,String name, String pass,String email) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(name))){
                return "Такое имя уже существует";
            }
        }
        customers.add(new Customer(id,name,pass,email));
        return "Регистрация прошла успешно";
    }

    //вернуть количество пользователей в БД
    public int getSizeCustomers()
    {
        return customers.size();
    }

    //получить гитары
    public  ArrayList<Product> getProducts() {
        return products;
    }

    //получить гитару по ее id
    public  Product getProductById(long id) {
        for (Product product : products){
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    //установить заказ
    public  void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    //получить заказ по его id
    public  Order getOrderById(long id) {
        for (Order or : orders){
            if (or.getId() == id){
                return or;
            }
        }
        return new Order();
    }

    //получить заказ по id прользователя
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
        employees.add(new Employee(1,"Aa","1234", "1sss@sss"));
        customers.add(new Customer(2,"Bb","1234", "2sss@sss"));
        customers.add(new Customer(3,"Cc","1234", "3sss@sss"));

        products.add(new Product(1,"Apple",100));
        products.add(new Product(2,"Tomato",124));
        products.add(new Product(3,"Banana",78));
        products.add(new Product(4,"Potato",65));

    }

}
