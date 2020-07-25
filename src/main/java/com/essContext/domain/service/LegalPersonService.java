package com.essContext.domain.service;

import com.essContext.controller.request.LegalPersonRequest;
import com.essContext.domain.model.LegalPerson;
import com.essContext.domain.repository.LegalPersonRepository;
import com.essContext.exception.ErrorCodeEnum;
import com.essContext.exception.MyException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LegalPersonService {
    @Autowired
    LegalPersonRepository legalPersonRepository;

    List<String> companyCodeRegistered = new ArrayList<String>(Arrays.asList("001", "002", "003"));

    List<String> synchronizationCode = new ArrayList<String>(Arrays.asList("001", "002", "003"));

    public LegalPerson register(LegalPersonRequest request) throws Exception {
        check(request);
        LegalPerson legalPerson = new LegalPerson();
        BeanUtils.copyProperties(legalPerson, request);
        return legalPersonRepository.save(legalPerson);
    }

    private void check(LegalPersonRequest request) {
        if(isExit(request.getCompanyCode())){
            throw new MyException(ErrorCodeEnum.DR10001.msg());
        }
        if(!isMatch(request.getCompanyCode(), request.getCompanyName())){
            throw new MyException(ErrorCodeEnum.DR10002.msg());
        }
        if(!isSynchronization(request.getCompanyCode())){
            throw new MyException(ErrorCodeEnum.DR10002.msg());
        }
    }

    private boolean isSynchronization(String companyCode) {
        return true;
//        if(synchronizationCode.contains(companyCode)){
//            return true;
//        }
//        return false;
    }

    private boolean isMatch(String companyCode, String companyName) {
        if(companyCode.equals(companyName)){
            return true;
        }
        return false;
    }

    private boolean isExit(String companyCode) {
        if(companyCodeRegistered.contains(companyCode)){
            return true;
        }
        return false;
    }

}
