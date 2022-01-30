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

import com.cpc.model.WORK_GROUP_STATUS_TABLE;
import com.cpc.service.SWorkGroupStatus;

/**  
 作業グループステータステーブル RestController 
 */  
@RestController
public class RCWorkGroupStatus {
    private final SWorkGroupStatus service;

    @Autowired
    public RCWorkGroupStatus(SWorkGroupStatus service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/workgroupstatus/insert", method = RequestMethod.POST)
    public String insert(@RequestBody WORK_GROUP_STATUS_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/workgroupstatus/update", method = RequestMethod.POST)
    public String update(@RequestBody WORK_GROUP_STATUS_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/workgroupstatus/delete", method = RequestMethod.POST)
    public String delete(@RequestBody WORK_GROUP_STATUS_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/workgroupstatus/select")
    public String select(
         @RequestParam(name="BATCH_ID", required = false) String BATCH_ID
         ,@RequestParam(name="PROCESS_ID", required = false) String PROCESS_ID
         ,@RequestParam(name="WORK_GROUP", required = false) String WORK_GROUP
         ) {
     
        WORK_GROUP_STATUS_TABLE data = new WORK_GROUP_STATUS_TABLE();
        data.setBATCH_ID(BATCH_ID);
        data.setPROCESS_ID(PROCESS_ID);
        data.setWORK_GROUP(WORK_GROUP);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<WORK_GROUP_STATUS_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

