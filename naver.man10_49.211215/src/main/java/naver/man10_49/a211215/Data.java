package naver.man10_49.a211215;

import java.io.Serializable;
import java.util.Arrays;

//Comparable은 크기 비교를 위한 compareTo 메서드를 소유한 인터페이스
//Cloneable은 인스턴스를 복제 할 수 있는 clone 메서드를 소유한 인터페이스
//Serializable은 인스턴스를 직렬화하는데 사용 - 다른 곳으로 전송

public class Data implements Comparable, Cloneable, Serializable {
	private int num;
	private String name;
	private int scores[];
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	//배열이나 List가 있을 때는 인덱스를 받아서 1개를 리턴하고
	//설정하는 메서드도 추가해주면 좋음
	public int getScore(int idx) {
		return scores[idx];
	}
	public void setScore(int score, int idx) {
		scores[idx] = score;
	}
	
	//등가성을 위한 메서드
	//빠르게 비교하기 위해서는 hashCode를 이용하는 방법이 있음
	@Override
	public int hashCode() {
		return num;
	}
	
	//equals 메서드
	@Override
	public boolean equals(Object other) {
		Data data = (Data)other;
		
		if(this.num == data.getNum() && this.name.equals(data.getName())) {
			return true;
		}
		
		return false;
	}
	
	//디버깅을 위한 메서드
	@Override
	public String toString() {
		return "Data [num=" + num + ", name=" + name + ", scores=" + Arrays.toString(scores) + "]";
	}
	
	//크기 비교 할 때 사용하는 메서드
	//배열이나 List의 데이터를 정렬 할 때 사용
	@Override
	public int compareTo(Object o) {
		Data data = (Data)o;
		return num - data.num;
	}
	
	//인스턴스를 복제하기 위한 메서드
	@Override
	public Data clone() {
		Data data = new Data();
		
		//문자열은 복사 생성자를 이용해서 복제
		data.name = new String(name);
		data.num = num;
		//배열이나 List를 메모리에 공간을 생성 한 후
		//요소를 하나씩 복제
		data.scores = new int[scores.length];
		for(int i = 0 ; i < scores.length ; i++) {
			data.scores[i] = scores[i];
		}
		return data;
	}
}
