﻿package com.cpc.viewcontroller;

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
import com.cpc.model.MATERIAL_GROUP_TABLE;
import com.cpc.model.PROCESS_STATUS_TABLE;
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
        		String base64 = get_base64(wm.getCAPTURE1());
        		wm.setCAPTURE1(base64);
        	}
        	if(wm.getCAPTURE2()!=null && !wm.getCAPTURE2().isBlank()) {
        		String base64 = get_base64(wm.getCAPTURE2());
        		wm.setCAPTURE2(base64);
        	}
        	if(wm.getCAPTURE3()!=null && !wm.getCAPTURE3().isEmpty()) {
        		String base64 = get_base64(wm.getCAPTURE3());
        		wm.setCAPTURE3(base64);
        	}
        	if(wm.getCAPTURE4()!=null && !wm.getCAPTURE4().isEmpty()) {
        		String base64 = get_base64(wm.getCAPTURE4());
        		wm.setCAPTURE4(base64);
        	}
        	if(wm.getCAPTURE5()!=null && !wm.getCAPTURE5().isEmpty()) {
        		String base64 = get_base64(wm.getCAPTURE5());
        		wm.setCAPTURE5(base64);
        	}
        	
        	// CSVファイルをリスト形式に変換して取得
        	if(wm.getCSV1()!=null && !wm.getCSV1().isEmpty()) {
        		String csv = get_csv(wm.getCSV1());
        		wm.setCSV1(csv);
        	}
        	if(wm.getCSV2()!=null && !wm.getCSV2().isEmpty()) {
        		String csv = get_csv(wm.getCSV2());
        		wm.setCSV2(csv);
        	}
        	if(wm.getCSV3()!=null && !wm.getCSV3().isEmpty()) {
        		String csv = get_csv(wm.getCSV3());
        		wm.setCSV3(csv);
        	}
        	if(wm.getCSV4()!=null && !wm.getCSV4().isEmpty()) {
        		String csv = get_csv(wm.getCSV4());
        		wm.setCSV4(csv);
        	}
        	if(wm.getCSV5()!=null && !wm.getCSV5().isEmpty()) {
        		String csv = get_csv(wm.getCSV5());
        		wm.setCSV5(csv);
        	}
        }
        
    	return list;
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
        		// 操作権限なしならボタン無効
//        		System.out.println("["+work_group+"]["+work_id+"]["+id+"]:操作権限なし");
            	return false;
        	}
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
        	}
        }else {
        	
        	// 指図の場合
        	
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
    	
    	String json = "";
    	
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

