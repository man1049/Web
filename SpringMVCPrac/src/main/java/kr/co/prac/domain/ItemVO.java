package kr.co.prac.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;


//DTO 클래스를 하나의 XML 태그로 변환하기 위한 작업
//propOrder에 포함된 항목만 순서대로 출력 됨
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="",propOrder = {
		"item_num","item_name","item_price","item_description","item_picture"
})

@Data
public class ItemVO {
	private int item_num;
	private String item_name;
	private int item_price;
	private String item_description;
	private String item_picture;
}
