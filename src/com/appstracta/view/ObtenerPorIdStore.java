package com.appstracta.view;

import com.appstracta.bo.CityBo;
import com.appstracta.exceptions.InternalException;

public class ObtenerPorIdStore {

	public static void main(String[] args) {
		try {
			CityBo cityBo = new CityBo();
			String ciudad = cityBo.obtenerPorIdStore(600);

			System.out.println("La ciudad es :: " + ciudad);
		} catch (InternalException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
