package com.cpc.viewcontroller;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpc.model.ACCEPT_TABLE;
import com.cpc.model.AI_RELATION_TABLE;
import com.cpc.model.INSTRUCTIONS_MASTER;
import com.cpc.model.INSTRUCTIONS_TABLE;
import com.cpc.model.MATERIAL_CHECK_TABLE;
import com.cpc.model.MATERIAL_GROUP_TABLE;
import com.cpc.model.PROCESS_MASTER;
import com.cpc.model.PROCESS_STATUS_TABLE;
import com.cpc.model.PROC_INSTRUCTIONS_DETAIL_MASTER;
import com.cpc.model.PROC_INSTRUCTIONS_MASTER;
import com.cpc.model.STATUS_MASTER;
import com.cpc.model.USER_MASTER;
import com.cpc.model.WORK_GROUP_MASTER;
import com.cpc.model.WORK_MASTER;
import com.cpc.model.WORK_RESULT_TABLE;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfEncryptor;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

/**  
 ajax用 RestController 
 */  
@RestController
public class VCAjax extends VCCommon{

    @Autowired
    public VCAjax() {
    }
      
    /*
     * 保管場所リスト取得
     */
    @GetMapping("/ajax/storage_list")
    public List<String> storage_list() {
    	return getStorageList();
    }
    
    /*
     * 作業手順固定文字列取得
     */
    @GetMapping("/ajax/fixed_work")
    public String fixed_work() {       
    	return getFixedWork();
    }
    
    /*
     * 承認者か？
     */
    @GetMapping("/ajax/isapp")
    public boolean isapp() { 
    	return super.isAdmin();
    }
    
    /*
     * EBR試験の画像ファイル／CSVファイル格納フォルダ取得
     */
    @GetMapping("/ajax/get_ebrtest")
    public List<WORK_MASTER> get_ebrtestdir(
    		@RequestParam(param_work_group) String work_group) {
    	
    	// 作業手順マスタ取得
        List<WORK_MASTER> list = getWorkMaster(work_group);
        for(WORK_MASTER wm : list) {
        	// 画像ファイルをBase64に変換して取得
        	if(wm.getCAPTURE1()!=null && !wm.getCAPTURE1().isEmpty()) {
        		String base64 = get_base64(super.getProperties().getEBR_TEST_PATH(), wm.getCAPTURE1());
        		wm.setCAPTURE1(base64);
        	}
        	if(wm.getCAPTURE2()!=null && !wm.getCAPTURE2().isBlank()) {
        		String base64 = get_base64(super.getProperties().getEBR_TEST_PATH(), wm.getCAPTURE2());
        		wm.setCAPTURE2(base64);
        	}
        	if(wm.getCAPTURE3()!=null && !wm.getCAPTURE3().isEmpty()) {
        		String base64 = get_base64(super.getProperties().getEBR_TEST_PATH(), wm.getCAPTURE3());
        		wm.setCAPTURE3(base64);
        	}
        	if(wm.getCAPTURE4()!=null && !wm.getCAPTURE4().isEmpty()) {
        		String base64 = get_base64(super.getProperties().getEBR_TEST_PATH(), wm.getCAPTURE4());
        		wm.setCAPTURE4(base64);
        	}
        	if(wm.getCAPTURE5()!=null && !wm.getCAPTURE5().isEmpty()) {
        		String base64 = get_base64(super.getProperties().getEBR_TEST_PATH(), wm.getCAPTURE5());
        		wm.setCAPTURE5(base64);
        	}
        	
        	// CSVファイルをリスト形式に変換して取得
        	if(wm.getCSV1()!=null && !wm.getCSV1().isEmpty()) {
        		String csv = get_csv(super.getProperties().getEBR_TEST_PATH(), wm.getCSV1());
        		wm.setCSV1(csv);
        	}
        	if(wm.getCSV2()!=null && !wm.getCSV2().isEmpty()) {
        		String csv = get_csv(super.getProperties().getEBR_TEST_PATH(), wm.getCSV2());
        		wm.setCSV2(csv);
        	}
        	if(wm.getCSV3()!=null && !wm.getCSV3().isEmpty()) {
        		String csv = get_csv(super.getProperties().getEBR_TEST_PATH(), wm.getCSV3());
        		wm.setCSV3(csv);
        	}
        	if(wm.getCSV4()!=null && !wm.getCSV4().isEmpty()) {
        		String csv = get_csv(super.getProperties().getEBR_TEST_PATH(), wm.getCSV4());
        		wm.setCSV4(csv);
        	}
        	if(wm.getCSV5()!=null && !wm.getCSV5().isEmpty()) {
        		String csv = get_csv(super.getProperties().getEBR_TEST_PATH(), wm.getCSV5());
        		wm.setCSV5(csv);
        	}
        }
        
    	return list;
    }
    
