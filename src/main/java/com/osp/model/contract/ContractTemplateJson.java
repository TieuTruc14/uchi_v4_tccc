package com.osp.model.contract;

/**
 * Created by tieut on 11/2/2017.
 */
public class ContractTemplateJson {
    private String id;
    private String name;
    private String contractKind;
    private boolean periodStatus;
    private boolean mortageCancel;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractKind() {
        return contractKind;
    }

    public void setContractKind(String contractKind) {
        this.contractKind = contractKind;
    }

    public boolean isPeriodStatus() {
        return periodStatus;
    }

    public void setPeriodStatus(boolean periodStatus) {
        this.periodStatus = periodStatus;
    }

    public boolean isMortageCancel() {
        return mortageCancel;
    }

    public void setMortageCancel(boolean mortageCancel) {
        this.mortageCancel = mortageCancel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
