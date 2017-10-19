package controller;

import domain.ZhangWu;
import service.ZhangWuService;

import java.util.List;

/**
 * 控制器层
 * 接收是视图层的数据，数据传递给service
 * 成员位置创建service对象
 */
public class ZhangWuController {
    private ZhangWuService zhangWuService = new ZhangWuService();

    public void deleteZhangWu(Integer id) {
        zhangWuService.deleteZhangWu(id);
    }

    public void editeZhangWu(ZhangWu zhangWu) {
        zhangWuService.editeZhangWu(zhangWu);
    }

    /**
     * 添加方法
     * 注意传递过来是一个对象。
     */
    public int addZhangWu(ZhangWu zhangWu) {
        return zhangWuService.addZhangWu(zhangWu);
    }


    /**
     * 定义方法实现条件查新
     * 传递两个日期的字符串
     * 调用service方法
     *
     * @return
     */
    public List <ZhangWu> select(String startDate, String endDate) {
        return zhangWuService.select(startDate, endDate);
    }


    /**
     * 定义方法 实现全部查询
     * 传递两个日期的字符串
     * 调用service方法
     *
     * @return
     */
    public List <ZhangWu> selectAll() {
        return zhangWuService.selectAll();
    }


    public void addZhangWu() {
    }
}

