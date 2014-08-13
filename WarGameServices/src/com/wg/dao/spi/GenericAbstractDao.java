package com.wg.dao.spi;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericAbstractDao<T> implements Serializable{
	
	@Autowired
	protected SessionFactory sessionFactory;

	public abstract T findByKey(int key);
	
	public List<T> findByCriteria(T criteria) throws IllegalArgumentException, IllegalAccessException 
	{
		Criteria queryCriteria = sessionFactory.getCurrentSession().createCriteria(criteria.getClass());
		if(criteria != null)
		{
			Field[] fields = criteria.getClass().getFields();
			for(Field field: fields)
			{
				if(field.get(criteria) != null)
				{
					queryCriteria.add(Restrictions.eq(field.getName(), field.get(criteria)));
				}
			}
		}
		return queryCriteria.list();

	}
	
	public List<T> findAll(T model)
	{
		Criteria queryCriteria = sessionFactory.getCurrentSession().createCriteria(model.getClass());
		List<T> res = queryCriteria.list();
		return res;

	}

}
