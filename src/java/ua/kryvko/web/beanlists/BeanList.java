/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.kryvko.web.beanlists;

import java.util.List;
import ua.kryvko.web.beans.DBBean;

/**
 *
 * @author Artem Kryvko
 */
public interface BeanList<T extends DBBean> {
    List<T> getBeanList();
}