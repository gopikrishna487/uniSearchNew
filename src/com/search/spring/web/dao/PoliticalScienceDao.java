package com.search.spring.web.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Component("PoliticalScienceDao")
@Transactional
public class PoliticalScienceDao {

	private static Logger logger = Logger.getLogger(PoliticalScienceDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		logger.info(sessionFactory);
		return sessionFactory.getCurrentSession();
	}

	public List<PoliticalScience> getPoliticalSciences() {

		return session().createQuery("from PoliticalScience").list();
	}

	public void saveOrUpdate(PoliticalScience PoliticalScience) {
		session().saveOrUpdate(PoliticalScience);
	}

	public boolean delete(String ISSN) {
		Query query = session().createQuery(
				"delete from PoliticalScience where ISSN=:ISSN");
		query.setString("ISSN", ISSN);

		return query.executeUpdate() == 1;
	}

	public PoliticalScience getPoliticalScience(String ISSN) {

		Query query = session().createQuery(
				"from PoliticalScience where ISSN=:ISSN");
		query.setString("ISSN", ISSN);
		return (PoliticalScience) query.uniqueResult();
	}
}
