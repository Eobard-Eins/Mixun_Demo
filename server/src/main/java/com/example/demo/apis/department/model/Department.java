package com.example.demo.apis.department.model;
import lombok.*;

import jakarta.persistence.*;
@Getter//这两个注解用于生成 setter 和 getter 方法，可以用在类或者属性上：
@Setter//如果用在属性上：则只为该属性提供 setter 和 getter 方法.如果是用在类上：则为这个类所有属性供 setter 和 getter方法
@NoArgsConstructor//注解在类上，为类提供一个无参的构造方法
@AllArgsConstructor//注解在类上，为类提供一个全参的构造方法
@Data//@Data 是一个复合注解，用在类上，使用后会生成：默认的无参构造函数、所有属性的 getter、所有非 final 属性的 setter 方法，并重写 toString、equals、hashcode 方法
@Entity//⽤于定义对象将会成为被 JPA 管理的实体，必填，将字段映射到指定的数据库表中
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="department_name")
    private String departmentName;

    @Column(name="department_num")
    private int departmentNum;
    @Column(name="department_manger_name")
    private String departmentMangerName;
    @Column(name="department_manger_id")
    private long departmentMangerId;
    @Column(name="department_description")
    private String departmentDescription;


}
