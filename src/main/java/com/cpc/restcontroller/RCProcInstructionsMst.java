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

import com.cpc.model.PROC_INSTRUCTIONS_MASTER;
import com.cpc.service.SProcInstructionsMst;

/**  
 工程別製造指図マスタ RestController 
 */  
@RestController
public class RCProcInstructionsMst {
    private final SProcInstructionsMst service;

    @Autowired
    public RCProcInstructionsMst(SProcInstructionsMst service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/procinstructionsmst/insert", method = RequestMethod.POST)
    public String insert(@RequestBody PROC_INSTRUCTIONS_MASTER data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/procinstructionsmst/update", method = RequestMethod.POST)
    public String update(@RequestBody PROC_INSTRUCTIONS_MASTER data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/procinstructionsmst/delete", method = RequestMethod.POST)
    public String delete(@RequestBody PROC_INSTRUCTIONS_MASTER data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/procinstructionsmst/select")
    public String select(
         @RequestParam(name="IM_ID", required = false) String IM_ID
         ,@RequestParam(name="INS_PROC_ID", required = false) String INS_PROC_ID
         ) {
     
        PROC_INSTRUCTIONS_MASTER data = new PROC_INSTRUCTIONS_MASTER();
        data.setIM_ID(IM_ID);
        data.setINS_PROC_ID(INS_PROC_ID);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<PROC_INSTRUCTIONS_MASTER>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

