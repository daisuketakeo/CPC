package com.cpc.restcontroller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cpc.model.WORK_RESULT_TABLE;
import com.cpc.service.SWorkResult;

/**  
 作業実績テーブル RestController 
 */  
@RestController
public class RCWorkResult {
    private final SWorkResult service;

    @Autowired
    public RCWorkResult(SWorkResult service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/workresult/insert", method = RequestMethod.POST)
    public String insert(@RequestBody WORK_RESULT_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/workresult/update", method = RequestMethod.POST)
    public String update(@RequestBody WORK_RESULT_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/workresult/delete", method = RequestMethod.POST)
    public String delete(@RequestBody WORK_RESULT_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/workresult/select")
    public String select(
         @RequestParam(name="WORK_RESULT_NO", required = false) String WORK_RESULT_NO
         ,@RequestParam(name="PROCESS_ID", required = false) String PROCESS_ID
         ,@RequestParam(name="WORK_GROUP", required = false) String WORK_GROUP
         ,@RequestParam(name="WORK_ID", required = false) String WORK_ID
         ,@RequestParam(name="ID", required = false) String ID
         ) {
     
        WORK_RESULT_TABLE data = new WORK_RESULT_TABLE();
        data.setWORK_RESULT_NO(WORK_RESULT_NO);
        data.setPROCESS_ID(PROCESS_ID);
        data.setWORK_GROUP(WORK_GROUP);
        data.setWORK_ID(WORK_ID);
        data.setID(ID);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<WORK_RESULT_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

