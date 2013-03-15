/****************************************************************************
** Pantalla de búsqueda de planes de vuelo para la gestión interna
**
** FBuscaPlan.cpp
*****************************************************************************/

// Biblioteca Qt
#include <QMessageBox>

#include "FBuscaPlan.h"

FBuscaPlan::FBuscaPlan(QWidget* parent): QFrame(parent) {
	setupUi(this);

	connect(act_fechaDestino, SIGNAL(clicked()), this, SLOT(conmutarFechaDestino()));
	connect(act_fechaOrigen, SIGNAL(clicked()), this, SLOT(conmutarFechaOrigen()));
	connect(btn_buscar, SIGNAL(clicked()), this, SLOT(clickBuscar()));
}

void FBuscaPlan::conmutarFechaDestino(){
	fechaDestino->setEnabled(!fechaDestino->isEnabled());
}

void FBuscaPlan::conmutarFechaOrigen() {
	fechaOrigen->setEnabled(!fechaOrigen->isEnabled());
}

void FBuscaPlan::clickBuscar() {
	QMessageBox::information(this, tr("Buscador de planes de vuelo"), tr("No se ha encontrado ningún vuelo con los criterios establecidos."));

}



