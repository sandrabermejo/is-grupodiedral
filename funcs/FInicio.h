/****************************************************************************
** Pantalla empotrable de inicio
**
** FInicio.h
*****************************************************************************/

#ifndef FINICIO_H
#define FINICIO_H

// Biblioteca Qt
#include <QFrame>

#include "ui_finicio.h"


/**
 * @brief Pantalla empotrable de inicio.
 *
 **/
class FInicio : public QFrame, public Ui::FInicio {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FInicio(QWidget * parent = NULL);
};

#endif
