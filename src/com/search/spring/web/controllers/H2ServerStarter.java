/*package com.search.spring.web.controllers;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class H2ServerStarter {

	@PostConstruct
    public void startH2TcpServer() throws SQLException
	{
         org.h2.tools.Server.createTcpServer("-tcpPort", "9092", "-tcpDaemon").start();
    }
	
	@PreDestroy
    public void stopH2TcpServer() throws SQLException
	{
		org.h2.tools.Server.createTcpServer("-tcpPort", "9092", "-tcpDaemon").stop();
    }
}*/