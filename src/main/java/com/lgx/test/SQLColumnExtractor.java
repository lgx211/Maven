package com.lgx.test;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.util.ArrayList;
import java.util.List;

public class SQLColumnExtractor {
    public static List<String> extractColumns(String sql) throws JSQLParserException {
        List<String> columns = new ArrayList<>();

        Select selectStatement = (Select) CCJSqlParserUtil.parse(sql);
        PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();

        List<SelectItem> selectItems = plainSelect.getSelectItems();
        for (SelectItem selectItem : selectItems) {
            if (selectItem instanceof SelectExpressionItem) {
                SelectExpressionItem expressionItem = (SelectExpressionItem) selectItem;
                Column column = (Column) expressionItem.getExpression();
                columns.add(column.getColumnName());
            }
        }

        return columns;
    }

    public static void main(String[] args) {
        String sql = "SELECT id, name FROM my_table WHERE age > 18";

        try {
            List<String> extractedColumns = extractColumns(sql);
            System.out.println("Columns extracted from SQL: " + extractedColumns);
        } catch (JSQLParserException e) {
            System.err.println("Error parsing SQL: " + e.getMessage());
        }
    }
}
