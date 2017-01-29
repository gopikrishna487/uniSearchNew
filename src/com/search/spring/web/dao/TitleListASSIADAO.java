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

import com.search.spring.web.controllers.HomeController;

@Repository
@Component("TitleListASSIADAO")
@Transactional
public class TitleListASSIADAO {
	private static Logger logger = Logger.getLogger(TitleListASSIADAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		logger.info(sessionFactory);
		return sessionFactory.getCurrentSession();
	}

	public List<TitleListASSIA> getTitleListASSIAs() {

		return session().createQuery("from TitleListASSIA").list();
	}

	public void saveOrUpdate(TitleListASSIA TitleListASSIA) {
		session().saveOrUpdate(TitleListASSIA);
	}

	public boolean delete(String ISSNPrint) {
		Query query = session().createQuery(
				"delete from TitleListASSIA where ISSNPrint=:ISSNPrint");
		query.setString("ISSNPrint", ISSNPrint);

		return query.executeUpdate() == 1;
	}

	public TitleListASSIA getTitleListASSIA(String ISSNPrint) {

		Query query = session().createQuery(
				"from TitleListASSIA where ISSNPrint=:ISSNPrint");
		query.setString("ISSNPrint", ISSNPrint);
		return (TitleListASSIA) query.uniqueResult();
	}

}
