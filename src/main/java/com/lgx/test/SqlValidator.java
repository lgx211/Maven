package com.lgx.test;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;

public class SqlValidator {
    public static void main(String[] args) {
        String sql = "SELECT a-b FROM your_table WHERE column = 'value'";

        try {
            // 尝试解析SQL语句，如果解析成功，说明语法正确
            CCJSqlParserUtil.parse(sql);

            System.out.println("SQL语法验证通过");
        } catch (JSQLParserException e) {
            // 解析失败，说明语法有问题
            System.out.println("SQL语法验证失败：" + e.getMessage());
        }
    }
}
