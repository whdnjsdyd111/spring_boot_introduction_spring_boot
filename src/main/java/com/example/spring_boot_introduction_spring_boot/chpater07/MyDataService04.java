package com.example.spring_boot_introduction_spring_boot.chpater07;

import com.example.spring_boot_introduction_spring_boot.chpater07.repositories.MyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class MyDataService04 {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    MyDataRepository repository;

    private static final int PAGE_SIZE = 3; // 한 페이지당 엔터티 수

    public Page<MyData> getMyDataInPage(Integer pageNumber) {
        // PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE);    원래
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, PAGE_SIZE);
        return repository.findAll(pageRequest);
    }

    public List<MyData> getAll() {
        return (List<MyData>) entityManager.createQuery("from MyData").getResultList();
    }

    public MyData get(int num) {
        return (MyData) entityManager
                .createQuery("from MyData where id = " + num)
                .getSingleResult();
    }

    public List<MyData> find(String fstr) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
        Root<MyData> root = query.from(MyData.class);
        query.select(root).where(builder.equal(root.get("name"), fstr));
        List<MyData> list = null;
        list = (List<MyData>) entityManager.createQuery(query).getResultList();
        return list;
    }
}
