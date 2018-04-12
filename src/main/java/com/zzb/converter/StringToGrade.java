package com.zzb.converter;

import org.springframework.core.convert.converter.Converter;

import com.zzb.entity.Grade;

public class StringToGrade implements Converter<String, Grade>{

	@Override
	public Grade convert(String arg0) {
		
		return Grade.valueOf(Grade.class,arg0);
	}

}
