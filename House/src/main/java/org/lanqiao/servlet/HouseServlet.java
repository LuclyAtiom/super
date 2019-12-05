package org.lanqiao.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.lanqiao.bean.HouseBean;
import org.lanqiao.bean.house;
import org.lanqiao.service.HouseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/House.do")
public class HouseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            System.out.println(111);
            resp.setContentType("text/html;charset=utf-8");
            resp.setCharacterEncoding("utf-8");

            int currPage = Integer.parseInt(req.getParameter("currPage"));
            int pageSize = Integer.parseInt(req.getParameter("pageSize"));
            HouseService service = new HouseService();
            //查询滑动条数
            HouseBean houseBean = service.HouseByCurrPage(currPage,pageSize);
            ObjectMapper  mapper = new ObjectMapper();
            String response = mapper.writeValueAsString(houseBean);

            //查询总房源
            List<house> list=service.LookAll();
            resp.getWriter().write(response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
