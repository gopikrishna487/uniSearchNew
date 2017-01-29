package com.search.spring.web.parcers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.search.spring.web.dao.PoliticalScience;

public class PoliticalScienceExcelParcer {
	
	@SuppressWarnings({ "deprecation"})
	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}

	public List<PoliticalScience> readBooksFromExcelFile(String excelFilePath)
			throws IOException {
		List<PoliticalScience> listBooks = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(
				excelFilePath));

		Workbook workbook = new HSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			PoliticalScience aBook = new PoliticalScience();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					aBook.setTitle((String) getCellValue(nextCell));
					break;
				case 1:
					aBook.setPublisher((String) getCellValue(nextCell));
					break;
				case 2:
					aBook.setISSN((String) getCellValue(nextCell));
					break;
				case 3:
					aBook.seteISSN((String) getCellValue(nextCell));
					break;
				case 4:
					aBook.setISBN((String) getCellValue(nextCell));
					break;
				case 5:
					aBook.setFullTextFirst((String) getCellValue(nextCell));
					break;
				case 6:
					aBook.setFullTextLast((String) getCellValue(nextCell));
					break;
				case 7:
					aBook.setAbstractFirst((String) getCellValue(nextCell));
					break;
				case 8:
					aBook.setAbstractLast((String) getCellValue(nextCell));
					break;
				}

			}
			listBooks.add(aBook);
		}

		workbook.close();
		inputStream.close();

		return listBooks;
	}


}