    /*
     * EBR試験の画像ファイル／CSVファイル格納フォルダ取得
     */
    @GetMapping("/ajax/get_sequence")
    public Map<String,String> get_sequence() {
    	
    	String SEQUENCE = get_csv(
    			super.getProperties().getCONFIG_PATH(),
    			super.getProperties().getSEQUENCE_FILE());
    	String SEQUENCE_INTERVAL = super.getProperties().getSEQUENCE_INTERVAL();
    	String CELLQUALIA_TOP_AUTOTRANS = super.getProperties().getCELLQUALIA_TOP_AUTOTRANS();
    	Map<String,String> map = new HashMap<String,String>(){
    		{
    			put("SEQUENCE", SEQUENCE);
    			put("SEQUENCE_INTERVAL", SEQUENCE_INTERVAL);
    			put("CELLQUALIA_TOP_AUTOTRANS", CELLQUALIA_TOP_AUTOTRANS);
    		}
    	};
    	
    	return map;
    }
    
    /*
     * 操作権限チェック
     */
    @GetMapping("/ajax/check_operation_authority")
    public boolean check_operation_authority(
    		@RequestParam(param_work_group) String work_group) {
    	
        // 作業手順マスタ取得
        List<WORK_MASTER> target_workmst = 
        		getWorkMaster(work_group);
        if(target_workmst.size()>0) {
        	WORK_MASTER wm = target_workmst.get(0);
        	String[] auth_arry = wm.getAUTHORITY().split(",");
        	boolean exec = false;
        	USER_MASTER user = super.getUserInfo();
        	for(String auth : auth_arry) {
        		if(user.getAUTHORITY().equals(auth)) {
        			exec = true;
        		}
        	}
        	if(!exec) {
        		// 操作権限なし
            	return false;
        	}
        }
        
        return true;
    }
    /*
     * ステータスチェック（ボタンの有効／無効セット）
     */
    @GetMapping("/ajax/check_status")
    public boolean check_status(
    		@RequestParam(param_work_group) String work_group,
    		@RequestParam(param_work_id) String work_id,
    		@RequestParam(param_id) String id) {
    	
    	/**********************************
    	 *       操作権限チェック
    	 **********************************/
        // 作業手順マスタ取得
        if(!check_operation_authority(work_group)) {
        	return false;
        }
    	
    	/**********************************
    	 *       対象作業の完了チェック
    	 **********************************/
		// 作業実績取得
        List<WORK_RESULT_TABLE> target_workresult = 
        		getWorkResult(work_group, work_id, id);
        
        if(target_workresult.size()>0) {
        	WORK_RESULT_TABLE wrt = target_workresult.get(0);
        	if(wrt.getWORK_USERID() != null && !wrt.getWORK_USERID().isEmpty()) {
            	// 作業完了ならボタン無効
//        		System.out.println("["+work_group+"]["+work_id+"]["+id+"]:作業完了");
            	return false;
            }
        }
        
        /**********************************
    	 *       前作業の完了チェック
    	 **********************************/
    	try {
    		
    		int wid = Integer.valueOf(work_id);
    		
        	if(wid>1) {
        		
        		// 先頭作業でない場合
        		String before_work_id = String.format("%03d", (wid-1));
        		
            	// 前作業実績取得
                List<WORK_RESULT_TABLE> before_workresult = 
                		getWorkResult(work_group, before_work_id, id);
                if(before_workresult.size()==0) {
                	// 前作業未完了ならボタン無効
//                	System.out.println("["+work_group+"]["+work_id+"]["+id+"]:前作業未完了");
                	return false;
                }else {
                	WORK_RESULT_TABLE wrt = before_workresult.get(0);
                	// 前作業未完了(実施ユーザ=NULL)ならボタン無効
                	if(wrt.getWORK_USERID() == null) {
//                		System.out.println("["+work_group+"]["+work_id+"]["+id+"]:前作業未完了(実施ユーザ=NULL)");
                    	return false;
                    }
                	if(wrt.getWORK_USERID().isEmpty()) {
//                		System.out.println("["+work_group+"]["+work_id+"]["+id+"]:前作業未完了(実施ユーザ=NULL)");
                    	return false;
                    }
                }
        	}
    	}catch(Exception e) {
    		// 例外発生 ボタン無効
//    		System.out.println("["+work_group+"]["+work_id+"]["+id+"]:例外発生");
    		return false;
    	}
        
    	/**********************************
    	 *       前作業グループの完了チェック
    	 **********************************/
        // 作業グループ取得
    	WORK_GROUP_MASTER workgroupmst = getWorkGroup(work_group);
        
        // 前作業グループ完了チェック
        if(workgroupmst.getBEFORE_WORK_GROUP() != null &&
        		!workgroupmst.getBEFORE_WORK_GROUP().isEmpty()) {
        	
            // 前作業グループの作業手順マスタ取得
            List<WORK_MASTER> before_workmst = 
            		getWorkMaster(workgroupmst.getBEFORE_WORK_GROUP());
            // 前作業グループの作業実績取得
        	List<WORK_RESULT_TABLE> before_workresult = 
        			getWorkResult(workgroupmst.getBEFORE_WORK_GROUP(), "", id);
        	
        	int before_process_work_end_count = 0;
        	for(WORK_MASTER wm : before_workmst) {
        		for(WORK_RESULT_TABLE wrt : before_workresult) {
        			if(wm.getWORK_ID().equals(wrt.getWORK_ID()) ) {
        				if(wrt.getWORK_USERID() != null 
            					&& !wrt.getWORK_USERID().isEmpty()) {
            				before_process_work_end_count++;
            			}
        			}
        		}
        	}
        	
        	// 前作業グループの作業実完了数 < 前作業グループの作業数 ： 前作業グループ未完了 
        	if(before_process_work_end_count < before_workmst.size()) {
//        		System.out.println("["+work_group+"]["+work_id+"]["+id+"]:前作業グループ未完了");
        		return false;
        	}
        }
        
        /**********************************
    	 *       対象作業グループの完了チェック
    	 **********************************/
        
        // 作業手順マスタ取得
        List<WORK_MASTER> target_workmst = 
        		getWorkMaster(work_group);
        
        // 作業実績取得
        target_workresult = 
        		getWorkResult(work_group, "", id);
        
        // 対象作業グループ完了チェック
        int current_process_work_end_count = 0;
        for(WORK_MASTER wm : target_workmst) {
        	for(WORK_RESULT_TABLE wrt : target_workresult) {
        		// 作業完了数カウント
        		if(wm.getWORK_ID().equals(wrt.getWORK_ID()) ) {
        			if(wrt.getWORK_USERID() != null
            				&& !wrt.getWORK_USERID().isEmpty()) {
            			current_process_work_end_count++;
            		}
        		}
        	}
        };
        
    	// 対象作業グループの作業実完了数 >= 対象作業グループの作業数 ： 対象工程完了
    	if(current_process_work_end_count >= target_workmst.size()) {
//    		System.out.println("["+work_group+"]["+work_id+"]["+id+"]:対象工程完了");
    		return false;
    	}
        
        return true;
    }
    
