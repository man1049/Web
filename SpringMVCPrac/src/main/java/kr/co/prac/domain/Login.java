package kr.co.prac.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Login {
	//@Email
	@Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,6})$", 
	message="이메일의 형식이 아닙니다.")
	@NotNull(message = "공백은 사용이 불가능합니다.")
	private String email;
	@Size(min = 8, max = 32 ,message = "8자부터 32자가 아닙니다.")
	@NotNull(message = "공백은 사용이 불가능합니다.")
	private String pw;
	private String loginType;
}
