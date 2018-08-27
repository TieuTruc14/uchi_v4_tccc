package com.osp.persistence;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.Text;

/**
 * Created by tieut on 10/19/2017.
 */
public class TextDao extends AbstractBean {
    private DaoUtil beanDaoUtil;
    public void init() {
        beanDaoUtil = (DaoUtil) this.getBean("beanDaoUtil");
    }
    public Text getText(String key) {
        return (Text) beanDaoUtil.get(Text.class, key);
    }

}
