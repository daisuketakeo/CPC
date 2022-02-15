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

import com.cpc.model.USER_MASTER;
import com.cpc.service.SUserMst;

/**  
 ユーザマスタ RestController 
 */  
@RestController
public class RCUserMst {
    private final SUserMst service;

    @Autowired
    public RCUserMst(SUserMst service) {
        this.service = service;

    }
    
    @RequestMapping(value = "/rest/usermst/insert", method = RequestMethod.POST)
    public String insert(@RequestBody USER_MASTER data) {
     if(service.insert(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/usermst/update", method = RequestMethod.POST)
    public String update(@RequestBody USER_MASTER data) {
     if(service.update(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @RequestMapping(value = "/rest/usermst/delete", method = RequestMethod.POST)
    public String delete(@RequestBody USER_MASTER data) {
     if(service.delete(data)) {
         return Const.OK;
     }else {
         return Const.NG;
     }
    }
    
    @GetMapping("/rest/usermst/select")
    public String select(
         @RequestParam(name="USERID", required = false) String USERID
         ,@RequestParam(name="USERNAME", required = false) String USERNAME
         ) {
     
        USER_MASTER data = new USER_MASTER();
        data.setUSERID(USERID);
        data.setUSERNAME(USERNAME);
        
        String json = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(
                new HashMap<String, List<USER_MASTER>>(){{put("list", service.select(data));}});
        }catch(Exception e) {}
        
        return json;
    }
    
}

