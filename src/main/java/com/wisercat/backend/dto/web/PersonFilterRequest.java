package com.wisercat.backend.dto.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PersonFilterRequest {

	private List<String> keys;
	private List<String> criteria;
	private List<String> values;

}
