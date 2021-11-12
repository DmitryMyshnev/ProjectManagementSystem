package ua.goIt.services;

import ua.goIt.dao.CompanyDao;
import ua.goIt.model.Company;


import static ua.goIt.services.Validate.*;
import static ua.goIt.services.ValidatePattern.*;


public class CompanyService implements Crud{
    private final Company company;
    private static CompanyDao companyDao;

    public CompanyService() {
        company = new Company();
        companyDao = new CompanyDao();
    }

    @Override
    public boolean isValid(String param) {
        String[] arrayParam = param.split(",");
        if (!isValidByPattern(NAME_PATTERN, arrayParam[0])) {
            System.out.printf((NAME_ERROR) + "%n", arrayParam[0]);
            return false;
        }
        if (!isValidByPattern(DIGITAL_PATTERN, arrayParam[1])) {
            System.out.printf((DIGITAL_ERROR) + "%n", arrayParam[1]);
            return false;
        }
        return true;
    }

    @Override
    public void save(String arg) {
        if (!isValidByPattern(COMPANY_SAVE_PATTERN, arg)) {
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
        if (!isValidByPattern(COMPANY_UPDATE_PATTERN, arg)) {
            System.out.println(TEMPLATE_ERROR);
            return;
        }
        if(!isValidByPattern(DIGITAL_PATTERN,arg.split(",")[2])){
            System.out.printf((DIGITAL_ERROR) + "%n",arg);
            return;
        }
        if (isValid(arg)) {
            prepareInstance(arg);
            getDao().update(company);
            System.out.println("Company '" + company.getName() + "' was updated.");
        }
    }

    @Override
    public void delete(String arg) {
        if(!isValidByPattern(DIGITAL_PATTERN,arg)){
            System.out.printf((DIGITAL_ERROR) + "%n",arg);
        }else {
            company.setId(Long.parseLong(arg));
            getDao().delete(company);
            System.out.println("Company  was deleted.");
        }
    }

    @Override
    public void getAll() {
        getDao().getAll().forEach(System.out::println);
    }

    @Override
    public void findById(Long id) {
        getDao().getById(id).ifPresent(System.out::println);
    }
    public static CompanyDao getDao() {
        if (companyDao == null) {
            companyDao = new CompanyDao();
        }
        return companyDao;
    }
    private void prepareInstance(String data) {
        String[] fields = data.split(",");
        company.setName(fields[0]);
        company.setQuantityEmployee(Integer.parseInt(fields[1]));
        if(fields.length == 3){
            company.setId(Long.parseLong(fields[2]));
        }
    }
}
