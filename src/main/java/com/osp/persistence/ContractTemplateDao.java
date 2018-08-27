package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.Contract;
import com.osp.model.ContractKind;
import com.osp.model.ContractTemplate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 10/27/2017.
 */
public class ContractTemplateDao extends AbstractBean {
    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;

    private static Log log = LogFactory.getLog(ContractKindDao.class);

    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
    }

    public List<ContractTemplate> list() {
        return (List<ContractTemplate>) beanDaoUtil.list(ContractTemplate.class.getName());
    }

    public ContractTemplate getContractTemplate(String id) {
        return (ContractTemplate) beanDaoUtil.get(ContractTemplate.class, id);
    }

    public List<ContractTemplate> listEnable(){
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("disable", false));
        criterions.add(Restrictions.eq("deleted", false));
        List<ContractTemplate> lst = (List<ContractTemplate>) beanDaoUtil.query(ContractTemplate.class, criterions);
        return lst;
    }

    public List<ContractTemplate> listEnableByKindId(String kindId){
        if(StringUtils.isBlank(kindId)) return null;
        ContractKindDao beanContractKindDao=(ContractKindDao)this.getBean("beanContractKindDao");
        List<Criterion> criterions = new ArrayList<Criterion>();
        ContractKind item= beanContractKindDao.getContractKind(kindId);
        if(item==null) return null;
        criterions.add(Restrictions.eq("contractKind", item));
        criterions.add(Restrictions.eq("disable", false));
        criterions.add(Restrictions.eq("deleted", false));
        List<ContractTemplate> lst = (List<ContractTemplate>) beanDaoUtil.query(ContractTemplate.class, criterions);
        return lst;
    }
}
