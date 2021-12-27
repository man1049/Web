package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import dao.ItemDao;
import domain.CollectionBean;
import domain.Item;

public class Main {

	public static void main(String[] args) {
		
		//ItemDao dao = new ItemDao();
		
		//Spring Container를 이용해서 인스턴스 가져오기
		/*
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		ItemDao item = context.getBean("ItemDao",ItemDao.class);
		
		System.out.println(item.getItem());
		*/
		/*
		GenericXmlApplicationContext context =
		new GenericXmlApplicationContext("applicationContext.xml");
		
		Item item = context.getBean("item",Item.class);
		
		System.out.println(item.toString());
		*/
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean cb = context.getBean("CB",CollectionBean.class);
		
		System.out.println(cb);
		
		context.close();
		
		

	}

}
