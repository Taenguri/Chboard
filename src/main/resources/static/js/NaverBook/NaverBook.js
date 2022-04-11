// 책 검색 처리
document.querySelector("#booksearch").addEventListener("click", function() {

	let keyword = document.getElementById("keyword").value;
	
	
	location.href= `/booksearch/${keyword}`
	
});



// 책 검색 엔터키 이벤트
function enterkey() {
	if (window.event.keyCode == 13) {
		document.getElementById('booksearch').click();
	}
}