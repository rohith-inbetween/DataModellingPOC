package com.datamodelling.store.repository.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements
    IBaseRepository<T, ID> {
  
  private EntityManager entityManager;
  private Class<T> domainClass;
  
  // There are two constructors to choose from, either can be used.
  public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager)
  {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }
  
  public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager)
  {
    super(domainClass, entityManager);
    this.domainClass = domainClass;
    this.entityManager = entityManager;
  }
  
  public List<T> findByColumnName(String id, String columnName)
  {
    String queryString = "select * from " + domainClass.getSimpleName() + " where " + columnName + "=\"" + id.toString()
        + "\"";
    Query query = entityManager.createNativeQuery(queryString, domainClass);
    return query.getResultList();
  }
  
}