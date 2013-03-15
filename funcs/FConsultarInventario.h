/****************************************************************************
** Esta función permite al usuario ver el inventario por pantalla
**
** FConsultarInventario.h
*****************************************************************************/

#ifndef FCONSULTARINVENTARIO_H
#define FCONSULTARINVENTARIO_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fconsultarinventario.h"


/**
 * @brief Esta funcion permite al usuario ver el inventario por pantalla
 *
 **/
class FConsultarInventario : public QFrame, public Ui::FConsultarinventario {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FConsultarInventario(QWidget * parent = NULL);
};

#endif
