package com.lgx.mybatis;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

// 把所有执行的sql都记录下来
// 对 StatementHandler 中的 prepare 方法进行拦截
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare",
		args = {Connection.class, Integer.class})})
public class MyStatementInterceptor implements Interceptor {

	//进行拦截的时候要执行的方法
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		String sql = boundSql.getSql();
		System.out.println("执行的" + sql);
		return invocation.proceed();
	}

	//用于封装目标对象的，可以返回目标对象本身，也可以返回它的代理
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	//配置插件的时候可以配置自定义相关属性，
	public void setProperties(Properties properties) {
		String dialect = properties.getProperty("dialect");
		System.out.println(dialect);
	}
}
