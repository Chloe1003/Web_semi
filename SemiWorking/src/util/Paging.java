package util;

public class Paging {

	private int curPage; // ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸ (?„ ?ƒ?•œ ?˜?´ì§?)
	
	private int totalCount; // ì´? ê²Œì‹œê¸? ?ˆ˜ (DB ì¡°íšŒ ê²°ê³¼ë¡? ?–»?–´?˜´)
	private int listCount; // ?•œ ?˜?´ì§??‹¹ ì¶œë ¥?  ê²Œì‹œê¸? ?ˆ˜ (ì§ì ‘ ?„¤? •?•¨)
	private int totalPage; // ì´? ?˜?´ì§? ?ˆ˜ (ê³„ì‚°?œ¼ë¡? ?•Œ?•„?ƒ„)
	
	private int pageCount; // ?•œ ?™”ë©´ì— ì¶œë ¥?  ?˜?´ì§? ?ˆ˜ (ì§ì ‘ ?„¤? •?•¨)
	private int startPage; // ?™”ë©´ì— ë³´ì´?Š” ?‹œ?‘ ?˜?´ì§? (ê³„ì‚°?œ¼ë¡? ?•Œ?•„?ƒ„)
	private int endPage; // ?™”ë©´ì— ë³´ì´?Š” ? ?˜?´ì§? (ê³„ì‚°?œ¼ë¡? ?•Œ?•„?ƒ„)
	
	private int startNo; // ê²Œì‹œê¸? ?‹œ?‘ë²ˆí˜¸ (ê³„ì‚°?œ¼ë¡? ?•Œ?•„?ƒ„)
	private int endNo; // ê²Œì‹œê¸? ? ë²ˆí˜¸ (ê³„ì‚°?œ¼ë¡? ?•Œ?•„?ƒ„)
	
	// ì´? ê²Œì‹œê¸? ?ˆ˜ë§? ?…? ¥?•˜?Š” ?ƒ?„±?
	public Paging(int totalCount) {
		this.setTotalCount(totalCount);
		
		makePaging();
	}
	
	// ì´? ê²Œì‹œê¸? ?ˆ˜, ?˜„?¬ ?˜?´ì§? ?…? ¥?•˜?Š” ?ƒ?„±?
	public Paging(int totalCount, int curPage) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		
		makePaging();
	}
	
	// ì´? ê²Œì‹œê¸? ?ˆ˜, ?˜„?¬ ?˜?´ì§?, ?˜?´ì§? ?‹¹ ê²Œì‹œê¸? ?ˆ˜ ?…? ¥?•˜?Š” ?ƒ?„±?
	public Paging(int totalCount, int curPage, int listCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		
		makePaging();
	}
	
	// ì´? ê²Œì‹œê¸? ?ˆ˜, ?˜„?¬ ?˜?´ì§?, ?˜?´ì§? ?‹¹ ê²Œì‹œê¸? ?ˆ˜, ?˜?´ì§? ì¹´ìš´?Š¸ ?…? ¥?•˜?Š” ?ƒ?„±?
	public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		this.setTotalCount(totalCount);
		this.setCurPage(curPage);
		this.setListCount(listCount);
		this.setPageCount(pageCount);
			
		makePaging();
	}
	
	
	private void makePaging() {
		if(totalCount == 0) return; // ê²Œì‹œê¸??´ ?—†?Š” ê²½ìš° ì¤‘ë‹¨
		
		// ê¸°ë³¸ê°? ?„¤? •
		if(curPage == 0) setCurPage(1); // ì²«í˜?´ì§?ë¡? ?„¤? •
		if(listCount == 0) setListCount(10); // ê²Œì‹œê¸? 10ê°œë¡œ ?„¤? •
		if(pageCount == 0) setPageCount(10); // ?˜?´ì§? 10ê°œë¡œ ?„¤? •
		
		
		// ì´? ?˜?´ì§? ?ˆ˜ ê³„ì‚°
		totalPage = totalCount / listCount;
		if( totalCount % listCount >0) totalPage++;
		
		// ?˜„?¬ ?˜?´ì§?ê°? ì´? ?˜?´ì§?ë³´ë‹¤ ?¬ê²? ?…? ¥?˜ë©? ê°•ì œë¡? ë§ˆì?ë§? ?˜?´ì§?ë¡? ê³ ì •
		if(totalPage < curPage) curPage = totalPage;
		
		// ?™”ë©´ì— ë³´ì´?Š” ?‹œ?‘?˜?´ì§? & ? ?˜?´ì§? ë²ˆí˜¸ ê³„ì‚°
		startPage = ((curPage-1)/pageCount)*pageCount+1;
		endPage = startPage+pageCount-1;

		// ë§ˆì?ë§‰ìœ¼ë¡? ê³„ì‚°?œ ?˜?´ì§?ê°? totalPageë³´ë‹¤ ì»¤ì§ˆê²½ìš° ê°•ì œë¡? ìµœì¢…?˜?´ì§?ê¹Œì?ë§? ë³´ì´?„ë¡? ?„¤? •
		if(endPage>totalPage) endPage = totalPage;

		// ?™”ë©´ì— ë³´ì´?Š” ?‹œ?‘ ê²Œì‹œê¸? & ? ê²Œì‹œê¸? ë²ˆí˜¸ ê³„ì‚°
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
