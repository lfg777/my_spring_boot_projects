package com.lfg.beans;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by lifengguang on 2017/10/26.
 */
public class AnalyExcelData {

    private static String path1 = "C:\\Users\\lifengguang\\Desktop\\loan_o.xlsx";

    private static String path2 = "C:\\Users\\lifengguang\\Desktop\\shenhezhulicases.xlsx";

    private void compare(String path1,String path2) throws IOException, InvalidFormatException {

        Workbook sheets = WorkbookFactory.create(new File(path1));
        Sheet sheet = sheets.getSheetAt(0);
        Iterator<Row> iterator = sheet.rowIterator();
        Workbook sheets2 = WorkbookFactory.create(new File(path2));
        Sheet sheet2 = sheets2.getSheetAt(0);



        //头部信息
        Row firstRow = iterator.next();

        while (iterator.hasNext()) {
            Row row = iterator.next();
            Cell firstListingId = row.getCell(0);
            String stringCellValue = firstListingId.getStringCellValue();
            Iterator<Row> iterator2 = sheet2.rowIterator();
            Row afterFirst = iterator2.next();
            while (iterator2.hasNext()) {
                Row row2 = iterator2.next();
                Cell cell2 = row2.getCell(0);
                String cell2Str = cell2.getStringCellValue();
                if (stringCellValue.equalsIgnoreCase(cell2Str)) {
                    Cell firstOwnerId = row.getCell(1);
                    Cell secondOwnerId = row2.getCell(1);
                    if (!firstOwnerId.getStringCellValue().equalsIgnoreCase(secondOwnerId.getStringCellValue())) {
                        System.out.println("listingId:"+stringCellValue+" newOwnerId:"+firstOwnerId.getStringCellValue()+" oldOwnerId:"+secondOwnerId.getStringCellValue());
                    }
                }

            }

        }

    }

    public static void main(String[] args) {
        AnalyExcelData a = new AnalyExcelData();
        try {
            a.compare(path1,path2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }


}
