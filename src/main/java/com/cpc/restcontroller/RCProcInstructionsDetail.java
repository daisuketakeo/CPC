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

import com.cpc.model.PROC_INSTRUCTIONS_DETAIL_TABLE;
import com.cpc.service.SProcInstructionsDetail;

/**  
 工程別製造指図詳細テーブル RestController 
 */  
@RestController
public class RCProcInstructionsDetail {
    private final SProcInstructionsDetail service;

    @Autowired
    public RCProcInstructionsDetail(SProcInstructionsDetail service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/procinstructionsdetail/insert", method = RequestMethod.POST)
    public String insert(@RequestBody PROC_INSTRUCTIONS_DETAIL_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/procinstructionsdetail/update", method = RequestMethod.POST)
    public String update(@RequestBody PROC_INSTRUCTIONS_DETAIL_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/procinstructionsdetail/delete", method = RequestMethod.POST)
    public String delete(@RequestBody PROC_INSTRUCTIONS_DETAIL_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/procinstructionsdetail/select")
    public String select(
         @RequestParam(name="BATCH_ID", required = false) String BATCH_ID
         ,@RequestParam(name="INS_PROC_ID", required = false) String INS_PROC_ID
         ,@RequestParam(name="INS_PROC_DETAIL_ID", required = false) String INS_PROC_DETAIL_ID
         ) {
     
        PROC_INSTRUCTIONS_DETAIL_TABLE data = new PROC_INSTRUCTIONS_DETAIL_TABLE();
        data.setBATCH_ID(BATCH_ID);
        data.setINS_PROC_ID(INS_PROC_ID);
        data.setINS_PROC_DETAIL_ID(INS_PROC_DETAIL_ID);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<PROC_INSTRUCTIONS_DETAIL_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

