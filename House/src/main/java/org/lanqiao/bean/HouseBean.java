package org.lanqiao.bean;

import java.util.List;

public class HouseBean {
    private int totalCount;//总记录数
    private List<house> data;//查询到的数据

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<house> getData() {
        return data;
    }

    public void setData(List<house> data) {
        this.data = data;
    }
}
