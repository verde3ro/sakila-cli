package com.appstracta.view;

import com.appstracta.bean.CityBean;
import com.appstracta.bo.CityBo;
import com.appstracta.exceptions.InternalException;

public class ObtenerPorId {

	public static void main(String[] args) {
		try {
			CityBo cityBo = new CityBo();
			CityBean ciudad = cityBo.obtenerPorId(600);

			System.out.println(ciudad);
		} catch (InternalException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
