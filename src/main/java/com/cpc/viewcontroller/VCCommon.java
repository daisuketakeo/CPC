package com.cpc.viewcontroller;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import com.cpc.config.PropertiesBean;
import com.cpc.model.DisplayParameter;
import com.cpc.model.PROCESS_MASTER;
import com.cpc.model.STATUS_MASTER;
import com.cpc.model.USER_MASTER;
import com.cpc.model.WORK_GROUP_MASTER;
import com.cpc.model.WORK_MASTER;
import com.cpc.model.WORK_RESULT_TABLE;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VCCommon {

    @Autowired
    private PropertiesBean property;
	@Autowired
	private HttpSession session;
	
	/*
	 * 画面
	 */
	public static final String disp_login = "login";	// ログイン画面
	public static final String disp_main = "main";	// メイン画面
	public static final String disp_home = "home";	// ホーム画面
	public static final String disp_body = "body";	// メイン画面ボディ部s
	
	/*
	 * 画面属性
	 */
	public static final String attr_err_flg = "error";	// エラーフラグ
	
	/*
	 * セッション変数
	 */
	public static final String seeeson_user = "USER_MASTER";	// ユーザ情報
	
	/*
	 * 画面パラメータ
	 */
	public static final String param_process_id    = "PROCESS_ID";		// 工程
	public static final String param_work_group    = "WORK_GROUP";		// 作業グループ
	public static final String param_id            = "ID";				// ID(MATERIAL_NO or BACTH_ID)
	public static final String param_work_id       = "WORK_ID";			// WORK_ID
	public static final String param_material_no   = "MATERIAL_NO";		// MATERIAL_NO
	public static final String param_material_group_id   = "MATERIAL_GROUP_ID";		// MATERIAL_GROUP_ID
	public static final String param_batch_id      = "BATCH_ID";		// BATCH_ID
	public static final String param_im_id         = "IM_ID";			// IM_ID
	public static final String param_work_group_json  = "WORK_GROUP_JSON";	// 画面へ渡す作業グループ情報(Json)
	public static final String param_work_group_map   = "WORK_GROUP_MAP";	// 画面へ渡す作業グループ情報(MAP)
	public static final String param_status_list      = "STATUS_LIST";		// 画面へ渡すステータスリスト
	public static final String param_disp_flg      = "DISP_FLG";		// 画面へ渡すステータスリスト
	
	/*
	 * REST URL
	 */
	public static final String rest_usermst    = "/rest/usermst/";	// ユーザマスタ
	public static final String rest_accept     = "/rest/accept/";	// 受入テーブル
	public static final String rest_workmst    = "/rest/workmst/";	// 作業手順マスタ
	public static final String rest_workresult = "/rest/workresult/";	// 作業実績
	public static final String rest_workgroupmst = "/rest/workgroupmst/";	// 作業グループマスタ
	public static final String rest_statusmst = "/rest/statusmst/";	// ステータスマスタ
	public static final String rest_processmst = "/rest/processmst/";	// 工程スマスタ
	public static final String rest_instructions = "/rest/instructions/";	// 製造指図テーブル
	public static final String rest_instructionsmst = "/rest/instructionsmst/";	// 製造指図マスタ
	public static final String rest_airelation = "/rest/airelation/";	// 受入指図連携テーブル
	public static final String rest_materialgroup = "/rest/materialgroup/";	// マテリアルグループテーブル
	public static final String rest_processstatus = "/rest/processstatus/";	// 工程別ステータステーブル
	public static final String rest_materialcheck = "/rest/materialcheck/";	// マテリアルチェックテーブル
		
	/*
	 * ユーザ権限
	 */
	public static final Map<String,String> authority = new HashMap<String,String>(){
		{
			put("KO01", "キッティングオペレータ（KO）");
			put("CP01", "製造担当者（CP）");
			put("CP02", "製造サブマネージャー（CPサブマネージャー）");
			put("CP03", "製造マネージャー（CPマネージャー）");
			put("QC01", "品質管理担当（QC）");
			put("QC02", "品質管理マネージャー（QCマネージャー）");
			put("QA01", "品質保証（QA）");
		}
	};
	
	/*
	 * 工程
	 */
	public static final String qc = "QC"; // 受入(QC用)
	public static final String qa = "QA"; // 受入(QA用) 
	public static final String is = "IS"; // 指図
//	public static final String ep = "EP"; // EBR製造
//	public static final String et = "ET"; // EBR試験
//	public static final String br = "BR"; // バッチレコードレビュー
			
	/*
	 * ログイン状態チェック
	 */
	public boolean loginCheck() {
    	USER_MASTER user = (USER_MASTER)session.getAttribute(seeeson_user);
        return user == null ? false : true;
    }
	
	/*
	 * QAか？
	 */
	public boolean isQA() {
    	USER_MASTER user = (USER_MASTER)session.getAttribute(seeeson_user);
    	if(user==null) return false;
    	if(user.getAUTHORITY().equals("QA01")) return true;
        return false;
    }
	
	/*
	 * QCか？
	 */
	public boolean isQC() {
    	USER_MASTER user = (USER_MASTER)session.getAttribute(seeeson_user);
    	if(user==null) return false;
    	if(user.getAUTHORITY().equals("QC01")) return true;
    	if(user.getAUTHORITY().equals("QC02")) return true;
        return false;
    }
	
	/*
	 * 製造か？
	 */
	public boolean isCP() {
    	USER_MASTER user = (USER_MASTER)session.getAttribute(seeeson_user);
    	if(user==null) return false;
    	if(user.getAUTHORITY().equals("CP01")) return true;
    	if(user.getAUTHORITY().equals("CP02")) return true;
    	if(user.getAUTHORITY().equals("CP03")) return true;
        return false;
    }
	
	/*
	 * キッティングオペレータか？
	 */
	public boolean isKO() {
    	USER_MASTER user = (USER_MASTER)session.getAttribute(seeeson_user);
    	if(user==null) return false;
    	if(user.getAUTHORITY().equals("KO01")) return true;
        return false;
    }
	
	/*
	 * 管理者か？
	 */
	public boolean isAdmin() {
    	USER_MASTER user = (USER_MASTER)session.getAttribute(seeeson_user);
    	if(user==null) return false;
    	if(user.getAUTHORITY().equals("CP03")) return true;
    	if(user.getAUTHORITY().equals("QA01")) return true;
        return false;
    }
		
	/*
	 * ログイン認証
	 */
    public String userCheck(String USERID, String PASSOWRD) {
    	
        try{
            List<USER_MASTER> list = 
            		getRest(rest_usermst+"select?USERID="+USERID, USER_MASTER.class);
            if(list.size()>0) {
            	USER_MASTER user = list.get(0);
            	// ユーザ存在するので、パスワードチェック
            	if(user.getPASSWORD().equals(PASSOWRD)) {
            		// ログインOK
            		// セッションにユーザ情報セット
            		session.setAttribute(seeeson_user, user);
            		return "";
            	}else {
            		// パスワード NG
            		return "2";
            	}
            }else {
            	// ユーザID NG
            	return "1";
            }
        }catch(Exception e) {
            e.printStackTrace();
            return "999";
        }
    }
    
    /*
     * ユーザ情報取得
     */
    public USER_MASTER getUserInfo() {
    	USER_MASTER user;
    	try {
    		user = (USER_MASTER)session.getAttribute(seeeson_user);
    		return user;
    	}catch(Exception e) {
    		return null;
    	}
    }
    
    /*
     * セッションクリア
     */
    public void sessionClear() {
    	session.setAttribute(seeeson_user, null);
    	return;
    }
    
    /*
     * 画面パラメータ設定
     */
    public void setHeaderAttr(Model model) {
    	USER_MASTER user = getUserInfo();
    	String user_name = user != null ? user.getUSERNAME() : ""; 
    	user_name += user != null && authority.containsKey(user.getAUTHORITY()) 
    			? "("+authority.get(user.getAUTHORITY())+")" : "";
    	model.addAttribute("user_name", user_name);
        model.addAttribute("system_name", property.getSYSTEM_NAME());
    }
    
    /*
     * Get RESTリクエスト
     * 戻り値：オブジェクト配列
     */
    public <T> List<T> getRest(String url, Class<T> toValueType) {
    	try {
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            ResponseEntity<JsonNode> res = restTemplate.getForEntity(property.getREST_URL() + url,JsonNode.class);            
            Map<String, List<T>> result = mapper.convertValue(res.getBody(), Map.class);
            List<T> tmp = result.get("list");
	        List<T> list = new ArrayList<T>();
	        for(T json : tmp) {
	        	list.add(mapper.convertValue(json, toValueType));
	        }
            return list;
            
    	}catch(Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    /*
     * Post RESTリクエスト
     */
    public boolean postRest(String url, Object data) {
    	try{
    		
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = 
            		restTemplate.postForEntity(property.getREST_URL() + url, data, String.class);
            
            HttpStatus responseHttpStatus = result.getStatusCode();

            if (responseHttpStatus.equals(HttpStatus.OK)) { // 200
            	String return_json = result.getBody();
            	if(return_json.equals("OK")) {
            		return true;
            	}else {
            		return false;
            	}
            } else if (responseHttpStatus.equals(HttpStatus.BAD_REQUEST)) { 
                // ステータスコード400の場合
            	return false;

            } else if (responseHttpStatus.equals(HttpStatus.UNAUTHORIZED)) { 
                // ステータスコード401の場合
            	return false;
            } else {
            	return false;
            }
            
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /*
     * WORK_RESULT_NO生成
     */
    public static String createWorkResultNo(String timestamp) {
    	return timestamp+getRandomString(10);
    }
    
    /*
     * タイムスタンプ取得:YYYYMMDDhhmiss
     */
    public static String getTimeStamp() {
        Calendar cl = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(cl.getTime());
    }
    
    /*
     * 作業実施日取得:YYYYMMDDhhmiss
     */
    public static String getWorkDate() {
        Calendar cl = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(cl.getTime());
    }
    
    /*
     * ランダム変数生成
     */
    public static String getRandomString(int i) 
    { 
        // bind the length 
    	byte[] bytearray = new byte[256];
        String mystring;
        StringBuffer thebuffer;
        String theAlphaNumericS;

        new Random().nextBytes(bytearray); 

        mystring 
            = new String(bytearray, Charset.forName("UTF-8")); 
            
        thebuffer = new StringBuffer();
        
        //remove all spacial char 
        theAlphaNumericS 
            = mystring 
                .replaceAll("[^A-Z0-9]", ""); 

        //random selection
        for (int m = 0; m < theAlphaNumericS.length(); m++) { 

            if (Character.isLetter(theAlphaNumericS.charAt(m)) 
                    && (i > 0) 
                || Character.isDigit(theAlphaNumericS.charAt(m)) 
                    && (i > 0)) { 

                thebuffer.append(theAlphaNumericS.charAt(m)); 
                i--; 
            } 
        } 

        // the resulting string 
        return thebuffer.toString(); 
    }
    
    /*
     * ステータスリスト取得(Json)
     */
    public String getStatusJson() {
    	String json = "";
    	String url= rest_statusmst+"select";
    	List<STATUS_MASTER> list = getRest(url, STATUS_MASTER.class);
    	Map<String ,String> map = new HashMap<String ,String>();
    	if(list.size()>0) {
    		for(STATUS_MASTER sm : list) {
    			map.put(sm.getSTATUS_CODE(), sm.getSTATUS_NAME());
    		}
    	}
    	try{
    		json = new ObjectMapper().writeValueAsString(map);
    	}catch(Exception e) {
    	}
    	return json;
    }
    
    /*
     * ステータスリスト取得(Json)
     */
    public String getStatusName(String status_code) {
    	String url= rest_statusmst+"select?STATUS_CODE="+status_code;
    	List<STATUS_MASTER> list = getRest(url, STATUS_MASTER.class);
    	if(list.size()>0) {
    		return list.get(0).getSTATUS_NAME();
    	}
    	return "";
    }
    
    /*
     * MapをJson形式に変換
     */
    public String getJson(Map<String ,Object> map) {
    	String json = "";
    	try{
    		json = new ObjectMapper().writeValueAsString(map);
    	}catch(Exception e) {
    	}
    	return json;
    }
    
    /*
     * Json形式をMapに変換
     */
    public Map<String ,Object> getMap(String json) {
    	try{
    		return new ObjectMapper().readValue(json, HashMap.class);
    	}catch(Exception e) {
    	}
    	return new HashMap<String,Object>();
    }
    
    /*
     * 画面パラメータ取得(Json)
     */
    public static String getParamJson(Map<String ,DisplayParameter> map) {
    	String json = "";
    	try{
    		json = new ObjectMapper().writeValueAsString(map);
    	}catch(Exception e) {
    	}
    	return json;
    }
    
    /*
     * ステータス取得
     */
    public String getStatus(String work_group) {
    	List<WORK_GROUP_MASTER> list = getWorkGroupMaster(work_group);
    	if(list.size()>0) {
    		return list.get(0).getSTATUS();
    	}else {
    		return "";
    	}
    }
    
    /*
     * 固定作業手順取得(Json)
     */
    public String getFixedWork() {
    	String json = "";
    	Map<String ,String> map = new HashMap<String ,String>(){
    		{
    			put("CHECKLIST_MSG1",property.getCHECKLIST_MSG1());
    			put("CHECKLIST_MSG2",property.getCHECKLIST_MSG2());
    		}	
    	};
    	try{
    		json = new ObjectMapper().writeValueAsString(map);
    	}catch(Exception e) {
    	}
    	return json;
    }
    
    /*
     * 作業グループ取得
     */
    public WORK_GROUP_MASTER getWorkGroup(String work_group) {
    	List<WORK_GROUP_MASTER> list = getWorkGroupMaster(work_group);
    	if(list.size()>0) {
    		return list.get(0);
    	}else {
    		return new WORK_GROUP_MASTER();
    	}
    }
    
    /*
     * 作業グループリスト取得
     */
    public List<WORK_GROUP_MASTER> getWorkGroupMaster(String work_group) {
    	String url= rest_workgroupmst+"select"+
    			"?"+ param_work_group+"="+work_group;
    	 return getRest(url, WORK_GROUP_MASTER.class);
    }
    
    /*
     * 作業手順リスト取得
     */
    public List<WORK_MASTER> getWorkMaster(String work_group) {
    	String url= rest_workmst+"select"+
    				"?"+ param_work_group+"="+work_group;
    	 return getRest(url, WORK_MASTER.class);
    }
    
    /*
     * 画面表示用作業グループマップ取得
     */
    public Map<String, DisplayParameter> getWorkGroupList(String process_id){
    	
    	Map<String, DisplayParameter> rtnmap = new HashMap<String,DisplayParameter>();
    	
    	String url= rest_workgroupmst+"select"+
				"?"+ param_process_id+"="+process_id;
	 	List<WORK_GROUP_MASTER> list = getRest(url, WORK_GROUP_MASTER.class);
	 
    	if(list.size()>0) {
        	int no = 1;
        	for(WORK_GROUP_MASTER wgrp : list) {
        		rtnmap.put(String.format("%02d", no), 
        				new DisplayParameter(wgrp.getWORK_GROUP(), wgrp.getDISPLAY_TYPE()));
        		no++;
        	}
    	}

    	return rtnmap;
    }
    
    /*
     * 作業実績リスト取得
     */
    public List<WORK_RESULT_TABLE> getWorkResult(
    		String work_group, String work_id, String id) {
    	String url= makeWorkResult(work_group, work_id, id);
    	 return getRest(url, WORK_RESULT_TABLE.class);
    }
    /*
     * 作業実績取得用URL生成
     */
    public String makeWorkResult(String work_group, String work_id, String id) {
    	return  rest_workresult+"select"
                + "?"+param_work_group+"="+work_group
                + "&"+param_work_id+"="+work_id
                + "&"+param_id+"="+id;
    }
    
    /*
     * User Lot No 採番
     */
    public String getNewUserLotNo() {
    	
    	String newno = "";
    	String dir = property.getCONFIG_PATH();
    	String file = property.getUSER_LOT_NO_FILE();
    	
        try {
            // ファイルがなければ作成
        	if (!Files.isDirectory(Paths.get(dir))) {
            	Files.createDirectories(Paths.get(property.getCONFIG_PATH()));
            }
        	
            // ファイルがなければ作成
        	if (!Files.exists(Paths.get(dir, file))) {
        		Files.createFile(Paths.get(dir, file));
            }
            
            // ファイル読み込み
            List<String> lines = 
            		Files.lines(Paths.get(dir, file), 
            				StandardCharsets.UTF_8).collect(Collectors.toList());
            
            Calendar cl = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yy");
            String yy = sdf.format(cl.getTime());
            // 採番
            if(lines.size()==0) {
            	newno = yy + "01";
            }else {
            	String currentyy = lines.get(0).substring(0, 2);
            	String currentno = lines.get(0).substring(2, 4);
            	if(currentyy.equals(yy)) {
            		int nextno = Integer.valueOf(currentno) + 1;
            		if(nextno>99) {
            			nextno = 1;
            		}
            		newno = yy + String.format("%02d",nextno);
            	}else {
            		newno = yy + "01";
            	}
            }
            
            Files.write(Paths.get(dir, file), new ArrayList<String>(Arrays.asList(newno)),
                    Charset.forName("UTF-8"), StandardOpenOption.WRITE);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return newno;
    }
    
    /*
     * 保管場所リスト取得
     */
    public List<String> getStorageList() {
    	
    	String dir = property.getCONFIG_PATH();
    	String file = property.getSTORAGE_FILE();
    	
        try {
            // ファイルがなければ作成
        	if (!Files.isDirectory(Paths.get(dir))) {
            	return new ArrayList<String>();
            }
            
            // ファイル読み込み
        	return Files.lines(Paths.get(dir, file), 
            				StandardCharsets.UTF_8).collect(Collectors.toList());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new ArrayList<String>();
    }
    
    /*
     * Kit Label 生成
     */
    public String makeKitLabel() {
        Calendar cl = Calendar.getInstance();
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
        SimpleDateFormat mmdd = new SimpleDateFormat("MMdd");
        
    	return property.getKIT_LABEL_FIX_STRING() + 
    			yyyy.format(cl.getTime()) +"0" + mmdd.format(cl.getTime());
    }
    
    /*
     * EBR試験の画像ファイルをBase64形式に変換して取得
     */
    public String get_base64(String filename) {
    	String dir = property.getEBR_TEST_PATH();
    	try {
            // ファイルがあれば
        	if (Files.exists(Paths.get(dir, filename))) {
        		byte[]fileContent = 
        				FileUtils.readFileToByteArray(new File(Paths.get(dir, filename).toString()));
        		return Base64.getEncoder().encodeToString(fileContent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return "";
    }
    
    /*
     * EBR試験のCSVファイルを取得
     */
    public String get_csv(String filename) {
    	String dir = property.getEBR_TEST_PATH();
    	try {
            // ファイルがあれば
        	if (Files.exists(Paths.get(dir, filename))) {
                // ファイル読み込み
            	return Files.readString(Paths.get(dir, filename));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return "";
    }
    
    /*
     * Batch ID 採番
     */
    public String getBatchID() {
    	return "BATCH"+getTimeStamp();
    }

}
