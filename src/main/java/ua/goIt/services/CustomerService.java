package ua.goIt.services;

import ua.goIt.dao.CustomerDao;
import ua.goIt.model.Customer;

import static ua.goIt.services.Validate.*;
import static ua.goIt.services.ValidatePattern.*;


public class CustomerService implements Crud{
    private  Customer customer;
    private static CustomerDao customerDao;

    public CustomerService() {
        customer = new Customer();
        customerDao = new CustomerDao();
    }

    @Override
    public boolean isValid(String param) {
        String[] arrayParam = param.split(",");
        if (!isValidByPattern(namePattern, arrayParam[0])) {
            System.out.printf((NAME_ERROR) + "%n", arrayParam[0]);
            return false;
        }
        if (!isValidByPattern(namePattern, arrayParam[1])) {
            System.out.printf((NAME_ERROR) + "%n", arrayParam[1]);
            return false;
        }
        return true;
    }
    @Override
    public void save(String arg) {
        if (!isValidByPattern(customerSavePattern, arg)) {
            System.out.println(TEMPLATE_ERROR);
        }else
        if (isValid(arg)) {
            prepareInstance(arg);
            getDao().create(customer);
            System.out.println("Customer '" + customer.getFirstName() + "' was added.");
        }
    }

    @Override
    public void update(String arg) {
        if (!isValidByPattern(customerUpdatePattern, arg)) {
            System.out.println(TEMPLATE_ERROR);
        }else
        if (isValid(arg)) {
            prepareInstance(arg);
            getDao().update(customer);
            System.out.println("Customer '" + customer.getFirstName() +" "+ customer.getLastName() + "' was updated.");
        }
    }

    @Override
    public void delete(String arg) {
        customer.setId(Long.parseLong(arg));
        getDao().delete(customer);
        System.out.println("Customer  was deleted.");
    }

    @Override
    public void getAll() {
        getDao().getAll().forEach(System.out::println);
    }

    @Override
    public void findById(Long id) {
        System.out.println(getDao().getById(id));
    }

    public static CustomerDao getDao() {
        if (customerDao == null) {
            customerDao = new CustomerDao();
        }
        return customerDao;
    }

    private Customer prepareInstance(String data) {
        String[] fields = data.split(",");
        customer.setFirstName(fields[0]);
        customer.setLastName(fields[1]);
        if(fields.length == 3){
            customer.setId(Long.parseLong(fields[2]));
        }
        return customer;
    }
}
