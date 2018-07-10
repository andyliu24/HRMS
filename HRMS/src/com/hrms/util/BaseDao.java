package com.hrms.util;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 *  用作数据的基础连接、关闭、查询和更新
 *  @author Andy Liu
 *  @time 2018-07-09 10:58
 */
public class BaseDao {

    //几个私有属性
    private String driver = ResourceBundle.getBundle("jdbc").getString("driver");
    private String url = ResourceBundle.getBundle("jdbc").getString("url");
    private String username = ResourceBundle.getBundle("jdbc").getString("username");
    private String password = ResourceBundle.getBundle("jdbc").getString("password");
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;


    //初始化同数据库的连接
    public Connection getConnection() {
        try {
            //加载数据库驱动
            Class.forName(driver);
            if (connection == null || connection.isClosed()) {
                //使用DriverManager进行数据库连接
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库类型驱动不能被找到，请联系技术支持。");
            System.out.println("详细信息：" + e.toString());
        } catch (SQLException e) {
            System.out.println("SQL连接出现问题，请检查用户名密码。");
            System.out.println("详细信息：" + e.toString());
        }
        return connection;
    }


    /**
     * 数据库关闭连接
     */
    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询结果的显示接口
     *
     * @param SQL_Statement SQL语句
     * @param parameters    参数集合
     * @return ResultSet
     * @author Andy Liu
     * @time 2018-07-09 14:30
     */
    public ResultSet executeQuery(String SQL_Statement, List<Object> parameters) {
        //获取连接，如果连接未建立成功则返回空指针
        if (getConnection() == null) {
            return null;
        }

        try {
            //创建prepareStatement对象
            preparedStatement = connection.prepareStatement(SQL_Statement);
            //判定是否有参数，若参数为空或者0则不进行参数处理。
            //如果没有查询条件，直接运行resultSet=preparedStatement.executeQuery();
            if (parameters != null && parameters.size() > 0) {
                //循环查询参数集合，因为不确定集合中的每个字段类型，所以采用.setObject()方法。
                for (int i = 0; i < parameters.size(); i++) {
                    preparedStatement.setObject(i + 1, parameters.get(i));
                }
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.err.println("SQL语句执行过程中出现问题！");
            System.err.println("详细信息：" + e.toString());
        } finally {
            //查询的时候不能关闭，否则会扔异常。
            //this.closeConnection();
        }
        return resultSet;
    }


    /**
    * 更新结果的显示接口
    * @author Andy Liu
    * @time 2018-07-09 14:30
    * @param SQL_Statement SQL语句
    * @param parameters 参数集合
    * @return ResultSet
    * */
    public int executeUpdate(String SQL_Statement, List<Object> parameters){
      int result=0;

      //获取连接，如果连接未建立成功则返回空指针
      if (getConnection()==null)
          return -1;

      try {
          //创建prepareStatement对象
          preparedStatement=connection.prepareStatement(SQL_Statement);
          //判定是否有参数，若参数为空或者0则不进行参数处理。
          //如果没有查询条件，直接运行resultSet=preparedStatement.executeQuery();
          if (parameters!=null && parameters.size()>0){
              //循环查询参数集合，因为不确定集合中的每个字段类型，所以采用.setObject()方法。
              for(int i=0; i<parameters.size(); i++){
                  preparedStatement.setObject(i+1,parameters.get(i));
              }
          }
          result=preparedStatement.executeUpdate();
      } catch (SQLException e) {
          System.err.println("SQL语句执行过程中出现问题！");
          System.err.println("详细信息："+e.toString());
      } finally {
          this.closeConnection();
      }
        return result;
    }

}
