package com.lry.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author liurenyi
 * @create 2019--11--21--11:04
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    public static Session getSession(){
        //1.获取SessionFactiory 会话工厂
        sessionFactory=new Configuration().configure().buildSessionFactory();
        //2.生产会话  通过openSession获取session对象
        session=sessionFactory.openSession();
        //3.开启事务
        transaction = session.beginTransaction();
        return sessionFactory.openSession();
    }

    public static void closeSession(){
        transaction.commit();//关闭
        session.close();//关闭
        sessionFactory.close();//关闭
    }
    
}
