package com.appstracta.view;

import java.util.List;

import com.appstracta.bean.CityBean;
import com.appstracta.bo.CityBo;
import com.appstracta.exceptions.InternalException;

public class ObtenerTodos {

	public static void main(String[] args) {
		try {
			CityBo cityBo = new CityBo();
			List<CityBean> ciudades = cityBo.obtenerTodos();

			ciudades.forEach(System.out::println);
		} catch (InternalException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
