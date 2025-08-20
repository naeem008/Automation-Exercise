package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// ############ এই import গুলো যোগ করুন ############
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	

	  private String filePath;

	    public ExcelUtils(String filePath) {
	        this.filePath = filePath;
	    }

	    /**
	     * Writes data (username, email, password) to a specified row in an Excel sheet.
	     * @param sheetName The name of the sheet.
	     * @param rowNum The row number to write to (0-based).
	     * @param username The username to write in column 0.
	     * @param email The email to write in column 1.
	     * @param password The password to write in column 2.
	     * @throws IOException
	     */
	    public void writeData(String sheetName, int rowNum, String username, String email, String password) throws IOException {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
	        
	        if (sheet == null) {
	            sheet = workbook.createSheet(sheetName);
	        }

	        Row row = sheet.createRow(rowNum);

	        // কলাম 0: Username
	        Cell usernameCell = row.createCell(0); 
	        usernameCell.setCellValue(username);

	        // কলাম 1: Email
	        Cell emailCell = row.createCell(1);
	        emailCell.setCellValue(email);

	        // কলাম 2: Password
	        Cell passwordCell = row.createCell(2);
	        passwordCell.setCellValue(password);

	        fis.close(); // প্রথমে ইনপুট স্ট্রিম বন্ধ করুন

	        FileOutputStream fos = new FileOutputStream(filePath);
	        workbook.write(fos);
	        workbook.close();
	        fos.close();
	    }
	    
	    /**
	     * Reads data from a specified row in an Excel sheet.
	     * @param sheetName The name of the sheet.
	     * @param rowNum The row number to read from (0-based).
	     * @return A map containing username, email, and password.
	     * @throws IOException
	     */
	    public Map<String, String> readData(String sheetName, int rowNum) throws IOException {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
	        
	        if (sheet == null) {
	            workbook.close();
	            fis.close();
	            throw new IOException("Sheet with name '" + sheetName + "' does not exist.");
	        }
	        
	        Row row = sheet.getRow(rowNum);
	        
	        if (row == null) {
	            workbook.close();
	            fis.close();
	            throw new IOException("Row with index " + rowNum + " does not exist in sheet '" + sheetName + "'.");
	        }
	        
	        Map<String, String> data = new HashMap<>();
	        
	        // কলাম 0 থেকে Username পড়া হচ্ছে
	        Cell usernameCell = row.getCell(0);
	        data.put("username", usernameCell != null ? usernameCell.getStringCellValue() : "");

	        // কলাম 1 থেকে Email পড়া হচ্ছে
	        Cell emailCell = row.getCell(1);
	        data.put("email", emailCell != null ? emailCell.getStringCellValue() : "");

	        // কলাম 2 থেকে Password পড়া হচ্ছে
	        Cell passwordCell = row.getCell(2);
	        data.put("password", passwordCell != null ? passwordCell.getStringCellValue() : "");

	        workbook.close();
	        fis.close();
	        return data;
	    }
	}

