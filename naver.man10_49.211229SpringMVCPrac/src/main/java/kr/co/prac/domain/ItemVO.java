package kr.co.prac.domain;

import lombok.Data;

@Data
public class ItemVO {
	private int item_num;
	private String item_name;
	private int item_price;
	private String item_description;
	private String item_picture;
}
