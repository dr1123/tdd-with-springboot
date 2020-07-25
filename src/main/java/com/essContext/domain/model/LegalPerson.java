package com.essContext.domain.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
//@Builder
public class LegalPerson {

    @ApiModelProperty("法人类型")
    private String type;

    @NotBlank(message = "企业全称必填")
    @ApiModelProperty("企业全称")
    private String companyName;

    @ApiModelProperty("企业统一社会信用代码")
    private String companyCode;

    @NotBlank(message = "法人姓名必填")
    @ApiModelProperty("法人姓名")
    private String name;

    @ApiModelProperty("证件类型")
    private String idType;

    @ApiModelProperty("证件号码")
//    @Max(10)
//    @Min(0)
    private String idCode;

    @ApiModelProperty("id")
    private String id;
}
