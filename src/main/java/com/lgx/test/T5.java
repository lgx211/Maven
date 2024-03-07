package com.lgx.test;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.apache.commons.lang3.StringUtils;

import java.io.StringReader;
import java.util.List;

public class T5 {
    public static void main(String[] args) throws JSQLParserException {
        String schema = "aaa";
        String tableName = "bbb";
        String upTableName = StringUtils.isNotEmpty(tableName) ? tableName.toUpperCase() : "";

        String sql = "select TABLE_NAME,TABLE_COMMENT as COMMENTS from INFORMATION_SCHEMA.Tables where table_schema =" + "'" + schema + "' "
                + (StringUtils.isNotEmpty(upTableName) ? " and (upper(table_name) like '%" + upTableName + "%' or upper(table_comment) like '%" + upTableName + "%' )" : "");
        System.out.println(tables(sql));
    }

    public static List<String> tables(String sql) {
        try {
            CCJSqlParserManager parserManager = new CCJSqlParserManager();
            Statement statement = parserManager.parse(new StringReader(sql));
            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            return tablesNamesFinder.getTableList(statement);
        } catch (JSQLParserException e) {

        }
        return null;
    }


}
