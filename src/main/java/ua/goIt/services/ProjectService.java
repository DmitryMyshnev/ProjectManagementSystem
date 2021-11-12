package ua.goIt.services;


import ua.goIt.dao.ProjectDao;
import ua.goIt.model.Project;
import static ua.goIt.services.ValidatePattern.*;
import static ua.goIt.services.Validate.*;

public class ProjectService implements Crud{
    private static ProjectDao projectDao;
    private  Project project;

    public ProjectService() {
        project = new Project();
        projectDao = new ProjectDao();
    }

    @Override
    public boolean isValid(String param) {
        String[] arrayParam = param.split(",");

       if(!isValidByPattern(namePattern,arrayParam[0])){
           System.out.printf((NAME_ERROR) + "%n", arrayParam[0]);
           return false;
       }
       if(!isValidByPattern(digitalPattern,arrayParam[2])){
           System.out.printf((DIGITAL_ERROR) + "%n",arrayParam[2]);
           return false;
       }
       if(arrayParam.length == 4){
           if(!isValidByPattern(digitalPattern,arrayParam[3])){
               System.out.printf((DIGITAL_ERROR) + "%n",arrayParam[3]);
               return false;
           }
       }
        return true;
    }

    @Override
    public void save(String arg) {
        if (!isValidByPattern(projectSavePattern, arg)) {
            System.out.println(TEMPLATE_ERROR);
        }else
        if (isValid(arg)) {
            projectDao.create(prepareInstance(arg));
            System.out.println("Project '" + project.getName() + "' was added.");
        }
    }

    @Override
    public void update(String arg) {
        if (!isValidByPattern(projectUpdatePattern, arg)) {
            System.out.println(TEMPLATE_ERROR);
        }else
        if (isValid(arg)) {
            projectDao.update(prepareInstance(arg));
            System.out.println("Project '" + project.getName() + "' was updated.");
        }
    }

    @Override
    public void delete(String arg) {
        project.setId(Long.parseLong(arg));
        getDao().delete(project);
        System.out.println("Project was deleted.");
    }

    @Override
    public void getAll() {
        getDao().getAll().forEach(System.out::println);
    }

    @Override
    public void findById(Long id) {
        System.out.println(getDao().getById(id));
    }

    public static ProjectDao getDao() {
        if (projectDao == null) {
            projectDao = new ProjectDao();
        }
        return projectDao;
    }

    private Project prepareInstance(String data) {
        String[] fields = data.split(",");
        project.setName(fields[0]);
        project.setDescription(fields[1]);
        project.setCost(Integer.parseInt(fields[2]));
        if(fields.length == 4){
            project.setId(Long.parseLong(fields[3]));
        }
        return project;
    }
}
