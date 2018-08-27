package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.ContractKind;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 10/27/2017.
 */
public class ContractKindDao extends AbstractBean {

    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;

    private static Log log = LogFactory.getLog(ContractKindDao.class);

    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
    }

    public List<ContractKind> list() {
        return (List<ContractKind>) beanDaoUtil.list(ContractKind.class.getName());
    }

    public ContractKind getContractKind(String id) {
        return (ContractKind) beanDaoUtil.get(ContractKind.class, id);
    }

    public List<ContractKind> listEnable(){
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("disable", false));
        criterions.add(Restrictions.eq("deleted", false));
        List<ContractKind> lst = (List<ContractKind>) beanDaoUtil.query(ContractKind.class, criterions);
        return lst;
    }

}
