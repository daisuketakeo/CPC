package com.cpc.viewcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpc.model.DisplayParameter;

/**  
 製造指図テーブル View Controller 
 */  
@Controller
public class VCInstructions extends VCCommon{

    @Autowired
    public VCInstructions() {
    }
    
    @RequestMapping(value = "/instructions", method = {RequestMethod.GET,RequestMethod.POST})
    public String displaynew(
    		@RequestParam(name="BATCH_ID", required = false) String batch_id,
    		Model model) {
        if(!super.loginCheck()) return disp_login;
        
        setHeaderAttr(model);
        model.addAttribute(disp_body, "/instructions/instructions");
    	// ステータスリスト
    	model.addAttribute(param_status_list, getStatusJson());
    	
    	// 指図リリース済み：ステータス名称
    	model.addAttribute("RELEASE_STATUS", getStatusName("I02"));
    	
    	// BATCH_ID
    	if(batch_id!=null) {
    		model.addAttribute(param_batch_id, batch_id);
    	}
		return disp_main;
    }
    
    @RequestMapping(value = "/instructions_detail", method = RequestMethod.GET)
    public String instructions_detail(Model model) {
        if(!super.loginCheck()) return disp_login;
        setHeaderAttr(model);
		return "/instructions/instructions_detail";
    }
    @RequestMapping(value = "/proc_instructions", method = RequestMethod.GET)
    public String proc_instructions(Model model) {
        if(!super.loginCheck()) return disp_login;
        setHeaderAttr(model);
		return "/instructions/proc_instructions";
    }
    
    @RequestMapping(value = "/manufacturing", method = RequestMethod.POST)
    public String manufacturing(
    		@RequestParam(name=param_batch_id) String BATCH_ID,
    		@RequestParam(name=param_process_id) String PROCESS_ID,
    		Model model) {
        if(!super.loginCheck()) return disp_login;
        
        setHeaderAttr(model);
        model.addAttribute(disp_body, "/manufacturing/manufacturing");
    	
    	// 画面パラメータ生成
    	Map<String, DisplayParameter> map = getWorkGroupList(PROCESS_ID);
    	String json = getParamJson(map);
    	
    	// 	作業グループ情報
    	model.addAttribute(param_work_group_json, json);
    	model.addAttribute(param_work_group_map, map);
    	
    	model.addAttribute(param_batch_id, BATCH_ID);
    	model.addAttribute(param_process_id, PROCESS_ID);
    	
		return disp_main;
    }
    
    @RequestMapping(value = "/qualitycontrol", method = RequestMethod.POST)
    public String qualitycontrol(
    		@RequestParam(name=param_batch_id) String BATCH_ID,
    		@RequestParam(name=param_process_id) String PROCESS_ID,
    		Model model) {
        if(!super.loginCheck()) return disp_login;
        
        setHeaderAttr(model);
        model.addAttribute(disp_body, "/qualitycontrol/qualitycontrol");
    	
    	// 画面パラメータ生成
    	Map<String, DisplayParameter> map = getWorkGroupList(PROCESS_ID);
    	String json = getParamJson(map);
    	
    	// 	作業グループ情報
    	model.addAttribute(param_work_group_json, json);
    	model.addAttribute(param_work_group_map, map);
    	
    	model.addAttribute(param_batch_id, BATCH_ID);
    	model.addAttribute(param_process_id, PROCESS_ID);
    	
		return disp_main;
    }
    
    @RequestMapping(value = "/batchrelease", method = RequestMethod.POST)
    public String batchrelease(
    		@RequestParam(name=param_batch_id) String BATCH_ID,
    		@RequestParam(name=param_process_id) String PROCESS_ID,
    		Model model) {
        if(!super.loginCheck()) return disp_login;
        
        setHeaderAttr(model);
        model.addAttribute(disp_body, "/batchrelease/batchrelease");
    	
    	// 画面パラメータ生成
    	Map<String, DisplayParameter> map = getWorkGroupList(PROCESS_ID);
    	String json = getParamJson(map);
    	
    	// 	作業グループ情報
    	model.addAttribute(param_work_group_json, json);
    	model.addAttribute(param_work_group_map, map);
    	
    	model.addAttribute(param_batch_id, BATCH_ID);
    	model.addAttribute(param_process_id, PROCESS_ID);
    	
		return disp_main;
    }

}

