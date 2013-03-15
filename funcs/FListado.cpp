/**
 * @file FListado.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Implemetación genérica de listado (con posibilidad de edición).
 * @deprecated Descontinuado.
 */

// Biblioteca Qt
#include <QMessageBox>
#include <QStringList>
// Biblioteca estándar C++
#include <vector>

using namespace std;

#include "FListado.h"

/**
 * @brief Función para convertir vectores de la STL en vectores de Qt.
 *
 */
QStringList stl2QtStrVector(vector<string> v){
	QStringList sl;

	for(size_t i = 0; i < v.size(); i++)
		sl.append(QString::fromStdString(v[i]));

	return sl;
}
	

FListado::FListado(vector<string> columnas): QFrame(){
	_lista = new QTreeWidget(this);

	_lista->setColumnCount(columnas.size());
	_lista->setHeaderLabels(stl2QtStrVector(columnas));
}
