package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.Announcement;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minh on 10/20/2017.
 */
public class AnnouncementDao extends AbstractBean {
    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;

    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
//        encoder=new BCryptPasswordEncoder();
    }

    public List<Announcement> listAnnouncement() {
        return (List<Announcement>) beanDaoUtil.list(Announcement.class.getName());
    }

    public Announcement getAnnouncement(int id) {
        return (Announcement) beanDaoUtil.get(Announcement.class, id);
    }
    public Announcement deleteAnnouncement( Announcement item) throws Exception{
        return (Announcement) beanDaoUtil.delete(item);
    }

    public Announcement getAnnouncementByName(String name){
        if(StringUtils.isBlank(name)){
            return null;
        }
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("username", name));
        List<Announcement> list = (List<Announcement>) beanDaoUtil.query(Announcement.class, criterions);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public Announcement add(Announcement item) throws Exception{
        /*if(getUserByUsername(item.getUsername())!=null || StringUtils.isBlank(item.getPassword())){
            return null;
        }*/
//        item.setPassword(encoder.encode(item.getPassword()));
        Announcement announcement=(Announcement)beanDaoUtil.add(item);
        return announcement;
    }



    public Announcement edit(Announcement item) throws Exception{
        Announcement updateObject=(Announcement) beanDaoUtil.edit(item);
        return updateObject;
    }

    public void pageAnnouncement(PagingResult page, String filterAnnouncementName) {
        Session session = beanHibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(Announcement.class);

            if (StringUtils.isNotEmpty(filterAnnouncementName)) {
                criteria.add(Restrictions.like("title", "%" + filterAnnouncementName + "%"));
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