    /*
     * 作業完了処理
     * 引数：Json形式
     */
    @RequestMapping(value = "/ajax/workend", 
    		consumes = "application/json",
    		method = RequestMethod.POST)
    @ResponseBody
    public String workend(@RequestBody WORK_RESULT_TABLE req) {
    	
        String url = "";
        boolean result = false; 
        
        // ユーザ情報取得
        USER_MASTER user = super.getUserInfo();
        
        // 作業実績登録
        WORK_RESULT_TABLE data = req;
        data.setWORK_USERID(user.getUSERID());
        data.setWORK_USERNAME(user.getUSERNAME());
        data.setWORK_DATE(getWorkDate());
        
        // 添付ファイル関連は作業完了時に登録しないのでnullにしておく（登録／更新対象から外す）
        data.setCHECK_FILE_NAME(null);
        data.setCHECK_FILE_BASE64(null);
        
        String rst = workresult_regist(data);
        result = rst.equals("OK");
        
        /**
         * ステータス更新
         */
    	if(result) {
    		
    		String status_code = getStatus(req.getWORK_GROUP());
    		
            // 作業手順マスタ取得
            List<WORK_MASTER> target_workmst = 
            		getWorkMaster(req.getWORK_GROUP());
            
            // 作業実績取得
            List<WORK_RESULT_TABLE> target_workresult = 
            		getWorkResult(req.getWORK_GROUP(), "", req.getID());
            
            // 対象作業グループの全作業完了チェック
            int process_work_end_count = 0;
            for(WORK_MASTER wm : target_workmst) {
            	for(WORK_RESULT_TABLE wrt : target_workresult) {
            		// 実施済みならボタン無効
            		if(wm.getWORK_ID().equals(wrt.getWORK_ID())) {
            			process_work_end_count++;
            		}
            	}
            };
            
        	// 対象作業グループの作業実完了数 >= 対象作業グループの作業数 ： 対象作業グループ完了
        	if(process_work_end_count >= target_workmst.size()) {
        		
        		// 受入の場合
        		if(req.getPROCESS_ID().equals(qc) || req.getPROCESS_ID().equals(qa)) {
            			
            		// 作業実績登録OK & 対象作業グループ完了 なら受入のステータス更新
                	ACCEPT_TABLE accept = new ACCEPT_TABLE();
                	accept.setMATERIAL_NO(req.getID());
                	accept.setSTATUS(status_code);
                	
                	// QAの場合
                	if(req.getPROCESS_ID().equals(qa)) {
                		// USer Lot # 発番
                		List<ACCEPT_TABLE> list_accept = 
                				getRest(rest_accept+"select?MATERIAL_NO="+req.getID(), ACCEPT_TABLE.class);
                		if(list_accept.size()>0) {
                			String qty = list_accept.get(0).getQTY();
                			accept.setUSER_LOT_NO(
                					req.getID()+
                					super.getNewUserLotNo()+
                					" 「1/"+qty+"」~「"+qty+"/"+qty+"」"
                					);
                		}
                	}
                    
                    url = rest_accept+"update";           
                    if(postRest(url, accept)) {
                    	// OK
                    	result = true;
                    }else {
                    	// NG
                    	result = false;
                    	// 作業実績削除
                        url = rest_workresult+"delete";           
                        postRest(url, data);
                    }
            	}else if(req.getPROCESS_ID().equals(is)){
            		// 指図の場合
            		
            	}else {
            		// 工程の場合
            		
                    // 工程別ステータス取得
                	url= rest_processstatus+"select"+
            				"?"+ param_batch_id+"="+req.getID()+
            				"&"+ param_process_id+"="+req.getPROCESS_ID();
            	 	List<PROCESS_STATUS_TABLE> list = 
            	 			getRest(url, PROCESS_STATUS_TABLE.class);
            	 	
                    if(list.size()>0) {
                    	
                    	// 工程別ステータス更新
                    	PROCESS_STATUS_TABLE oldpst = list.get(0);
                    	oldpst.setSTATUS(status_code);
                    	url = rest_processstatus+"update";
                    	postRest(url, oldpst);
                    	
                    }else {
                    	
                    	// 工程別ステータス登録
                    	PROCESS_STATUS_TABLE newpst = new PROCESS_STATUS_TABLE();
                    	newpst.setBATCH_ID(req.getID());
                    	newpst.setPROCESS_ID(req.getPROCESS_ID());
                    	newpst.setSTATUS(status_code);
                        url = rest_processstatus+"insert";
                        postRest(url, newpst);
                    }
            	}
        	}else {
        		
        		if(req.getPROCESS_ID().equals(qc) || req.getPROCESS_ID().equals(qa)) {
        			// 受入の場合
            	}else if(req.getPROCESS_ID().equals(is)){
            		// 指図の場合
            	}else {
            		// 工程の場合
            		
            		// 工程の先頭作業の場合
            		if(data.getWORK_GROUP().substring(3, 5).equals("01")
            				&& data.getWORK_ID().equals("001")) {
            			
                        // 工程別ステータス取得
                    	url= rest_processstatus+"select"+
                				"?"+ param_batch_id+"="+req.getID()+
                				"&"+ param_process_id+"="+req.getPROCESS_ID();
                	 	List<PROCESS_STATUS_TABLE> list = 
                	 			getRest(url, PROCESS_STATUS_TABLE.class);
                	 	
                        if(list.size()>0) {
                        	
                        	// 工程別ステータス更新
                        	PROCESS_STATUS_TABLE oldpst = list.get(0);
                        	oldpst.setSTATUS(status_code);
                        	url = rest_processstatus+"update";
                        	postRest(url, oldpst);
                        	
                        }else {
                        	
                        	// 工程別ステータス登録
                        	PROCESS_STATUS_TABLE newpst = new PROCESS_STATUS_TABLE();
                        	newpst.setBATCH_ID(req.getID());
                        	newpst.setPROCESS_ID(req.getPROCESS_ID());
                        	newpst.setSTATUS(status_code);
                            url = rest_processstatus+"insert";
                            postRest(url, newpst);
                        }
                        
                    	// 先頭工程の場合
                    	if(data.getWORK_GROUP().equals("EP101")) {
                    		// 指図のステータス、開始日時更新
                	 		INSTRUCTIONS_TABLE insdata = new INSTRUCTIONS_TABLE();
                	 		insdata.setBATCH_ID(req.getID());
                	 		insdata.setSTATUS("I03");
                	 		insdata.setSTARTING_TIME(super.getWorkDate());
                	 		url = rest_instructions+"update";
                        	postRest(url, insdata);
                    	}
            		}
            	}
        	}
        	
        	//
        	if(req.getPROCESS_ID().equals("ET2") ||
					req.getPROCESS_ID().equals("ET3") ||
					req.getPROCESS_ID().equals("ET4")) {
				
    			// QC-2/QC-3/QC-4のいづれか最後に承認した場合
    			// 作業手順マスタ取得
            	url= rest_workmst+"select";
        	 	List<WORK_MASTER> list = getRest(url, WORK_MASTER.class);
        	 	WORK_MASTER ET2_wm = null;
        	 	WORK_MASTER ET3_wm = null;
        	 	WORK_MASTER ET4_wm = null;
        	 	for(WORK_MASTER wm : list) {
        	 		if(wm.getPROCESS_ID().equals("ET2")) {
        	 			ET2_wm = wm;
        	 		}
        	 		if(wm.getPROCESS_ID().equals("ET3")) {
        	 			ET3_wm = wm;
        	 		}
        	 		if(wm.getPROCESS_ID().equals("ET4")) {
        	 			ET4_wm = wm;
        	 		}
        	 	}
        	 	
        	 	// 作業実績取得
        	 	boolean ET2end = false;
        	 	if(ET2_wm!=null) {
                    // 作業実績取得
                    List<WORK_RESULT_TABLE> et2_workresult = 
                    		getWorkResult(ET2_wm.getWORK_GROUP(), ET2_wm.getWORK_ID(), req.getID());
                    if(et2_workresult.size()>0) {
                    	ET2end = true;
                    }
        	 	}
        	 	boolean ET3end = false;
        	 	if(ET3_wm!=null) {
                    // 作業実績取得
                    List<WORK_RESULT_TABLE> et3_workresult = 
                    		getWorkResult(ET3_wm.getWORK_GROUP(), ET3_wm.getWORK_ID(), req.getID());
                    if(et3_workresult.size()>0) {
                    	ET3end = true;
                    }
        	 	}
        	 	boolean ET4end = false;
        	 	if(ET4_wm!=null) {
                    // 作業実績取得
                    List<WORK_RESULT_TABLE> et4_workresult = 
                    		getWorkResult(ET4_wm.getWORK_GROUP(), ET4_wm.getWORK_ID(), req.getID());
                    if(et4_workresult.size()>0) {
                    	ET4end = true;
                    }
        	 	}
        	 	
        	 	// すべて完了の場合
        	 	if(ET2end && ET3end && ET4end) {
            		// 指図のステータス、終了日時更新
        	 		INSTRUCTIONS_TABLE insdata = new INSTRUCTIONS_TABLE();
        	 		insdata.setBATCH_ID(req.getID());
        	 		insdata.setSTATUS("I04");
        	 		insdata.setFINISH_TIME(super.getWorkDate());
        	 		url = rest_instructions+"update";
                	postRest(url, insdata);
        	 	}
        	 	
			}
        }
		
		return result ? "OK" : "NG";
    }
    
