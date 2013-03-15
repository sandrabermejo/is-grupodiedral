/****************************************************************************
** Esta función permite dar de baja a un cliente de nuestro sistema.
**
** FDardeBajaCliente.h
*****************************************************************************/

#ifndef FDARDEBAJACLIENTE_H
#define FDARDEBAJACLIENTE_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fdardebajacliente.h"


/**
 * @brief Esta función permite dar de baja a un cliente de nuestro sistema.
 *
 **/
class FDardeBajaCliente : public QFrame, public Ui::FDardebajacliente {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FDardeBajaCliente(QWidget * parent = NULL);
};

#endif
