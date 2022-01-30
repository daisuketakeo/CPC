package com.cpc.viewcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cpc.model.PROC_INSTRUCTIONS_TABLE;

/**  
 工程別製造指図テーブル View Controller 
 */  
@Controller
public class VCProcInstructions extends VCCommon{

    @Autowired
    public VCProcInstructions() {
    }
    
    @RequestMapping("/procinstructions/new")
    public String displaynew(Model model) {
        if(!super.loginCheck()) return disp_login;
        model.addAttribute("Model", new PROC_INSTRUCTIONS_TABLE());
        return "NewProcInstructions.html";
    }

    @RequestMapping("/procinstructions/update")
    public String displayupdate(@Validated @ModelAttribute PROC_INSTRUCTIONS_TABLE data, Model model) {
        if(!super.loginCheck()) return disp_login;
        model.addAttribute("Model", new PROC_INSTRUCTIONS_TABLE());
        return "UpdateProcInstructions.html";
    }
    
    @PostMapping("/procinstructions/new")
    public String insert(@Validated @ModelAttribute PROC_INSTRUCTIONS_TABLE data, Model model) {
        if(!super.loginCheck()) return disp_login;
        String url = "/rest/procinstructions/insert";           
        if(postRest(url, data)) {
         // OK
        }else {
         // NG
        }
        return "redirect:/procinstructions/selectall";
    }
    
    @PostMapping("/procinstructions/update")
    public String update(@Validated @ModelAttribute PROC_INSTRUCTIONS_TABLE data, Model model) {
        if(!super.loginCheck()) return disp_login;
        String url = "/rest/procinstructions/update";           
        if(postRest(url, data)) {
         // OK
        }else {
         // NG
        }
        return "redirect:/procinstructions/selectall";
    }
    
    @PostMapping("/procinstructions/delete")
    public String delete(@Validated @ModelAttribute PROC_INSTRUCTIONS_TABLE data, Model model) {
        if(!super.loginCheck()) return disp_login;
        String url = "/rest/procinstructions/delete";           
        if(postRest(url, data)) {
         // OK
        }else {
         // NG
        }
        return "redirect:/procinstructions/selectall";
    }

    @GetMapping("/procinstructions/selectall")
    public String selectAll(Model model) {
     
        if(!super.loginCheck()) return disp_login;
        
        String url = "/rest/procinstructions/selectall";
        List<PROC_INSTRUCTIONS_TABLE> list = getRest(url, PROC_INSTRUCTIONS_TABLE.class);
        model.addAttribute("list", list);
        
        return "ProcInstructionsList.html";
    }
    
}