    /*
     * 作業実績登録
     * 引数：Json形式
     */
    @RequestMapping(value = "/ajax/workresult_regist", 
    		consumes = "application/json",
    		method = RequestMethod.POST)
    @ResponseBody
    public String workresult_regist(@RequestBody WORK_RESULT_TABLE req) {
    	
        String url = "";
        WORK_RESULT_TABLE data = req;
        
        // 作業実績取得
        List<WORK_RESULT_TABLE> list = 
        		getWorkResult(req.getWORK_GROUP(),req.getWORK_ID(), req.getID());
        
        if(list.size()>0) {
        	
        	// 作業実績更新
        	WORK_RESULT_TABLE oldwrt = list.get(0);
        	data.setWORK_RESULT_NO(oldwrt.getWORK_RESULT_NO());
        	url = rest_workresult+"update";
        	
        }else {
        	
        	// 作業実績登録
        	
            // タイムスタンプ取得
            String timestamp = getTimeStamp();
            String new_work_no = createWorkResultNo(timestamp);
            
            // 作業実績登録
            data.setWORK_RESULT_NO(new_work_no);
            url = rest_workresult+"insert";
        }
        
        return postRest(url, data) ? "OK": "NG";
        
    }
    
    /*
     * Kit Label 発行
     */
    @GetMapping("/ajax/make_kit_label")
    public String make_kit_label() {
    	return makeKitLabel();
    }
    
