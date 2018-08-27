package com.osp.web.admin.config;

import com.osp.common.util.SendMailUtil;
import com.osp.common.util.XmlHandler;
import com.osp.common.web.AbstractAction;
import com.osp.model.ConfigBackupDatabaseForm;
import com.osp.model.ConfigBackupDatabaseManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;

/**
 * Created by Admin on 30/10/2017.
 */
public class ConfigBackUpNowAction extends AbstractAction {
    private Logger logger = LogManager.getLogger(ConfigBackUpNowAction.class);
    private String message;

    public String execute()throws Exception{
        ConfigBackupDatabaseForm configBackupDatabaseForm = new ConfigBackupDatabaseForm();
        try {
//            ConfigBackupDatabaseManager cfManager = new ConfigBackupDatabaseManager();
            ConfigBackupDatabaseManager beanConfigBackupDatabaseManager =(ConfigBackupDatabaseManager)this.getBean("beanConfigBackupDatabaseManager");
            String folder=getText("system.backup.os");
            String fileName = beanConfigBackupDatabaseManager.createBackupFileBat();
            Runtime c = Runtime.getRuntime();
            String cmd = "cmd /c start " + getText("system.backup.database.folder") + "backup.bat";
            Process pro;
            if(getText("system.backup.os").equals("0")){
                pro = c.exec(cmd, null);
            }else{
                pro = c.exec(getText("system.backup.database.folder")+"backup.sh",
                        null, new File(getText("system.backup.database.folder")));
            }
            if (pro.waitFor() == 0) {

                String content = "<h3 style='color:black'>Dữ liệu đã sao lưu thành công:</h3>" +
                        "<div>• Thư mục lưu trữ: " + getText("system.backup.database.folder") + "<div>" +
                        "<div>• Tên file: " + fileName + "<div>" +
                        "<div>• Thời gian lưu trữ: " + new Date().toString() + "<div>";
                String[] emails = XmlHandler.getValueNode("Emails").replaceAll("\\s+", "").split(",");
                SendMailUtil.sendGmail(emails, "[Uchi] Sao Lưu Dữ Liệu Thành Công", content);
                message = getText("msg.backup.succes");

            } else {

                String content = "<h3 style='color:black'>Dữ liệu chưa được sao lưu</h3>" +
                        "<div>Vào lúc: " + new Date().toString() + "<div>";
                String[] emails = XmlHandler.getValueNode("Emails").replaceAll("\\s+", "").split(",");
                SendMailUtil.sendGmail(emails, "[Uchi] Sao lưu dữ liệu không thành công", content);
                message= getText("err.backup.database");
            }
        } catch (Exception e) {
            message=getText("err.backup.database");
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
