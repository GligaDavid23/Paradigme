/*8.5.2 Scrieti o alta metoda care genereaza un fisier excel cu continutul si culorile:

Folositi urmatoarea structura de date din care sa folositi datele:
Map<String, Object[]> data = new TreeMap<String, Object[]>();
data.put("2", new Object[] {"Amit", "Shukla", 9,8,7,5});
data.put("3", new Object[] {"Lokesh", "Gupta", 8,9,6,7});
data.put("4", new Object[] {"John", "Adwards", 8,8,7,6 });
data.put("5", new Object[] {"Brian", "Schultz", 7,6,8,9});
Continutul coloanei G este =MAX(Di:Fi) unde i este randul.
Continutul coloane H este =AVERAGE(Di:Fi) unde i este randul.
Formulele se seteaza cu cell.setCellFormula(...);
Salvati sub numele output8.xlsx.
Adaugati font bold la celulele de pe primul rand.
Adaugati fundal galben pe ultimile doua coloane, fundal verde pe primul rand (CellStyle).
 */

package ro.ulbs.paradigme.lab8.pb2;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.*;

public class SheetCreator {
	public static void main(String[] args) {
		try (XSSFWorkbook workbook = new XSSFWorkbook();
		     FileOutputStream out = new FileOutputStream("output8.xlsx")) {

			XSSFSheet sheet = workbook.createSheet();

			XSSFFont fontHeader = workbook.createFont();
			fontHeader.setBold(true);

			XSSFCellStyle styleForHeader = workbook.createCellStyle();
			styleForHeader.setFont(fontHeader);
			styleForHeader.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			styleForHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			styleForHeader.setAlignment(HorizontalAlignment.CENTER);
			styleForHeader.setBorderBottom(BorderStyle.THIN);
			styleForHeader.setBorderLeft(BorderStyle.THIN);
			styleForHeader.setBorderRight(BorderStyle.THIN);
			styleForHeader.setBorderTop(BorderStyle.THIN);

			XSSFCellStyle yellowStyle = workbook.createCellStyle();
			yellowStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
			yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			yellowStyle.setAlignment(HorizontalAlignment.CENTER);
			yellowStyle.setBorderBottom(BorderStyle.THIN);
			yellowStyle.setBorderLeft(BorderStyle.THIN);
			yellowStyle.setBorderRight(BorderStyle.THIN);
			yellowStyle.setBorderTop(BorderStyle.THIN);

			XSSFCellStyle normalStyle = workbook.createCellStyle();
			normalStyle.setAlignment(HorizontalAlignment.CENTER);
			normalStyle.setBorderBottom(BorderStyle.THIN);
			normalStyle.setBorderLeft(BorderStyle.THIN);
			normalStyle.setBorderRight(BorderStyle.THIN);
			normalStyle.setBorderTop(BorderStyle.THIN);

			XSSFCellStyle failedStyle = workbook.createCellStyle();
			failedStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			failedStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			failedStyle.setAlignment(HorizontalAlignment.CENTER);
			failedStyle.setBorderBottom(BorderStyle.THIN);
			failedStyle.setBorderLeft(BorderStyle.THIN);
			failedStyle.setBorderRight(BorderStyle.THIN);
			failedStyle.setBorderTop(BorderStyle.THIN);

			String[] headers = {"Name", "Surname", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Max", "Average", "Sum"};
			Row header = sheet.createRow(0);
			int colNum = 0;
			for (String h : headers) {
				Cell cell = header.createCell(colNum++);
				cell.setCellValue(h);
				cell.setCellStyle(styleForHeader);
			}

			Map<String, Object[]> data = new TreeMap<>();
			data.put("2", new Object[]{"Amit", "Shukla", 9, 8, 7, 5});
			data.put("3", new Object[]{"Lokesh", "Gupta", 8, 2, 1, 7});
			data.put("4", new Object[]{"John", "Adwards", 8, 8, 7, 6});
			data.put("5", new Object[]{"Brian", "Schultz", 7, 6, 8, 9});

			int rowNum = 1;
			for (Object[] objArr : data.values()) {
				Row row = sheet.createRow(rowNum);
				int cellNum = 0;
				for (Object obj : objArr) {
					Cell cell = row.createCell(cellNum++);
					if (obj instanceof String)
						cell.setCellValue((String) obj);
					else
						cell.setCellValue(((Number) obj).doubleValue());
					cell.setCellStyle(normalStyle);
				}
				int excelRow = rowNum + 1;
				Cell maxCell = row.createCell(6);
				maxCell.setCellFormula("MAX(C" + excelRow + ":F" + excelRow + ")");
				maxCell.setCellStyle(yellowStyle);

				Cell avgCell = row.createCell(7);
				avgCell.setCellFormula("Round(AVERAGE(C" + excelRow + ":F" + excelRow + "), 2)");
				avgCell.setCellStyle(yellowStyle);

				Cell sumCell = row.createCell(8);
				sumCell.setCellFormula("SUM(C" + excelRow + ":F" + excelRow + ")");
				sumCell.setCellStyle(yellowStyle);

				rowNum++;
			}

			for (int i = 0; i < headers.length; i++)
				sheet.autoSizeColumn(i);

			workbook.write(out);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
