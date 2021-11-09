package ua.goIt.services;


import ua.goIt.dao.ProjectDao;
import ua.goIt.model.Project;

import java.util.List;
import java.util.Optional;


public class ProjectService {
    private static ProjectDao projectDao;

    public void save(Project entity) {
        getInstance().create(entity);
    }

    public static void edit(Project entity) {
        getInstance().update(entity);
    }

    public static void remove(Project entity) {
        getInstance().delete(entity);
    }

    public static Optional<Project> find(Long id) {
        return getInstance().getById(id);
    }
  public static List<Project> findAll(){
        return getInstance().getAll();
  }

    private static ProjectDao getInstance() {
        if (projectDao == null) {
            projectDao = new ProjectDao();
        }
        return projectDao;
    }
}
