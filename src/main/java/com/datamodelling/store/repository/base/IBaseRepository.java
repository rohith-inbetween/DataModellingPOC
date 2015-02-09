package com.datamodelling.store.repository.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {
  
  // Common apis across all repositories will go here
  
  /**
   * Gets an iterable of all rows matching the condition i.e. of value in
   * particular column.
   * 
   * @param searchValue Value to be searched
   * @param modelClass The class of the table entity to be searched in
   * @param columnName Column in which to search for the value
   * @return Iterable containing all the matching data
   */
  public List<T> findByColumnName(String searchValue, String columnName);
}
