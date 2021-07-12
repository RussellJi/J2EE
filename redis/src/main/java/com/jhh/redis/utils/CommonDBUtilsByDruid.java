package com.jhh.redis.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
* 通过CommonDButils获取连接、关闭连接，通过Druid连接池进行连接复用
* */
public class CommonDBUtilsByDruid {
    static DataSource ds;
    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("F:\\Vscode\\JavaProject\\J2EE\\login\\src\\main\\webapp\\WEB-INF\\Druid.properties"));
//            props.load(new FileInputStream("\\WEB-INF\\Druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        try {

            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet set, Statement stmt, Connection conn){
            try {
                if (set != null){
                    set.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
}
