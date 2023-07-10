package com.example.demo.apis.employee.model;


import lombok.*;

import jakarta.persistence.*;

@Getter//这两个注解用于生成 setter 和 getter 方法，可以用在类或者属性上：
@Setter//如果用在属性上：则只为该属性提供 setter 和 getter 方法.如果是用在类上：则为这个类所有属性供 setter 和 getter方法
@NoArgsConstructor//注解在类上，为类提供一个无参的构造方法
@AllArgsConstructor//注解在类上，为类提供一个全参的构造方法
@Data//@Data 是一个复合注解，用在类上，使用后会生成：默认的无参构造函数、所有属性的 getter、所有非 final 属性的 setter 方法，并重写 toString、equals、hashcode 方法
@Entity//⽤于定义对象将会成为被 JPA 管理的实体，必填，将字段映射到指定的数据库表中
@Table(name = "employees")//⽤于指定数据库的表名，表示此实体对应的数据库⾥⾯的表名，⾮必填，默认表名和 entity 名字⼀样。
public class Employee {

    @Id//定义属性为数据库的主键，⼀个实体⾥⾯必须有⼀个主键，但不⼀定是这个注解，可以和 @GeneratedValue 配合使⽤或成对出现
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键⽣成策略,其中，GenerationType ⼀共有以下四个值：
    /*
      public enum GenerationType {
          // 通过表产⽣主键，框架借由表模拟序列产⽣主键，使⽤该策略可以使应⽤更易于数据库移植。
          TABLE,
          // 通过序列产⽣主键，通过 @SequenceGenerator 注解指定序列名， MySql 不⽀持这种⽅式；
          SEQUENCE,
          // 采⽤数据库ID⾃增⻓， ⼀般⽤于mysql数据库
          IDENTITY,
          // JPA ⾃动选择合适的策略，是默认选项；
          AUTO
      }
     */
    private long id;

    @Column(name = "employee_name")//定义该属性对应数据库中的列名
    private  String employeeName;
    @Column(name="employee_phone")
    private String employeePhone;
    @Column(name="employee_department")
    private String employeeDepartment;
    @Column(name="employee_position")
    private String employeePosition;


}