    /*
     * マテリアル一覧取得
     */
    @GetMapping("/ajax/get_material_list")
    public String get_material_list(
    		@RequestParam(param_batch_id) String batch_id,
    		@RequestParam(param_process_id) String process_id,
    		@RequestParam(param_work_group) String work_group) {
    	
    	String json = "{}";
    	
    	// 製造指図テーブル取得
    	String url= rest_instructions+"select"+
				"?"+ param_batch_id+"="+batch_id;
	 	List<INSTRUCTIONS_TABLE> list1 = getRest(url, INSTRUCTIONS_TABLE.class);
	 	
	 	if(list1.size()>0) {
	 		String im_id = list1.get(0).getIM_ID();
	 		// 受入指図連携テーブル取得
	 		url= rest_airelation+"select"+
					"?"+ param_im_id+"="+im_id+
					"&"+ param_process_id+"="+process_id;
		 	List<AI_RELATION_TABLE> list2 = getRest(url, AI_RELATION_TABLE.class);
		 	if(list2.size()>0) {

		 		Map<String ,Object> map = new HashMap<String ,Object>();
		 		for(AI_RELATION_TABLE art : list2) {
			 		String material_no = art.getMATERIAL_NO();
			 		// 受入テーブル取得
			 		url= rest_accept+"select"+
							"?"+ param_material_no+"="+material_no;
			 		List<ACCEPT_TABLE> list3 = getRest(url, ACCEPT_TABLE.class);
			 		if(list3.size()>0) {
			 			ACCEPT_TABLE ac = list3.get(0);
			 			if(!map.containsKey(ac.getMATERIAL_NO())) {
			 				map.put(ac.getMATERIAL_NO(), ac);
			 			}
			 		}
		 		}
		 		
		 		json = getJson(map);
		 	}
	 	}
	 	
        return json;
    }
    
