package ua.goIt.services;


import java.util.List;
import java.util.Optional;

public interface Crud {
    void save(String arg);

    void update(String arg);

    void delete(String arg);

    List<Object> getAll();

    Optional<Object> findById(Long id);

}
