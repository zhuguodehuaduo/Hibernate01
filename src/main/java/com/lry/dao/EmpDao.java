package com.lry.dao;

import com.lry.po.Emp;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--11--21--11:00
 */
public interface EmpDao {
    List<Emp> selectAll();
}
