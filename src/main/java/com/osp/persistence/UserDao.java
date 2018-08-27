package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.Bank;
import com.osp.model.User;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by tieut on 9/10/2017.
 */
public class UserDao extends AbstractBean {
    private static final long serialVersionUID = 2200852816925386056L;
    private HibernateUtil beanHibernateUtil;
    private DaoUtil beanDaoUtil;
    private BCryptPasswordEncoder encoder;


    private static Log log = LogFactory.getLog(UserDao.class);

    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
        beanHibernateUtil = (HibernateUtil) getBean("beanHibernateUtil");
//        encoder=new BCryptPasswordEncoder();
    }

    public List<User> listUser() {
        return (List<User>) beanDaoUtil.list(User.class.getName());
    }

    public User getUser(Integer id) {
        return (User) beanDaoUtil.get(User.class, id);
    }


    public User getUserByUsername(String username){
        if(StringUtils.isBlank(username)){
            return null;
        }
        List<Criterion> criterions = new ArrayList<Criterion>();
        criterions.add(Restrictions.eq("username", username));
        List<User> list = (List<User>) beanDaoUtil.query(User.class, criterions);
        if(list!=null && list.size()>0){
            return list.get(0);
        }
        return null;
    }

    public List<User> getUserByPosition(String position){
        if(StringUtils.isBlank(position)) return null;
        List<Criterion> criterions=new ArrayList<>();
        criterions.add(Restrictions.like("position","%"+position+"%"));
        List<User> items=(List<User>) beanDaoUtil.query(User.class,criterions);
        return items;
    }

    public User add(User item) throws Exception{
        if(getUserByUsername(item.getUsername())!=null || StringUtils.isBlank(item.getPassword())){
            return null;
        }
//        item.setPassword(encoder.encode(item.getPassword()));
        User user=(User)beanDaoUtil.add(item);
        return user;
    }

    public Bank addBank(Bank item) throws Exception{
        Bank bank=(Bank)beanDaoUtil.add(item);
        return bank;
    }

    public User edit(User item) throws Exception{
        User updateObject=(User)beanDaoUtil.edit(item);
        return updateObject;
    }

    public void pageUser(PagingResult page, String filterUserName) {
        Session session = beanHibernateUtil.getSession();
        try {
            Criteria criteria = session.createCriteria(User.class);

            if (StringUtils.isNotEmpty(filterUserName)) {
                criteria.add(Restrictions.like("username", "%" + filterUserName + "%"));
            }
            // record count
            beanDaoUtil.pageObject(page,criteria);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            beanHibernateUtil.closeSession(session);
        }
    }



    public void pageTest(PagingResult page){
        System.out.println("start");
        Session session = beanHibernateUtil.getSession();
        try {
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<User> query = builder.createQuery(User.class);
//            Root<User> root = query.from(User.class);
////            query.select(root);
////            query.select(root).where(builder.equal(root.get("id"), 1l));
//            query.select(root).where(builder.like(root.get("username"), "%manh%"));
//            List<User> users = session.createQuery(query).getResultList();
//
//            // Count number of user
//            CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
//            Root<User> root12 = criteriaQuery.from(User.class);
//            criteriaQuery.select(builder.count(root12));
//            Query<Long> query12 = session.createQuery(criteriaQuery);
//            long count12 = query12.getSingleResult();

            Query query1234=session.createQuery("from User");
            query1234.setFirstResult(1);
            query1234.setMaxResults(3);
            List list = query1234.list();
            System.out.println("ksk");

            page.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            beanHibernateUtil.closeSession(session);
        }
    }


}
