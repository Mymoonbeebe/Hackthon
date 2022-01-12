package com.mini.project;

public class Main {
	public static void main(String[] args) throws Exception
	{
		OnlineFurnitureStore ofs=new OnlineFurnitureStore();
		ofs.readconfigProperties();
		ofs.ValidatepageTitle();
	ofs.selectFurniture();
	ofs.countCategory();
	ofs.closebrowser();
	}
}
