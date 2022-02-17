package com.cpc.viewcontroller;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
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
    public boolean isapp(
    		@RequestParam(param_process_id) String process_id,
    		HttpServletRequest request,
    		HttpServletResponse response) { 
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return false;
    	}
    	
    	if(process_id.equals("ET2") ||
    			process_id.equals("ET3") ||
    			process_id.equals("ET4")) {
    		return super.isQA();
    	}
    	
    	return super.isCP_Admin();
    }
    
    /*
     * EBR試験の画像ファイル／CSVファイル内容取得
     */
    @GetMapping("/ajax/get_ebrtest")
    public List<WORK_MASTER> get_ebrtestdir(
    		@RequestParam(param_work_group) String work_group,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return null;
    	}
    	
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
     * 処理シーケンス情報取得
     */
    @GetMapping("/ajax/get_sequence")
    public Map<String,String> get_sequence(
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return null;
    	}
    	
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
     * Cellqualia top情報取得
     */
    @GetMapping("/ajax/get_cellqualia_top")
    public Map<String,String> get_cellqualia_top(
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return null;
    	}
    	
    	String dir = super.getProperties().getCELLQUALIA_TOP_PATH();
    	
    	String AUTOTRANS = super.getProperties().getCELLQUALIA_TOP_AUTOTRANS();
    	
    	String LOGO = super.getProperties().getCELLQUALIA_TOP_LOGO();
    	String MACHINE_STATUS_SUMMARY = super.getProperties().getCELLQUALIA_TOP_MACHINE_STATUS_SUMMARY();
    	String TOP = super.getProperties().getCELLQUALIA_TOP_TOP();
    	String FINISHED = super.getProperties().getCELLQUALIA_TOP_FINISHED();
    	String ALARMS = super.getProperties().getCELLQUALIA_TOP_ALARMS();
    	String MAINTENANCE = super.getProperties().getCELLQUALIA_TOP_MAINTENANCE();
    	String PRE_BATCH = super.getProperties().getCELLQUALIA_TOP_PRE_BATCH();
    	String BATCH_PROGRESS = super.getProperties().getCELLQUALIA_TOP_BATCH_PROGRESS();
    	String POST_BATCH_STANDALONE = super.getProperties().getCELLQUALIA_TOP_POST_BATCH_STANDALONE();
    	String POST_BATCH_ENTERPRISE = super.getProperties().getCELLQUALIA_TOP_POST_BATCH_ENTERPRISE();
    	String BATCH_LIST = super.getProperties().getCELLQUALIA_TOP_BATCH_LIST();
    	String DELIVERY = super.getProperties().getCELLQUALIA_TOP_DELIVERY();
    	String COSTS = super.getProperties().getCELLQUALIA_TOP_COSTS();
    	String LOG_ANALYSIS = super.getProperties().getCELLQUALIA_TOP_LOG_ANALYSIS();

    	Map<String,String> map = new HashMap<String,String>(){
    		{
    			put("AUTOTRANS"              ,AUTOTRANS );
    			put("LOGO"                   ,get_base64(dir, LOGO) );
    			put("MACHINE_STATUS_SUMMARY" ,get_base64(dir, MACHINE_STATUS_SUMMARY) );
    			put("TOP"                    ,get_base64(dir, TOP) );
    			put("FINISHED"               ,get_base64(dir, FINISHED) );
    			put("ALARMS"                 ,get_base64(dir, ALARMS) );
    			put("MAINTENANCE"            ,get_base64(dir, MAINTENANCE) );
    			put("PRE_BATCH"              ,get_base64(dir, PRE_BATCH) );
    			put("BATCH_PROGRESS"         ,get_base64(dir, BATCH_PROGRESS) );
    			put("POST_BATCH_STANDALONE"  ,get_base64(dir, POST_BATCH_STANDALONE) );
    			put("POST_BATCH_ENTERPRISE"  ,get_base64(dir, POST_BATCH_ENTERPRISE) );
    			put("BATCH_LIST"             ,get_base64(dir, BATCH_LIST) );
    			put("DELIVERY"               ,get_base64(dir, DELIVERY) );
    			put("COSTS"                  ,get_base64(dir, COSTS) );
    			put("LOG_ANALYSIS"           ,get_base64(dir, LOG_ANALYSIS) );
    		}
    	};
    	
    	return map;
    }
    
    /*
     * Batch progressのCSVファイル内容／画像ファイル取得
     */
    @GetMapping("/ajax/get_progress_batch")
    public INSTRUCTIONS_MASTER get_progress_batch(
    		@RequestParam(param_batch_id) String batch_id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return null;
    	}
    	
    	String csvdir = super.getProperties().getBATCH_PROGRESS_CSV_PATH();
    	String url = "";
    	
 		url = rest_instructions+"select?BATCH_ID="+batch_id;
	 	List<INSTRUCTIONS_TABLE> list = getRest(url, INSTRUCTIONS_TABLE.class);
	 	if(list.size()>0) {
	 		url = rest_instructionsmst+"select?IM_ID="+list.get(0).getIM_ID();
		 	List<INSTRUCTIONS_MASTER> list2 = getRest(url, INSTRUCTIONS_MASTER.class);
		 	if(list2.size()>0) {
		 		INSTRUCTIONS_MASTER im = list2.get(0);
		 		
		 		// 各種CSVファイル取得
		 		if(im.getBP_ALERM()!=null && !im.getBP_ALERM().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_ALERM());
		 			im.setBP_ALERM(csv);
	        	}
		 		if(im.getBP_WARNING()!=null && !im.getBP_WARNING().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_WARNING());
		 			im.setBP_WARNING(csv);
	        	}
	        	if(im.getBP_HEADER()!=null && !im.getBP_HEADER().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_HEADER());
		 			im.setBP_HEADER(csv);
	        	}
	        	if(im.getBP_PH_OVER_TIME()!=null && !im.getBP_PH_OVER_TIME().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_PH_OVER_TIME());
		 			im.setBP_PH_OVER_TIME(csv);
	        	}
	        	if(im.getBP_GLUCOSE_OVER_TIME()!=null && !im.getBP_GLUCOSE_OVER_TIME().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_GLUCOSE_OVER_TIME());
		 			im.setBP_GLUCOSE_OVER_TIME(csv);
	        	}
	        	if(im.getBP_LACTATE_OVER_TIME()!=null && !im.getBP_LACTATE_OVER_TIME().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_LACTATE_OVER_TIME());
		 			im.setBP_LACTATE_OVER_TIME(csv);
	        	}
	        	if(im.getBP_GROWTH_RATE_OVER_TIME()!=null && !im.getBP_GROWTH_RATE_OVER_TIME().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_GROWTH_RATE_OVER_TIME());
		 			im.setBP_GROWTH_RATE_OVER_TIME(csv);
	        	}
	        	if(im.getBP_ORVER_VIEW()!=null && !im.getBP_ORVER_VIEW().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_ORVER_VIEW());
		 			im.setBP_ORVER_VIEW(csv);
	        	}
	        	if(im.getBP_IDENTIFICATION()!=null && !im.getBP_IDENTIFICATION().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_IDENTIFICATION());
		 			im.setBP_IDENTIFICATION(csv);
	        	}
	        	if(im.getBP_CULTURE_CONDITION()!=null && !im.getBP_CULTURE_CONDITION().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_CULTURE_CONDITION());
		 			im.setBP_CULTURE_CONDITION(csv);
	        	}
	        	if(im.getBP_DETAIL()!=null && !im.getBP_DETAIL().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getBP_DETAIL());
		 			im.setBP_DETAIL(csv);
	        	}
	        	
	        	//　画像ファイル取得
	        	if(im.getBP_CAMERA_VISION()!=null && !im.getBP_CAMERA_VISION().isEmpty()) {
		 			String capture = super.getCameaVisionCapture(im.getBP_CAMERA_VISION());
		 			im.setBP_CAMERA_VISION(capture);
	        	}
	        	
	        	return im;
		 	}
	 	}
        
    	return new INSTRUCTIONS_MASTER();
    }
    
    /*
     * Post-batch overviewのCSVファイル内容取得
     */
    @GetMapping("/ajax/get_post_batch")
    public INSTRUCTIONS_MASTER get_post_batch(
    		@RequestParam(param_batch_id) String batch_id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return null;
    	}
    	
    	String csvdir = super.getProperties().getPOST_BATCH_OVERVIEW_PATH();
    	String url = "";
    	
 		url = rest_instructions+"select?BATCH_ID="+batch_id;
	 	List<INSTRUCTIONS_TABLE> list = getRest(url, INSTRUCTIONS_TABLE.class);
	 	if(list.size()>0) {
	 		url = rest_instructionsmst+"select?IM_ID="+list.get(0).getIM_ID();
		 	List<INSTRUCTIONS_MASTER> list2 = getRest(url, INSTRUCTIONS_MASTER.class);
		 	if(list2.size()>0) {
		 		INSTRUCTIONS_MASTER im = list2.get(0);
		 		
		 		// 各種CSVファイル取得
		 		if(im.getPOB_ICP()!=null && !im.getPOB_ICP().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPOB_ICP());
		 			im.setPOB_ICP(csv);
	        	}
	        	if(im.getPOB_ICP_SUMMARY()!=null && !im.getPOB_ICP_SUMMARY().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPOB_ICP_SUMMARY());
		 			im.setPOB_ICP_SUMMARY(csv);
	        	}
	        	if(im.getPOB_ICP_MICROBIOLOGICAL_STERILITY()!=null && !im.getPOB_ICP_MICROBIOLOGICAL_STERILITY().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPOB_ICP_MICROBIOLOGICAL_STERILITY());
		 			im.setPOB_ICP_MICROBIOLOGICAL_STERILITY(csv);
	        	}
	        	if(im.getPOB_ICP_KARYOTYPE_RESULTS()!=null && !im.getPOB_ICP_KARYOTYPE_RESULTS().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPOB_ICP_KARYOTYPE_RESULTS());
		 			im.setPOB_ICP_KARYOTYPE_RESULTS(csv);
	        	}
	        	if(im.getPOB_ICP_PTENCY()!=null && !im.getPOB_ICP_PTENCY().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPOB_ICP_PTENCY());
		 			im.setPOB_ICP_PTENCY(csv);
	        	}
	        	if(im.getPOB_ICP_MATERIAL_OVERVIEW()!=null && !im.getPOB_ICP_MATERIAL_OVERVIEW().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPOB_ICP_MATERIAL_OVERVIEW());
		 			im.setPOB_ICP_MATERIAL_OVERVIEW(csv);
	        	}
	        	if(im.getPOB_ICP_MATERIAL_IDENTIFICATION()!=null && !im.getPOB_ICP_MATERIAL_IDENTIFICATION().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPOB_ICP_MATERIAL_IDENTIFICATION());
		 			im.setPOB_ICP_MATERIAL_IDENTIFICATION(csv);
	        	}
	        	if(im.getPOB_ICP_CULTURE_CONDITION()!=null && !im.getPOB_ICP_CULTURE_CONDITION().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPOB_ICP_CULTURE_CONDITION());
		 			im.setPOB_ICP_CULTURE_CONDITION(csv);
	        	}
	        	
	        	return im;
		 	}
	 	}
        
    	return new INSTRUCTIONS_MASTER();
    }
    
    /*
     * Post-batch overviewのPDFダウンロード
     */
    @GetMapping("/ajax/postbopdf_download")
    public void postbopdf_download(
    		@RequestParam(param_batch_id) String batch_id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return;
    	}
    	
    	String url = "";
    	String dir = super.getProperties().getPOST_BATCH_OVERVIEW_PATH();
    	
 		url = rest_instructions+"select?BATCH_ID="+batch_id;
	 	List<INSTRUCTIONS_TABLE> list = getRest(url, INSTRUCTIONS_TABLE.class);
	 	if(list.size()>0) {
	 		url = rest_instructionsmst+"select?IM_ID="+list.get(0).getIM_ID();
		 	List<INSTRUCTIONS_MASTER> list2 = getRest(url, INSTRUCTIONS_MASTER.class);
		 	if(list2.size()>0) {
		 		INSTRUCTIONS_MASTER im = list2.get(0);
		 		super.download(dir, im.getPOB_ELECTRONIC_BATCH_RECORD(), response);
		 	}
	 	}
    }
    
    /*
     * Post-batch overviewのVideoダウンロード
     */
    @GetMapping("/ajax/postbovideo_download")
    public void postbovideo_download(
    		@RequestParam(param_batch_id) String batch_id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return;
    	}
    	
    	String url = "";
    	String dir = super.getProperties().getPOST_BATCH_OVERVIEW_PATH();
    	
 		url = rest_instructions+"select?BATCH_ID="+batch_id;
	 	List<INSTRUCTIONS_TABLE> list = getRest(url, INSTRUCTIONS_TABLE.class);
	 	if(list.size()>0) {
	 		url = rest_instructionsmst+"select?IM_ID="+list.get(0).getIM_ID();
		 	List<INSTRUCTIONS_MASTER> list2 = getRest(url, INSTRUCTIONS_MASTER.class);
		 	if(list2.size()>0) {
		 		INSTRUCTIONS_MASTER im = list2.get(0);
		 		super.download(dir, im.getPOB_CELL_GROWTH_VIDEO(), response);
		 	}
	 	}
    }
    
    /*
     * Pre-batch overviewのCSVファイル内容取得
     */
    @GetMapping("/ajax/get_pre_batch")
    public INSTRUCTIONS_MASTER get_pre_batch(
    		@RequestParam(param_batch_id) String batch_id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return null;
    	}
    	
    	String csvdir = super.getProperties().getPRE_BATCH_OVERVIEW_PATH();
    	String url = "";
    	
 		url = rest_instructions+"select?BATCH_ID="+batch_id;
	 	List<INSTRUCTIONS_TABLE> list = getRest(url, INSTRUCTIONS_TABLE.class);
	 	if(list.size()>0) {
	 		url = rest_instructionsmst+"select?IM_ID="+list.get(0).getIM_ID();
		 	List<INSTRUCTIONS_MASTER> list2 = getRest(url, INSTRUCTIONS_MASTER.class);
		 	if(list2.size()>0) {
		 		INSTRUCTIONS_MASTER im = list2.get(0);
		 		
		 		// 各種CSVファイル取得
		 		if(im.getPRB_ICP_MATERIAL_OVERVIEW()!=null && !im.getPRB_ICP_MATERIAL_OVERVIEW().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPRB_ICP_MATERIAL_OVERVIEW());
		 			im.setPRB_ICP_MATERIAL_OVERVIEW(csv);
	        	}
	        	if(im.getPRB_ICP_MATERIAL_IDENTIFICATION()!=null && !im.getPRB_ICP_MATERIAL_IDENTIFICATION().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPRB_ICP_MATERIAL_IDENTIFICATION());
		 			im.setPRB_ICP_MATERIAL_IDENTIFICATION(csv);
	        	}
	        	if(im.getPRB_ICP_CULTURE_CONDITION()!=null && !im.getPRB_ICP_CULTURE_CONDITION().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPRB_ICP_CULTURE_CONDITION());
		 			im.setPRB_ICP_CULTURE_CONDITION(csv);
	        	}
	        	if(im.getPRB_ICP_ALERM()!=null && !im.getPRB_ICP_ALERM().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPRB_ICP_ALERM());
		 			im.setPRB_ICP_ALERM(csv);
	        	}
	        	if(im.getPRB_ICP_WARNINGS()!=null && !im.getPRB_ICP_WARNINGS().isEmpty()) {
		 			String csv = get_csv(csvdir, im.getPRB_ICP_WARNINGS());
		 			im.setPRB_ICP_WARNINGS(csv);
	        	}
	        	
	        	return im;
		 	}
	 	}
        
    	return new INSTRUCTIONS_MASTER();
    }
    
    /*
     * 操作権限チェック
     */
    @GetMapping("/ajax/check_operation_authority")
    public boolean check_operation_authority(
    		@RequestParam(param_work_group) String work_group,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return false;
    	}

        // 作業手順マスタ取得
        List<WORK_MASTER> target_workmst = 
        		getWorkMaster(work_group);
        if(target_workmst.size()>0) {
        	WORK_MASTER wm = target_workmst.get(0);
        	String[] auth_arry = wm.getAUTHORITY().split(",");
        	boolean exec = false;
        	USER_MASTER user = super.getUserInfo();
        	if(user==null || user.getUSERID() ==null) return false;
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
    		@RequestParam(param_id) String id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return false;
    	}
    	
    	/**********************************
    	 *       操作権限チェック
    	 **********************************/
        // 作業手順マスタ取得
        if(!check_operation_authority(work_group,request,response)) {
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
    	
    	// batch release の場合
    	if(work_group.indexOf("BR")>=0) {
    		
    		// QC-2/QC-3/QC-4のいづれか最後に承認した場合
			// 作業手順マスタ取得
        	String url= rest_workmst+"select";
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
                		getWorkResult(ET2_wm.getWORK_GROUP(), ET2_wm.getWORK_ID(), id);
                if(et2_workresult.size()>0) {
                	ET2end = true;
                }
    	 	}
    	 	boolean ET3end = false;
    	 	if(ET3_wm!=null) {
                // 作業実績取得
                List<WORK_RESULT_TABLE> et3_workresult = 
                		getWorkResult(ET3_wm.getWORK_GROUP(), ET3_wm.getWORK_ID(), id);
                if(et3_workresult.size()>0) {
                	ET3end = true;
                }
    	 	}
    	 	boolean ET4end = false;
    	 	if(ET4_wm!=null) {
                // 作業実績取得
                List<WORK_RESULT_TABLE> et4_workresult = 
                		getWorkResult(ET4_wm.getWORK_GROUP(), ET4_wm.getWORK_ID(), id);
                if(et4_workresult.size()>0) {
                	ET4end = true;
                }
    	 	}
    	 	
    	 	// 未完了があった場合
    	 	if(!ET2end || !ET3end || !ET4end) {
    	 		return false;
    	 	}
    	 	
    	}
        
        return true;
    }
    
    /*
     * ステータスチェック（ボタンの有効／無効セット）
     */
    @GetMapping("/ajax/check_status_qc")
    public boolean check_status_qc(
    		@RequestParam(param_batch_id) String batch_id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return false;
    	}
    	
    	/**********************************
    	 *       操作権限チェック
    	 **********************************/
        // 作業手順マスタ取得
        if(!isQA()) {
        	return false;
        }

        // QC-2/QC-3/QC-4のいづれか最後に承認した場合
		// 作業手順マスタ取得
     	String url= rest_workmst+"select";
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
             		getWorkResult(ET2_wm.getWORK_GROUP(), ET2_wm.getWORK_ID(), batch_id);
             if(et2_workresult.size()>0) {
             	ET2end = true;
             }
 	 	}
 	 	boolean ET3end = false;
 	 	if(ET3_wm!=null) {
             // 作業実績取得
             List<WORK_RESULT_TABLE> et3_workresult = 
             		getWorkResult(ET3_wm.getWORK_GROUP(), ET3_wm.getWORK_ID(), batch_id);
             if(et3_workresult.size()>0) {
             	ET3end = true;
             }
 	 	}
 	 	boolean ET4end = false;
 	 	if(ET4_wm!=null) {
             // 作業実績取得
             List<WORK_RESULT_TABLE> et4_workresult = 
             		getWorkResult(ET4_wm.getWORK_GROUP(), ET4_wm.getWORK_ID(), batch_id);
             if(et4_workresult.size()>0) {
             	ET4end = true;
             }
 	 	}
 	 	
 	 	// 未完了があった場合
 	 	if(!ET2end || !ET3end || !ET4end) {
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
    public String workend(@RequestBody WORK_RESULT_TABLE req,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return param_errmsg_session;
    	}
    	
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
        
        String rst = workresult_regist(data,request,response);
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
                    
                    if(req.getPROCESS_ID().equals(br)){
                		// batch releaseの場合
                    	// 指図のステータス更新
            	 		INSTRUCTIONS_TABLE insdata = new INSTRUCTIONS_TABLE();
            	 		insdata.setBATCH_ID(req.getID());
            	 		insdata.setSTATUS("I05");
            	 		url = rest_instructions+"update";
                    	postRest(url, insdata);
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
    public String workresult_regist(@RequestBody WORK_RESULT_TABLE req,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
        	try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
        	return param_errmsg_session;
        }
    	
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
    public String make_kit_label(
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return param_errmsg_session;
    	}
    	
    	return makeKitLabel();
    }
    
    /*
     * マテリアル一覧取得
     */
    @GetMapping("/ajax/get_material_list")
    public String get_material_list(
    		@RequestParam(param_batch_id) String batch_id,
    		@RequestParam(param_process_id) String process_id,
    		@RequestParam(param_work_group) String work_group,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return param_errmsg_session;
    	}
    	
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
			 			// 保管済み以外は除外
			 			if(!ac.getSTATUS().equals(param_status_storage_end)) continue;
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
     * 承認一覧取得
     */
    @GetMapping("/ajax/get_applist")
    public List<WORK_RESULT_TABLE> get_applist(
    		@RequestParam(param_work_group) String work_group,
    		@RequestParam(param_batch_id) String batch_id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return null;
    	}
    	
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
        		
        		if(wg2.getBEFORE_WORK_GROUP().substring(0, 3).equals(
        				wg1.getBEFORE_WORK_GROUP().substring(0, 3))) {
        			// 作業グループが同じなら
        			// 前前作業グループの作業実績取得
                    List<WORK_RESULT_TABLE> list3 = 
                    		getWorkResult(wg2.getBEFORE_WORK_GROUP(), "", batch_id);
                    
                    if(list3.size()>0) {
                    	list.add(list3.get(list3.size()-1));
                    }
        		}else {
        			// 作業グループが異なる場合
        			WORK_RESULT_TABLE dummy = new WORK_RESULT_TABLE();
        			dummy.setWORK_USERID("");
        			dummy.setWORK_USERNAME("");
        			dummy.setWORK_DATE("");
        			list.add(dummy);
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
    public String create_instructions(@RequestBody String req,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return param_errmsg_session;
    	}
    	
        String url = "";
        String batch_id = "";
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
	 		batch_id = getBatchID();
	 		data.setBATCH_ID(batch_id);
	 		data.setIM_ID(im_id);
	 		data.setNAME(mst.getNAME());
	 		data.setPROTOCOL(mst.getPROTOCOL());
	 		data.setSTATUS("I01");
	 		url= rest_instructions+"insert";
	 		if(!postRest(url, data)) {
	 			return "";
	 		}else {
	 			// 工程別ステータス登録
	 			url= rest_processmst+"select";
	 		 	List<PROCESS_MASTER> list2 = getRest(url, PROCESS_MASTER.class);
	 		 	for(PROCESS_MASTER pm : list2) {
	 		 		String init_status = "";
	 		 		if(pm.getPROCESS_ID().indexOf("IS")>=0) continue;
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
	 		 			return "";
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
	 	        
	 	        String rst = workresult_regist(wrt,request,response);
	 	        if(!rst.equals("OK")) {
	 	        	return "";
	 	        }
	 		}
	 	}
        
        return batch_id;
        
    }
    
    /*
     * 指図リリース
     * 引数：Json形式
     */
    @RequestMapping(value = "/ajax/release_instructions", 
    		consumes = "application/json",
    		method = RequestMethod.POST)
    @ResponseBody
    public String release_instructions(@RequestBody String req,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return param_errmsg_session;
    	}
    	
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
	 	        
	 	        String rst = workresult_regist(wrt,request,response);
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
    public String material_check(@RequestBody List<MATERIAL_CHECK_TABLE> req,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return param_errmsg_session;
    	}
    	
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
    		@RequestParam(param_ins_proc_id) String ins_proc_id,
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	if(!super.loginCheck()) {
    		try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
    		return null;
    	}
    	
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
    
    /*
     * COA PDF出力
     */
	@GetMapping("preview_coa")
	public void preview_coa(
		@RequestParam(param_batch_id) String batch_id,
		HttpServletRequest request,
		HttpServletResponse response) {

		if(!super.loginCheck()) {
			try{response.setStatus(HttpServletResponse.SC_CONFLICT);}catch(Exception e) {}
			return;
		}
		
		try {
			
			Map<String,String> map = new HashMap<String,String>();
			String pass = "Passed";
			String fail = "Failed";
			String url = rest_workresult+"select"
	                + "?"+param_process_id+"=ET3"
	                + "&"+param_id+"="+batch_id;
			
            // 作業実績取得
            List<WORK_RESULT_TABLE> et3_workresult = getRest(url, WORK_RESULT_TABLE.class);
            for(WORK_RESULT_TABLE wrt : et3_workresult) {
            	String key = wrt.getWORK_GROUP()+wrt.getWORK_ID();
            	String val = wrt.getCHECK_RESULT()!=null && wrt.getCHECK_RESULT().equals("1") ? pass
            			: wrt.getCHECK_RESULT()!=null && wrt.getCHECK_RESULT().equals("0") ? fail : "";
            	if(!map.containsKey(key)) {
            		map.put(key, val);
            	}
            }
            
            url = rest_workresult+"select"
	                + "?"+param_process_id+"=ET4"
	                + "&"+param_id+"="+batch_id;
            
            // 作業実績取得
            List<WORK_RESULT_TABLE> et4_workresult = getRest(url, WORK_RESULT_TABLE.class);
            for(WORK_RESULT_TABLE wrt : et4_workresult) {
            	String key = wrt.getWORK_GROUP()+wrt.getWORK_ID();
            	String val = wrt.getCHECK_RESULT()!=null && wrt.getCHECK_RESULT().equals("1") ? pass
            			: wrt.getCHECK_RESULT()!=null && wrt.getCHECK_RESULT().equals("0") ? fail : "";
            	if(!map.containsKey(key)) {
            		map.put(key, val);
            	}
            }
            
			Document doc = new Document();
			ByteArrayOutputStream baOutStr = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(doc, baOutStr);
			
			String ttf = super.getProperties().getCOA_PDF_FONT_FILE();
			String encoding = BaseFont.IDENTITY_H;
			if(!super.checkExist(ttf)) {
				ttf = BaseFont.HELVETICA;
				encoding = BaseFont.WINANSI;
			}
			
			//setting font family, color
			BaseFont bf = BaseFont.createFont(ttf,encoding,false);
			Font font12 = new Font(bf, 12, Font.NORMAL);
			Font font12_underline = new Font(bf, 12, Font.UNDERLINE);
			Font font20_header = new Font(bf, 20, Font.BOLD);
			
			//doc.addAuthor("CPC"); 
			//doc.addSubject("COA");
			
			doc.open();
			
			doc.add(new Paragraph("Certificate of analysis", font20_header));
			doc.add(new Paragraph("　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　",font12_underline));
			doc.add(new Paragraph("\n"));
			doc.add(new Paragraph("Product Name/Description: hMSC", font12));
			doc.add(new Paragraph("Lot #: XXXXXXXX", font12));
			doc.add(new Paragraph("Storage Conditions: - 80 degrees C", font12));
			doc.add(new Paragraph("Expiration XXXX/XX/XX", font12));
			doc.add(new Paragraph("\n"));
			doc.add(new Paragraph("\n"));
			doc.add(new Paragraph("Quality Control Data:", font12));
			// 表の作成
            Table table = new Table(3);
            table.setWidth( 99 );

            // 横の表示位置
            //table.setDefaultHorizontalAlignment( Element.ALIGN_CENTER );
            // 縦の表示位置
            //table.setDefaultVerticalAlignment( Element.ALIGN_MIDDLE );
            // 表の余白を指定
            table.setPadding(1);
            // 表のセル間の感覚を指定
            table.setSpacing(0);
            // 表の線の色を指定
            table.setBorderColor( new Color( 0, 0, 0 ) );
            
            List<Cell> table_list = new ArrayList<Cell>();
            // 1行目
            table_list.add(new Cell( new Phrase( "Test Items", font12) ));
            table_list.add(new Cell( new Phrase( "Specifications", font12) ));
            table_list.add(new Cell( new Phrase( "Results", font12) ));
            // 2行目
            table_list.add(new Cell( new Phrase( "1) Doubling time", font12) ));
            table_list.add(new Cell( new Phrase( "< 18 hours", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET302001"), font12) ));
            // 3行目
            table_list.add(new Cell( new Phrase( "2) Distribution of cell shapes", font12) ));
            table_list.add(new Cell( new Phrase( "Aa least 90% of the population should be within ±20% of the maximum frequency value.", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET303001"), font12) ));
            // 4行目
            table_list.add(new Cell( new Phrase( "3) Antigen Analysis", font12) ));
            table_list.add(new Cell( new Phrase( "Positivity rate of CD73,CD90, and CD105 is greater than 70%.", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET304001"), font12) ));
            // 5行目
            table_list.add(new Cell( new Phrase( "4) Size of mitochondria", font12) ));
            table_list.add(new Cell( new Phrase( "Precision ratio < 30%", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET305001"), font12) ));
            // 6行目
            table_list.add(new Cell( new Phrase( "5) Cell viability", font12) ));
            table_list.add(new Cell( new Phrase( "80%>", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET401001"), font12) ));
            // 7行目
            table_list.add(new Cell( new Phrase( "6) Cytokine secretion", font12) ));
            table_list.add(new Cell( new Phrase( "IL-10 and INF-γ", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET402001"), font12) ));
            // 8行目
            table_list.add(new Cell( new Phrase( "7) Sterility test", font12) ));
            table_list.add(new Cell( new Phrase( "Negative", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET403001"), font12) ));
            // 9行目
            table_list.add(new Cell( new Phrase( "8) Endotoxin test", font12) ));
            table_list.add(new Cell( new Phrase( "<EU/mL", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET404001"), font12) ));
            // 10行目
            table_list.add(new Cell( new Phrase( "9) Mycoplasma test", font12) ));
            table_list.add(new Cell( new Phrase( "Negative", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET405001"), font12) ));
            // 11行目
            table_list.add(new Cell( new Phrase( "10) Virus test", font12) ));
            table_list.add(new Cell( new Phrase( "Negative", font12) ));
            table_list.add(new Cell( new Phrase( map.get("ET406001"), font12) ));

            
            for(Cell cell : table_list) {
            	table.addCell( cell );
            }

            doc.add( table );
            doc.add(new Paragraph("\n"));
			doc.add(new Paragraph("\n"));
			
            Paragraph para1 = new Paragraph( "Approved by_____________", font12 );
            para1.setAlignment(Element.ALIGN_RIGHT);
            doc.add( para1 );
			
            Paragraph para2 = new Paragraph( "Date             _____________", font12 );
            para2.setAlignment(Element.ALIGN_RIGHT);
            doc.add( para2 );
            
			doc.close();
			writer.close();
			
			// PDFを返す
			response.getOutputStream().write(baOutStr.toByteArray());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
}

