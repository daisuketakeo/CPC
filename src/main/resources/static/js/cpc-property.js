
var deviation = 'Deviation';			// 逸脱
var wgrp_diviation_status = 'W99';		// 作業グループの逸脱ステータス
var is_release_status = 'I02';			// 指図リリース済ステータス
var end_status = ['P05','T05','B03'];	// 工程の完了ステータス
var current_status = ['P02','P03','P04','T02','T03','T04','B02'];	// 工程の仕掛ステータス

var proc_instructions      = 'IS';
var proc_kitting_preclture = 'EP1';
var proc_preclture         = 'EP2';
var proc_QC1               = 'ET1';
var proc_kitting_expansion = 'EP3';
var proc_expansion         = 'EP4';
var proc_buffer_exchange   = 'EP5';
var proc_freezing          = 'EP6';
var proc_QC2               = 'ET2';
var proc_QC3               = 'ET3';
var proc_QC4               = 'ET4';
var proc_batch_release     = 'BR';

var wgrp_instructions_create  = 'IS01';
var wgrp_instructions_release = 'IS02';

var wgrp_expansion_top = 'EP401';
var wid_expansion_top = '001';
var wgrp_expansion_culture = 'EP404';
var wid_expansion_culture = '002';

var wgrp_kitting_expansion_rt   = 'EP301';
var wgrp_kitting_expansion_p4t  = 'EP302';
var wgrp_kitting_expansion_m20t = 'EP303';

// 工程情報
// PROCESS_ID, 要素名, 画面フラグ 
var PROCESS = new Map([
    ['EP1', ['PrecultureKitting','2', '/manufacturing',  0, false]],
    ['EP2', ['Preculture'       ,'2', '/manufacturing',  1, false]],
    ['ET1', ['QC1'              ,'2', '/qualitycontrol', 2, false]],
    ['EP3', ['ExpansionKitting' ,'2', '/manufacturing',  3, false]],
    ['EP4', ['Expansion'        ,'2', '/manufacturing',  4, false]],
    ['EP5', ['BufferExchange'   ,'2', '/manufacturing',  5, false]],
    ['EP6', ['Freezing'         ,'2', '/manufacturing',  6, false]],
    ['ET2', ['QC2'              ,'3', '/qualitycontrol', 7, false]],
    ['ET3', ['QC3'              ,'3', '/qualitycontrol', 8, false]],
    ['ET4', ['QC4'              ,'3', '/qualitycontrol', 9, false]],
    ['BR',  ['BatchRelease'     ,'4', '/batchrelease',  10, false]]
]);


// メッセージ 
const MESSAGE = {
	I001: 'Complete the work?',
	I002: 'Create instructions?',
	I003: 'Release instructions?',
	I004: '',
	I005: '',
	I006: '',
	I007: '',
	I008: '',
	I009: '',
	I010: '',
	I011: '',
	I012: '',
	I013: '',
	I014: '',
	I015: '',
	I016: '',
	I017: '',
	I018: '',
	I019: '',
	I020: '',
	W001: 'Please input Lot #.',
	W002: 'Please input Exp Date.',
	W003: 'Please check PASS or FAIL.(Visually check)',
	W004: 'Please input reason.(Visually check)',
	W005: 'Please check PASS or FAIL.(COA)',
	W006: 'Please input reason.(COA)',
	W007: 'Please attach file.',
	W008: 'Please select storage.',
	W009: 'Please check Accept or Reject.',
	W010: 'Cannot be operated.',
	W011: 'Please relese.',
	W012: 'Please select item.',
	W013: 'Please select batch.',
	W014: 'This batch [$$} released.',
	W015: 'Please output Kit label.',
	W016: 'Please output Exp.date label.',
	W017: 'Please check Pass or Fail.',
	W018: 'Please check Release or Reject.',
	W019: 'Please input reason.',
	W020: 'Please input Count value.',
	W021: 'Please input comment.',
	W022: 'Please check Continue or Suspension.',
	W023: 'Please select material.',
	W024: 'Different materials checked.',
	W025: 'Pre-batch overview cannot be selected.',
	W025: 'Please select PDF file.',
	E001: '',
	E002: '',
	E003: '',
	E004: '',
	E005: '',
	E006: '',
	E007: '',
	E008: '',
	E009: '',
	E010: '',
	E011: '',
	E012: '',
	E013: '',
	E014: '',
	E015: '',
	E016: '',
	E017: '',
	E018: '',
	E019: '',
	E020: ''
};