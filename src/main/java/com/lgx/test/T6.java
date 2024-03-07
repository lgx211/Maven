package com.lgx.test;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.io.StringReader;
import java.util.List;

public class T6 {

    public static void main(String[] args) {
        recoverTableName("SHOW TABLE IN AAA");
    }

    public static String recoverTableName(String sql) {
        List<String> tables = tables(sql);
        String sqlStr = sql;
        for (String s : tables) {
            if (s.contains("\"")) {
                String a = s.replace("\"", "");
                sqlStr = sqlStr.replace(s, a);
            }
        }
        return sqlStr;
    }

    public static List<String> tables(String sql) {
        String sqlStr = sql.replace(";", "").replace("；", "");
        sqlStr = sqlStr.trim().replaceAll(" +", " ");
        try {
            CCJSqlParserManager parserManager = new CCJSqlParserManager();
            Statement statement = parserManager.parse(new StringReader(sqlStr));
            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            return tablesNamesFinder.getTableList(statement);
        } catch (JSQLParserException e) {
        }
        return null;
    }
}
