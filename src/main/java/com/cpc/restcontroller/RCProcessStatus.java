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

import com.cpc.model.PROCESS_STATUS_TABLE;
import com.cpc.service.SProcessStatus;

/**  
 工程別ステータステーブル RestController 
 */  
@RestController
public class RCProcessStatus {
    private final SProcessStatus service;

    @Autowired
    public RCProcessStatus(SProcessStatus service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/processstatus/insert", method = RequestMethod.POST)
    public String insert(@RequestBody PROCESS_STATUS_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/processstatus/update", method = RequestMethod.POST)
    public String update(@RequestBody PROCESS_STATUS_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/processstatus/delete", method = RequestMethod.POST)
    public String delete(@RequestBody PROCESS_STATUS_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/processstatus/select")
    public String select(
         @RequestParam(name="BATCH_ID", required = false) String BATCH_ID
         ,@RequestParam(name="PROCESS_ID", required = false) String PROCESS_ID
         ) {
     
        PROCESS_STATUS_TABLE data = new PROCESS_STATUS_TABLE();
        data.setBATCH_ID(BATCH_ID);
        data.setPROCESS_ID(PROCESS_ID);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<PROCESS_STATUS_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

