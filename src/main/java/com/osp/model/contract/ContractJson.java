package com.osp.model.contract;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by tieut on 10/30/2017.
 */
public class ContractJson implements Serializable{
    private static final long serialVersionUID = -3934636849238656322L;
    private Integer id;
    private byte type;
    private String contractTemplate;
    private String contractNumber;
    private Long contractValue;
    private String relationObject;
    private String propertyInfo;
    private Integer notary;
    private Integer drafter;
    private Date receivedDate;
    private Date notaryDate;
    private String numberCopyContract;
    private String numberOfPage;
    private Long notaryCost;
    private Long remunerationCost;
    private Long notaryCostTotal;
    private boolean notaryOutside;
    private String notaryPlaceOutside;
    private String bank;
    private Long bankServiceCost;
    private String crediterName;
    private String fileName;
    private String filePath;
    private boolean errorStatus;
    private Integer errorUser;
    private String errorDescription;
    private boolean additionStatus;
    private String additionDescription;
    private boolean cancelStatus;
    private String cancelDescription;
    private Integer cancelRelationContract;
    private String contractPeriod;
    private boolean mortageCancelStatus;
    private Date mortageCancelDate;
    private String mortageCancelNote;
    private String originalStorePlace;
    private String note;
    private String summary;
    private String content;
    private String jsonProperty;
    private String jsonPrivy;
    private Integer userCreated;
    private Date dateCreated;
    private Integer userUpdated;
    private Date dateUpdated;

    public ContractJson() {
    }

