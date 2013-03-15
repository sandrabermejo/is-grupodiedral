/**
 * @file fun_consultarfichaempleado.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Esta función permite ver la ficha de los empleados.
 * Además es la encargada de gestionar todo lo relativo al
 * registro de empleados.
 */

// Biblioteca estándar C++
#include <string>
#include <fstream>
using namespace std;

#include "fun_consultarfichaempleado.h"

// Constantes
const char * nombreArchivoEmpleados = "datos/empleados.dat";

// Pantallas que utiliza
#include "FConsultarFichaEmpleado.h"

FunConsultarFichaEmpleado::FunConsultarFichaEmpleado(const Usuario * usuario){
	_usuario = usuario;
	_frame = NULL;

	leerListaEmpleados();
}

QWidget * FunConsultarFichaEmpleado::getQtWidget(QWidget * parent){
	if (_frame == NULL){
		_frame = new FConsultarFichaEmpleado(this, _usuario->puede(Funcionalidad::REGISTRAR_EMPLEADO),
						     _usuario->puede(Funcionalidad::BAJA_EMPLEADO), false, parent);
	}

	return _frame;
}

std::string FunConsultarFichaEmpleado::getNombreFunc() const {
	return "Consultar ficha empleado";
}

bool FunConsultarFichaEmpleado::activo() const {
	return _frame != NULL;
}

ostream &operator<<(ostream& out, const tFichaEmpleado &emp){
	// Escribe el objeto para ser imprimido en archivo
	out << emp.nif; out.put(0);
	out << emp.nombre; out.put(0);
	out << emp.apellido1; out.put(0);
	out << emp.apellido2; out.put(0);

	// Escribe activo como si fuese un char
	out.put(emp.activo);

	// Escribe el entero del departamento como su representación en memoria
	// Asume que la reprentación de enteros es común en todos los sistemas (es un prototipo)
	out.write((const char*) &emp.dpto, sizeof(int));

	return out;
}

istream& operator>>(istream& in, tFichaEmpleado& emp){
	// Lee el objecto desde el archivo
	getline(in, emp.nif, (char) 0);
	getline(in, emp.nombre, (char) 0);
	getline(in, emp.apellido1, (char) 0);
	getline(in, emp.apellido2, (char) 0);

	emp.activo = (bool) in.get();

	in.read((char*) &emp.dpto, sizeof(int));

	return in;
}

void FunConsultarFichaEmpleado::leerListaEmpleados(){
	ifstream fempleados(nombreArchivoEmpleados);

	// Variable temporal para empleado
	tFichaEmpleado tmpleado;
	
	fempleados >> tmpleado;

	while (!fempleados.eof()){
		_listaEm.push_back(tmpleado);

		fempleados >> tmpleado;
	}
}

const vector< tFichaEmpleado >& FunConsultarFichaEmpleado::getListaEmpleados() const {
	return _listaEm;
}

bool FunConsultarFichaEmpleado::insertarEmpleado(const tFichaEmpleado& empleado){
	/* Ordena a los empleados por orden de NIF (inpendientemente del
	orden escogido para la visualización */

	if (!_usuario->puede(Funcionalidad::REGISTRAR_EMPLEADO))
		return false;
	
	size_t pos = 0;

	while (pos < _listaEm.size()){
		if (empleado.nif <= _listaEm[pos].nif)
			pos++;
		else
			break;
	}

	_listaEm.insert(_listaEm.begin() + pos, empleado);

	return true;
}

FunConsultarFichaEmpleado::~FunConsultarFichaEmpleado(){
	ofstream fempleados(nombreArchivoEmpleados);
	
	for (size_t i = 0; i < _listaEm.size(); i++)
		fempleados << _listaEm[i];

	fempleados.close();
}