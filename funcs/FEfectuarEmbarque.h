/****************************************************************************
** Esta función permite controlar el embarque de los pasajeros
**
** FEfectuarEmbarque.h
*****************************************************************************/

#ifndef FEFECTUAREMBARQUE_H
#define FEFECTUAREMBARQUE_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fefectuarembarque.h"


/**
 * @brief Esta función permite controlar el embarque de los pasajeros
 *
 **/
class FEfectuarEmbarque : public QFrame, public Ui::FEfectuarembarque {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FEfectuarEmbarque(QWidget * parent = NULL);
};

#endif
