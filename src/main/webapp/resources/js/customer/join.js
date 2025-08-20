/**
 * 
 */

// 회원가입, 수정시의 이메일 체크
function selectEmailChk() {
	if(document.inputform.user_email3.value) {
		document.inputform.user_email2.value = document.inputform.user_email3.value;
		return false;
	} else {
		document.inputform.user_email2.value = "";
		document.inputform.user_email2.focus();
		return false;
	}
}
 

// 아이디 중복확인 버튼 클릭시	
// 1. 아이디 중복확인 페이지 open
function confirmId() {
	// alert("중복확인"); / 실행되는지 먼저 확인 후 작성용
	if(!document.inputform.user_id.value) { // 아이디 값이 없을시
		alert("아이디를 입력하세요!!");
		document.inputform.user_id.focus();
		return false;  // 값을 흘러나가지 않고록 막아야함
	} 
	
	// 중복확인 버튼 클릭시 컨트롤러로 url을 전달, 컨트롤러에 소스 추가
	let url = "/spring_pj_ict05/idConfirmAction.do?user_id=" + document.inputform.user_id.value;
	window.open(url, "confirm", "menubar=no, width=500, height=400");
}

// 2. join.jsp - onSubmit시 회원가입페이지 필수 체크
function signInCheck() {
	//  2-1. 중복확인 버튼 체크
	// <input type="hidden" name="hiddenUserid" value="0">
	// hiddenUserid : 중복확인 버튼 안눌렀을 때 체크(0: 클릭안함, 1: 클릭함)
	
	// 2-2. 중복확인 버튼 클릭하지 않은 경우 "중복확인 해주세요!!" 메시지 띄운다.
	if(document.inputform.hiddenUserid.value == "0") {
		alert("중복확인 해주세요!!");
		document.inputform.dubChk.focus();
		return false;
	}
	
	// 비밀번호 불일치
	if(document.inputform.user_password.value != document.inputform.re_password.value) {
		alert("비밀번호가 불일치합니다. 다시 확인해주세요!!");
		document.inputform.re_password.value = "";
		document.inputform.re_password.focus();
		return false;
	}

}

// 3. 사용가능한 id를 찾은 경우 => 자식창에서 부모창으로 user_id값을 전달
/*
	opener : window 객체의 open() 메서드로 열린 자식창(=중복확인)에서 부모창(=회원가입창)에 접근할 때 사용
	hiddenUserid : 중복확인 버튼 안눌렀을 때 체크(0: 클릭안함, 1: 클릭함)
	self.close();  // 자식창 닫기

*/
function setUserId(userid) {
	// alert("userid");
	opener.document.inputform.user_id.value = userid;
	opener.document.inputform.hiddenUserid.value = "1"; // 중복확인창 클릭 인증
	self.close();
}

// 주소에 api
function searchAddress() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을 때 실행할 코드를 작성하는 부분입니다
			// 예제를 참고하여 다양한 활용법을 확인해 보세요
	
			var addr = '';
			var extraAddr = '';
	
			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			} 
	
			// 사용자가 선택한 주소가 도로명 타입일 때 참고항목을 조합한다
			if(data.userSelectedType === 'R'){
				// 법정동명이 있는 경우 추가한다 (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다
				if(data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				} 
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다
				if(extraAddr !== ''){
					extraAddr = '(' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다
				addr += extraAddr;
		
			} else {
				extraAddr = '';
			}
	
			// 주소 정보를 해당 필드에 넣는다
			document.getElementById("user_address1").value = addr;
			// 커서를 상세주소 필드로 이동한다
			document.getElementById("user_address2").focus();
		}
	}).open();
}

