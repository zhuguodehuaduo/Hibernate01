package com.lry.po;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author liurenyi
 * @create 2019--11--20--10:03
 */
@Entity
public class Emp {
    private int id;
    private int gid;
    private String name;
    private int age;
    private double qian;
    private String bumen;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "gid")
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "qian")
    public double getQian() {
        return qian;
    }

    public void setQian(double qian) {
        this.qian = qian;
    }

    @Basic
    @Column(name = "bumen")
    public String getBumen() {
        return bumen;
    }

    public void setBumen(String bumen) {
        this.bumen = bumen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Emp emp = (Emp) o;

        if (id != emp.id) {
            return false;
        }
        if (gid != emp.gid) {
            return false;
        }
        if (age != emp.age) {
            return false;
        }
        if (Double.compare(emp.qian, qian) != 0) {
            return false;
        }
        if (name != null ? !name.equals(emp.name) : emp.name != null) {
            return false;
        }
        return bumen != null ? bumen.equals(emp.bumen) : emp.bumen == null;
          }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + gid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        temp = Double.doubleToLongBits(qian);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (bumen != null ? bumen.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", gid=" + gid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", qian=" + qian +
                ", bumen='" + bumen + '\'' +
                '}';
    }

    public Emp(int gid, String name, int age, double qian, String bumen) {
        this.gid = gid;
        this.name = name;
        this.age = age;
        this.qian = qian;
        this.bumen = bumen;
    }

    public Emp(int id, int gid, String name, int age, double qian, String bumen) {
        this.id = id;
        this.gid = gid;
        this.name = name;
        this.age = age;
        this.qian = qian;
        this.bumen = bumen;
    }

    public Emp() {

    }
}
