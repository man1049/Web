package wrapper;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MainRequestWrapper extends HttpServletRequestWrapper {
	
	HttpServletRequest request;

	public MainRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	public String[] getParameterValue(String[] name) {
		String[] strs = request.getParameterValues("name");
		String[] strs_copy = new String[strs.length];
		if(Arrays.toString(strs) == null) {
			return null;
		}
		for(int i = 0 ; i < strs.length ; i++) {
			strs_copy[i] = strs[i].toUpperCase();
		}
		System.out.println(Arrays.toString(strs_copy));
		
		return strs_copy;
	}
}
