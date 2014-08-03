package com.wg.dao.spi;

import java.lang.reflect.Field;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.dao.api.IGenericDao;
import com.wg.model.BaseModel;
import com.wg.model.Character;

@Service
public class CharacterDao implements IGenericDao<com.wg.model.Character> {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public com.wg.model.Character findByKey(int key) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Character where id = :id");
		query.setParameter("id", key);
		List ls = query.list() ;
		if(ls != null && ls.size()>0)
			return (Character) ls.get(0);
		return null;
	}

	@Override
	public List<com.wg.model.Character> findByCriteria(BaseModel criteria) throws IllegalArgumentException, IllegalAccessException {
		
		com.wg.model.Character criteriaModel = (com.wg.model.Character)criteria;
		Criteria queryCriteria = sessionFactory.getCurrentSession().createCriteria(criteriaModel.getClass());
		if(criteriaModel != null)
		{
			Field[] fields = criteriaModel.getClass().getFields();
			for(Field field: fields)
			{
				if(field.get(criteriaModel) != null)
				{
					queryCriteria.add(Restrictions.eq(field.getName(), field.get(criteriaModel)));
				}
			}
		}
		return queryCriteria.list();
	}

	@Override
	public List<com.wg.model.Character> findAll() {
		Criteria queryCriteria = sessionFactory.getCurrentSession().createCriteria(com.wg.model.Character.class);
		return queryCriteria.list();
	}

}
