package utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtility {

		public static FileInputStream fi;
		public static FileOutputStream fo;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static CellStyle style;  
		
		
		public static String readExcelData(int i) throws IOException {
			String xlfile=System.getProperty("user.dir")+"\\src\\test\\resources\\BikesInfo.xlsx";
			fi= new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet("Login Validation"); 
			row=ws.getRow(i);
			cell=row.getCell(0);
			String data= cell.toString();
			return data;
		}
		
		
		public static void setCellData(String xlsheet,int rownum,int colnum,String data) throws IOException
		{   
			String xlfile=System.getProperty("user.dir")+"\\src\\test\\resources\\BikesInfo.xlsx";
			fi=new FileInputStream(xlfile);
			wb=new XSSFWorkbook(fi);
			try{
				
				ws=wb.createSheet(xlsheet);
			}
			catch(Exception e) {
				ws=wb.getSheet(xlsheet);
				
			}
			
			row=ws.getRow(rownum);
			if(row==null)
			{
				row=ws.createRow(rownum);
				
			}
			
			cell=row.createCell(colnum);
			cell.setCellValue(data);
			ws.autoSizeColumn(colnum);
			fo=new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\BikesInfo.xlsx");
			wb.write(fo);		
			wb.close();
			fi.close();
			fo.close();
					
		}
		
		
		public static void fillBlueColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException

		{

			fi=new FileInputStream(xlfile);

			wb=new XSSFWorkbook(fi);

			ws=wb.getSheet(xlsheet);

			row=ws.getRow(rownum);

			cell=row.getCell(colnum);

			style=wb.createCellStyle();

			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());

			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  

			cell.setCellStyle(style);		

			fo=new FileOutputStream(xlfile);

			wb.write(fo);

			wb.close();

			fi.close();

			fo.close();

		}
		public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException

		{

			fi=new FileInputStream(xlfile);

			wb=new XSSFWorkbook(fi);

			ws=wb.getSheet(xlsheet);

			row=ws.getRow(rownum);

			cell=row.getCell(colnum);

			style=wb.createCellStyle();

			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());

			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  

			cell.setCellStyle(style);		

			fo=new FileOutputStream(xlfile);

			wb.write(fo);

			wb.close();

			fi.close();

			fo.close();

		}
		
		
		
}