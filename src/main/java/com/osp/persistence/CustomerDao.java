package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;

/**
 * Created by tieut on 9/30/2017.
 */
public class CustomerDao extends AbstractBean {
    private DaoUtil beanDaoUtil;
    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
    }


}
