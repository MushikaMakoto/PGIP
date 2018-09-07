package Main;

import java.sql.Date;

/*
 * empid 社員番号
 * name 氏名
 * email メールアドレス
 * gender 性別
 * dept 部署
 * empdate 入社日付
 *
 * データベース名:test_database
 * test_databaseにあるカラムから
 * モデルクラスを作る。
 */

public class Data {
    protected int empid;
    protected String name;
    protected String email;
    protected int gender;
    protected String dept;
    protected Date empdate;

    public Data() {
    }

    public Data(int empid) {
        this.empid = empid;
    }

    public Data(int empid, String name, String email, int gender, String dept, Date empdate) {
        this(name, email, gender, dept, empdate);
        this.empid = empid;
    }

    public Data(String name, String email, int gender, String dept, Date empdate) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.dept = dept;
        this.empdate = empdate;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getDate() {
    	return empdate;
    }

    public void setDate(Date empdate) {
        this.empdate = empdate;
    }
}