    public ContractJson(Integer id, byte type, String contractTemplate, String contractNumber, Long contractValue, String relationObject, String propertyInfo, Integer notary, Integer drafter, Date receivedDate, Date notaryDate, String numberCopyContract, String numberOfPage, Long notaryCost, Long remunerationCost, Long notaryCostTotal, boolean notaryOutside, String notaryPlaceOutside, String bank, Long bankServiceCost, String crediterName, String fileName, String filePath, boolean errorStatus, Integer errorUser, String errorDescription, boolean additionStatus, String additionDescription, boolean cancelStatus, String cancelDescription, Integer cancelRelationContract, String contractPeriod, boolean mortageCancelStatus, Date mortageCancelDate, String mortageCancelNote, String originalStorePlace, String note, String summary, String content, String jsonProperty, String jsonPrivy, Integer userCreated, Date dateCreated, Integer userUpdated, Date dateUpdated) {
        this.id = id;
        this.type = type;
        this.contractTemplate = contractTemplate;
        this.contractNumber = contractNumber;
        this.contractValue = contractValue;
        this.relationObject = relationObject;
        this.propertyInfo = propertyInfo;
        this.notary = notary;
        this.drafter = drafter;
        this.receivedDate = receivedDate;
        this.notaryDate = notaryDate;
        this.numberCopyContract = numberCopyContract;
        this.numberOfPage = numberOfPage;
        this.notaryCost = notaryCost;
        this.remunerationCost = remunerationCost;
        this.notaryCostTotal = notaryCostTotal;
        this.notaryOutside = notaryOutside;
        this.notaryPlaceOutside = notaryPlaceOutside;
        this.bank = bank;
        this.bankServiceCost = bankServiceCost;
        this.crediterName = crediterName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.errorStatus = errorStatus;
        this.errorUser = errorUser;
        this.errorDescription = errorDescription;
        this.additionStatus = additionStatus;
        this.additionDescription = additionDescription;
        this.cancelStatus = cancelStatus;
        this.cancelDescription = cancelDescription;
        this.cancelRelationContract = cancelRelationContract;
        this.contractPeriod = contractPeriod;
        this.mortageCancelStatus = mortageCancelStatus;
        this.mortageCancelDate = mortageCancelDate;
        this.mortageCancelNote = mortageCancelNote;
        this.originalStorePlace = originalStorePlace;
        this.note = note;
        this.summary = summary;
        this.content = content;
        this.jsonProperty = jsonProperty;
        this.jsonPrivy = jsonPrivy;
        this.userCreated = userCreated;
        this.dateCreated = dateCreated;
        this.userUpdated = userUpdated;
        this.dateUpdated = dateUpdated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getContractTemplate() {
        return contractTemplate;
    }

    public void setContractTemplate(String contractTemplate) {
        this.contractTemplate = contractTemplate;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Long getContractValue() {
        return contractValue;
    }

    public void setContractValue(Long contractValue) {
        this.contractValue = contractValue;
    }

    public String getRelationObject() {
        return relationObject;
    }

    public void setRelationObject(String relationObject) {
        this.relationObject = relationObject;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    public Integer getNotary() {
        return notary;
    }

    public void setNotary(Integer notary) {
        this.notary = notary;
    }

    public Integer getDrafter() {
        return drafter;
    }

    public void setDrafter(Integer drafter) {
        this.drafter = drafter;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getNotaryDate() {
        return notaryDate;
    }

    public void setNotaryDate(Date notaryDate) {
        this.notaryDate = notaryDate;
    }

    public String getNumberCopyContract() {
        return numberCopyContract;
    }

    public void setNumberCopyContract(String numberCopyContract) {
        this.numberCopyContract = numberCopyContract;
    }

    public String getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(String numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public Long getNotaryCost() {
        return notaryCost;
    }

    public void setNotaryCost(Long notaryCost) {
        this.notaryCost = notaryCost;
    }

    public Long getRemunerationCost() {
        return remunerationCost;
    }

    public void setRemunerationCost(Long remunerationCost) {
        this.remunerationCost = remunerationCost;
    }

    public Long getNotaryCostTotal() {
        return notaryCostTotal;
    }

    public void setNotaryCostTotal(Long notaryCostTotal) {
        this.notaryCostTotal = notaryCostTotal;
    }

    public boolean isNotaryOutside() {
        return notaryOutside;
    }

    public void setNotaryOutside(boolean notaryOutside) {
        this.notaryOutside = notaryOutside;
    }

    public String getNotaryPlaceOutside() {
        return notaryPlaceOutside;
    }

    public void setNotaryPlaceOutside(String notaryPlaceOutside) {
        this.notaryPlaceOutside = notaryPlaceOutside;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Long getBankServiceCost() {
        return bankServiceCost;
    }

    public void setBankServiceCost(Long bankServiceCost) {
        this.bankServiceCost = bankServiceCost;
    }

    public String getCrediterName() {
        return crediterName;
    }

    public void setCrediterName(String crediterName) {
        this.crediterName = crediterName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public boolean isErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public Integer getErrorUser() {
        return errorUser;
    }

    public void setErrorUser(Integer errorUser) {
        this.errorUser = errorUser;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public boolean isAdditionStatus() {
        return additionStatus;
    }

    public void setAdditionStatus(boolean additionStatus) {
        this.additionStatus = additionStatus;
    }

    public String getAdditionDescription() {
        return additionDescription;
    }

    public void setAdditionDescription(String additionDescription) {
        this.additionDescription = additionDescription;
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

    public Integer getCancelRelationContract() {
        return cancelRelationContract;
    }

    public void setCancelRelationContract(Integer cancelRelationContract) {
        this.cancelRelationContract = cancelRelationContract;
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

    public String getOriginalStorePlace() {
        return originalStorePlace;
    }

    public void setOriginalStorePlace(String originalStorePlace) {
        this.originalStorePlace = originalStorePlace;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getJsonProperty() {
        return jsonProperty;
    }

    public void setJsonProperty(String jsonProperty) {
        this.jsonProperty = jsonProperty;
    }

    public String getJsonPrivy() {
        return jsonPrivy;
    }

    public void setJsonPrivy(String jsonPrivy) {
        this.jsonPrivy = jsonPrivy;
    }

    public Integer getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Integer userCreated) {
        this.userCreated = userCreated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Integer userUpdated) {
        this.userUpdated = userUpdated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
