package com.lgx.utils.excel.easy;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.util.ArrayList;
import java.util.List;

//动态表头填充
public class DynamicHead {

    public static void main(String[] args) {
        testExport();
    }

    public static void testExport() {
        String fileName = "/Users/bipo/Downloads/111.xlsx";
        EasyExcel.write(fileName)
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(20))
                .registerWriteHandler(myHorizontalCellStyleStrategy())
                // 这里放入动态头
                .head(getHead()).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(getData());
    }

    public static List<List<String>> getData() {
        List<List<String>> total = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("德玛西亚");
        list.add("aaa,bbb,ccc,ddd");
        list.add("坦克路");
        list.add("班次： 08:00 - 17:00 班次： 18:00 - 24:00");
        list.add("班次： 08:00 - 17:00");
        total.add(list);

        System.out.println("内容:" + list);
        return total;
    }

    private static List<List<String>> getHead() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<>();
        head0.add("姓名");
        list.add(head0);

        List<String> head1 = new ArrayList<>();
        head1.add("部门");
        list.add(head1);

        List<String> head2 = new ArrayList<>();
        head2.add("职位");
        list.add(head2);

        List<String> head3 = new ArrayList<>();
        head3.add("10月1日");
        head3.add("周六");
        list.add(head3);

        List<String> head4 = new ArrayList<>();
        head4.add("10月2日");
        head4.add("周日");
        list.add(head4);

        System.out.println("表头:" + list);

        return list;
    }


    public static HorizontalCellStyleStrategy myHorizontalCellStyleStrategy() {
        //表头样式
        WriteCellStyle headStyle = new WriteCellStyle();
        headStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setBold(true);
        headWriteFont.setFontName("宋体");
        headWriteFont.setFontHeightInPoints((short) 11);
        headStyle.setWriteFont(headWriteFont);

        //内容样式
        WriteCellStyle contentStyle = new WriteCellStyle();
        contentStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        contentStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        contentStyle.setWrapped(true);

        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontName("宋体");
        contentWriteFont.setFontHeightInPoints((short) 11);
        contentStyle.setWriteFont(contentWriteFont);

        return new HorizontalCellStyleStrategy(headStyle, contentStyle);
    }
}
