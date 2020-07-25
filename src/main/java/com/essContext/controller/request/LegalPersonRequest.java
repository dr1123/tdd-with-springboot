package com.essContext.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
public class LegalPersonRequest {
    private String type;
    private String companyName;
    private String companyCode;
    private String name;
    private String idType;
    private String idCode;

}

