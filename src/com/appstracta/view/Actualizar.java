package com.appstracta.view;

import java.util.Date;

import com.appstracta.bean.CityBean;
import com.appstracta.bo.CityBo;
import com.appstracta.dto.CityDto;
import com.appstracta.exceptions.InternalException;

public class Actualizar {

	public static void main(String[] args) {
		try {
			CityBo cityBo = new CityBo();
			CityBean ciudad = cityBo.actualizar(new CityDto("Apaeo el Grande", new Date(), 60), 1000);

			System.out.println(ciudad);
		} catch (InternalException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
