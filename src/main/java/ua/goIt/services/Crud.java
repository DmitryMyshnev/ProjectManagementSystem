package ua.goIt.services;


public interface Crud {
    void save(String arg);

    void update(String arg);

    void delete(String arg);

    boolean isValid(String param);

   void getAll();

   void findById(Long id);

}
