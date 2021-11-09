package ua.goIt.services;

import ua.goIt.dao.DeveloperDao;
import ua.goIt.model.Developer;

import java.util.List;
import java.util.Optional;

public class DeveloperService  {
    private static DeveloperDao developerDao;

    public void save(Developer entity) {
        getInstance().create(entity);
    }

    public static void edit(Developer entity) {
        getInstance().update(entity);
    }

    public static void remove(Developer entity) {
        getInstance().delete(entity);
    }

    public static Optional<Developer> find(Long id) {
        return getInstance().getById(id);
    }

     public List<Developer> findAll(){
        return getInstance().getAll();
     }

    public static Integer getAllSalary(String projectName) {
        return getInstance().getAllSalaryByProject(projectName);
    }

    public static List<Developer> getAllDeveloperFromProject(String projectName) {
        return getInstance().getAllDeveloperByProject(projectName);
    }

    public static List<Developer> getDeveloperSkill(String skillsName) {
        return getInstance().getDeveloperBySkills(skillsName);
    }
    public static List<Developer> getDeveloperLevel(String level){
      return   getInstance().getDeveloperByLevel(level);
    }
    private static DeveloperDao getInstance() {
        if (developerDao == null) {
            developerDao = new DeveloperDao();
        }
        return developerDao;
    }
}
