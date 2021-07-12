package com.jhh.userManager.dao;

import com.jhh.userManager.utils.CommonDBUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * BasicDao，完成增删改查的封装
 * update()
 * queryMulti()
 * querySingle()
 * queryScalar()
 *
 */
class BasicDao<T>{
    // 初始化属性QueryRunner
    private QueryRunner qr = new QueryRunner();

    // why update不更新到java类中：查询结果的时候会保存到java类中
    public int update(String sql,Object... params){
        // 获得连接
        Connection conn = null;
        conn = CommonDBUtilsByDruid.getConnection();
        // 执行update语句
        try{
            // 返回受影响的行数
            return qr.update(conn,sql,params);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            CommonDBUtilsByDruid.close(null, null, conn);
        }
    }

    /**
     *
     * @param sql  sql语句，可以有?
     * @param clazz 传一个Class对象，如User.class
     * @param params 给？赋值
     * @return 根据User.class返回对应类型的集合
     */
    public List<T> queryMulti(String sql,Class<T> clazz,Object...params){
        // 获得连接
        Connection conn = null;
        conn = CommonDBUtilsByDruid.getConnection();
        // 执行update语句
        try{
            List<T> list = qr.query(conn, sql, new BeanListHandler<>(clazz),params);
            // 返回集合
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            CommonDBUtilsByDruid.close(null, null, conn);
        }
    }
    // 查询单行
    public T querySingle(String sql,Class<T> clazz,Object...params){
        // 获得连接
        Connection conn = null;
        conn = CommonDBUtilsByDruid.getConnection();
        // 执行update语句
        try{
            T object = qr.query(conn,sql, new BeanHandler<>(clazz),params);
            // 返回对象
            return object;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            CommonDBUtilsByDruid.close(null, null, conn);
        }
    }

    // 查询单行单列的方法，返回单值
    public Object queryScalar(String sql,Class<T> clazz,Object...params){
        // 获得连接
        Connection conn = null;
        conn = CommonDBUtilsByDruid.getConnection();
        // 执行update语句
        try{
            Object object = qr.query(conn, sql, new ScalarHandler(), params);
            // 返回对象
            return object;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            CommonDBUtilsByDruid.close(null, null, conn);
        }
    }

}