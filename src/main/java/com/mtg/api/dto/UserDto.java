package com.mtg.api.dto;

import java.util.List;

public class UserDto {

	private String name;
	
	private List<ListDto> list;
	
	public UserDto() {
		
	}

	public List<ListDto> getList() {
		return list;
	}

	public void setList(List<ListDto> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
