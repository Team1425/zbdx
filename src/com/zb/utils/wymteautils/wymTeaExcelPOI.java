package com.zb.utils.wymteautils;

import com.zb.dao.wymteadao.wymTeaDao;
import com.zb.pojo.wymteacher.wymTeacher;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import java.util.Date;
import java.util.List;

public class wymTeaExcelPOI {
    public void export(String[] titles, ServletOutputStream out) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
            HSSFRow row = hssfSheet.createRow(0);
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
            hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
            HSSFCell hssfCell = null;
            for (int i = 0; i <titles.length ; i++) {
                hssfCell = row.createCell(i);
                hssfCell.setCellValue(titles[i]);
                hssfCell.setCellStyle(hssfCellStyle);
            }

            wymTeaDao wymTeaDao = new wymTeaDao();
            List<wymTeacher> list = wymTeaDao.findAll();
            for (int i = 0; i <list.size() ; i++) {


                row = hssfSheet.createRow(i+1);
                wymTeacher wymTeacher = list.get(i);
                Integer wymTeaId = null;
                if(wymTeacher.getWymTeaId()!=null){
                    wymTeaId = wymTeacher.getWymTeaId();
                }
                row.createCell(0).setCellValue(wymTeaId);

                String wymTeaJobnum = "";
                if(wymTeacher.getWymTeaJobnum()!=null){
                    wymTeaJobnum = wymTeacher.getWymTeaJobnum();
                }
                row.createCell(1).setCellValue(wymTeaJobnum);

                String wymTeaName = "";
                if(wymTeacher.getWymTeaName()!=null){
                    wymTeaName = wymTeacher.getWymTeaName();
                }
                row.createCell(2).setCellValue(wymTeaName);

                String wymTeaSex = "";
                if(wymTeacher.getWymTeaSex()!=null){
                    wymTeaSex = wymTeacher.getWymTeaSex();
                }
                row.createCell(3).setCellValue(wymTeaSex);

                Date wymTeaBirthday = null;
                if(wymTeacher.getWymTeaBirthday()!=null){
                    wymTeaBirthday = new java.sql.Date(wymTeacher.getWymTeaBirthday().getTime());
                }
                HSSFCell cellBirthday = row.createCell(4);
                cellBirthday.setCellValue(wymTeaBirthday);
                HSSFDataFormat format= workbook.createDataFormat();
                hssfCellStyle.setDataFormat(format.getFormat("yyyy年m月d日"));
                cellBirthday.setCellStyle(hssfCellStyle);
                hssfSheet.setColumnWidth(4, 5000);


                String wymTeaIdcard = "";
                if(wymTeacher.getWymTeaIdcard()!=null){
                    wymTeaIdcard = wymTeacher.getWymTeaIdcard();
                }
                row.createCell(5).setCellValue(wymTeaIdcard);
                hssfSheet.setColumnWidth(5, 5000);

                Date wymTeaStartdate =null;
                if(wymTeacher.getWymTeaStartdate()!=null){
                    wymTeaStartdate = new java.sql.Date(wymTeacher.getWymTeaStartdate().getTime());

                }
                HSSFCell cellStartdate = row.createCell(6);
                cellStartdate.setCellValue(wymTeaBirthday);
                format= workbook.createDataFormat();
                hssfCellStyle.setDataFormat(format.getFormat("yyyy年m月d日"));
                cellStartdate.setCellStyle(hssfCellStyle);
                hssfSheet.setColumnWidth(6, 5000);

                String wymTeaCollege = "";
                if(wymTeacher.getWymTeaCollege()!=null){
                    wymTeaCollege = wymTeacher.getWymTeaCollege();
                }
                row.createCell(7).setCellValue(wymTeaCollege);

                String wymTeaProfession = "";
                if(wymTeacher.getWymTeaProfession()!=null){
                    wymTeaProfession = wymTeacher.getWymTeaProfession();
                }
                row.createCell(8).setCellValue(wymTeaProfession);
                hssfSheet.setColumnWidth(8, 3000);

                String wymTeaZhicheng = "";
                if(wymTeacher.getWymTeaZhicheng()!=null){
                    wymTeaZhicheng = wymTeacher.getWymTeaZhicheng();
                }
                row.createCell(9).setCellValue(wymTeaZhicheng);

                String wymTeaZhengzhimm = "";
                if(wymTeacher.getWymTeaZhengzhimm()!=null){
                    wymTeaZhengzhimm = wymTeacher.getWymTeaZhengzhimm();
                }
                row.createCell(10).setCellValue(wymTeaZhengzhimm);

                String wymTeaPhonenum = "";
                if(wymTeacher.getWymTeaPhonenum()!=null){
                    wymTeaPhonenum = wymTeacher.getWymTeaPhonenum();
                }
                row.createCell(11).setCellValue(wymTeaPhonenum);
                hssfSheet.setColumnWidth(11, 5000);

                String wymTeaEmail = "";
                if(wymTeacher.getWymTeaEmail()!=null){
                    wymTeaEmail = wymTeacher.getWymTeaEmail();
                }
                row.createCell(12).setCellValue(wymTeaEmail);
                hssfSheet.setColumnWidth(12, 5000);

                String wymTeaSalary = "";
                if(wymTeacher.getWymTeaSalary()!=null){
                    wymTeaSalary = wymTeacher.getWymTeaSalary();
                }
                row.createCell(13).setCellValue(wymTeaSalary);

            }
            workbook.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
