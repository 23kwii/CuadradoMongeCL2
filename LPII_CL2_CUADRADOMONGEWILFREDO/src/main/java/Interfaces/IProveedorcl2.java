package Interfaces;

import java.util.List;

import model.TblProveedorcl2;



public interface IProveedorcl2 {
	//delaramos metodos
		void RegistrarProveedorcl2(TblProveedorcl2 proveedorcl2);
		void ActualizarProveedorcl2(TblProveedorcl2 proveedorcl2);
		void EliminarProveedorcl2(TblProveedorcl2 proveedorcl2);
		List<TblProveedorcl2> ListadoProveedorcl2();
		TblProveedorcl2 BuscarProveedorcl2(TblProveedorcl2 proveedorcl2);

	}//fin metodos
