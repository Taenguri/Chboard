


// 회원 검색 처리
document.querySelector("#searchBtn").addEventListener("click", function() {

	let keyword = document.getElementById("keywordInput").value;
	let condition = document.getElementById("condition").value;	
	
	console.log(keyword);
	console.log(condition);
	
	location.href="/userList?keyword="+keyword+"&condition=" + condition;
	
	
});




//검색용 엔터키 이벤트
function enterkey() {
	if (window.event.keyCode == 13) {
		document.getElementById('searchBtn').click();
	}
}