    /*
     * 実施対象マテリアル一覧取得
     */
    @GetMapping("/ajax/get_exec_material_list")
    public List<String> get_exec_material_list(
    		@RequestParam(param_batch_id) String batch_id) {
    	
    	List<String> rtn = new ArrayList<String>();
    	
    	// 製造指図テーブル取得
    	String url= rest_instructions+"select"+
				"?"+ param_batch_id+"="+batch_id;
	 	List<INSTRUCTIONS_TABLE> list1 = getRest(url, INSTRUCTIONS_TABLE.class);
	 	
	 	if(list1.size()>0) {
	 		String im_id = list1.get(0).getIM_ID();
	 		// 指図指図マスタ取得
	 		url= rest_instructionsmst+"select"+
					"?"+ param_im_id+"="+im_id;
		 	List<INSTRUCTIONS_MASTER> list2 = getRest(url, INSTRUCTIONS_MASTER.class);
		 	if(list2.size()>0) {

		 		String mg_id = list2.get(0).getMATERIAL_GORUP_ID();
		 		// 指図指図マスタ取得
		 		url= rest_materialgroup+"select"+
						"?"+ param_material_group_id+"="+mg_id;
			 	List<MATERIAL_GROUP_TABLE> list3 = getRest(url, MATERIAL_GROUP_TABLE.class);
			 	if(list3.size()>0) {
			 		for(MATERIAL_GROUP_TABLE mgt : list3) {
			 			rtn.add(mgt.getMATERIAL_NO());
			 		}
			 	}
		 	}
	 	}
	 	
        return rtn;
    }
    
    /*
     * 承認一覧取得
     */
    @GetMapping("/ajax/get_applist")
    public List<WORK_RESULT_TABLE> get_applist(
    		@RequestParam(param_work_group) String work_group,
    		@RequestParam(param_batch_id) String batch_id) {
    	
    	List<WORK_RESULT_TABLE> list = new ArrayList<WORK_RESULT_TABLE>();
    	
        // 作業グループ取得
    	WORK_GROUP_MASTER wg1 = getWorkGroup(work_group);
    	
    	// 作業実績取得
        List<WORK_RESULT_TABLE> list1 = 
        		getWorkResult(work_group, "", batch_id);
        
        // 前作業グループ取得(Confirm)
        if(wg1.getBEFORE_WORK_GROUP() != null &&
        		!wg1.getBEFORE_WORK_GROUP().isEmpty()) {
        	
        	// 前作業グループの作業実績取得
            List<WORK_RESULT_TABLE> list2 = 
            		getWorkResult(wg1.getBEFORE_WORK_GROUP(), "", batch_id);
            
        	WORK_GROUP_MASTER wg2 = getWorkGroup(wg1.getBEFORE_WORK_GROUP());
        	
        	// 前前作業グループ取得(工程最後の作業グループ)
        	if(wg2.getBEFORE_WORK_GROUP() != null &&
            		!wg2.getBEFORE_WORK_GROUP().isEmpty()) {
        		
            	// 前前作業グループの作業実績取得
                List<WORK_RESULT_TABLE> list3 = 
                		getWorkResult(wg2.getBEFORE_WORK_GROUP(), "", batch_id);
                
                if(list3.size()>0) {
                	list.add(list3.get(list3.size()-1));
                }
        	}
        	
        	if(list2.size()>0) {
            	list.add(list2.get(0));
            }
        }
        
        if(list1.size()>0) {
        	list.add(list1.get(0));
        }
        
    	return list;
    }
    
