package dao;

import domain.Item;

public class ItemDao {
	public Item getItem() {
		Item item = new Item();
		item.setNum(1);
		item.setName("김백산");
		item.setAge(29);
		return item;

	}
}
