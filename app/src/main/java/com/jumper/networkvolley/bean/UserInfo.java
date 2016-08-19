package com.jumper.networkvolley.bean;

public class UserInfo {
    public int id;
    public String mobile;
    public String email;
    public String password;
    public String nick_name;
    public String user_img;
    public int province;
    public int checkstatus;//是否参与了某个医院体重管理（或血糖管理）   0:没有参加，可以修改   1：参加了，不可以修改  在修改资料中使用
    public String bindHospitalName;//参加体重管理（或血糖管理）的名字
    public int city;
    public int country;
    public String provice_name;
    public String country_name;
    public String city_name;
    public int switch_push_msg;
    public String expected_confinement;
    public String realname;
    public String identification;
    public int age;

    public String contactPhone;
    public String hospitalName;

    /**
     * //0 孕妇   1辣妈
     */
    public int currentIdentity;//0 孕妇   1辣妈
    public String baby_birthday;
    public String baby_sex;//0女   1男
    public String expected_week;//怀孕/宝宝  的周数
    public String expected_day;//怀孕/宝宝  的天数
    public String expected_days;// 好像没有用
    public String reg_time;
    /**
     * 绑定医院ID
     */
    public int hospitalId;//绑定医院ID

    public boolean firstLogin;

    public int gold;
    public int height;
    public float weight;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", user_img='" + user_img + '\'' +
                ", province=" + province +
                ", checkstatus=" + checkstatus +
                ", bindHospitalName='" + bindHospitalName + '\'' +
                ", city=" + city +
                ", country=" + country +
                ", provice_name='" + provice_name + '\'' +
                ", country_name='" + country_name + '\'' +
                ", city_name='" + city_name + '\'' +
                ", switch_push_msg=" + switch_push_msg +
                ", expected_confinement='" + expected_confinement + '\'' +
                ", realname='" + realname + '\'' +
                ", identification='" + identification + '\'' +
                ", age=" + age +
                ", contactPhone='" + contactPhone + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", currentIdentity=" + currentIdentity +
                ", baby_birthday='" + baby_birthday + '\'' +
                ", baby_sex='" + baby_sex + '\'' +
                ", expected_week='" + expected_week + '\'' +
                ", expected_day='" + expected_day + '\'' +
                ", expected_days='" + expected_days + '\'' +
                ", reg_time='" + reg_time + '\'' +
                ", hospitalId=" + hospitalId +
                ", firstLogin=" + firstLogin +
                ", gold=" + gold +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
