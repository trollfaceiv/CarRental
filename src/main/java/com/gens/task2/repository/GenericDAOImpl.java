package com.gens.task2.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

public abstract class GenericDAOImpl<I extends Serializable, Id extends Serializable> implements GenericDAO<I,Id> {
	
		@PersistenceContext
		protected EntityManager entityManager;
		protected final Class<I> entityClass;
		
		CriteriaBuilder builder;
		
		
		@SuppressWarnings("unchecked")
		public GenericDAOImpl() {
			this.entityClass = (Class<I>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		
		private CriteriaQuery<I> initCriteria(){
			builder = this.entityManager.getCriteriaBuilder();
			return builder.createQuery(this.entityClass);
		}
		
		@Override
		public List<I> retrieveAll(){
			CriteriaQuery<I> query = this.initCriteria();
			
			return this.entityManager.createQuery(
					query.select(query.from(this.entityClass))).getResultList();
			
		}
		
		@Override
		public I retrieveByID(Id id) {
			CriteriaQuery<I> query = this.initCriteria();
	
			return this.entityManager.createQuery(
					query.where(
							builder.equal(query.from(this.entityClass).get("id"),id))).getSingleResult();
					
}
		
		@Override
		public void inserOrUpdateItem(I entity) {
			Session session = entityManager.unwrap(Session.class);
			session.merge(entity);
			flushAndClear();
		}

		
		@Override
		public void deleteItem(I entity) {
			Session session = entityManager.unwrap(Session.class);
			session.remove(entity);
			flushAndClear();
		}
		
		@Override
		public void deleteByID(Id id) {
			deleteItem(retrieveByID(id));
			flushAndClear();
		}
		
		private void flushAndClear() {
			entityManager.flush();
			entityManager.clear();
		}
					
}
