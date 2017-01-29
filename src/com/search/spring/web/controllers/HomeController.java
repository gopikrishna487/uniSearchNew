package com.search.spring.web.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.search.spring.web.dao.TitleListASSIA;
import com.search.spring.web.dao.TitleListASSIADAO;
import com.search.spring.web.parcers.ASSIAExcelParcer;

@Controller
public class HomeController {
 
	@Autowired
	private TitleListASSIADAO titleListASSIADAO;
	@RequestMapping("/")
	public String showHome() {
		return "index";
	}
	
	@RequestMapping("/home")
	public String showHomeJSP() {
		return "home";
	}
	
	@RequestMapping("/books")
    public String getProducts(Model model) throws IOException {
		
		String excelFilePath = "C:/titlelist_assia.xls";
		
		ASSIAExcelParcer reader = new ASSIAExcelParcer();
		List<TitleListASSIA> listBooks = reader.readBooksFromExcelFile(excelFilePath);
		titleListASSIADAO.saveOrUpdate(listBooks.get(1));
		titleListASSIADAO.saveOrUpdate(listBooks.get(2));
		
        List<TitleListASSIA> books = titleListASSIADAO.getTitleListASSIAs();
        model.addAttribute("books", books);

        return "books";
    }
}
