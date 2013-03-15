/****************************************************************************
** Esta clase es una extensión de la interfaz Func para funcionalidades
** que se presentan en la UI de Qt.
**
** func.h
*****************************************************************************/

#ifndef QFUNC_H
#define QFUNC_H

// Biblioteca Qt
#include <QWidget>

#include "func.h"

/**
 * @brief Clase abstracta general para casos de uso con ciertos cambios añadidos para
 * operar con Qt.
 */
class QFunc : public Func {
public:
	virtual std::string getNombreFunc() const = 0;
	
	/**
	 * @brief Obtiene el control principal de Qt asociado a esta funcionalidad.
	 *
	 * @note El comportamiento por defecto será que el control no estará activo
	 * hasta que se solicite por primera vez y a partir de entonces seguirá
	 * activo hasta que se destruya el objeto u otra causa final.
	 *
	 * @param parent Control padre del control requerido.
	 *
	 * @return Control debidamente configurado o @c NULL si no es soportado.
	 *
	 **/
	virtual QWidget * getQtWidget(QWidget * parent) = 0;
	
	/**
	 * @brief Devuelve el estado de activación de la funcionalidad y en particular
	 * de su sistema gráfico.
	 *
	 * @return bool
	 **/
	virtual bool activo() const = 0;
};

#endif // QFUNC_H
