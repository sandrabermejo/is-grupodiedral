/****************************************************************************
** Consulta la nómina de un mes seleccionado.
**
** fun_consultanomina.h
*****************************************************************************/

#ifndef FUN_CONSULTANOMINA_H
#define FUN_CONSULTANOMINA_H

// Biblioteca Qt
#include <QFrame>
#include "qfunc.h"

#include "ui_fconsultanomina.h"


/**
 * @brief Consulta la nómina de un mes seleccionado.
 *
 **/
class FunConsultaNomina : public QFrame, public Ui::FConsultaNomina, public QFunc {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FunConsultaNomina(QWidget * parent = NULL);

	/*
	 * Funciones heredadas de QFunc
	*/
	
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;
	
private:
	bool _activo;
};

#endif
