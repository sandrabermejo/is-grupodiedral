/****************************************************************************
** Esta función permite al personal administrativo añadir un nuevo empleado a la base de datos de la compañía.
**
** FRegistrarEmpleado.cpp
*****************************************************************************/

#include "FRegistrarEmpleado.h"
#include "fun_consultarfichaempleado.h"

FRegistrarEmpleado::FRegistrarEmpleado(FunConsultarFichaEmpleado * empleados, QWidget* parent): QFrame(parent), _empleados(empleados) {
	setupUi(this);

	connect(btn_cancelar, SIGNAL(clicked(bool)), this, SLOT(clickCancelar(bool)));
	connect(btn_registrar, SIGNAL(clicked(bool)), this, SLOT(clickRegistrar(bool)));
}

void FRegistrarEmpleado::clickCancelar(bool){
	le_nombre->clear();
	le_apellido1->clear();
	le_apellido2->clear();
	le_nif->clear();
	
	emit heTerminado(QDialog::Rejected);
}

void FRegistrarEmpleado::clickRegistrar(bool){
	_empleados->insertarEmpleado(tFichaEmpleado(le_nif->text().toStdString(),
						    le_nombre->text().toStdString(),
						    le_apellido1->text().toStdString(),
						    le_apellido2->text().toStdString(),
						    true,
						    0
						 ));
	
	emit heTerminado(QDialog::Accepted);
}

