/**
 * @file usuario.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase identificadora del usuario.
 */

#include "usuario.h"

using namespace std;

Usuario::Usuario(string nombre){
	_nombre = nombre;
	_credenciales = NULL;
}

bool Usuario::solicitarAcceso(string clave){
	// Supuestamente realiza transacciones con la base de datos

	if (_nombre == "hsimpson@ace.es" && clave == "rosquillas"){
		_credenciales = new Credenciales(Funcionalidad::CONSULTAR_PLAN_VUELO, Funcionalidad::BAJA_CLIENTE, Funcionalidad::REGISTRAR_MATERIAL, Funcionalidad::CONSULTAR_PLAN_VUELO);
		_nombre = "Homer J.";
		_apellidos = "Simpson";
		_puesto = "Vicepresidente ejecutivo de Seguridad aérea";
	}

	else if (_nombre == "root" && clave == "root") {
		_credenciales = new Credenciales(Funcionalidad::CONSULTAR_PLAN_VUELO, Funcionalidad::BAJA_CLIENTE, Funcionalidad::ORG_LABORAL, Funcionalidad::PROGRAMAR_REVISION, Funcionalidad::REGISTRAR_MATERIAL, Funcionalidad::CONSULTA_NOMINA, Funcionalidad::EDITAR_EMPLEADO, Funcionalidad::EDITAR_INFO_ECONOMICA, Funcionalidad::MODIFICAR_ITEMS_INVENTARIO, Funcionalidad::PROGRAMAR_HORARIOS, Funcionalidad::PROGRAMAR_OFERTA, Funcionalidad::REGISTRAR_EMPLEADO, Funcionalidad::VERIFICAR_REGISTRO, Funcionalidad::INTRODUCIR_PLAN_VUELO, Funcionalidad::BAJA_EMPLEADO, Funcionalidad::CONSULTAR_INVENTARIO, Funcionalidad::CONSULTAR_EMPLEADO, Funcionalidad::EFECTUAR_EMBARQUE, Funcionalidad::CONFIG_NOMINA, Funcionalidad::CONSULTAR_PLAN_VUELO);
		_nombre = "Edgar Malcom";
		_apellidos = "Chalmers";
		_puesto = "Superintendente";
	}

	else if (_nombre == "nflanders@ace.es" && clave == "carambacarambitacarambola") {
		_credenciales = new Credenciales(Funcionalidad::PROGRAMAR_REVISION, Funcionalidad::REGISTRAR_MATERIAL, Funcionalidad::CONSULTA_NOMINA, Funcionalidad::MODIFICAR_ITEMS_INVENTARIO, Funcionalidad::PROGRAMAR_REVISION);
		_nombre = "Nedward";
		_apellidos = "Flanders";
		_puesto = "Jefe de Mantenimiento";
	}
	else if (_nombre == "cwiggum@ace.es" && clave == "ralph") {
		_credenciales = new Credenciales(Funcionalidad::CONSULTA_NOMINA, Funcionalidad::CONSULTA_NOMINA);
		_nombre = "Clancy";
		_apellidos = "Wiggum";
		_puesto = "Jefe de Seguridad";
	}

	return _credenciales != NULL;
}

bool Usuario::esValido() const {
	return _credenciales != NULL;
}
