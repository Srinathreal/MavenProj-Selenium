package MavenStarted;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelUsingForEach {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet Sheet = workbook.createSheet("EMP INFo");

//		Object empdata[][] = { { "Country", "Population", "Grade" }, { "Thailand", 76968797, "A" },
//				{ "China", 98787987, "B" }, { "Japan", 5686587, "D" }, };

		ArrayList<Object[]> empdata = new ArrayList<Object[]>();
		empdata.add(new Object[] { "Country", "Population", "Grade" });
		empdata.add(new Object[] { "Thailand", 76968797, "A" });
		empdata.add(new Object[] { "China", 98787987, "B" });
		empdata.add(new Object[] { "Japan", 5686587, "D" });

//		int rows = empdata.length;
//		int cols = empdata[0].length;

		int rowcount = 0;
		for (Object emp[] : empdata) {
			XSSFRow Row = Sheet.createRow(rowcount++);

			// to creat row (rowcount) '0' data starts using here

			int colcounts = 0;
			for (Object value : emp) {
				XSSFCell cell = Row.createCell(colcounts++);

				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}

		}
		String Filepath = ".//DataFiles//Employees3.xlsx";
		FileOutputStream fileOutputStream = new FileOutputStream(Filepath);
		workbook.write(fileOutputStream);
		fileOutputStream.close();
	}
}
