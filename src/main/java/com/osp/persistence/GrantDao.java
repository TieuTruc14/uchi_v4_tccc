package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.*;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieut on 10/19/2017.
 */
public class GrantDao extends AbstractBean {
    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;
    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
    }
    public Group getGroup(String id) {
        return (Group) beanDaoUtil.get(Group.class, id);
    }

    public Group addGroup(Group item) throws Exception{
        if(getGroup(item.getId())!=null){
            return null;
        }
        Group group=(Group)beanDaoUtil.add(item);
        return group;
    }
    public Group editGroup(Group item) throws Exception{
        Group updateObject=(Group)beanDaoUtil.edit(item);
        return updateObject;
    }

    public void pageGroup(PagingResult page, String filterName) {
        Session session = beanHibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(Group.class);

            if (StringUtils.isNotEmpty(filterName)) {
                criteria.add(Restrictions.like("name", "%" + filterName + "%"));
            }
           beanDaoUtil.pageObject(page,criteria);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            beanHibernateUtil.closeSession(session);
        }
    }

    public List<GroupGrant> listGroupGrant() {
        return (List<GroupGrant>) beanDaoUtil.list(GroupGrant.class.getName());
    }

    public List<GroupPermission> listGroupPermissionByGroup(String groupId){
        if(StringUtils.isBlank(groupId)){
            return null;
        }
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("groupId", groupId));
        List<GroupPermission> list = (List<GroupPermission>) beanDaoUtil.query(GroupPermission.class, criterions);
        return list;

    }
    public List<?> saveOrUpdateGroupPermissions(List<GroupPermission> items){
        List<?> itemsSave=items;
        try{
            itemsSave=beanDaoUtil.saveOrUpdateMany(items,50);
        }catch (Exception e){
            e.printStackTrace();
        }

        return itemsSave;
    }

    public List<?> saveOrUpdatePermissionGroupGrants(List<PermissionGroupGrant> items){
        List<?> itemsR=items;
        itemsR=beanDaoUtil.saveOrUpdateMany(items,50);
        return itemsR;
    }
    public List<PermissionGroupGrant> listPermissionGroupGrant() {
        return (List<PermissionGroupGrant>) beanDaoUtil.list(PermissionGroupGrant.class.getName());
    }

    public void deleteGroupPermissionByGroup(String groupId) {
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("groupId", groupId));

        List<GroupPermission> lstGroupPermission = (List<GroupPermission>) beanDaoUtil.query(GroupPermission.class, criterions);
        if(lstGroupPermission!=null){
            if(lstGroupPermission.size()>0){
                deleteGroupPermissions(lstGroupPermission);
            }
        }
    }
    public List<?> deleteGroupPermissions(List<GroupPermission> items) {
        Session session = beanHibernateUtil.getSession();
        session.getTransaction().begin();
        int i=0;
        try {
            for (GroupPermission item : items) {
                session.delete(item);
                i++;
                if(i%100==0){
                    session.flush();
                }
            }
            session.flush();
            session.clear();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            beanHibernateUtil.closeSession(session);
        }

        return items;
    }

}
