package MavenStarted;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.print.DocFlavor.STRING;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelUsingIterator {

	public static void main(String[] args) throws IOException {

		
		String Filepath = "../MavenProject-Selenium/src/main/Population.xlsx";
		
		//TO CREATE A FILE (INPUT WAY) ---
		FileInputStream inputStream = new FileInputStream(Filepath);

		//TO EXTRACT WORKBOOK FROM FILE(inputStream)  ---
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		//TO CREATE SHEET FROM A WORKBOOK
		XSSFSheet sheet = workbook.getSheetAt(0);

//		int Rows = sheet.getLastRowNum(); // 3
//		short Cells = sheet.getRow(0).getLastCellNum(); // 2

		Iterator<Row> rowIterator = sheet.rowIterator();

		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				}
				System.out.print("  |  ");
			}
			System.out.println();
		}

	}
}
