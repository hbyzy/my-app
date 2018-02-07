package com.mycompany.app;
import java.sql.*;
public class MysqlTry {
    static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/school";
    static  final String USER="root";
    static final String PASS="yuhua1012";
    public static void main (String[] args){
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("database connecting...");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("sql operation");
            stmt=conn.createStatement();
            String sql,sqlins;
            sqlins="insert into students(id,name,sex,age,birthday,tel) values (45,'zong qiang','male',32,'05/09/2009','139456')";
            sql="select name,sex,age from students";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                int age=rs.getInt("age");
                String name=rs.getString("name");
                String sex=rs.getString("sex");
                System.out.print("name:"+name+"\t");
                System.out.print("age:"+age+"\t");
                System.out.println("sex:"+sex);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