    /*
     * 指図作成
     * 引数：Json形式
     */
    @RequestMapping(value = "/ajax/create_instructions", 
    		consumes = "application/json",
    		method = RequestMethod.POST)
    @ResponseBody
    public String create_instructions(@RequestBody String req) {
    	
        String url = "";
        Map<String ,Object> map = getMap(req.toString());
        String im_id = map.get("IM_ID").toString();
        
 		// 指図指図マスタ取得
 		url= rest_instructionsmst+"select"+
				"?"+ param_im_id+"="+im_id;
	 	List<INSTRUCTIONS_MASTER> list = getRest(url, INSTRUCTIONS_MASTER.class);
	 	if(list.size()>0) {
	 		INSTRUCTIONS_MASTER mst = list.get(0);
	 		// 指図作成
	 		INSTRUCTIONS_TABLE data = new INSTRUCTIONS_TABLE();
	 		String batch_id = getBatchID();
	 		data.setBATCH_ID(batch_id);
	 		data.setIM_ID(im_id);
	 		data.setNAME(mst.getNAME());
	 		data.setPROTOCOL(mst.getPROTOCOL());
	 		data.setSTATUS("I01");
	 		url= rest_instructions+"insert";
	 		if(!postRest(url, data)) {
	 			return "NG";
	 		}else {
	 			// 工程別ステータス登録
	 			url= rest_processmst+"select";
	 		 	List<PROCESS_MASTER> list2 = getRest(url, PROCESS_MASTER.class);
	 		 	for(PROCESS_MASTER pm : list2) {
	 		 		String init_status = "";
	 		 		if(pm.getPROCESS_ID().indexOf("EP")>=0) {
	 		 			init_status = "P01";
	 		 		}
	 		 		if(pm.getPROCESS_ID().indexOf("ET")>=0) {
	 		 			init_status = "T01";
	 		 		}
	 		 		if(pm.getPROCESS_ID().indexOf("BR")>=0) {
	 		 			init_status = "B01";
	 		 		}
	 		 		
	 		 		PROCESS_STATUS_TABLE pst = new PROCESS_STATUS_TABLE();
	 		 		pst.setBATCH_ID(batch_id);
	 		 		pst.setPROCESS_ID(pm.getPROCESS_ID());
	 		 		pst.setSTATUS(init_status);
	 		 		
	 		 		url= rest_processstatus+"insert";
	 		 		if(!postRest(url, pst)) {
	 		 			return "NG";
	 		 		}
	 		 	}
	 		 	
	 	        // ユーザ情報取得
	 	        USER_MASTER user = super.getUserInfo();
	 	        
	 	        // 作業実績登録
	 	        WORK_RESULT_TABLE wrt = new WORK_RESULT_TABLE();
	 	        wrt.setPROCESS_ID("IS");
	 	        wrt.setWORK_GROUP("IS01");
	 	        wrt.setWORK_ID("001");
	 	        wrt.setID(batch_id);
	 	        wrt.setWORK_USERID(user.getUSERID());
	 	        wrt.setWORK_USERNAME(user.getUSERNAME());
	 	        wrt.setWORK_DATE(getWorkDate());
	 	        
	 	        String rst = workresult_regist(wrt);
	 	        if(!rst.equals("OK")) {
	 	        	return "NG";
	 	        }
	 		}
	 	}
        
        return "OK";
        
    }
    
