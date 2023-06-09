package com.appstracta.bo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.appstracta.bean.CityBean;
import com.appstracta.dao.CityDao;
import com.appstracta.dto.CityDto;
import com.appstracta.exceptions.InternalException;

public class CityBo {

	private final CityDao cityDao;

	public CityBo() {
		this.cityDao = new CityDao();
	}

	public List<CityBean> obtenerTodos() throws InternalException {
		try {
			return this.cityDao.obtenerTodos();
		} catch (InternalException ex) {
			throw ex;
		}
	}

	public CityBean obtenerPorId(int cityId) throws InternalException {
		if (cityId <= 0) {
			throw new InternalException("El id de la ciudad debe ser mayor 0");
		}

		try {
			CityBean ciudad = this.cityDao.obtenerPorId(cityId);

			if (ciudad.getCityId() > 0 && ciudad.getCity() != null) {
				return ciudad;
			}

			throw new InternalException(String.format("El id %d de ciudad no se encuentra registrado", cityId));
		} catch (InternalException ex) {
			throw ex;
		}
	}

	public CityBean guardar(CityDto cityDto) throws InternalException {
		if ((cityDto == null) || (cityDto.getCountryId() <= 0) || (null == cityDto.getCity()) || (null == cityDto.getUpdate())) {
			throw new InternalException("Debes mandar todos los valores de la ciudad para guardarla");
		}

		try {
			return this.cityDao.guardar(cityDto);
		} catch (InternalException ex) {
			throw ex;
		}
	}

	public CityBean actualizar(CityDto cityDto, int cityId) throws InternalException {
		if (cityId <= 0 || (cityDto == null) || (cityDto.getCountryId() <= 0) || (null == cityDto.getCity()) || (null == cityDto.getUpdate())) {
			throw new InternalException("Debes mandar todos los valores de la ciudad para actualizarla");
		}

		try {
			return this.cityDao.actualizar(cityDto, cityId);
		} catch (InternalException ex) {
			throw ex;
		}
	}

	public int borrar(int cityId) throws InternalException {
		if (cityId <= 0) {
			throw new InternalException("El id de la ciudad debe ser mayor a 0");
		}

		try {
			return this.cityDao.borrar(cityId);
		} catch (InternalException ex) {
			throw ex;
		}
	}

	public void crearArchivo() throws InternalException{
		try {
			List<CityBean> ciudades = this.obtenerTodos();

			try (FileWriter writer = new FileWriter("ciudades.txt")) {
				for (CityBean ciudad : ciudades) {
					writer.write(ciudad + System.lineSeparator());
				}
			}
		}
		catch (InternalException ex) {
			throw ex;
		} catch (IOException ex) {
			throw new InternalException("Ocurrió un error al generar el archivo de ciudades");
		}
	}

	public String obtenerPorIdStore(int cityId) throws InternalException {
		if (cityId <= 0) {
			throw new InternalException("El id de la ciudad debe ser mayor 0");
		}

		try {
			String ciudad = this.cityDao.obtenerPorIdStore(cityId);

			if (Objects.nonNull(ciudad)) {
				return ciudad;
			}

			throw new InternalException(String.format("El id %d de ciudad no se encuentra registrado", cityId));
		} catch (InternalException ex) {
			throw ex;
		}
	}

}
