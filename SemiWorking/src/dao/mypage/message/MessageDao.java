package dao.mypage.message;

import java.util.List;

import dto.Message;
import dto.Users;
import util.Paging;

public interface MessageDao {
		
		// �씫�� �긽�깭 �뾽�뜲�씠�듃
		public void updateRead(int m_no);
		
//		// 硫붿떆吏� �궘�젣
//		public void deleteMesssage(int m_no);
		
		// 履쎌� 蹂대궡湲�
		public void insertMsg(Message msg);
		
		// 履쎌� �럹�씠吏� 泥섎━ 由ъ뒪�듃 諛섑솚
		public List selectMsgPagingList(int side, int u_no, Paging paging);
		
		// 珥� 履쎌� �닔 諛섑솚
		public int cntMsg(int side, int u_no);
		
		// 由ъ뒪�듃�뿉�꽌 履쎌� �꽑�깮
		public Message selectMsgByMno(int m_no);
		
		public Users selectUserName(int u_no);
		
		
	
	
}
