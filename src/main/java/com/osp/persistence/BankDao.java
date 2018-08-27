package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.Bank;
import com.osp.model.Manual;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 26/10/2017.
 */
public class BankDao extends AbstractBean {
    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;

    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
    }

    public List<Bank> listBank() {
        return (List<Bank>) beanDaoUtil.list(Bank.class.getName());
    }

    public List<Bank> listOrderAndEnable(){
        Session session = beanHibernateUtil.getSession();
        List<Bank> list=null;
        try {
            Criteria criteria = session.createCriteria(Bank.class);
            criteria.add(Restrictions.eq("disable",false));
            criteria.addOrder(Order.desc("orderNumber"));
            list = criteria.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            beanHibernateUtil.closeSession(session);
        }
        return list;
    }

    public Bank getBank(int id) {
        return (Bank) beanDaoUtil.get(Bank.class, id);
    }

    public Bank getBankByBankId(String id){
        if(StringUtils.isBlank(id)){
            return null;
        }
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("id", id));
        List<Bank> list = (List<Bank>) beanDaoUtil.query(Bank.class, criterions);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public void pageBank(PagingResult page, String filterBankName,String filterBankCode) {
        Session session = beanHibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(Bank.class);

            if (StringUtils.isNotEmpty(filterBankName)) {
                criteria.add(Restrictions.like("name", "%" + filterBankName + "%"));
            }
            if(StringUtils.isNotEmpty(filterBankCode)){
                criteria.add(Restrictions.like("code","%"+filterBankCode+"%"));
            }
            beanDaoUtil.pageObject(page,criteria);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            beanHibernateUtil.closeSession(session);
        }
    }

}
