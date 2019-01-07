package f_vo;

public class PageInfo {
	
	private int page; // 현제 페이지 정보
	private int maxPage; // 최대 페이값지
	private int startPage; // 시작 페이지 값
	private int endPage;// 마지막 페이지 값
	private int listCount; // 전체 글 갯수
	
	
	
	
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	

}
