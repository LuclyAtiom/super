package org.lanqiao.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lanqiao.bean.house;
import org.lanqiao.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class HouseDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDS());
    public int getTotalCount() throws SQLException {
        String sql = "select count(*) from house1";
        long totalCount =(long) qr.query(sql, new ScalarHandler<>());
        return (int)totalCount;
    }

    public List findHouseByCurrPage(int currPage, int pageSize) throws SQLException {
        String sql = "select * from house1 limit ? , ?";
        int begin = (currPage-1)*pageSize;//第几条记录开始（begin）
        Object[] params = {begin,pageSize};
        java.util.List<house> houses = qr.query(sql, new BeanListHandler<house>(house.class), params);
        return houses;
    }

    public house findAll(String address) throws SQLException {
        String sql = "SELECT * FROM house1 WHERE address=?";
        house house = qr.query(sql, new BeanHandler<house>(house.class));
        return house;
    }

    public List<house> LookAll() throws SQLException {
        String sql = "SELECT * FROM house1";
        List<house> query = qr.query(sql, new BeanListHandler<house>(house.class));
        return query;
    }
}
