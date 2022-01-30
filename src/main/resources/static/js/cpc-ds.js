/*
 * ヘッダスタイル変更
 */
function change_header_style(flg){
	var cls = '';
	if(flg==0){
		cls = 'header_home';
	}else if(flg==1){
		cls = 'header_ic';
	}else if(flg==2){
		cls = 'header_mf';
	}else if(flg==3){
		cls = 'header_qc';
	}else if(flg==4){
		cls = 'header_rv';
	}
    $('#header_bar').removeClass('header_ic');
    $('#header_bar').removeClass('header_mf');
    $('#header_bar').removeClass('header_qc');
    $('#header_bar').removeClass('header_rv');
    
    $('#header_bar').addClass(cls);
}
/*
 * テーブル 初期状態
 */
function row_default(tblID, row){
	var vTR = tblID + " " + row;
	$(vTR).css("background-color","#ffffff");
	$(vTR).mouseover(function(){
		$(this).css("background-color","#cccccc") .css("cursor","pointer")
	});
	$(vTR).mouseout(function(){
		$(this).css("background-color","#ffffff") .css("cursor","normal")
	});
}

/*
 * TR 初期状態
 */
function tr_default(tblID){
	row_default(tblID, "tr");
}
/*
 * TBODY 初期状態
 */
function tbody_default(tblID){
	row_default(tblID, "tbody");
}

/*
 * テーブル 行選択状態
 */
function row_click(trID){
	trID.css("background-color","#fcf2d1");
	trID.mouseover(function(){
		$(this).css("background-color","#cccccc") .css("cursor","pointer")
	});
	trID.mouseout(function(){
		$(this).css("background-color","#fcf2d1") .css("cursor","normal")
	});
}
 /*
  * 要素ごとに有効無効 設定
  */
 function setDisabled(element, disabled){
 	if($(element).length){
 		$(element).prop("disabled",disabled);
 	}
 }
 /*
  * 要素ごとにデータ 設定(テキストボックス)
  */
 function setTextBox(element,data){
 	if($(element).length){
 		$(element).val(data);
 	}
 }
 /*
  * 要素ごとにデータ 設定(チェックボックス)
  */
 function setCheckBoxPassFail(elementPass, elementFail, result){
 	if($(elementPass).length && $(elementFail).length){
 		if(result == '1'){
 			// Passなら
 			$(elementPass).prop('checked', true);
 			$(elementFail).prop('checked', false);
 		}else if(result == '0'){
 			// Failなら
 			$(elementPass).prop('checked', false);
 			$(elementFail).prop('checked', true);
 		}else{
 			$(elementPass).prop('checked', false);
 			$(elementFail).prop('checked', false);
 		}
 	}
 }
 
/*
 * 作業グループ名称取得
 */
function getWorkGroupName(
	work_group, no, tagname){

	var args = 
		"?WORK_GROUP="+work_group;

	$.ajax({
	    type: "GET", 
	    url: '/rest/workgroupmst/select'+args,
	}).done(function(data) {
	    var usage_arr = JSON.parse(data);
	    var WORK_GROUP_MASTER = usage_arr.list[0];
        var work_group_name = "#"+tagname+no;
		$(work_group_name).text(WORK_GROUP_MASTER.work_GROUP_NAME);
	}).fail(function(XMLHttpRequest, textStatus, errorThrown) {
	  // エラーメッセージの表示
	  console.log('Error : ' + errorThrown + ", Reason: " + textStatus);
	});
}
/*
 * 作業手順取得
 */
function getWork(
	work_group, work_id){

	var args = 
		"?WORK_GROUP="+work_group+
		"&WORK_ID="+work_id;

	$.ajax({
	    type: "GET", 
	    url: '/rest/workmst/select'+args,
	}).done(function(data) {
	    var usage_arr = JSON.parse(data);
	    var WORK_MASTER = usage_arr.list[0];
		var tdid = "#td"+work_group+work_id;
		$(tdid).text(WORK_MASTER.work);
	}).fail(function(XMLHttpRequest, textStatus, errorThrown) {
	  // エラーメッセージの表示
	  console.log('Error : ' + errorThrown + ", Reason: " + textStatus);
	});
}

/***********************************
Blobへ変換 引数はbase64形式の文字列
***********************************/
 function toBlob(base64) {
     var bin = atob(base64.replace(/^.*,/, ''));
     var buffer = new Uint8Array(bin.length);
     for (var i = 0; i < bin.length; i++) {
         buffer[i] = bin.charCodeAt(i);
     }
     // Blobを作成
     try{
         var blob = new Blob([buffer.buffer], {
             type: 'image/png'
         });
     }catch (e){
         return false;
     }
     return blob;
 }

 /***********************************
 確認ダイアログ表示
 ***********************************/
 function confirm(){
	$('#confirmdialog').dialog({
		dialogClass:'confirm_dialog',
		modal:true, //モーダル表示
		title:"Confirm", //タイトル
		buttons: { //ボタン
		"OK": function() {
			$(this).dialog("close");
			}
		}
	});
 }
  /***********************************
 警告ダイアログ表示
 ***********************************/
 function alertdialog(msg){
	$('#alertdialog_p').text(msg);
	$('#alertdialog').dialog({
		dialogClass:'alertdialog',
		modal:true, //モーダル表示
		title:"Alert!", //タイトル
		buttons: { //ボタン
		"Close": function() {
			$(this).dialog("close");
			}
		}
	});
 }
  /***********************************
 エラーダイアログ表示
 ***********************************/
 function error(msg){
	$('#errordialog_p').text(msg);
	$('#errordialog').dialog({
		dialogClass:'error_dialog',
		modal:true, //モーダル表示
		title:"Error!", //タイトル
		buttons: { //ボタン
		"Close": function() {
			$(this).dialog("close");
			}
		}
	});
 }
