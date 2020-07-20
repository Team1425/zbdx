package com.zb.utils;

import com.zb.dao.WjBooksDao;
import com.zb.pojo.WjBooks;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import java.util.List;

public class WjExcelPOI {
    public void export(String titles[], ServletOutputStream out){

        try {
            //1.创建一个Workbook,对应一个Excel
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.在workbook中添加一个Sheet,对应Excel中的Sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
            //3.添加表头
            HSSFRow row = hssfSheet.createRow(0);
            //4.创建单元格,并设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
            //居中样式
            hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
            //创建单元格
            HSSFCell hssfCell = null;

            for(int i =0;i<titles.length;i++){
                hssfCell = row.createCell(i);
                hssfCell.setCellValue(titles[i]);
                hssfCell.setCellStyle(hssfCellStyle);
            }

            WjBooksDao wjBooksDao = new WjBooksDao();
            List<WjBooks> list = wjBooksDao.findAll();

            for (int i=0;i<list.size();i++){
                row =hssfSheet.createRow(i+1);
                WjBooks wjBooks= list.get(i);
                Integer id = null;
                if(wjBooks.getId()!=null){
                    id = wjBooks.getId();
                }
                row.createCell(0).setCellValue(id);

                String booksname="";
                if(wjBooks.getBooksname()!=null){
                    booksname=wjBooks.getBooksname();
                }
                row.createCell(1).setCellValue(booksname);

                String author="";
                if(wjBooks.getAuthor()!=null){
                    author=wjBooks.getAuthor();
                }
                row.createCell(2).setCellValue(author);

                String ISBN="";
                if(wjBooks.getISBN()!=null){
                    ISBN=wjBooks.getISBN();
                }
                row.createCell(3).setCellValue(ISBN);

                String ph="";
                if(wjBooks.getPh()!=null){
                    ph=wjBooks.getPh();
                }
                row.createCell(4).setCellValue(ph);

                String price="";
                if(wjBooks.getPrice()!=null){
                    price=wjBooks.getPrice();
                }
                row.createCell(5).setCellValue(price);

                String pd="";
                if(wjBooks.getPd()!=null){
                    pd=wjBooks.getPd();
                }
                row.createCell(6).setCellValue(pd);
            }


            workbook.write(out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
