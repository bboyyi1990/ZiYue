package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyClass {

    public static void main(String[] args) {
        // 创建Schema对象
        // 构造方法第一个参数为数据库版本号
        // 第二个参数为自动生成的实体类将要存放的位置,前面为我的Android Module的包名
        Schema schema = new Schema(1000, "com.yi.ziyue.beans.greendao");
        // 添加需要创建的实体类信息
        addNote(schema);
        try {
            // 创建实体类.第二个参数填Android Module的路径
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addNote(Schema schema) {
        // 指定需要生成实体类的类名,类名确定了那么表名也是根据这个类名来自动命名的,例如下面这个,生成的表名叫做person_entity
        Entity entity = schema.addEntity("Student");
        // 指定自增长主键
        entity.addIdProperty().autoincrement().primaryKey();
        // 添加类的属性,根据属性生成数据库表中的字段
        entity.addStringProperty("title");
        entity.addStringProperty("content");



    }
}
