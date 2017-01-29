package com.search.spring.web.test.tests;

import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class H2ServerStarter {

	@PostConstruct
    public void startH2TcpServer() throws SQLException
	{
         org.h2.tools.Server.createTcpServer("-tcpPort", "9092", "-tcpDaemon").start();
    }
	
	
}