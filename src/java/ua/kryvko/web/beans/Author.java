/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.beans;

import java.sql.Date;

/**
 *
 * @author Artem Kryvko
 */
public class Author extends DBBean{
    
    private String fio;
    private Date birthday;

    public Author() {
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String name) {
        this.fio = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
    
}
