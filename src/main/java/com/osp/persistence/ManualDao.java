package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.Manual;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 17/10/2017.
 */
public class ManualDao extends AbstractBean {
    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;

    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
//        encoder=new BCryptPasswordEncoder();
    }

    public List<Manual> listManual() {
        return (List<Manual>) beanDaoUtil.list(Manual.class.getName());
    }

    public Manual getManual(int id) {
        return (Manual) beanDaoUtil.get(Manual.class, id);
    }
    public Manual deleteManual( Manual item) throws Exception{
        return (Manual) beanDaoUtil.delete(item);
    }

    public Manual getManualByManualname(String name){
        if(StringUtils.isBlank(name)){
            return null;
        }
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("username", name));
        List<Manual> list = (List<Manual>) beanDaoUtil.query(Manual.class, criterions);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public Manual add(Manual item) throws Exception{
        /*if(getUserByUsername(item.getUsername())!=null || StringUtils.isBlank(item.getPassword())){
            return null;
        }*/
//        item.setPassword(encoder.encode(item.getPassword()));
        Manual manual=(Manual)beanDaoUtil.add(item);
        return manual;
    }



    public Manual edit(Manual item) throws Exception{
        Manual updateObject=(Manual)beanDaoUtil.edit(item);
        return updateObject;
    }

    public void pageManual(PagingResult page, String filterManualName) {
        Session session = beanHibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(Manual.class);

            if (StringUtils.isNotEmpty(filterManualName)) {
                criteria.add(Restrictions.like("title", "%" + filterManualName + "%"));
            }
            // record count
           beanDaoUtil.pageObject(page,criteria);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            beanHibernateUtil.closeSession(session);
        }
    }
}
