package com.osp.web;

import com.osp.common.persitence.DaoUtil;
import com.osp.common.persitence.HibernateUtil;
import com.osp.common.utils.AbstractBean;
import com.osp.model.Bank;
import com.osp.persistence.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import redis.clients.jedis.Jedis;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tieut on 9/10/2017.
 */
public class test extends AbstractBean{
//    public static void main(String[] args) {
//        ApplicationContext ctx       = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
//        UserDao userDao=(UserDao)ctx.getBean("beanUserDao");
//        if(ctx!=null){
//            userDao.setBeanDaoUtil((DaoUtil) ctx.getBean("beanDaoUtil"));
//            userDao.setBeanHibernateUtil((HibernateUtil) ctx.getBean("beanHibernateUtil"));
//
//            try{
//                Resource resource = new ClassPathResource("nganhang.xlsx");
//                FileInputStream fileInput=new FileInputStream(resource.getFile());
//
//                Workbook workbook = new XSSFWorkbook(fileInput);
//                Sheet firstSheet = workbook.getSheetAt(0);
//                Iterator<Row> iterator = firstSheet.iterator();
//
//                List<Bank> items=new ArrayList<>();
//
//                if(iterator.hasNext()){
////                    //pass first row meta
////                    iterator.next();
//                    int miss=0;
//                    while (iterator.hasNext() && miss<5) {
//                        Bank item=new Bank();
//                        Row myRow = iterator.next();
//
//                        Cell name =myRow.getCell(1);
//                        Cell nameE =myRow.getCell(2);
//                        Cell code =myRow.getCell(3);
//                        Cell national =myRow.getCell(4);
//                        Cell website =myRow.getCell(5);
//
//
//                        if(name!=null){
//                            switch (name.getCellType()) {
//                                case Cell.CELL_TYPE_STRING:
//
//                                    item.setName(name.getStringCellValue());
//                                    break;
//                            }
//                        }else{
//                            miss++;
//                        }
//
//                        if(nameE!=null){
//                            switch (nameE.getCellType()) {
//                                case Cell.CELL_TYPE_STRING:
//                                    item.setNameEnglish(nameE.getStringCellValue());
//                                    break;
//                            }
//                        }
//                        if(code!=null){
//                            switch (code.getCellType()) {
//                                case Cell.CELL_TYPE_STRING:
//                                    item.setCode(code.getStringCellValue());
//                                    break;
//                            }
//                        }
//
//                        if(national!=null){
//                            switch (national.getCellType()) {
//                                case Cell.CELL_TYPE_STRING:
//                                    item.setNational(national.getStringCellValue());
//                                    break;
//                            }
//                        }
//                        if(website!=null){
//                            switch (website.getCellType()) {
//                                case Cell.CELL_TYPE_STRING:
//                                    item.setWebsite(website.getStringCellValue());
//                                    break;
//                            }
//                        }
//                        items.add(item);
//                    }
//                    if(items.size()>0){
//                        int count=1;
//                        for(Bank item:items){
//                            String id=genCode(count);
//                            item.setId(id);
//                            item=userDao.addBank(item);
//                            count++;
//                        }
//                    }
//
//                }
//
//                workbook.close();
//                fileInput.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//            System.out.println("ok");
//        }
//    }

    public static String genCode(int i){
        Integer suff=Integer.valueOf(i);
        String pre="NH";
        String code="00000";
        code = code.substring(0, (5 - suff.toString().length()));
        code=code.concat(suff.toString());
//        if(StringUtils)
        code=pre+code;
        return code;
    }

//    public static void main(String[] args) {
//        //Connecting to Redis server on localhost
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("Connection to server sucessfully");
//        //check whether server is running or not
//        System.out.println("Server is running: "+jedis.ping());
//
//        jedis.set("tutorial-name", "Redis tutorial");
//        // Get the stored data and print it
//        System.out.println("Stored string in redis:: "+ jedis.get("tutorial-name"));
//
//        Jedis jedis1 = new Jedis("localhost");
//        System.out.println("Stored string in redis:: "+ jedis1.get("tutorial-name"));
//
//        jedis1.set("key1","Phạm Tiến Mạnh");
//        System.out.println(jedis1.get("key1"));
//
//
//    }

    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
//            String newPass = new BigInteger(130, new SecureRandom()).toString(32);
//            System.out.println(newPass);
            String password = "1";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);

            System.out.println(hashedPassword);
            i++;
        }
    }

}
