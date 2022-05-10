package com.lgx.utils.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelTest {

    public static void main(String[] args) throws IOException {
        UserPojo userPojo = new UserPojo();
        userPojo.setUserName("zs");
        userPojo.setPhone("123");
        UserPojo userPojo2 = new UserPojo();
        userPojo2.setUserName("ls");
        userPojo2.setPhone("321");
        List<UserPojo> userPojos = new ArrayList<UserPojo>();
        userPojos.add(userPojo);
        userPojos.add(userPojo2);
        String fileName = "/Users/liguoxi/tmp/aaa.xlsx";

        Poi.writeExcel(userPojos, fileName);

        EasyExcel.writeExcel(userPojos, fileName);

        HuTool.writeExcel(userPojos, fileName);

    }
}
