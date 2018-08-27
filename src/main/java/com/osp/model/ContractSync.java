package com.osp.model;

import java.io.Serializable;
import java.util.Date;

public class ContractSync implements Serializable {
    private static final long serialVersionUID = 5595320698029909030L;
    private int id;
    private String contractTemplateId;
    private String propertyInfo;
    private String summary;
    private Date notaryDate;
    private String contractNumber;
    private long contractValue;
    private String relationObject;
    private int notaryId;
    private String notaryName;
    private long notaryCost;
    private String note;
    private String bankId;
    private boolean cancelStatus;
    private String cancelDescription;
    private String contractPeriod;
    private boolean mortageCancelStatus;
    private Date mortageCancelDate;
    private String mortageCancelNote;
    private int userCreated;
    private Date dateCreated;
    private int userUpdated;
    private Date dateUpdated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getNotaryDate() {
        return notaryDate;
    }

    public void setNotaryDate(Date notaryDate) {
        this.notaryDate = notaryDate;
    }


    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public long getContractValue() {
        return contractValue;
    }

    public void setContractValue(long contractValue) {
        this.contractValue = contractValue;
    }

    public String getRelationObject() {
        return relationObject;
    }

    public void setRelationObject(String relationObject) {
        this.relationObject = relationObject;
    }

    public String getContractTemplateId() {
        return contractTemplateId;
    }

    public void setContractTemplateId(String contractTemplateId) {
        this.contractTemplateId = contractTemplateId;
    }

    public int getNotaryId() {
        return notaryId;
    }

    public void setNotaryId(int notaryId) {
        this.notaryId = notaryId;
    }

    public String getNotaryName() {
        return notaryName;
    }

    public void setNotaryName(String notaryName) {
        this.notaryName = notaryName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public int getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(int userCreated) {
        this.userCreated = userCreated;
    }

    public int getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(int userUpdated) {
        this.userUpdated = userUpdated;
    }

    public long getNotaryCost() {
        return notaryCost;
    }

    public void setNotaryCost(long notaryCost) {
        this.notaryCost = notaryCost;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(boolean cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getCancelDescription() {
        return cancelDescription;
    }

    public void setCancelDescription(String cancelDescription) {
        this.cancelDescription = cancelDescription;
    }

    public String getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public boolean isMortageCancelStatus() {
        return mortageCancelStatus;
    }

    public void setMortageCancelStatus(boolean mortageCancelStatus) {
        this.mortageCancelStatus = mortageCancelStatus;
    }

    public Date getMortageCancelDate() {
        return mortageCancelDate;
    }

    public void setMortageCancelDate(Date mortageCancelDate) {
        this.mortageCancelDate = mortageCancelDate;
    }

    public String getMortageCancelNote() {
        return mortageCancelNote;
    }

    public void setMortageCancelNote(String mortageCancelNote) {
        this.mortageCancelNote = mortageCancelNote;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
