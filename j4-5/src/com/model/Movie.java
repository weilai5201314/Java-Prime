package com.model;

// 定义一个 Movie 的公开类
public class Movie {
    // 该类具有电影名称、电影类别、电影时长、地区等属性（都是字符串类型、私有）
    private String name, model, time, area;

    // 定义获取和设置电影属性的方法
    public void set(String name, String model, String time, String area) {
        this.name = name;
        this.model = model;
        this.time = time;
        this.area = area;
    }

    // 定义获取电影信息的方法，无返回值
    public void display()
    {
        System.out.printf("电影名称：%s，电影类别：%s，电影时长：%s，地区：%s。",name,model,time,area);
    }
}


