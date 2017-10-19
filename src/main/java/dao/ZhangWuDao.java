package dao;

import domain.ZhangWu;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 时下对数据类，数据的增删改查
 * DBUtils工具类完成
 */
public class ZhangWuDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getBasicDataSource());

    public void deleteZhangWu(Integer id) {
        String sql = "DELETE FROM gjp.gjp_zhangwu WHERE zwid=?";
        try {
            qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editeZhangWu(ZhangWu zhangWu) {
        String sql = "UPDATE gjp.gjp_zhangwu SET flname=?,money=?,zhangwu=?,createtime=?,description=? WHERE zwid=?";
        Object[] params = {zhangWu.getFlname(), zhangWu.getMoney(), zhangWu.getZhangwu(), zhangWu.getCreatetime(), zhangWu.getDescription(), zhangWu.getZwid()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int addZhangWu(ZhangWu zhangWu) {
        String sql = "INSERT INTO gjp.gjp_zhangwu(flname,money,zhangwu,createtime,description)VALUE(?,?,?,?,?)";
        Object[] params = {zhangWu.getFlname(), zhangWu.getMoney(), zhangWu.getZhangwu(), zhangWu.getCreatetime(), zhangWu.getDescription()};
        try {
            int row = qr.update(sql, params);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败");
        }
    }


    /**
     * 定义方法，带有日期条件来查询数据库
     * 方法，业务层调用
     * 结果集 将所有的账务数据放到beanList对象中
     */
    public List <ZhangWu> select(String startDate, String endDate) {
        try {
            String sql = "SELECT * FROM gjp.gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
            Object[] params = {startDate, endDate};
            List <ZhangWu> list = qr.query(sql, new BeanListHandler <ZhangWu>(ZhangWu.class), params);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 定义方法，查询数据库，回去所有的账务数据
     * 方法，业务层调用
     * 结果集 将所有的账务数据放到beanList对象中
     */
    public List <ZhangWu> selectAll() {
        try {
            String sql = "SELECT * FROM gjp.gjp_zhangwu";
            List <ZhangWu> list = qr.query(sql, new BeanListHandler <ZhangWu>(ZhangWu.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
