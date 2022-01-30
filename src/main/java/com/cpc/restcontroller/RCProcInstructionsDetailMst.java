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

import com.cpc.model.PROC_INSTRUCTIONS_DETAIL_MASTER;
import com.cpc.service.SProcInstructionsDetailMst;

/**  
 工程別製造指図詳細マスタ RestController 
 */  
@RestController
public class RCProcInstructionsDetailMst {
    private final SProcInstructionsDetailMst service;

    @Autowired
    public RCProcInstructionsDetailMst(SProcInstructionsDetailMst service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/procinstructionsdetailmst/insert", method = RequestMethod.POST)
    public String insert(@RequestBody PROC_INSTRUCTIONS_DETAIL_MASTER data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/procinstructionsdetailmst/update", method = RequestMethod.POST)
    public String update(@RequestBody PROC_INSTRUCTIONS_DETAIL_MASTER data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/procinstructionsdetailmst/delete", method = RequestMethod.POST)
    public String delete(@RequestBody PROC_INSTRUCTIONS_DETAIL_MASTER data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/procinstructionsdetailmst/select")
    public String select(
         @RequestParam(name="IM_ID", required = false) String IM_ID
         ,@RequestParam(name="INS_PROC_ID", required = false) String INS_PROC_ID
         ,@RequestParam(name="INS_PROC_DETAIL_ID", required = false) String INS_PROC_DETAIL_ID
         ) {
     
        PROC_INSTRUCTIONS_DETAIL_MASTER data = new PROC_INSTRUCTIONS_DETAIL_MASTER();
        data.setIM_ID(IM_ID);
        data.setINS_PROC_ID(INS_PROC_ID);
        data.setINS_PROC_DETAIL_ID(INS_PROC_DETAIL_ID);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<PROC_INSTRUCTIONS_DETAIL_MASTER>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

