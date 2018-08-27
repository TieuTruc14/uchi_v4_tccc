package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.Contract;
import com.osp.model.ContractNumber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by tieut on 10/27/2017.
 */
public class ContractDao extends AbstractBean {
    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;

    private static Log log = LogFactory.getLog(ContractKindDao.class);

    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
    }

    public List<Contract> list() {
        return (List<Contract>) beanDaoUtil.list(Contract.class.getName());
    }

    public Contract getContract(Integer id) {
        return (Contract) beanDaoUtil.get(Contract.class, id);
    }

    /*CONTRACT NUMBER*/
    public ContractNumber getContractNumber(String id) {
        return (ContractNumber) beanDaoUtil.get(ContractNumber.class, id);
    }
    public ContractNumber addContractNumber(ContractNumber item) throws Exception {
        if(getContractNumber(item.getId())!=null) return null;
        ContractNumber itemAdd=(ContractNumber)beanDaoUtil.add(item);
        return itemAdd;
    }

}
