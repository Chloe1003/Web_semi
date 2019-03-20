package util;

public class Paging {

	private int curPage; // ?��?�� ?��?���? 번호 (?��?��?�� ?��?���?)
	
	private int totalCount; // �? 게시�? ?�� (DB 조회 결과�? ?��?��?��)
	private int listCount; // ?�� ?��?���??�� 출력?�� 게시�? ?�� (직접 ?��?��?��)
	private int totalPage; // �? ?��?���? ?�� (계산?���? ?��?��?��)
	
	private int pageCount; // ?�� ?��면에 출력?�� ?��?���? ?�� (직접 ?��?��?��)
	private int startPage; // ?��면에 보이?�� ?��?�� ?��?���? (계산?���? ?��?��?��)
	private int endPage; // ?��면에 보이?�� ?�� ?��?���? (계산?���? ?��?��?��)
	
	private int startNo; // 게시�? ?��?��번호 (계산?���? ?��?��?��)
	private int endNo; // 게시�? ?�� 번호 (계산?���? ?��?��?��)
	
	// �? 게시�? ?���? ?��?��?��?�� ?��?��?��
	public Paging(int totalCount) {
		this.setTotalCount(totalCount);
		
		makePaging();
	}
	
	// �? 게시�? ?��, ?��?�� ?��?���? ?��?��?��?�� ?��?��?��
	public Paging(int totalCount, int curPage) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		
		makePaging();
	}
	
	// �? 게시�? ?��, ?��?�� ?��?���?, ?��?���? ?�� 게시�? ?�� ?��?��?��?�� ?��?��?��
	public Paging(int totalCount, int curPage, int listCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		
		makePaging();
	}
	
	// �? 게시�? ?��, ?��?�� ?��?���?, ?��?���? ?�� 게시�? ?��, ?��?���? 카운?�� ?��?��?��?�� ?��?��?��
	public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		this.setPageCount(pageCount);
			
		makePaging();
	}
	
	
	private void makePaging() {
		if(totalCount == 0) return; // 게시�??�� ?��?�� 경우 중단
		
		// 기본�? ?��?��
		if(curPage == 0) setCurPage(1); // 첫페?���?�? ?��?��
		if(listCount == 0) setListCount(10); // 게시�? 10개로 ?��?��
		if(pageCount == 0) setPageCount(10); // ?��?���? 10개로 ?��?��
		
		
		// �? ?��?���? ?�� 계산
		totalPage = totalCount / listCount;
		if( totalCount % listCount >0) totalPage++;
		
		// ?��?�� ?��?���?�? �? ?��?���?보다 ?���? ?��?��?���? 강제�? 마�?�? ?��?���?�? 고정
		if(totalPage < curPage) curPage = totalPage;
		
		// ?��면에 보이?�� ?��?��?��?���? & ?�� ?��?���? 번호 계산
		startPage = ((curPage-1)/pageCount)*pageCount+1;
		endPage = startPage+pageCount-1;

		// 마�?막으�? 계산?�� ?��?���?�? totalPage보다 커질경우 강제�? 최종?��?���?까�?�? 보이?���? ?��?��
		if(endPage>totalPage) endPage = totalPage;

		// ?��면에 보이?�� ?��?�� 게시�? & ?�� 게시�? 번호 계산
		startNo = (curPage-1)*listCount+1;
		endNo = curPage*listCount;


	}
	
	
	@Override
	public String toString() {
		return "Paging [curPage=" + curPage + ", totalCount=" + totalCount + ", listCount=" + listCount + ", totalPage="
				+ totalPage + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startNo=" + startNo + ", endNo=" + endNo + "]";
	}


	public int getCurPage() {
		return curPage;
	}


	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getListCount() {
		return listCount;
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
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


	public int getStartNo() {
		return startNo;
	}


	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}


	public int getEndNo() {
		return endNo;
	}


	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	
	
}
