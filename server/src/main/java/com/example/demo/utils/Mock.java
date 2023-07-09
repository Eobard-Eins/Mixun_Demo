package com.example.demo.utils;

import java.util.Random;

public class Mock {

    public static Random r = new Random();

    public static final String[] department = {"研发部", "生产部", "财务部", "人事部", "计划部", "营销部", "安全部", "监察部", "后勤部", "保卫部"};

    public static String randomDepartment() {
        return department[r.nextInt(department.length)];
    }

    public static final String[] role = {"研发部长", "生产部长", "财务部长", "人事部长", "计划部长", "营销部长", "安全部长", "监察部长", "后勤部长", "保卫部长"};

    public static String randomRole() {
        return role[r.nextInt(role.length)];
    }

    public static int randomInt() {
        return r.nextInt(100) + 1;
    }

    public static final String[] address = {"学院路588号", "江苏路603号", "文化路561号", "劳动路284号", "祝秦路512号", "宋城路763号", "宝庆中路125号", "天山南路833号", "星火路752号", "天山西路144号"};

    public static String randomAddress() {
        return address[r.nextInt(address.length)];
    }


    public static String[] firstname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈"};

    public static String[] lastname = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};

    public static String randomFirstName() {return firstname[r.nextInt(firstname.length)];}

    public static String randomLastName() {return lastname[r.nextInt(lastname.length)];}

    public static String randomName() {return firstname[r.nextInt(firstname.length)]+lastname[r.nextInt(lastname.length)];}

    public static String[] emailId = {"guangjia@mail.com","guanfawe@mail.com","egfaerg@mail.com","agvseg@mail.com","agaerar@mail.com","vdfbsb@mail.com","gsfdb@mail.com","ggbng@mail.com","gugsea@mail.com"};

    public static String randomEmailId() {return emailId[r.nextInt(emailId.length)];}

    public static String[] phone = {"18204057394","18081743869", "13556953378", "15673397046", "18991013143", "18965252026", "17535896457", "17801907106", "18564109403", "18322374862"};

    public static String randomPhone() {return phone[r.nextInt(phone.length)];}

    public static String[] product = {"西瓜","牛奶", "大楼", "软件", "黄金", "白银", "钻石", "硬件", "软件", "跑路"};

    public static String randomProduct() {return product[r.nextInt(product.length)];}
}
