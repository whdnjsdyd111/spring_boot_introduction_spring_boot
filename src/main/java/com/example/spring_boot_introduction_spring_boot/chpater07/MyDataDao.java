package com.example.spring_boot_introduction_spring_boot.chpater07;

import java.io.Serializable;
import java.util.List;

public interface MyDataDao<T> extends Serializable {
    public List<T> getAll();
    public T findById(long id);
    public List<T> findByName(String name);
    public List<T> find(String fstr);
    public List<T> findByAge(int min, int max);
}
