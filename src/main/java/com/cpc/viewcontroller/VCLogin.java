package com.cpc.viewcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cpc.model.USER_MASTER;

/**  
ログイン画面 Controller 
*/  
@Controller
public class VCLogin extends VCCommon{

    @Autowired
    public VCLogin() {
    }
    
    @RequestMapping("/")
    public String root(Model model) {
    	sessionClear();
    	model.addAttribute(attr_err_flg, null);
    	model.addAttribute("USER_MASTER", new USER_MASTER());
        setHeaderAttr(model);
        return disp_login;
    }
	
    @RequestMapping("/login")
    public String login(Model model) {
    	
    	sessionClear();
    	
    	String err = "";
    	try {
    		err = (String)model.getAttribute(attr_err_flg);
    	}catch(Exception e) {
    	}
    	
    	model.addAttribute("USER_MASTER", new USER_MASTER());
    	model.addAttribute(attr_err_flg, err);
    	setHeaderAttr(model);
        return disp_login;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
    	sessionClear();
    	model.addAttribute(attr_err_flg, null);
    	model.addAttribute("USER_MASTER", new USER_MASTER());
        setHeaderAttr(model);
        return disp_login;
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
    	model.addAttribute(attr_err_flg, null);
        setHeaderAttr(model);
        model.addAttribute(disp_body, disp_home);
        return disp_main;
    }
    
    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String main(@Validated @ModelAttribute USER_MASTER data, Model model) {

    	String trn = super.userCheck(data);
    	if(trn.isEmpty()) {
    		// ログイン成功
    		setHeaderAttr(model);
    		model.addAttribute(disp_body, disp_home);
    		return disp_main;
    	}else {
    		// ログイン失敗
    		setHeaderAttr(model);
    		model.addAttribute(attr_err_flg, trn);
    		return disp_login;
    	}
    }
    
//    @RequestMapping("/pdf")
//    public String pdf(Model model) {
//        return "/test/pdfjs/web/test2";
//    }
	
}
