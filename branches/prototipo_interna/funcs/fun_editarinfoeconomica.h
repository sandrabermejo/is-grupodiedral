/****************************************************************************
** Funcionalidad para editar la información económica
**
** fun_editarinfoeconomica.h
*****************************************************************************/

#ifndef FUN_EDITARINFOECONOMICA_H
#define FUN_EDITARINFOECONOMICA_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad para editar la información económica.
 * 
 */
class FunEditarInfoEconomica : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunEditarInfoEconomica() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_EDITARINFOECONOMICA_H
