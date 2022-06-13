package com.lgx.utils.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserPojo {
    @ExcelProperty(index = 0, value = {"用户账号", "用户账号"})
    private String userName;//用户账号
    @ExcelProperty(index = 1, value = {"手机号码", "手机号码"})
    private String phone;//手机号码
}
