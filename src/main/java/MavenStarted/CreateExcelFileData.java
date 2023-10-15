package MavenStarted;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFileData {
	//Using ForLoop
	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook(); // WorkBook

		XSSFSheet createSheet = workbook.createSheet(); // CreateSheet

		Object[][] empdata = { { "EMP ID", "NAME", "JOB" }, { 520, "Steve", "CEO" }, { 521, "TRaja", "Manager" },
				{ 522, "Srinath", "Analyst" } };

		int rows = empdata.length;
		System.out.println(rows);
		int cols = empdata[0].length;
		System.out.println(cols);

		for (int r = 0; r <rows; r++) {

			XSSFRow Row = createSheet.createRow(r);
			for (int c = 0; c <cols; c++) {
				XSSFCell Cell = Row.createCell(c);

				Object value = empdata[ r ] [ c ];
				if (value instanceof String)
					Cell.setCellValue((String) value);
				if (value instanceof Integer)
					Cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					Cell.setCellValue((Boolean) value);
			}

		}
		String Filepath = ".//DataFiles//Employees.xlsx";
		FileOutputStream fileOutputStream = new FileOutputStream(Filepath);
		workbook.write(fileOutputStream);
		fileOutputStream.close();
	}
}
