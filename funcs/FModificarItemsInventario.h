/****************************************************************************
** Esta función permite al usuario modificar diversos datos de los items almacenados en el inventario de la compañía.
**
** FModificarItemsInventario.cpp
*****************************************************************************/

#ifndef FMODIFICARITEMSINVENTARIO_H
#define FMODIFICARITEMSINVENTARIO_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fmodificaritemsinventario.h"


/**
 * @brief Esta funcion permite al usuario modificar diversos datos de los items almacenados en el inventario de la compa€ia.
 *
 **/
class FModificarItemsInventario : public QFrame, public Ui::FModificaritemsinventario {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estÃ¡ndar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FModificarItemsInventario(QWidget * parent = NULL);
};

#endif
