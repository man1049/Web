package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	//접속 중인 세션의 개수를 저장하기 위한 변수
	private static int count;

	//count를 리턴하는 메서드 - getter
	public static int getCount() {
		return count;
	}

	//세션이 생성 될 대 호출되는 메서드
    @Override
    public void sessionCreated(HttpSessionEvent se)  { 

    	//세션의 수명을 설정
    	HttpSession session = se.getSession();
    	session.setMaxInactiveInterval(60*5);
    	
    	count = count + 1;
    	System.out.println("현재 접속자 수 : " + count);

    }

    //세션이 소멸 될 때 호출되는 메서드
    @Override
    public void sessionDestroyed(HttpSessionEvent se)  { 

    	count = count - 1;
    	System.out.println("현재 접속자 수 : " + count);

    }
	
}
