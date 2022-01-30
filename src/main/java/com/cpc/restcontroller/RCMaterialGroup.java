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

import com.cpc.model.MATERIAL_GROUP_TABLE;
import com.cpc.service.SMaterialGroup;

/**  
 マテリアルグループテーブル RestController 
 */  
@RestController
public class RCMaterialGroup {
    private final SMaterialGroup service;

    @Autowired
    public RCMaterialGroup(SMaterialGroup service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/materialgroup/insert", method = RequestMethod.POST)
    public String insert(@RequestBody MATERIAL_GROUP_TABLE data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/materialgroup/update", method = RequestMethod.POST)
    public String update(@RequestBody MATERIAL_GROUP_TABLE data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/materialgroup/delete", method = RequestMethod.POST)
    public String delete(@RequestBody MATERIAL_GROUP_TABLE data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/materialgroup/select")
    public String select(
         @RequestParam(name="MATERIAL_GORUP_ID", required = false) String MATERIAL_GORUP_ID
         ,@RequestParam(name="MATERIAL_NO", required = false) String MATERIAL_NO
         ) {
     
        MATERIAL_GROUP_TABLE data = new MATERIAL_GROUP_TABLE();
        data.setMATERIAL_GORUP_ID(MATERIAL_GORUP_ID);
        data.setMATERIAL_NO(MATERIAL_NO);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<MATERIAL_GROUP_TABLE>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

