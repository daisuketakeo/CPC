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

import com.cpc.model.ACCEPT_TABLE;
import com.cpc.service.SAccept;

/**  
 受入テーブル RestController 
 */  
@RestController
public class RCAccept {
    private final SAccept service;

    @Autowired
    public RCAccept(SAccept service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/accept/insert", method = RequestMethod.POST)
    public String insert(@RequestBody ACCEPT_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/accept/update", method = RequestMethod.POST)
    public String update(@RequestBody ACCEPT_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/accept/delete", method = RequestMethod.POST)
    public String delete(@RequestBody ACCEPT_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/accept/select")
    public String select(
         @RequestParam(name="MATERIAL_NO", required = false) String MATERIAL_NO
         ) {
     
        ACCEPT_TABLE data = new ACCEPT_TABLE();
        data.setMATERIAL_NO(MATERIAL_NO);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<ACCEPT_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

