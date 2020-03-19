package com.lft;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

class PoiTest {

	@Test
	void test() throws IOException {
		//1.创建workbook工作簿
		Workbook wb = new XSSFWorkbook();
		//2.创建表单Sheet
		Sheet sheet = wb.createSheet("test");
		Row row = sheet.createRow(2);
		row.createCell(0).setCellValue(1.1);
		row.createCell(1).setCellValue(new Date());
		row.createCell(2).setCellValue(Calendar.getInstance());
		row.createCell(3).setCellValue("a string");
		row.createCell(4).setCellValue(true);
		row.createCell(5).setCellType(CellType.ERROR);
		//3.文件流
		FileOutputStream fos = new FileOutputStream("E:\\test.xlsx");
		//4.写入文件
		wb.write(fos);
		fos.close();
		wb.close();
	}
	
	@Autowired
	private ApplicationContext ctx;
	
	@Test
	void testOpenFile() throws EncryptedDocumentException, IOException {
		InputStream inputStream = ctx.getResource("").getInputStream();
		Workbook wb = WorkbookFactory.create(inputStream);
		//大数据量数据导出
		SXSSFWorkbook workbook = new SXSSFWorkbook();
		
		Sheet sheet = wb.getSheet("test");
		int lastRowNum = sheet.getLastRowNum();
		
		for (int i = 0; i < lastRowNum; i++) {
			
			Row row = sheet.getRow(i);
			short lastCellNum = row.getLastCellNum();
			
			for (int j = 0; j <lastCellNum; j++) {
				
			}
		}
	}

}