    /*
     * 指図リリース
     * 引数：Json形式
     */
    @RequestMapping(value = "/ajax/release_instructions", 
    		consumes = "application/json",
    		method = RequestMethod.POST)
    @ResponseBody
    public String release_instructions(@RequestBody String req) {
    	
        String url = "";
        Map<String ,Object> map = getMap(req.toString());
        String batch_id = map.get("BATCH_ID").toString();
        
 		// 指図指図マスタ取得
 		url= rest_instructions+"select"+
				"?"+ param_batch_id+"="+batch_id;
	 	List<INSTRUCTIONS_TABLE> list = getRest(url, INSTRUCTIONS_TABLE.class);
	 	if(list.size()>0) {
	 		
	 		INSTRUCTIONS_TABLE data = list.get(0);
	 		data.setSTATUS("I02");
	 		url= rest_instructions+"update";
	 		if(!postRest(url, data)) {
	 			return "NG";
	 		}else {
	 		// ユーザ情報取得
	 	        USER_MASTER user = super.getUserInfo();
	 	        
	 	        // 作業実績登録
	 	        WORK_RESULT_TABLE wrt = new WORK_RESULT_TABLE();
	 	        wrt.setPROCESS_ID("IS");
	 	        wrt.setWORK_GROUP("IS02");
	 	        wrt.setWORK_ID("001");
	 	        wrt.setID(batch_id);
	 	        wrt.setWORK_USERID(user.getUSERID());
	 	        wrt.setWORK_USERNAME(user.getUSERNAME());
	 	        wrt.setWORK_DATE(getWorkDate());
	 	        
	 	        String rst = workresult_regist(wrt);
	 	        if(!rst.equals("OK")) {
	 	        	return "NG";
	 	        }
	 		}
	 	}
        
        return "OK";
        
    }
    
    /*
     * マテリアルチェック登録
     * 引数：Json形式
     */
    @RequestMapping(value = "/ajax/material_check", 
    		consumes = "application/json",
    		method = RequestMethod.POST)
    @ResponseBody
    public String material_check(@RequestBody List<MATERIAL_CHECK_TABLE> req) {
    	
        String url = rest_materialcheck+"insert";
        USER_MASTER user = super.getUserInfo();
        String timestamp = getWorkDate();
        
        for(MATERIAL_CHECK_TABLE data : req) {
        	
        	data.setCHECK_USERID(user.getUSERID());
        	data.setCHECK_USERNAME(user.getUSERNAME());
        	data.setCHECK_DATE(timestamp);
        	
        	url= rest_materialcheck+"insert";
	 		if(!postRest(url, data)) {
	 			return "NG";
	 		}
        }
        
        return "OK";
        
    }
    
    /*
     * 工程別指図詳細データ取得
     */
    @GetMapping("/ajax/get_procdetail")
    public List<PROC_INSTRUCTIONS_DETAIL_MASTER> get_procdetail(
    		@RequestParam(param_im_id) String im_id,
    		@RequestParam(param_ins_proc_id) String ins_proc_id) {
    	
    	// 工程別指図詳細マスタ取得
    	String url = rest_procinstructionsdetailmst+"select"+
				"?"+ param_im_id+"="+im_id+
				"&"+ param_ins_proc_id+"="+ins_proc_id;
	 	List<PROC_INSTRUCTIONS_DETAIL_MASTER> list = 
	 			getRest(url, PROC_INSTRUCTIONS_DETAIL_MASTER.class);
	 	for(PROC_INSTRUCTIONS_DETAIL_MASTER pim : list) {
	 		if(pim.getCAPTURE()!=null && !pim.getCAPTURE().isEmpty()) {
	 			String base64 = get_base64(super.getProperties().getIST_PROC_DETAIL_PATH(), pim.getCAPTURE());
	 			pim.setCAPTURE(base64);
	 		}
	 	}
    	
    	return list;
    }
   
    // 以下デバッグ用
    
    
    @GetMapping("/ajax/pdf_test")
    public void pdf_test() {

    	
    	  String DEST = "C:/cpc/hello.pdf";
    	  try {
    		  
    		   Document doc = new Document();
    		   PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(DEST)); 
    		   //setting font family, color
    		   Font font = new Font(Font.NORMAL, 16, Font.BOLDITALIC, Color.RED);
    		   doc.open();
    		   Paragraph para = new Paragraph("Hello! This PDF is created using openPDF", font);
    		   doc.add(para);
    		   doc.close();
    		   writer.close(); 
    		   

    	  } catch (Exception e) {
    	   // TODO Auto-generated catch block
    	   e.printStackTrace();
    	  }   
        
    }
    
    @GetMapping("/preview")
    public void preview(HttpServletRequest request, HttpServletResponse response) {
    	
    	// PDF file address
        File file = new File ("C:/cpc/compressed.tracemonkey-pldi-09.pdf");
		if (file.exists()) {
		   byte[] data = null;
		   FileInputStream input=null;
		   try {
		       input= new FileInputStream(file);
		       data = new byte[input.available()];
		       input.read(data);
		       response.getOutputStream().write(data);
		   } catch (Exception e) {
		      e.printStackTrace();
		   }finally{
		       try {
		           if(input!=null){
		               input.close();
		           }
		       } catch (IOException e) {
		           e.printStackTrace();
		       }
		   }
		}
    }
    
    @GetMapping("/viewer")
    public String viewer() {
    	
    	return "redirect:/instructions/js/pdfjs/web/viewer";
    }
    
}

