package com.guest.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.dao.MessageDao;
import com.guest.jdbc.ConnectionProvider;
import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;

/**
 * Servlet implementation class MessageDaoInsertTestServlet
 */
@WebServlet("/MessageDaoInsertTestServlet")
public class MessageDaoInsertTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageDaoInsertTestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {		
//		conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:guestbook");			
		conn = ConnectionProvider.getConnection();
		Message message = new Message();
		message.setGuestName("홍길동"+ Math.floor(Math.random()*100));
		message.setPassword("hong");
		message.setMessage("홍길동 다녀감"+Math.random());
		

//		MessageDao dao1 = new MessageDao(); 해당 인스턴스가 하나만 있게 보장하려고 아래와 같이 한다.
		MessageDao dao = MessageDao.getInstance();
		dao.insert(conn, message);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
