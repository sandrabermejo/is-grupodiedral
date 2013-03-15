/****************************************************************************
** Permite al personal administrativo actualizar la información económica de la compañía.
**
** FEditarInformacionEconomica.h
*****************************************************************************/

#ifndef FEDITARINFORMACIONECONOMICA_H
#define FEDITARINFORMACIONECONOMICA_H

// Biblioteca Qt
#include <QFrame>

#include "ui_feditarinformacioneconomica.h"


/**
 * @brief Permite al personal administrativo actualizar la informacion economica de la compa€ia.
 *
 **/
class FEditarInformacionEconomica : public QFrame, public Ui::FEditarinformacioneconomica {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * Contructor estÃ¡ndar para el empotrable.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 */
	FEditarInformacionEconomica(QWidget * parent = NULL);
};

#endif
