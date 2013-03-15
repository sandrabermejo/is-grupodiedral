/**
 * @file funcionalidad.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase que centraliza el soporte a las funcionalidades de la aplicación.
 */

#include "funcionalidad.h"
#include "qfunc.h"

// Clases de funciones
#include "fun_inicio.h"
#include "fun_consultanomina.h"
#include "fun_orglaboral.h"
#include "fun_registrarmaterial.h"
#include "fun_registrarempleado.h"
#include "fun_editarinfoeconomica.h"
#include "fun_efectuarembarque.h"
#include "fun_verificarregistroempleado.h"
#include "fun_consultarplanvuelo.h"
#include "fun_confignomina.h"
#include "fun_consultarfichaempleado.h"
#include "fun_consultarinventario.h"
#include "fun_bajacliente.h"
#include "fun_bajaempleado.h"
#include "fun_editaempleado.h"
#include "fun_introducirplanvuelo.h"
#include "fun_modificarinventario.h"
#include "fun_programarhorarios.h"
#include "fun_programarrevision.h"
#include "fun_programaroferta.h"

using namespace std;

/**
 * @brief Macro para abreviar la inclusión de funcionalidades.
 * 
 * @note Funciona sólo en su contexto.
 */
#define nuevaFunc(TIPO) _funcs[id] = (ret = new TIPO);

Funcionalidad::Funcionalidad(const char*) : _parent(NULL) {
	// De momento no tiene en cuenta locale
}

void Funcionalidad::setContexto(const Usuario * usuario, QWidget* parent){
	_parent = parent;
	_usuario = usuario;
}

QFunc* Funcionalidad::getFunc(Funcionalidad::IdFunc id){
	QFunc * ret = NULL;

	// Busca la funcionalidad entre las ya instanciadas.
	ret = _funcs[id];
	

	// Si no está instanciada la funcionalidad
	if (ret == NULL)
		switch(id){
			case INICIO :
				nuevaFunc(FunInicio()); break;
			case CONSULTA_NOMINA :
				nuevaFunc(FunConsultaNomina(_parent)); break;
			case ORG_LABORAL :
				nuevaFunc(FunOrgLaboral()); break;
			case REGISTRAR_MATERIAL :
				nuevaFunc(FunRegistrarMaterial()); break;
			case REGISTRAR_EMPLEADO :
				nuevaFunc(FunRegistrarEmpleado((FunConsultarFichaEmpleado *) getFunc(Funcionalidad::CONSULTAR_EMPLEADO))); break;
			case EDITAR_INFO_ECONOMICA :
				nuevaFunc(FunEditarInfoEconomica()); break;
			case EFECTUAR_EMBARQUE :
				nuevaFunc(FunEfectuarEmbarque()); break;
			case VERIFICAR_REGISTRO :
				nuevaFunc(FunVerificarRegistroEmpleado()); break;
			case CONSULTAR_PLAN_VUELO :
				nuevaFunc(FunConsultarPlanVuelo()); break;
			case CONFIG_NOMINA :
				nuevaFunc(FunConfigNomina()); break;
			case CONSULTAR_EMPLEADO :
				nuevaFunc(FunConsultarFichaEmpleado(_usuario)); break;
			case CONSULTAR_INVENTARIO :
				nuevaFunc(FunConsultarInventario()); break;
			case BAJA_CLIENTE :
				nuevaFunc(FunBajaCliente()); break;
			case BAJA_EMPLEADO :
				nuevaFunc(FunBajaEmpleado()); break;
			case EDITAR_EMPLEADO :
				nuevaFunc(FunEditaEmpleado()); break;
			case INTRODUCIR_PLAN_VUELO :
				nuevaFunc(FunIntroducirPlanVuelo()); break;
			case MODIFICAR_ITEMS_INVENTARIO :
				nuevaFunc(FunModificarInventario()); break;
			case PROGRAMAR_HORARIOS :
				nuevaFunc(FunProgramarHorarios()); break;
			case PROGRAMAR_REVISION :
				nuevaFunc(FunProgramarRevision()); break;
			case PROGRAMAR_OFERTA :
				nuevaFunc(FunProgramarOferta()); break;
			default : ;
		}

	// Puede devolver NULL si no está soportado
	return ret;
}

vector<Funcionalidad::IdFunc> Funcionalidad::getFuncIds(){
	vector<IdFunc> ret;

	// Método partiendo de la premisa (potencialmente falsa) de que los enum tiene valores enteros consecutivos
	for (IdFunc i = INICIO; i <= CONFIG_NOMINA; i = IdFunc(i + 1))
		ret.insert(ret.end(), i);

	/*
	 * En C++11 se haría así:

	 ret.assign({INICIO, CONSULTAR_PLAN_VUELO, BAJA_CLIENTE, ORG_LABORAL, PROGRAMAR_REVISION, REGISTRAR_MATERIAL, CONSULTA_NOMINA,
	 	EDITAR_EMPLEADO, EDITAR_INFO_ECONOMICA, MODIFICAR_ITEMS_INVENTARIO, PROGRAMAR_HORARIOS, PROGRAMAR_OFERTA,
		REGISTRAR_EMPLEADO, VERIFICAR_REGISTRO, INTRODUCIR_PLAN_VUELO, BAJA_EMPLEADO, CONSULTAR_INVENTARIO, CONSULTAR_EMPLEADO,
		EFECTUAR_EMBARQUE});
	*/

	return ret;
}

Funcionalidad::~Funcionalidad(){
	for (map<IdFunc, QFunc *>::iterator it = _funcs.begin(); it != _funcs.end(); it++){
		if (it->second != NULL)
			delete it->second;
	}
}