package Interfaces;

import java.util.List;

import model.TblUsuariocl2;



public interface IUsuariocl2 {
	//delaramos metodos
	void RegistrarUsuariocl2(TblUsuariocl2 usuariocl2);
	void ActualizarUsuariocl2(TblUsuariocl2 usuariocl2);
	void EliminarUsuariocl2(TblUsuariocl2 usuariocl2);
	List<TblUsuariocl2> ListadoUsuariocl2();
	TblUsuariocl2 BuscarUsuariocl2(TblUsuariocl2 usuariocl2);

}//fin metodos
