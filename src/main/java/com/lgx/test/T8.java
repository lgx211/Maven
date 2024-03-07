package com.lgx.test;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.apache.commons.lang3.StringUtils;

import java.io.StringReader;
import java.util.List;

public class T8 {
    public static void main(String[] args) throws JSQLParserException {
//        String sql1 = "show tables in aaa";
        String sql = "SELECT TABNAME AS TABLE_NAME FROM SYSCAT.TABLES WHERE TABSCHEMA =" + "'" + "schema" + "'"
                + (StringUtils.isNotEmpty("upTableName") ? " and (upper(TABNAME) like '%" + "upTableName" + "%' or  upper(table_comment) like '%" + "upTableName" + "%' )" : "");

        System.out.println(tables(sql));
//        System.out.println(tables(sql1));
    }

    public static List<String> tables(String sql) {
        Statement statement = null;
        try {
            CCJSqlParserManager parserManager = new CCJSqlParserManager();
            statement = parserManager.parse(new StringReader(sql));
        } catch (JSQLParserException e) {

        }


        TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
        return tablesNamesFinder.getTableList(statement);
    }
}
