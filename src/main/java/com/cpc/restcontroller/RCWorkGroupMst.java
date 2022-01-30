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

import com.cpc.model.WORK_GROUP_MASTER;
import com.cpc.service.SWorkGroupMst;

/**  
 作業グループマスタ RestController 
 */  
@RestController
public class RCWorkGroupMst {
    private final SWorkGroupMst service;

    @Autowired
    public RCWorkGroupMst(SWorkGroupMst service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/workgroupmst/insert", method = RequestMethod.POST)
    public String insert(@RequestBody WORK_GROUP_MASTER data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/workgroupmst/update", method = RequestMethod.POST)
    public String update(@RequestBody WORK_GROUP_MASTER data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/workgroupmst/delete", method = RequestMethod.POST)
    public String delete(@RequestBody WORK_GROUP_MASTER data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/workgroupmst/select")
    public String select(
         @RequestParam(name="PROCESS_ID", required = false) String PROCESS_ID
         ,@RequestParam(name="WORK_GROUP", required = false) String WORK_GROUP
         ) {
     
        WORK_GROUP_MASTER data = new WORK_GROUP_MASTER();
        data.setPROCESS_ID(PROCESS_ID);
        data.setWORK_GROUP(WORK_GROUP);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<WORK_GROUP_MASTER>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

