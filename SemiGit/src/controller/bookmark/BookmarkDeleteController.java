package controller.bookmark;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bookmark.BookmarkDao;
import dao.bookmark.BookmarkDaoImpl;
import service.bookmark.BookmarkService;
import service.bookmark.BookmarkServiceImpl;


@WebServlet("/bookmark/delete")
public class BookmarkDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookmarkDao bDao = new BookmarkDaoImpl();
	private BookmarkService bServ = new BookmarkServiceImpl();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bm_no = Integer.parseInt(request.getParameter("bm_no"));
		
		bServ.deleteBookmark(bm_no);
		
		response.sendRedirect("/bookmark");
		
	}

}
