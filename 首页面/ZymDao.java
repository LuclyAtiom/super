package org.house.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.house.bean.House;
import org.house.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class ZymDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDS());

    public List<House> LookAll(String page, String city) throws SQLException {
        String sql = "";
        String address="%"+city+"%";
        System.out.println(page + "" + address);
        int a = Integer.valueOf(page);
        a = (a - 1) * 5;
        if (city.equals("全部")) {
            sql = "SELECT * FROM house LIMIT ? ,5";
            Object[] params = {a};
            List<House> list = qr.query(sql, new BeanListHandler<House>(House.class), params);
            return list;
        } else {
            List<House> list=null;
            if(city.contains("全部城区")){
                sql = "SELECT * FROM house LIMIT ? ,5";
                Object[] params = {a};
                list= qr.query(sql, new BeanListHandler<House>(House.class), params);
            }

            if(city.contains("区")){
                sql = "SELECT * FROM house WHERE address = ? LIMIT ? ,5";
                Object[] params = {city, a};
                 list= qr.query(sql, new BeanListHandler<House>(House.class), params);
            }if(city.contains("室")){
                sql = "SELECT * FROM house WHERE TYPE = ? LIMIT ? ,5";
                Object[] params = {city, a};
                list = qr.query(sql, new BeanListHandler<House>(House.class), params);
            }
            if (city.contains("万")) {
                String[] split = city.split("\\万");
                System.out.println("价格"+split[0]);
                String[] split1 = split[0].split("\\-");

                sql = "SELECT * FROM house WHERE money BETWEEN ? AND ? LIMIT ? ,5";
                Object[] params = {split1[0],split1[1], a};
                list = qr.query(sql, new BeanListHandler<House>(House.class), params);
            }
            return list;
        }
    }

//    public List<House> LookMoner(String page, String type) {
//    }
}
