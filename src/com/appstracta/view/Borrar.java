package com.appstracta.view;

import com.appstracta.bo.CityBo;
import com.appstracta.exceptions.InternalException;

public class Borrar {

	public static void main(String[] args) {
		try {
			CityBo cityBo = new CityBo();
			int cityId = cityBo.borrar(1000);

			System.out.printf("El id %d de ciudad se borro correctamente", cityId);
		} catch (InternalException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
