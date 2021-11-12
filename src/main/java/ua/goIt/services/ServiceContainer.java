package ua.goIt.services;

import ua.goIt.model.Developer;

import java.util.Map;

public class ServiceContainer {
    private final Map<String, Crud> entityMap;
    private static ServiceContainer serviceContainer;

    private ServiceContainer() {
        entityMap = Map.of(
                "developer", new DeveloperService(),
                "project",new ProjectService(),
                "customer",new CustomerService(),
                "company",new CompanyService(),
                "skills",new SkillsService());
    }

    public static Crud getService(String service) {
        return getInstance().entityMap.getOrDefault(service, null);
    }
    private static ServiceContainer getInstance(){
        if (serviceContainer == null) {
            serviceContainer = new ServiceContainer();
        }
        return serviceContainer;
    }
}
