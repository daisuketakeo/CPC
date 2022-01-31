package com.cpc.viewcontroller;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
     * ステータスチェック（ボタンの有効／無効セット）
     */
    @GetMapping("/ajax/check_status")
    public boolean check_status(
    		@RequestParam(param_work_group) String work_group,
    		@RequestParam(param_work_id) String work_id,
    		@RequestParam(param_id) String id) {
    	
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
                	return false;
                }else {
                	WORK_RESULT_TABLE wrt = before_workresult.get(0);
                	// 前作業未完了(実施ユーザ=NULL)ならボタン無効
                	if(wrt.getWORK_USERID() == null) {
                    	return false;
                    }
                	if(wrt.getWORK_USERID().isEmpty()) {
                    	return false;
                    }
                }
        	}
    	}catch(Exception e) {
    		// 例外発生 ボタン無効
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
        if(req.getPROCESS_ID().equals(qc) || req.getPROCESS_ID().equals(qa)) {
        	
        	// 受入の場合
        	if(result) {
        		
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
            		
            		// 作業実績登録OK & 対象作業グループ完了 なら受入のステータス更新
            		String status_code = getStatus(req.getWORK_GROUP());
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
     * 作業実績登録
     * 引数：Json形式
     */
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
    
    /*
     * Kit Label 発行
     */
    @GetMapping("/ajax/make_kit_label")
    public String make_kit_label() {
    	return makeKitLabel();
    }
    
    
    
    
    // 以下デバッグ用
    
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

