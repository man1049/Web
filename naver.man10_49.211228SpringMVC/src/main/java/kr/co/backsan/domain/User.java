package kr.co.backsan.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class User {
	private String id;
	private String pw;
	private String mail;
	private String gend;
}
