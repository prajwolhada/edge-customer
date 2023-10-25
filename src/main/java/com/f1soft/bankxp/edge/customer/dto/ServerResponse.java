package com.f1soft.bankxp.edge.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse extends ModelBase {

    private boolean success;
    private String message;
    private Object obj;
    private String code;

    public ServerResponse(boolean success) {
        this.success = success;
    }
}
