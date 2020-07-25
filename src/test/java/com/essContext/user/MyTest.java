package com.essContext.user;

import com.essContext.BaseTest;
import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.service.LegalPersonService;
import com.essContext.exception.ErrorCodeEnum;
import com.essContext.exception.MyException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author dingrui
 * @version V1.0
 * @className: MyTest
 * @description: mytest
 * @date 2020/7/25 14:01
 */
public class MyTest extends BaseTest {

    @Autowired
    LegalPersonService legalPersonService;

    @Test
    void should_return_success_when_register_given_legalPerson_sfz_info() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdType("身份证");
        legalPersonRequest.setCompanyCode("12345");
        legalPersonRequest.setCompanyName("12345");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length() > 0);
    }
    @Test
    void should_return_success_when_register_given_legalPerson_hz_info() throws Exception {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setIdType("护照");
        legalPersonRequest.setCompanyCode("12345");
        legalPersonRequest.setCompanyName("12345");

        LegalPerson legalPerson = legalPersonService.register(legalPersonRequest);

        assertTrue(legalPerson.getId().length() > 0);
    }

    @Test()
    void should_return_fail_when_register_given_companyCode_isExit() {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setCompanyCode("001");

        Exception exception = assertThrows(
                MyException.class, () -> legalPersonService.register(legalPersonRequest));
        assertTrue(exception.getMessage().contains(ErrorCodeEnum.DR10001.msg()));
    }

    @Test()
    void should_return_fail_when_register_given_companyCode_isMatching() {
        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
        legalPersonRequest.setCompanyName("12345");
        legalPersonRequest.setCompanyCode("123456");

        Exception exception = assertThrows(
                MyException.class, () -> legalPersonService.register(legalPersonRequest));
        assertTrue(exception.getMessage().contains(ErrorCodeEnum.DR10002.msg()));
    }

//    @Test()
//    void should_return_fail_when_register_given_companyCode_isSyn() {
//        LegalPersonRequest legalPersonRequest = new LegalPersonRequest();
//        legalPersonRequest.setCompanyName("12345");
//        legalPersonRequest.setCompanyCode("12345");
//
//        Exception exception = assertThrows(
//                MyException.class, () -> legalPersonService.register(legalPersonRequest));
//        assertTrue(exception.getMessage().contains(ErrorCodeEnum.DR10003.msg()));
//    }

}
