/****************************************************************************
** Esta función permite añadir un nuevo vuelo de la compañía
**
** FIntroducirPlanVuelo.h
*****************************************************************************/

#ifndef FINTRODUCIRPLANVUELO_H
#define FINTRODUCIRPLANVUELO_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fintroducirplanvuelo.h"


/**
 * @brief Esta función permite añadir un nuevo vuelo de la compañía.
 *
 **/
class FIntroducirPlanVuelo : public QFrame, public Ui::FIntroducirplanvuelo {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FIntroducirPlanVuelo(QWidget * parent = NULL);
};

#endif
