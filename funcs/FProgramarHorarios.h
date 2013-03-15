/****************************************************************************
** Esta funcion permite al personal administrativo programar el horario de un empleado.
**
** FProgramarHorarios.h
*****************************************************************************/

#ifndef FPROGRAMARHORARIOS_H
#define FPROGRAMARHORARIOS_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fprogramarhorarios.h"


/**
 * @brief Esta funcion permite al personal administrativo programar el horario de un empleado.
 *
 **/
class FProgramarHorarios : public QFrame, public Ui::FProgramarhorarios {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FProgramarHorarios(QWidget * parent = NULL);
};

#endif
