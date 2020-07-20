package com.zb.utils;


import com.zb.dao.wghCollegeDao.wghCollegeDao;
import com.zb.pojo.wghpojo.wghCollege;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import java.util.List;

public class wghExcelPOI {
    //利用此方法生成Excel
    public void excelport(String[] titles, ServletOutputStream out){
        //1.创建一个workbook对象，对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.在workbook中添加一个sheet，对应Excel中的sheet
        HSSFSheet sheet =workbook.createSheet("sheet1");
        //3.在sheet中添加表头第0行
        HSSFRow hssfRow = sheet.createRow(0);
        //4.创建单元格，并设置表头居中
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        //4.1样式居中，其他样式百度
        hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        //4.2创建单元格
        HSSFCell cell = null;
        for(int i=0;i<titles.length;i++){
            cell = hssfRow.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(hssfCellStyle);
        }

        wghCollegeDao wghCollegeDao = new wghCollegeDao();
        try {
            List<wghCollege> list = wghCollegeDao.findAll();
            //创建行，注意行的下标从0开始，之前已经设置了0了
            for(int i=0;i<list.size();i++) {
                hssfRow = sheet.createRow(i + 1);
                wghCollege wghcollege = list.get(i);
                Integer id = null;
                if (wghcollege.getWgh_id() != null) {
                    id = wghcollege.getWgh_id();
                }
                hssfRow.createCell(0).setCellValue(id);
                String name = "";
                if (wghcollege.getWgh_name() != null) {
                    name = wghcollege.getWgh_name();
                }
                hssfRow.createCell(1).setCellValue(name);
                String leader = "";
                if (wghcollege.getWgh_leader() != null) {
                    leader = wghcollege.getWgh_leader();
                }

                hssfRow.createCell(2).setCellValue(leader);
                Integer teacherNum = null;
                if (wghcollege.getWgh_teacherNum() != null) {
                    teacherNum = wghcollege.getWgh_teacherNum();
                }

                hssfRow.createCell(3).setCellValue(teacherNum);
                Integer studentNum = null;
                if (wghcollege.getWgh_studentNum() != null) {
                    studentNum = wghcollege.getWgh_studentNum();
                }
                hssfRow.createCell(4).setCellValue(studentNum);
                String promotionNum = "";
                if (wghcollege.getWgh_promotionRate() != null) {
                    promotionNum = wghcollege.getWgh_promotionRate();
                }

                hssfRow.createCell(5).setCellValue(promotionNum);
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
