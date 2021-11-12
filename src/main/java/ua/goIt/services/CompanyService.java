package ua.goIt.services;

import ua.goIt.dao.CompanyDao;
import ua.goIt.dao.CustomerDao;
import ua.goIt.model.Company;
import ua.goIt.model.Customer;

import static ua.goIt.services.Validate.*;
import static ua.goIt.services.ValidatePattern.*;


public class CompanyService implements Crud{
    private Company company;
    private static CompanyDao companyDao;

    public CompanyService() {
        company = new Company();
        companyDao = new CompanyDao();
    }

    @Override
    public boolean isValid(String param) {
        String[] arrayParam = param.split(",");
        if (!isValidByPattern(namePattern, arrayParam[0])) {
            System.out.printf((NAME_ERROR) + "%n", arrayParam[0]);
            return false;
        }
        if (!isValidByPattern(digitalPattern, arrayParam[1])) {
            System.out.printf((DIGITAL_ERROR) + "%n", arrayParam[1]);
            return false;
        }
        return true;
    }

    @Override
    public void save(String arg) {
        if (!isValidByPattern(companySavePattern, arg)) {
            System.out.println(TEMPLATE_ERROR);
        }else
        if (isValid(arg)) {
            prepareInstance(arg);
            getDao().create(company);
            System.out.println("Company '" + company.getName() + "' was added.");
        }
    }

    @Override
    public void update(String arg) {
        if (!isValidByPattern(companyUpdatePattern, arg)) {
            System.out.println(TEMPLATE_ERROR);
        }else
        if (isValid(arg)) {
            prepareInstance(arg);
            getDao().update(company);
            System.out.println("Company '" + company.getName() + "' was updated.");
        }
    }

    @Override
    public void delete(String arg) {

    }

    @Override
    public void getAll() {

    }

    @Override
    public void findById(Long id) {

    }
    public static CompanyDao getDao() {
        if (companyDao == null) {
            companyDao = new CompanyDao();
        }
        return companyDao;
    }
    private Company prepareInstance(String data) {
        String[] fields = data.split(",");
        company.setName(fields[0]);
        company.setQuantityEmployee(Integer.parseInt(fields[1]));
        if(fields.length == 3){
            company.setId(Long.parseLong(fields[2]));
        }
        return company;
    }
}
