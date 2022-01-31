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

import com.cpc.model.INSTRUCTIONS_MASTER;
import com.cpc.service.SInstructionsMst;

/**  
 製造指図マスタ RestController 
 */  
@RestController
public class RCInstructionsMst {
    private final SInstructionsMst service;

    @Autowired
    public RCInstructionsMst(SInstructionsMst service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/instructionsmst/insert", method = RequestMethod.POST)
    public String insert(@RequestBody INSTRUCTIONS_MASTER data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/instructionsmst/update", method = RequestMethod.POST)
    public String update(@RequestBody INSTRUCTIONS_MASTER data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/instructionsmst/delete", method = RequestMethod.POST)
    public String delete(@RequestBody INSTRUCTIONS_MASTER data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/instructionsmst/select")
    public String select(
         @RequestParam(name="IM_ID", required = false) String IM_ID
         ,@RequestParam(name="NAME", required = false) String NAME
         ,@RequestParam(name="MATERIAL_GORUP_ID", required = false) String MATERIAL_GORUP_ID
         ) {
     
        INSTRUCTIONS_MASTER data = new INSTRUCTIONS_MASTER();
        data.setIM_ID(IM_ID);
        data.setNAME(NAME);
        data.setMATERIAL_GORUP_ID(MATERIAL_GORUP_ID);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<INSTRUCTIONS_MASTER>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

