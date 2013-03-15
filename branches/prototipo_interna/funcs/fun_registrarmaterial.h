/****************************************************************************
** Funcionalidad para registrar entradas de material
**
** fun_registrarmaterials.h
*****************************************************************************/

#ifndef FUN_REGISTRARMATERIAL_H
#define FUN_REGISTRARMATERIAL_H

// Biblioteca Qt
#include <QFrame>

#include "qfunc.h"

/**
 * @brief Funcionalidad para registrar entradas de material
 * 
 */
class FunRegistrarMaterial : public QFunc {
public:
	/**
	 * Constructor por defecto.
	 */
	FunRegistrarMaterial() : _frame(NULL){};

	/*
	 * Funciones heredadas de QFunc
	*/
	QWidget * getQtWidget(QWidget * parent);
	std::string getNombreFunc() const;
	bool activo() const;

	
private:
	QFrame * _frame;
};

#endif // FUN_REGISTRARMATERIAL_H
