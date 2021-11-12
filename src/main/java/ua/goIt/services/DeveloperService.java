package ua.goIt.services;

import ua.goIt.dao.DeveloperDao;
import ua.goIt.model.Developer;
import static ua.goIt.services.ValidatePattern.*;
import java.util.List;
import static ua.goIt.services.Validate.*;

public class DeveloperService implements Crud {
    private  Developer developer;
    private static DeveloperDao developerDao;

    public DeveloperService() {
        developer = new Developer();
        developerDao = new DeveloperDao();
    }

    @Override
    public boolean isValid(String param) {
        String[] arrayParam = param.split(",");

        if (!isValidByPattern(namePattern, arrayParam[0])) {
            System.out.printf((NAME_ERROR) + "%n", arrayParam[0]);
            return false;
        }
        if (!isValidByPattern(agePattern, arrayParam[1])) {
            System.out.printf((AGE_ERROR) + "%n", arrayParam[1]);
            return false;
        }
        if (!isValidByPattern(genderPattern, arrayParam[2])) {
            System.out.printf((GENDER_ERROR) + "%n", arrayParam[2]);
            return false;
        }
        if (!isValidByPattern(digitalPattern, arrayParam[3])) {
            System.out.printf((DIGITAL_ERROR) + "%n", arrayParam[3]);
            return false;
        } else
            return true;
    }

    @Override
    public void save(String arg) {
        if (!isValidByPattern(developerSavePattern, arg)) {
            System.out.println(TEMPLATE_ERROR);
        }else
        if (isValid(arg)) {
            prepareInstance(arg);
            getDao().create(developer);
            System.out.println("Developer '" + developer.getName() + "' was added.");
        }
    }

    @Override
    public void update(String arg) {
        if (!isValidByPattern(developerUpdatePattern, arg)) {
            System.out.println(TEMPLATE_ERROR);
        }else
        if (isValid(arg)) {
            prepareInstance(arg);
            getDao().update(developer);
            System.out.println("Developer '" + developer.getName() + "' was updated.");
        }
    }

    @Override
    public void delete(String arg) {
            developer.setId(Long.parseLong(arg));
            getDao().delete(developer);
            System.out.println("Developer was deleted.");
    }

    @Override
    public void findById(Long id) {
        System.out.println(getDao().getById(id));
    }

    @Override
    public void getAll() {
     getDao().getAll().forEach(System.out::println);
    }

    public static Integer getAllSalary(String projectName) {
        return getDao().getAllSalaryByProject(projectName);
    }

    public static List<Developer> getAllDeveloperFromProject(String projectName) {
        return getDao().getAllDeveloperByProject(projectName);
    }

    public static List<Developer> getDeveloperSkill(String skillsName) {
        return getDao().getDeveloperBySkills(skillsName);
    }

    public static List<Developer> getDeveloperLevel(String level) {
        return getDao().getDeveloperByLevel(level);
    }

    public static DeveloperDao getDao() {
        if (developerDao == null) {
            developerDao = new DeveloperDao();
        }
        return developerDao;
    }

    private Developer prepareInstance(String data) {
        String[] fields = data.split(",");
        developer.setName(fields[0]);
        developer.setAge(Integer.parseInt(fields[1]));
        developer.setSex(fields[2]);
        developer.setSalary(Integer.parseInt(fields[3]));
        if(fields.length == 5){
            developer.setId(Long.parseLong(fields[4]));
        }
        return developer;
    }
}
