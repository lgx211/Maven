package com.lgx.utils.excel;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@ExcelIgnoreUnannotated
public class UserPojo {

    //加了这个，表头就会占用两行，不知道为啥
//    @ExcelProperty(index = 0, value = {"用户账号", "用户账号"})
    @ExcelProperty("用户账号")
    @ColumnWidth(15)
    private String userName;//用户账号

//    @ExcelProperty(index = 1, value = {"手机号码", "手机号码"})
    @ExcelProperty("手机号码")
    @ColumnWidth(15)
    private String phone;//手机号码

    private String noNeed;//不需要的字段
}
