package com.cpc.viewcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cpc.model.DisplayParameter;
import com.cpc.model.USER_MASTER;

/**  
 受入テーブル Controller 
 */  
@Controller
public class VCAccept extends VCCommon{

    @Autowired
    public VCAccept() {
    }
    
    /*
     * 受入
     */
    @GetMapping("/accept")
    public String accept(Model model) {
    	
    	if(!super.loginCheck()) return disp_login;
		
		// ヘッダ設定
    	setHeaderAttr(model);
    	
    	//ユーザ情報取得
    	USER_MASTER user = super.getUserInfo();
    	
    	// ユーザ権限が定義されてない場合ホームに戻る
    	if(!authority.containsKey(user.getAUTHORITY())) {
    		model.addAttribute(disp_body, disp_home);
    		return disp_main;
    	}
    	
    	if(isQA()) {
			// QA
			return "redirect:/accept/qa";
		}else{
			// QC
			return "redirect:/accept/qc";
		}
    }
    
    /*
     * 受入一覧（QC用）
     */
    @GetMapping("/accept/qc")
    public String accept_qc(Model model) {
    	
        if(!super.loginCheck()) return disp_login;
        
		// ヘッダ設定
    	setHeaderAttr(model);
    	model.addAttribute(disp_body, "/accept/accept");
    	
    	// 画面パラメータ生成
    	Map<String, DisplayParameter> map = getWorkGroupList(qc);
    	String json = getParamJson(map);
    	
    	// 	作業グループ情報
    	model.addAttribute(param_work_group_json, json);
    	model.addAttribute(param_work_group_map, map);
    	
    	// 工程
    	model.addAttribute(param_process_id, qc);
    	
    	// ステータスリスト
    	model.addAttribute(param_status_list, getStatusJson());
        
        return disp_main;
    }
    
    /*
     * 受入一覧（QA用）
     */
    @GetMapping("/accept/qa")
    public String accept_qa(Model model) {
    	
        if(!super.loginCheck()) return disp_login;
        
		// ヘッダ設定
    	setHeaderAttr(model);
    	model.addAttribute(disp_body, "/accept/accept");
    	
    	// 画面パラメータ生成
    	Map<String, DisplayParameter> map = getWorkGroupList(qa);
    	String json = getParamJson(map);
    	
    	// 	作業グループ情報
    	model.addAttribute(param_work_group_json, json);
    	model.addAttribute(param_work_group_map, map);
    	
    	// 工程
    	model.addAttribute(param_process_id, qa);
    	
    	// ステータスリスト
    	model.addAttribute(param_status_list, getStatusJson());
        
        return disp_main;
    }
    
}

