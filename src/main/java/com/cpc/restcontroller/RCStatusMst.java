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

import com.cpc.model.STATUS_MASTER;
import com.cpc.service.SStatusMst;

/**  
 ステータスマスタ RestController 
 */  
@RestController
public class RCStatusMst {
    private final SStatusMst service;

    @Autowired
    public RCStatusMst(SStatusMst service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/statusmst/insert", method = RequestMethod.POST)
    public String insert(@RequestBody STATUS_MASTER data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/statusmst/update", method = RequestMethod.POST)
    public String update(@RequestBody STATUS_MASTER data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/statusmst/delete", method = RequestMethod.POST)
    public String delete(@RequestBody STATUS_MASTER data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/statusmst/select")
    public String select(
         @RequestParam(name="TABLE_TYPE", required = false) String TABLE_TYPE
         ,@RequestParam(name="STATUS_CODE", required = false) String STATUS_CODE
         ) {
     
        STATUS_MASTER data = new STATUS_MASTER();
        data.setTABLE_TYPE(TABLE_TYPE);
        data.setSTATUS_CODE(STATUS_CODE);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<STATUS_MASTER>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

