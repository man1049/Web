package kr.co.prac.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
//최상위 태그 이름 설정
@XmlRootElement(name = "ANIMALS")
public class ItemReport {
	//객체 하나마다 생성 될 태그 이름을 설정
	@XmlElement(name = "ANIMAL")
	private List<ItemVO> list;
	
	//생성자
	public ItemReport() {
		
	}
	
	public ItemReport(List<ItemVO> list) {
		this.list = list;
	}
	
	public List<ItemVO> getList(){
		return list;
	}

}
