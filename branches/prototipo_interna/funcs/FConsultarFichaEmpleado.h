/**
 * @file FConsultarFichaEmpleado.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Esta función permite ver la ficha de los empleados.
 */

#ifndef FCONSULTARFICHAEMPLEADO_H
#define FCONSULTARFICHAEMPLEADO_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fconsultarfichaempleado.h"


// Declaraciones aplazadas
struct tFichaEmpleado;
class FunConsultarFichaEmpleado;

/**
 * @brief Esta funcion permite ver la ficha de los empleados
 *
 **/
class FConsultarFichaEmpleado : public QFrame, public Ui::FConsultarfichaempleado {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param empleados Clase de la función de empleados.
	 * @param registrarActivo Si está activa la opción registrar.
	 * @param bajaActiva Si está activa la opción dar de baja.
	 * @param editarActiva Si está activa la opción editar.
	 * @param parent Componente padre (por defecto @c NULL).
	 */	
	FConsultarFichaEmpleado(FunConsultarFichaEmpleado* empleados, bool registrarActivo, bool bajaActiva, bool, QWidget* parent = 0);

private slots:
	void buscarLista();
	void clickRegistrar(bool);
	void clickDarBaja(bool);
private:

	/**
	 * @brief Puntero a la clase de función con la que opera.
	 **/
	FunConsultarFichaEmpleado * _empleados;
	
	/**
	 * @brief Carga una lista de empleados en el control de lista del marco.
	 *
	 * @return void
	 **/
	void cargarListaEmpleados(std::vector <tFichaEmpleado> lista);

	/**
	 * @brief Inserta un empleado en la estructura de lista
	 *
	 * @param emple Estructura de empleado
	 * @return void
	 **/
	void appendEmpleado(const tFichaEmpleado &emple);
};

#endif
