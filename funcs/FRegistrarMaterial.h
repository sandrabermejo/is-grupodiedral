/****************************************************************************
** Esta función registra un item en el inventario de la empresa.
**
** FRegistrarMaterial.h
*****************************************************************************/

#ifndef FREGISTRARMATERIAL_H
#define FREGISTRARMATERIAL_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fregistrarmaterial.h"


/**
 * @brief Esta funci¢n registra un item en el inventario de la empresa.
 *
 **/
class FRegistrarMaterial : public QFrame, public Ui::FRegistrarmaterial {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FRegistrarMaterial(QWidget * parent = NULL);
};

#endif
