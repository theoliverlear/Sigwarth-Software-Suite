package com.sigwarthsoftware.springboot.communication.response;
//=================================-Imports-==================================
import lombok.Data;

@Data
public class OperationSuccessResponse {
    //============================-Variables-=================================
    boolean success;
    //===========================-Constructors-===============================
    public OperationSuccessResponse(boolean success) {
        this.success = success;
    }
}
