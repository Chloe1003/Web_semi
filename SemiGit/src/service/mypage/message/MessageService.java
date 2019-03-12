package service.mypage.message;

import java.util.List;

import dto.Message;

public interface MessageService {

	// 사용자별 쪽지 조회
	public List getMessageListByUno(int u_no);
	
	// 선택한 쪽지 반환
	public Message getMessageByMno(int m_no);
	
	// 읽은 상태 업데이트
	public void updateRead(int m_no);
	
	// 쪽지 삭제
	public void deleteMessage(int m_no);
	
	
}
