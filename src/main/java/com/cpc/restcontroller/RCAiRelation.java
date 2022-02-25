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

import com.cpc.model.AI_RELATION_TABLE;
import com.cpc.service.SAiRelation;

/**  
 受入指図連携テーブル RestController 
 */  
@RestController
public class RCAiRelation {
    private final SAiRelation service;

    @Autowired
    public RCAiRelation(SAiRelation service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/airelation/insert", method = RequestMethod.POST)
    public String insert(@RequestBody AI_RELATION_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/airelation/update", method = RequestMethod.POST)
    public String update(@RequestBody AI_RELATION_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/airelation/delete", method = RequestMethod.POST)
    public String delete(@RequestBody AI_RELATION_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/airelation/select")
    public String select(
         @RequestParam(name="IM_ID", required = false) String IM_ID
         ,@RequestParam(name="WORK_GROUP", required = false) String WORK_GROUP
         ,@RequestParam(name="MATERIAL_NO", required = false) String MATERIAL_NO
         ) {
     
        AI_RELATION_TABLE data = new AI_RELATION_TABLE();
        data.setIM_ID(IM_ID);
        data.setWORK_GROUP(WORK_GROUP);
        data.setMATERIAL_NO(MATERIAL_NO);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<AI_RELATION_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

