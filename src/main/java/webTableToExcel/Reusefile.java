package webTableToExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.netty.handler.codec.DateFormatter;

public class Reusefile {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    String path;
    
    Reusefile(String path)
    {
    	this.path=path;
    }
    
    public int getRowCount(String sheetName) throws IOException 
    {
    	fi=new FileInputStream(path);
    	workbook=new XSSFWorkbook(fi);
    	sheet=workbook.getSheet(sheetName);
    	int rowcount=sheet.getLastRowNum();
    	workbook.close();
    	fi.close();
    	return rowcount;
    }
    
    public int getCellCount(String sheetName,int rownum) throws IOException
    {
    	fi=new FileInputStream(path);
    	workbook=new XSSFWorkbook(fi);
    	sheet=workbook.getSheet(sheetName);
    	row=sheet.getRow(rownum);
    	int cellCount=row.getLastCellNum();
    	workbook.close();
    	fi.close();
    	return cellCount;
    }
    
    public String getCellData(String sheetName, int rownum,int colnum) throws IOException
    {
    	fi=new FileInputStream(path);
    	workbook=new XSSFWorkbook(fi);
    	sheet=workbook.getSheet(sheetName);
    	row=sheet.getRow(rownum);
    	cell=row.getCell(colnum);
    	
    	DataFormatter formatter= new DataFormatter();
    	String data;
    	try {
    		data=formatter.formatCellValue(cell);
    	}
    	catch(Exception e)
    	{
    		data=" ";
    	}
    	workbook.close();
    	fi.close();
    	return data;
    	
    }
    
    public void writeToExcel(String sheetname, int rownum,int coloumn,String data) throws IOException
    {
    	File file=new File(path);
    	if(!file.exists())    //if file not exists create a new file
    	{
    		workbook=new XSSFWorkbook();
    		fo=new FileOutputStream(file);
    		workbook.write(fo);
    	}
    	
    	fi=new FileInputStream(file);
    	workbook=new XSSFWorkbook(fi);
    	
    	if(workbook.getSheetIndex(sheetname)==-1)//if sheet not exist then create new sheet
    		workbook.createSheet(sheetname);
    	sheet=workbook.getSheet(sheetname);
    	
    	if(sheet.getRow(rownum)==null) //if row not exists create new row
    	{
    		sheet.createRow(rownum);
    		
    	}
    	row=sheet.getRow(rownum);
    	
    	cell=row.createCell(coloumn);
    	cell.setCellValue(data);
    	
    	fo=new FileOutputStream(file);
    	workbook.write(fo);
    	workbook.close();
    	fo.close();
    	fi.close();
    }
}
