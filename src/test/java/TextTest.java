import com.lry.po.Emp;
import com.sun.xml.internal.txw2.TXW;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.List;

public class TextTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    //开始
    @org.junit.Before
    public void Before(){
        //1.获取SessionFactiory 会话工厂
        sessionFactory=new Configuration().configure().buildSessionFactory();
        //2.生产会话  通过openSession获取session对象
        session=sessionFactory.openSession();
        //3.开启事务
        transaction = session.beginTransaction();
    }

    @org.junit.Test
    public void textgetSelect() {
        //执行查询 get(要查询的实体类-类型,参数)
        //执行查询(查询单条数据)
        Emp emp1 = session.get(Emp.class, 1);
        System.out.println(emp1);
    }

    @org.junit.Test
    public void textloadSelect() {
        //执行查询(查询单条数据)
        Emp emp2 = session.load(Emp.class, 1);
        System.out.println(emp2);
    }

    @org.junit.Test
    public void textcreateQuerySelect() {
        //执行查询(查询单条数据)
        Query query = session.createQuery("from Emp where id=?");//实体类的名字
        query.setParameter(0,2); //占位符的形式 id=?
        //Query query = session.createQuery("from Emp where id:ids");
        //query.setParameter("ids",4); //自定义占位符
        Object o = query.uniqueResult(); //只针对于只有一条语句时才能使用
        System.out.println(o);
    }

    @org.junit.Test
    public void textcreateQuerySelectAll() {
        //查询全部         Emp实体类的名字 也可以写com.lry.po.Emp
        Query from_emp = session.createQuery("from Emp");
        List list = from_emp.list();
        for (Object o1 : list) {
            System.out.println(o1);
        }
    }

    @org.junit.Test
    public void textcreateSQLQuerySelectAll() {
        //查询全部
        SQLQuery sqlQuery=session.createSQLQuery("select * from Emp");
        List list1 = sqlQuery.list();
        for (Object o1 : list1) {
            System.out.println(o1);
        }
    }

    //增加
    @org.junit.Test
    public void textinsert() {
        Emp emp=new Emp(110,"我",12,1000,"开发");
        Serializable save = session.save(emp);
        System.out.println(save);
    }

    //删除
    @org.junit.Test
    public void textdelete() {
        //Hibernaye中的删除 是先查询是否存在对象然后删除
        Emp emp=session.get(Emp.class,11);
       if(emp!=null){
           session.delete(emp);
       }
    }

    //修改
    @org.junit.Test
    public void textupdate() {
       Emp emp=new Emp();
       emp.setId(10);
       emp.setGid(133);
       emp.setName("炸弹");
       emp.setAge(1);
       emp.setQian(1000);
       emp.setBumen("运维");
       session.saveOrUpdate(emp);
       //saveOrUpdate方法 可以实现增加或者修改
        //不管执行那个都会先查询 如果查询不到的话就是新增 查询到了就是修改
    }

    //结束
    @org.junit.After
    public void After(){
        transaction.commit();//关闭
        session.close();//关闭
        sessionFactory.close();//关闭
    }

}