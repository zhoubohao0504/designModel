package com.zbh.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql ,RowMapper<?> rowMapper ,Object[] values){
        try {
            //1.获取连接
            Connection conn =  this.getConnection();
            //2.创建语句集
            PreparedStatement preparedStatement = this.createPrepareStatement(conn,sql);
            //3.执行语句集
            ResultSet resultSet = this.executeQuery(preparedStatement,values);
            //4.处理结果集
            List<?>  result = this.parseResult(resultSet,rowMapper);
            //5.关闭结果集
            this.closeResult(resultSet);
            //6.关闭语句集
            this.closeStatement(preparedStatement);
            //7.关闭连接
            this.closeConn(conn);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void closeConn(Connection conn) throws Exception {
        //数据库连接池，就不是关闭而是回收了
        conn.close();
    }

    protected void closeStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.close();
    }

    protected void closeResult(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    protected List<?> parseResult(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (resultSet.next()){
            result.add(rowMapper.mapRow(resultSet,rowNum ++));
        }
        return result;
    }


    private ResultSet executeQuery(PreparedStatement preparedStatement, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i,values[i]);
        }
        return preparedStatement.executeQuery();
    }

    private PreparedStatement createPrepareStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    private Connection getConnection() throws Exception{
        return this.dataSource.getConnection();
    }

}
