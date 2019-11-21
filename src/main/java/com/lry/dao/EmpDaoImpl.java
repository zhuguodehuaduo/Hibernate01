package com.lry.dao;

import com.lry.po.Emp;
import com.lry.util.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--11--21--11:01
 */
public class EmpDaoImpl implements EmpDao {

    public List<Emp> selectAll() {
        //1.获取Session
        Session session = HibernateUtils.getSession();
        //2.创建hql语句
        String hql="from com.lry.po.Emp";
        //3.创建query
        Query query = session.createQuery(hql);
        //4.进行查询
        List<Emp> list = query.list();
        for (Object o : list) {
            System.out.println(o);
        }
        //5.关闭
        HibernateUtils.closeSession();
        return list;
    }
}
