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

import com.cpc.model.MATERIAL_CHECK_TABLE;
import com.cpc.service.SMaterialCheck;

/**  
 マテリアルチェックテーブル RestController 
 */  
@RestController
public class RCMaterialCheck {
    private final SMaterialCheck service;

    @Autowired
    public RCMaterialCheck(SMaterialCheck service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/materialcheck/insert", method = RequestMethod.POST)
    public String insert(@RequestBody MATERIAL_CHECK_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/materialcheck/update", method = RequestMethod.POST)
    public String update(@RequestBody MATERIAL_CHECK_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/materialcheck/delete", method = RequestMethod.POST)
    public String delete(@RequestBody MATERIAL_CHECK_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/materialcheck/select")
    public String select(
         @RequestParam(name="MATERIAL_NO", required = false) String MATERIAL_NO
         ,@RequestParam(name="BATCH_ID", required = false) String BATCH_ID
         ,@RequestParam(name="PROCESS_ID", required = false) String PROCESS_ID
         ,@RequestParam(name="WORK_GROUP", required = false) String WORK_GROUP
         ,@RequestParam(name="WORK_ID", required = false) String WORK_ID
         ) {
     
        MATERIAL_CHECK_TABLE data = new MATERIAL_CHECK_TABLE();
        data.setMATERIAL_NO(MATERIAL_NO);
        data.setBATCH_ID(BATCH_ID);
        data.setPROCESS_ID(PROCESS_ID);
        data.setWORK_GROUP(WORK_GROUP);
        data.setWORK_ID(WORK_ID);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<MATERIAL_CHECK_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

