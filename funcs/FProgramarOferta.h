/****************************************************************************
** Esta función permite al empleado de administración encargado en programa ofertas incluir una de estas en el sistema de la empresa.
**
** FProgramarOferta.h
*****************************************************************************/

#ifndef FPROGRAMAROFERTA_H
#define FPROGRAMAROFERTA_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fprogramaroferta.h"


/**
 * @brief Esta función permite al empleado de administración encargado en programa ofertas incluir una de estas en el sistema de la empresa.
 *
 **/
class FProgramarOferta : public QFrame, public Ui::FProgramaroferta {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FProgramarOferta(QWidget * parent = NULL);
};

#endif
