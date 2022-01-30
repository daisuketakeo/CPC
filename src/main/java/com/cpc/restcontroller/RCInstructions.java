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

import com.cpc.model.INSTRUCTIONS_TABLE;
import com.cpc.service.SInstructions;

/**  
 製造指図テーブル RestController 
 */  
@RestController
public class RCInstructions {
    private final SInstructions service;

    @Autowired
    public RCInstructions(SInstructions service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/instructions/insert", method = RequestMethod.POST)
    public String insert(@RequestBody INSTRUCTIONS_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/instructions/update", method = RequestMethod.POST)
    public String update(@RequestBody INSTRUCTIONS_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/instructions/delete", method = RequestMethod.POST)
    public String delete(@RequestBody INSTRUCTIONS_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/instructions/select")
    public String select(
         @RequestParam(name="BATCH_ID", required = false) String BATCH_ID
         ,@RequestParam(name="IM_ID", required = false) String IM_ID
         ,@RequestParam(name="NAME", required = false) String NAME
         ) {
     
        INSTRUCTIONS_TABLE data = new INSTRUCTIONS_TABLE();
        data.setBATCH_ID(BATCH_ID);
        data.setIM_ID(IM_ID);
        data.setNAME(NAME);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<INSTRUCTIONS_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

