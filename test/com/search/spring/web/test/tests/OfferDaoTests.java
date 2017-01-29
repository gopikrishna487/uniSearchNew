package com.search.spring.web.test.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.search.spring.web.dao.TitleListASSIA;
import com.search.spring.web.dao.TitleListASSIADAO;
import com.search.spring.web.parcers.ASSIAExcelParcer;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:com/search/spring/web/config/dao-context.xml" 
 ,"classpath:com/search/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OfferDaoTests {

	private static Logger logger = Logger.getLogger(OfferDaoTests.class);

	@Autowired
	@Qualifier("TitleListASSIADAO")
	private TitleListASSIADAO TitleListASSIADao;

		
	@PostConstruct
	public void init() throws SQLException, InterruptedException{
		//org.h2.tools.Server.createTcpServer("-tcpPort", "9092", "-tcpDaemon").start();
		//TimeUnit.MINUTES.sleep(2);
	}
	@PreDestroy
	public void destroy() throws SQLException{
		//org.h2.tools.Server.createTcpServer("-tcpPort", "9092", "-tcpDaemon").stop();
	}
	
	
	@Test
	public void testGetTitleListASSIAs() throws IOException, InterruptedException {
	
		//Thread.currentThread();
		//Thread.sleep(1000);
		List<TitleListASSIA> listOfTitles = TitleListASSIADao
				.getTitleListASSIAs();
		System.out.println("Starting of main test.................!");
		logger.info(listOfTitles);
	}

	@Test
	public void testInsertData() throws IOException {
		String excelFilePath = "C:/titlelist_assia.xls";

		ASSIAExcelParcer reader = new ASSIAExcelParcer();
		List<TitleListASSIA> listBooks = reader.readBooksFromExcelFile(excelFilePath);
		
		logger.info(listBooks);
		
		TitleListASSIADao.saveOrUpdate(listBooks.get(1));
		List<TitleListASSIA> listOfTitles = TitleListASSIADao
				.getTitleListASSIAs();
		
		assertEquals("Should be 2 retrieved users.", 16, listOfTitles.size());
		
		logger.info(listOfTitles.size());

	}
}
