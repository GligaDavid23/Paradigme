/*8.5.1 Scrieti o aplicatie care utilizeaza libraria POI si extrage informatiile din fisierul laborator8_input.xlsx
afisand continutul celulelor din acest fisier. In fisierul excel valorile sunt fie numerice fie text (string).*/

package ro.ulbs.paradigme.lab8.pb1;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.*;

public class DataExtraction {
	public static void main(String[] args) {
		XSSFWorkbook workbook = null;
		try {
			FileInputStream file = new FileInputStream(new
					File("laborator8_input.xlsx"));
			//Create Workbook instance holding reference to .xlsx file
			workbook = new XSSFWorkbook(file);
			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows one by one
			for (Row row : sheet) {
				//For each row, iterate through all the columns
				for (Cell cell: row){
					//Check the cell type and format accordingly
					switch (cell.getCellType()) {
						case CellType.NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case CellType.STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
					}
				}
				System.out.println();
			}
			file.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
