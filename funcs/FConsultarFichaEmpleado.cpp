/**
 * @file FConsultarFichaEmpleado.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Esta función permite ver la ficha de los empleados.
 */

// Biblioteca estándar C++
#include <vector>
using namespace std;

// Biblioteca Qt
#include <QList>
#include <QMessageBox>
#include <QTreeWidgetItem>

#include "FConsultarFichaEmpleado.h"
#include "FRegistrarEmpleado.h"
#include "FDardeBajaEmpleado.h"
#include "DialogoFrames.h"
#include "fun_consultarfichaempleado.h"

FConsultarFichaEmpleado::FConsultarFichaEmpleado(FunConsultarFichaEmpleado * empleados, bool registrarActivo, bool bajaActiva, bool, QWidget* parent): QFrame(parent) {
	setupUi(this);

	_empleados = empleados;

	// Lleva a efecto las opciones indicadas
	if (!registrarActivo){
		tb_registrar->setEnabled(false);
		tb_registrar->setVisible(false);
	}

	if (!bajaActiva){
		tb_baja->setEnabled(false);
		tb_baja->setVisible(false);
	}

	connect(textoBusqueda, SIGNAL(editingFinished()), this, SLOT(buscarLista()));
	connect(tb_registrar, SIGNAL(clicked(bool)), this, SLOT(clickRegistrar(bool)));
	connect(tb_baja, SIGNAL(clicked(bool)), this, SLOT(clickDarBaja(bool)));

	cargarListaEmpleados(empleados->getListaEmpleados());
}

void FConsultarFichaEmpleado::buscarLista(){
	QList<QTreeWidgetItem *> resultados = lista->findItems(textoBusqueda->text(), Qt::MatchContains, lista->currentColumn());

	if (resultados.size() > 0)
		lista->setCurrentItem(resultados[0]);
}

void FConsultarFichaEmpleado::clickRegistrar(bool){
	FRegistrarEmpleado inserto(_empleados);

	// Es necesario que esta variable sea puntero porque si no Qt destruirá el objeto
	// automáticamente y luego C++ intentará destruirlo otra vez (variable local).
	DialogoFrames * dialogo = new DialogoFrames("Registrar empleado", &inserto, this);

	if (dialogo->exec() == QDialog::Accepted){
		// Hacer cambios para ser más eficiente
		cargarListaEmpleados(_empleados->getListaEmpleados());
	}
}

void FConsultarFichaEmpleado::clickDarBaja(bool ){
	if (lista->currentItem() == NULL)
		QMessageBox::information(this, tr("Dar de baja empleado"), tr("Debes seleccionar un empleado para poder darlo de baja."));
	
	else {
		FDardeBajaEmpleado inserto;
		
		// Es necesario que esta variable sea puntero porque si no Qt destruirá el objeto
		// automáticamente y luego C++ intentará destruirlo otra vez (variable local).
		DialogoFrames * dialogo = new DialogoFrames("Dar de baja empleado", &inserto, this);
		dialogo->exec();
	}
}


void FConsultarFichaEmpleado::cargarListaEmpleados(vector< tFichaEmpleado > listaEm){

	// Borra el contenido anterior
	lista->clear();
	
	for (size_t i = 0; i < listaEm.size(); i++)
		appendEmpleado(listaEm[i]);
}

void FConsultarFichaEmpleado::appendEmpleado(const tFichaEmpleado& emple){
	QStringList tmp;

	tmp.append(QString::fromUtf8(emple.nif.c_str()));
	tmp.append(QString::fromUtf8(emple.nombre.c_str()));
	tmp.append(QString::fromUtf8((emple.apellido1 + " " + emple.apellido2).c_str()));
	tmp.append(QString::fromUtf8(emple.activo ? "Sí" : "No"));
	
	lista->addTopLevelItem(new QTreeWidgetItem(tmp));
}