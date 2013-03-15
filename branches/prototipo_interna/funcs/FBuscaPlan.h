/****************************************************************************
** Pantalla de búsqueda de planes de vuelo para la gestión interna
**
** FBuscaPlan.h
*****************************************************************************/

#ifndef FBUSCAPLAN_H
#define FBUSCAPLAN_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fbuscaplan.h"


/**
 * @brief Pantalla de búsqueda de planes de vuelo para la gestión interna
 *
 **/
class FBuscaPlan : public QFrame, public Ui::FBuscaPlan {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FBuscaPlan(QWidget * parent = NULL);

private slots:
	void conmutarFechaDestino();
	void conmutarFechaOrigen();
	void clickBuscar();
};

#endif
