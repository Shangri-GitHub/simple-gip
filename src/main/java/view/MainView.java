package view;

import controller.ZhangWuController;
import domain.ZhangWu;

import java.util.List;
import java.util.Scanner;

/**
 * 视图层，用户看到的页面
 * 成员位置，创建controller对象
 */
public class MainView {
    ZhangWuController zhangWuController = new ZhangWuController();

    public void run() {
        // 创建Scanner 对象，键盘反复输入
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        while (flag) {
            System.out.println("-----管家婆家庭记账软件--------");
            System.out.println("1、添加账务  2、编辑账务 3、删除账务 4、查询账务 5、退出系统");
            System.out.println("请输入要查询的序号?");
            // 接收用户的菜单选项

            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addZhangWu();
                    break;
                case 2:
                    editeZhangwu();
                    break;
                case 3:
                    deleteZhangwu();
                    break;
                case 4:
                    selectZhangWu();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }

    private void deleteZhangwu() {
        selectAll();
        System.out.println("选择删除的账务id");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入ID:");
        int id = sc.nextInt();
        zhangWuController.deleteZhangWu(id);
        System.out.println("删除成功");
    }

    private void editeZhangwu() {
        // 调用所有数据，进行修改
        selectAll();
        System.out.println("选择需要修改的数据");

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入ID:");
        int zwid = sc.nextInt();
        System.out.print("请输入分类名称:");
        String flname = sc.next();
        System.out.print("请输入金额:");
        Double money = sc.nextDouble();
        System.out.print("请输入账户:");
        String zhanghu = sc.next();
        System.out.print("请输入日期:");
        String createTime = sc.next();
        System.out.print("请输入描述:");
        String description = sc.next();

        //将用户输入的所有数据，封装到账务的对象中,id必须封装到id里。
        ZhangWu zhangWu = new ZhangWu(zwid, flname, money, zhanghu, createTime, description);

        zhangWuController.editeZhangWu(zhangWu);
        System.out.println("修改成功");

    }

    private void addZhangWu() {
        System.out.println("------添加账务功能-------");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入分类名称");
        String flname = sc.next();
        System.out.print("请输入金额");
        Double money = sc.nextDouble();
        System.out.print("请输入账户");
        String zhanghu = sc.next();
        System.out.print("请输入日期");
        String createTime = sc.next();
        System.out.print("请输入描述");
        String description = sc.next();
        // 接收到的数据传到controller方法中
        ZhangWu zhangWu = new ZhangWu(0, flname, money, zhanghu, createTime, description);
        int row = zhangWuController.addZhangWu(zhangWu);
        if (row > 0) {
            System.out.println("恭喜你，添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    public void selectZhangWu() {
        System.out.println("1、全部查询  2、条件查询");
        // 创建Scanner 对象，键盘反复输入
        Scanner scanner = new Scanner(System.in);
        int selectNum = scanner.nextInt();
        if (selectNum == 1) {
            selectAll();
        } else if (selectNum == 2) {
            select();
        }

    }

    private void selectAll() {
        // 控制层的方法，查询所有的账务信息
        List <ZhangWu> list = zhangWuController.selectAll();

        if (list.size() != 0) {
            print(list);
        } else {
            System.out.println("没有查询到数据");
        }

    }

    private void select() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入开始日期：");
        String startDate = sc.nextLine();
        System.out.print("请输入结束日期：");
        String endDate = sc.nextLine();
        //调用controller的方法
        List <ZhangWu> list = zhangWuController.select(startDate, endDate);
        if (list.size() != 0) {
            print(list);
        } else {
            System.out.println("没有查询到数据");
        }


    }

    private void print(List <ZhangWu> list) {
        // 输出表头
        System.out.println("ID\t 类别\t 账户\t 时间\t 描述\t");
        // 遍历结果
        for (ZhangWu zw : list) {
            System.out.println(zw.getZwid() + "\t" + zw.getZhangwu() + "\t" + zw.getFlname() + "\t" + zw.getCreatetime() + "\t" + zw.getDescription());
        }
    }


}
