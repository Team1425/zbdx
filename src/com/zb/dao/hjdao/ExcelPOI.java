package com.zb.dao.hjdao;

import com.zb.pojo.hjpojo.hjGroup;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import java.util.List;

public class ExcelPOI {
    public void export(String [] titels,
                       ServletOutputStream out){
        try {
//以下代码，能百度复制就不要去记，懂逻辑，懂值的替换即可
//1.创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
//2.在workbook中添加一个sheet，对应Excel中的sheet
            HSSFSheet hssfSheet =
                    workbook.createSheet("sheet1");
//3.在sheet中添加表头第0行
            HSSFRow row = hssfSheet.createRow(0);
//4.创建单元格，并设置表头居中
            HSSFCellStyle hssfCellStyle =
                    workbook.createCellStyle();
//4.1居中样式,这里只设置居中，其他样式可自行百度
            hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
//4.2创建单元格
            HSSFCell hssfCell = null;
            for (int i=0;i<titels.length;i++){
                hssfCell = row.createCell(i);
                hssfCell.setCellValue(titels[i]);
                hssfCell.setCellStyle(hssfCellStyle);
            }
            hjGroupDao hjGroupDao = new hjGroupDao();
            List<hjGroup> list = hjGroupDao.findAll();
//创建行，注意行的下标从0开始，之前已经设置了0了
            for (int i=0;i<list.size();i++){
                row = hssfSheet.createRow(i+1);
                hjGroup group = list.get(i);
                Integer id= null;
                if(group.getHj_grp_id()!=null){id = group.getHj_grp_id();
                } row.createCell(0).setCellValue(id);
                String name ="";
                if (group.getHj_grp_name()!=null){
                    name = group.getHj_grp_name();
                } row.createCell(1).setCellValue(name);
                Integer total= null;
                if(group.getHj_grp_total()!=null){total = group.getHj_grp_total();
                }
                row.createCell(2).setCellValue(total);
                String type = "";
                if(group.getHj_grp_type()!=null){
                    type=group.getHj_grp_type();
                } row.createCell(3).setCellValue(type);
                String money = "";
                if(group.getHj_grp_money()!=null){
                    money=group.getHj_grp_money();
                } row.createCell(4).setCellValue(money);
                String activity = "";
                if (group.getHj_grp_activity()!=null){
                    activity=group.getHj_grp_activity();
                } row.createCell(5).setCellValue(activity);
            } //将文件输出到客户端浏览器
            workbook.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
