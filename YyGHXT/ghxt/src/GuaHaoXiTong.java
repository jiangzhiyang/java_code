import java.util.ArrayList;
import java.util.Scanner;

public class GuaHaoXiTong {
        private ArrayList<Deparment> deparments = new ArrayList<>();
        private ArrayList<YuYue> yuYues = new ArrayList<>();
        private Scanner sc = new Scanner(System.in);
        public void start() {
            while (true) {
                System.out.println("========欢迎进入医院管理系统========");
                System.out.println("1、科室管理-科室增加");
                System.out.println("2、科室管理-科室删除");
                System.out.println("3、科室管理-科室修改");
                System.out.println("4、医生管理-医生录入");
                System.out.println("5、医生管理-医生坐诊设置");
                System.out.println("6、医生管理-全部医生坐诊详情");
                System.out.println("7、医生管理-挂号预约");
                System.out.println("8、搜索医生预约详情及预约患者详情");
                System.out.println("9、安全退出");
                System.out.println("================================");
                System.out.println("请选择您要进行的操作:");
                switch (sc.next()) {
                    case "1":
                        addDeparment();
                        break;
                    case "2":
                        killDeparment();
                        break;
                    case "3":
                        setDeparment();
                        break;
                    case "4":
                        addDocter();
                        break;
                    case "5":
                        break;
                    case "6":
                        break;
                    case "7":
                        break;
                    case "8":
                        break;
                    case "9":
                        return;

                }
            }
        }

    //医生录入
    private void addDocter() {
        System.out.println("======医生录入======");
        everydeparment();
        System.out.println("请输入医生科室:");
        String name = sc.next();

    }


    //修改科室名
    private void setDeparment() {
        System.out.println("======修改科室======");
        if (deparments.size() == 0){
            System.out.println("当前科室为空！！！");
            System.out.println("-----------------");
            return;
        }
        while (true){
            everydeparment();
            System.out.println("请输入您要修改的科室名:");
            String name = sc.next();
            if (name == null){
                System.out.println("您输入的科室不存在或有误！是否重新输入？y/n");
                String a = sc.next();
                switch (a){
                    case "y":
                        break;
                    case "n":
                        return;
                    default:
                        System.out.println("无效选择，程序退出!");
                        return;
                }
                continue;
            }
            System.out.println("请输入修改后的名称:");
            String name1 = sc.next();
            if (chazhao(name1) != null) {
                System.out.println("该科室名已存在，请重新输入!");
                continue;
            }
            chazhao(name).setName(name1);
            System.out.println("修改成功!");
            System.out.println("-----------------");

        }
    }

    //打印当前所有科室名
    private void everydeparment(){
        if (deparments.size() == 0){
            System.out.println("-----------------");
            System.out.println("当前科室为空！！！");
            System.out.println("-----------------");
            return;
        }
        System.out.println("-----------------");
        System.out.println("当前科室信息如下:"+deparments.size());
        for (int i = 0; i < deparments.size(); i++) {
            System.out.println(i+1+"、"+deparments.get(i).getName());
        }
        System.out.println("-----------------");
    }

    //删除科室
    private void killDeparment() {
        System.out.println("======科室删除======");
        if (deparments.size() == 0){
            System.out.println("当前科室为空！！！");
            System.out.println("-----------------");
            return;
        }
        while (true) {
            everydeparment();
            System.out.println("请输入您要删除的科室名:");
            String name = sc.next();
            if (chazhao(name) == null){
                System.out.println("您输入的科室不存在或有误！是否重新输入？y/n");
                String a = sc.next();
                switch (a){
                    case "y":
                        break;
                    case "n":
                        return;
                    default:
                        System.out.println("无效选择，程序退出!");
                        return;
                }
            }else {
                deparments.remove(chazhao(name));
                System.out.println("删除成功！");
                System.out.println("-----------------");
                return;
            }
        }

    }

    //新增科室
    private void addDeparment() {
        System.out.println("======科室增加======");
        while (true) {
            System.out.println("请输入新增科室名称:");
            String name = sc.next();
            if (chazhao(name) != null){
                System.out.println("您输入的科室已存在！是否重新输入？y/n");
                String a = sc.next();
                switch (a){
                    case "y":
                        break;
                    case "n":
                        return;
                    default:
                        System.out.println("无效选择，程序退出!");
                        return;
                }
                continue;
            }
            Deparment deparment = new Deparment();
            deparment.setName(name);
            deparments.add(deparment);
            System.out.println("添加成功！");
            System.out.println("---------------------");
            break;
        }


    }

    //根据科室名查找科室
    private Deparment chazhao(String deparmentName) {
      for (Deparment deparment : deparments) {    //遍历科室集合
         if (deparment.getName().equals(deparmentName)) {
               return deparment;
         }
      }
      return null;
    }


}
