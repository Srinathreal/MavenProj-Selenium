package MavenStarted;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingExcelFiles {

	public static void main(String[] args) throws IOException {

		String FilePath = "../MavenProject-Selenium/src/main/Population.xlsx";

		// Step 1
		FileInputStream input = new FileInputStream(FilePath);
		// step2
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		// step3
		XSSFSheet sheet = workbook.getSheetAt(0);
		// step 4
		int rows = sheet.getLastRowNum(); // 3
		short Cells = sheet.getRow(0).getLastCellNum(); //2

		//                     0<=3
		for (int r = 0; r <= rows; r++) {

			XSSFRow row = sheet.getRow(r);  //0 th row
			
      //                           0<=2
			for (int c = 0; c <= Cells; c++) {
				
     //                                  0.getCell(0)
				XSSFCell cell = row.getCell(c);
				
				if (cell != null) {

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
					System.out.print(" | ");
				}
			}
			System.out.println();
		}

	}
}
