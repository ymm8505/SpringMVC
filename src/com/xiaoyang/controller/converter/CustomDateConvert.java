package com.xiaoyang.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomDateConvert implements Converter<String,Date>{

	@Override
	public Date convert(String StrDate) {
		System.out.println( "----��ʽ���������========================");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(StrDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
