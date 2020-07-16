package com.zb.utils;

import com.zb.dao.by_LostDao;
import com.zb.pojo.by_Lost;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import java.util.List;

public class by_ExcelPOI {
    //利用此方法生成Excel
    public void export(String [] titles, ServletOutputStream out){

        try {
            //以下代码，能百度复制就不要去记，懂逻辑，懂值替换即可
            //1.创建一个workbook，对应一个excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            //2.在workbook中添加一个sheet，对应excel中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
            //3.在sheet中添加表头第0行
            HSSFRow row = hssfSheet.createRow(0);
            //4.创建单元格，并设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
            //4.1居中样式,这里只设置居中，其他样式可自行百度
            hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
            //4.2创建单元格
            HSSFCell hssfCell = null;
            for (int i = 0;i<titles.length;i++){
                hssfCell = row.createCell(i);
                hssfCell.setCellValue(titles[i]);
                hssfCell.setCellStyle(hssfCellStyle);
            }
            by_LostDao lostDao = new by_LostDao();
            List<by_Lost> list = lostDao.findAll();
            //创建行，注意行的下标从0开始，之前已经设置0了
            for (int i = 0;i<list.size();i++){
                row = hssfSheet.createRow(i+1);
                by_Lost lost = list.get(i);
                Integer id = null;
                if(lost.getId()!=null){
                    id = lost.getId();
                }
                row.createCell(0).setCellValue(id);

                String type = "";
                if(lost.getType()!=null){
                    type = lost.getType();
                }
                row.createCell(1).setCellValue(type);

                String trait = "";
                if(lost.getTrait()!=null){
                    trait=lost.getTrait();
                }
                row.createCell(2).setCellValue(trait);

                String lost_loc = "";
                if(lost.getLost_loc()!=null){
                    lost_loc=lost.getLost_loc();
                }
                row.createCell(3).setCellValue(lost_loc);

                String get_loc = "";
                if(lost.getGet_loc()!=null){
                    get_loc=lost.getGet_loc();
                }
                row.createCell(4).setCellValue(get_loc);
            }

            //将文件输出到客户端浏览器
            workbook.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
