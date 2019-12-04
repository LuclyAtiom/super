package org.lanqiao.service;


import org.lanqiao.bean.HouseBean;
import org.lanqiao.bean.house;
import org.lanqiao.dao.HouseDao;

import java.sql.SQLException;
import java.util.List;

public class HouseService {
    HouseDao dao = new HouseDao();
    public HouseBean HouseByCurrPage(int currPage, int pageSize) throws SQLException {
        int totalCount = dao.getTotalCount();

        List<house> list = dao.findHouseByCurrPage(currPage,pageSize);
        HouseBean houseBean = new HouseBean();
        houseBean.setTotalCount(totalCount);
        houseBean.setData(list);
        return houseBean;
    }

    public house findAll(String address) throws SQLException {
        house house = dao.findAll(address);
        return house;

    }

    public List<house> LookAll() throws SQLException {
        return dao.LookAll();
    }
}
