package com.hygor.erick.DAO;

import java.util.List;

public interface IDAO<T> {
    void save(T entidade);
    void update(String id, T entidade);
    void delete(String id);
    T find(String id);
    List<T> findAll();
}
