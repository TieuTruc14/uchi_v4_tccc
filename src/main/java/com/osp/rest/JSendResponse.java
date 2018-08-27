package com.osp.rest;

/**
 * Created by tieut on 9/12/2017.
 * http://labs.omniti.com/labs/jsend
 */

public class JSendResponse {
    public static enum StatusType {
        success {
            public String toString() {
                return "success";
            }
        },
        fail {
            public String toString() {
                return "fail";
            }
        },
        error {
            public String toString() {
                return "error";
            }
        }
    }


    private StatusType status = StatusType.success;
    private Object data;
    private String message = "OK";

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
