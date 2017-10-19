package service;

import dao.ZhangWuDao;
import domain.ZhangWu;

import java.util.List;

/**
 * 业务层
 * 接收controller的数据
 * 经过计算，传递给dao，操作数据库
 * 调用dao层的类，类成员位置，创建dao成员对象
 */
public class ZhangWuService {
    private ZhangWuDao zhangWuDao = new ZhangWuDao();


    public void deleteZhangWu(Integer id){
        zhangWuDao.deleteZhangWu(id);
    }

    public void editeZhangWu(ZhangWu zhangWu){
        zhangWuDao.editeZhangWu(zhangWu);
    }

    public int addZhangWu(ZhangWu zhangWu){
        return zhangWuDao.addZhangWu(zhangWu);
    }


    /**
     * 定义方法，实现自定义查询日期的
     * 传递两个日期
     * @return
     */
    public List <ZhangWu> select(String startDate,String endDate) {
        return zhangWuDao.select(startDate,endDate);
    }


    /**
     * 定义方法，全部查询
     * @return
     */
    public List <ZhangWu> selectAll() {
        return zhangWuDao.selectAll();
    }

}
