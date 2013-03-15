/**
 * @file fun_consultarfichaempleado.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Esta función permite ver la ficha de los empleados.
 * Además es la encargada de gestionar todo lo relativo al
 * registro de empleados.
 *
 */

#ifndef FUN_CONSULTARFICHAEMPLEADO_H
#define FUN_CONSULTARFICHAEMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"
#include "usuario.h"

// Declaración anticipada
struct tFichaEmpleado;

/**
 * @brief Esta función permite ver la ficha de los empleados y
 * gestionar el registro de empleados.
 *
 * @see FunRegistrarEmpleado
 * 
 */
class FunConsultarFichaEmpleado : public QFunc {
public:
	/**
	 * Constructor aportando usuario.
	 *
	 * @param usuario Estructura representando un usuario válido.
	 */
	FunConsultarFichaEmpleado(const Usuario * usuario = NULL);

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;


	// FUNCIONES PROPIAS

	/**
	 * @brief Destructor de la función.
	 *
	 **/
	~FunConsultarFichaEmpleado();
	
	/**
	 * @brief Obtiene la lista de empleados.
	 *
	 * @return const vector< tFichaEmpleado >&
	 **/
	const std::vector<tFichaEmpleado> &getListaEmpleados() const;

	/**
	 * @brief Inserta un empleado en la lista de empleados.
	 *
	 * @param empleado Estructura de empleado.
	 * @return @c true si la operación ha finalizado correctamente.
	 **/
	bool insertarEmpleado(const tFichaEmpleado &empleado);

private:
	QFrame * _frame;
	const Usuario * _usuario;

	/**
	 * @brief Lee la lista de empleados desde la base de datos (un archivo normal)
	 * a las estructuras internas del programa.
	 *
	 * @return void
	 **/
	void leerListaEmpleados();

	/**
	 * @brief Lista de empleados.
	 **/
	std::vector<tFichaEmpleado> _listaEm;
};

/**
 * @brief Estructura de empleado
 **/
struct tFichaEmpleado {
	
	/**
	 * @brief Constructor de empleado detallado.
	 *
	 * @param nif NIF
	 * @param nombre Nombre
	 * @param apellido1 Primer apellido
	 * @param apellido2 Segundo apeliido
	 * @param activo ¿Está el empleado activo?
	 * @param dpto Departamento
	 **/
	tFichaEmpleado(std::string nif, std::string nombre, std::string apellido1, std::string apellido2, bool activo, int dpto) :
	nif(nif), nombre(nombre), apellido1(apellido1), apellido2(apellido2), activo(activo), dpto(dpto){};

	/**
	 * @brief Constructor de empleado por defecto (valores indeterminados).
	 *
	 **/
	tFichaEmpleado(){};

	std::string nif;
	std::string nombre;
	std::string apellido1;
	std::string apellido2;

	bool activo;
	int dpto;
};

/**
 * @brief Operador para impresión de empleados (serializados) en archivos.
 *
 * @param out Flujo de salida.
 * @param emp Estructura de empleado.
 * @return ostream
 **/
std::ostream& operator <<(std::ostream &out, const tFichaEmpleado &emp);

/**
 * @brief Operador para lectura de empleados (serializados) desde archivos.
 *
 * @param in Flujo de entrada.
 * @param emp Estructura de empleado.
 * @return istream
 **/
std::istream& operator >>(std::istream &in, tFichaEmpleado &emp);

#endif // FUN_CONSULTARFICHAEMPLEADO_H
