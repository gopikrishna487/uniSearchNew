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
@Component("SociologyDao")
@Transactional
public class SociologyDao {

	
	private static Logger logger = Logger.getLogger(SociologyDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		logger.info(sessionFactory);
		return sessionFactory.getCurrentSession();
	}

	public List<Sociology> getSociologys() {

		return session().createQuery("from Sociology").list();
	}

	public void saveOrUpdate(Sociology Sociology) {
		session().saveOrUpdate(Sociology);
	}

	public boolean delete(String ISSN) {
		Query query = session().createQuery(
				"delete from Sociology where ISSN=:ISSN");
		query.setString("ISSN", ISSN);

		return query.executeUpdate() == 1;
	}

	public Sociology getSociology(String ISSN) {

		Query query = session().createQuery(
				"from Sociology where ISSN=:ISSN");
		query.setString("ISSN", ISSN);
		return (Sociology) query.uniqueResult();
	}
	
}
