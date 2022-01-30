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

import com.cpc.model.PROCESS_MASTER;
import com.cpc.service.SProcessMst;

/**  
 工程マスタ RestController 
 */  
@RestController
public class RCProcessMst {
    private final SProcessMst service;

    @Autowired
    public RCProcessMst(SProcessMst service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/processmst/insert", method = RequestMethod.POST)
    public String insert(@RequestBody PROCESS_MASTER data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/processmst/update", method = RequestMethod.POST)
    public String update(@RequestBody PROCESS_MASTER data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/processmst/delete", method = RequestMethod.POST)
    public String delete(@RequestBody PROCESS_MASTER data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/processmst/select")
    public String select(
         @RequestParam(name="PROCESS_ID", required = false) String PROCESS_ID
         ) {
     
        PROCESS_MASTER data = new PROCESS_MASTER();
        data.setPROCESS_ID(PROCESS_ID);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<PROCESS_MASTER>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

