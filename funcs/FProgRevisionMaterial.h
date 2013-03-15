/****************************************************************************
** Esta función programa una revisión debido a que ha habido algún tipo de material que se ha estropeado y necesita repararse.
**
** FProgRevisionMaterial.h
*****************************************************************************/

#ifndef FPROGREVISIONMATERIAL_H
#define FPROGREVISIONMATERIAL_H

// Biblioteca Qt
#include <QFrame>

#include "ui_fprogrevisionmaterial.h"


/**
 * @brief Esta función programa una revisión debido a que ha habido algún tipo de material que se ha estropeado y necesita repararse.
 *
 **/
class FProgRevisionMaterial : public QFrame, public Ui::FProgrevisionmaterial {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estándar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FProgRevisionMaterial(QWidget * parent = NULL);
};

#endif
