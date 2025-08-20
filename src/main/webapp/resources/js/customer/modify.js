/**
 * 
 */

// 수정시의 이메일 체크
// modifyDetailAction 클래스에서 이메일 / 상세페이지에서 이메일
function detail_selectEmailChk() {
	if(document.modifyform.user_email3.value) {
		document.modifyform.user_email2.value = document.inputform.user_email3.value;
		return false;
	} else {
		document.modifyform.user_email2.value = "";
		document.modifyform.user_email2.focus();
		return false;
	}
}
 
// 비밀번호 불일치
function modifyCheck() {
	if(	document.modifyform.user_password.value != document.modifyform.re_password.value) {
			alert("비밀번호가 불일치합니다. 다시 확인해주세요!!");
			document.modifyform.re_password.value = "";
			document.modifyform.re_password.focus();
			return false;
		} 
	
}



