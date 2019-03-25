package service.mypage.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Message;
import dto.Users;
import util.Paging;

public interface MessageService {


		// 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙트
		public void updateRead(int m_no);
			
		// 占쏙옙占쏙옙 占쏙옙占쏙옙
//		public void deleteMessage(int m_no);
		
		
		// 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		public void sendMsg(Message msg);
		
		// 占쏙옙청占식띰옙占쏙옙沽占쏙옙占� curPage 占쏙옙환
		public int getCurPage(HttpServletRequest req);

		
		// 履쎌� �럹�씠吏� 泥섎━ 由ъ뒪�듃 諛섑솚
		public List getMsgPagingList(int side, int u_no, Paging paging);
		
		// 珥� 履쎌� �닔 諛섑솚
		public int getTotalMsgCount(int side, int u_no);
		
		// �꽑�깮�븳 履쎌� 諛섑솚
		public Message getMsgByMno(int m_no);
		
		public Users getUserName(int u_no);
	
}
