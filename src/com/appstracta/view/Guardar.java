package com.appstracta.view;

import java.util.Date;

import com.appstracta.bean.CityBean;
import com.appstracta.bo.CityBo;
import com.appstracta.dto.CityDto;
import com.appstracta.exceptions.InternalException;

public class Guardar {

	public static void main(String[] args) {
		try {
			CityBo cityBo = new CityBo();

			CityBean ciudad = cityBo.guardar(new CityDto("Apaseo el Alto", new Date(), 60));
			System.out.println(ciudad);
		} catch (InternalException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
