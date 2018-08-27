package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.ContractHistory;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by minh on 10/24/2017.
 */
public class ContractHistoryDao extends AbstractBean {
    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;

    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
//        encoder=new BCryptPasswordEncoder();
    }
    public List<ContractHistory> listContractHistory() {
        return (List<ContractHistory>) beanDaoUtil.list(ContractHistory.class.getName());
    }
    public ContractHistory getContractHistory(int id) {
        return (ContractHistory) beanDaoUtil.get(ContractHistory.class, id);
    }
    public void pageContractHistory(PagingResult page, String filterContractHistory) {
        Session session = beanHibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(ContractHistory.class);

            if (StringUtils.isNotEmpty(filterContractHistory)) {
                criteria.add(Restrictions.like("contractContent", "%" + filterContractHistory + "%"));
            }
            beanDaoUtil.pageObject(page,criteria);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            beanHibernateUtil.closeSession(session);
        }
    }

}
