/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.beanlists;


import java.util.ArrayList;
import java.util.List;
import ua.kryvko.web.beans.DBBean;


/**
 *
 * @author Artem Kryvko
 */
public abstract class BeanListImpl<T extends DBBean> implements BeanList<T>{
    
    public final static String QUERY = "SELECT * FROM ";
    protected final List<T> beanList;

    public BeanListImpl() {
        this.beanList = new ArrayList<>();
    }
    
    abstract void getData();

    @Override
    public List<T> getBeanList() {
        if(beanList.isEmpty()) {
            getData();
        }
        return beanList;
    }
    
}
