/****************************************************************************
** Pantalla que permite editar la organización laboral de la empresa
**
** FOrgLaboral.h
*****************************************************************************/

#ifndef FORGLABORAL_H
#define FORGLABORAL_H

// Biblioteca Qt
#include <QFrame>

#include "ui_forglaboral.h"

/**
 * @brief Pantalla que permite editar la organización laboral de la empresa
 *
 **/
class FOrgLaboral : public QFrame, public Ui::FOrgLaboral {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FOrgLaboral(QWidget * parent = NULL);
};

#endif
