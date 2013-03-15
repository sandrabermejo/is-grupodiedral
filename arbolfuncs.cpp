/**
 * @file arbolfuncs.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase para la organización de las funciones.
 *
 * Esta clase define la organización de funciones y establece un orden lineal
 * para las casos de uso incorporados.
 *
 * Su origen se remonta a el control árbol de Qt.
 */

#include "funcs/funcionalidad.h"
#include "arbolfuncs.h"

using namespace std;

ArbolFuncs::ArbolFuncs(const Usuario * cred) {

	// Inicia los controles
	_lista = new NodoAF*[10];
	_nNodos = 0;

	// Crea el árbol en base al modelo
	generarModelo();
	
	Funcionalidad::IdFunc * tmpListaFunc = NULL;
	size_t tmpNFunc = 0;

	for (size_t nodo = 0; nodo < _tamModelo; nodo++){
		tmpNFunc = 0;

		if (_modelo[nodo] != NULL){
			tmpListaFunc = new Funcionalidad::IdFunc[_modelo[nodo]->nFuncs];

			for (size_t i = 0; i < _modelo[nodo]->nFuncs; i++)
				if (cred->puede(_modelo[nodo]->funcs[i]) || _modelo[nodo]->funcs[i] == Funcionalidad::INICIO)
					tmpListaFunc[tmpNFunc++] = _modelo[nodo]->funcs[i];
		}

		if (tmpNFunc > 0)
			// Crea el nodo de la lista personalizada. Copia el nombre del modelo, no lo apunta.
			_lista[_nNodos++] = new NodoAF(tmpListaFunc, tmpNFunc,
						       (_modelo[nodo]->nombreNodo == NULL ? NULL : new string(*_modelo[nodo]->nombreNodo)));
		else
			delete [] tmpListaFunc; tmpListaFunc = NULL;
	}
}

ArbolFuncs::~ArbolFuncs(){
	// Libera la memoria reservada por el modelo
	for (size_t i = 0; i < _tamModelo; i++)
		delete _modelo[i];
	delete _modelo; _modelo = NULL;


	// Libera la memoria reservada por el árbol modificado
	for (size_t i = 0; i < _nNodos; i++)
		delete _lista[i];
	delete _lista; _lista=NULL;
}

Funcionalidad::IdFunc ArbolFuncs::getFuncFromPos(int pos, int subpos) const {
	if (pos < (int) _nNodos && subpos < (int) _lista[pos]->nFuncs)
		return _lista[pos]->funcs[subpos != -1 ? subpos : 0];
	else
		return Funcionalidad::INICIO;
}

int ArbolFuncs::getPosicion(Funcionalidad::IdFunc func) const {
	int ret = -1;

	size_t nodo = 0;
	size_t i = 0;
	while (ret == -1 && nodo < _nNodos){
		if (_lista[nodo]->funcs[i] == func)
			ret = i;

		if (i == _lista[nodo]->nFuncs -1){
			i = 0;
			nodo++;
		}
		else
			i++;
	}

	return ret;
}

size_t ArbolFuncs::tamano() const {
	return _nNodos;
}

vector<Funcionalidad::IdFunc> ArbolFuncs::getContenidoNodo(size_t orden) const {
	if (orden < _nNodos && _lista[orden]->funcs != NULL)
		return vector<Funcionalidad::IdFunc>(_lista[orden]->funcs, _lista[orden]->funcs + _lista[orden]->nFuncs);
	else
		return vector<Funcionalidad::IdFunc>();
}

const char* ArbolFuncs::getNombreNodo(size_t orden) const {
	if (orden < _nNodos && _lista[orden]->nombreNodo != NULL)
		return _lista[orden]->nombreNodo->c_str();
	else
		return NULL;
}

void ArbolFuncs::generarModelo(){
	/**
	 * MODELO DE ÁRBOL
	 *
	 * La generación del árbol de distribción de funciones que se presentará al usuario
	 * se basa en un modelo definido en esta función. Ese modelo incluye las categorías
	 * y el orden predefinido de las funciones a la vista del usuario.
	 *
	 * Cada nodoAF representa una categoría de funciones o en su defecto una función
	 * con nivel de categoría. Las funciones con nivel de categoría no indican nombre
	 * de nodo y obligatoriamente constan de un array de funciones unitario. En caso
	 * constrario la búsqueda en base a la posición fallará.
	 */
	
	_modelo = new NodoAF*[_tamModelo = 6];

	Funcionalidad::IdFunc * tmpLista;

	// Primera sección inicio
	tmpLista = new Funcionalidad::IdFunc[1];
	tmpLista[0] = Funcionalidad::INICIO;

	_modelo[0] = new NodoAF(tmpLista, 1);

	// Segunda sección: mecánico
	tmpLista = new Funcionalidad::IdFunc[1];
	tmpLista[0] = Funcionalidad::PROGRAMAR_REVISION;

	_modelo[1] = new NodoAF(tmpLista, 1, "Mantenimiento");

	// Tercera sección: inventario
	tmpLista = new Funcionalidad::IdFunc[3];
	tmpLista[0] = Funcionalidad::REGISTRAR_MATERIAL;
	tmpLista[1] = Funcionalidad::CONSULTAR_INVENTARIO;
	tmpLista[2] = Funcionalidad::MODIFICAR_ITEMS_INVENTARIO;

	_modelo[2] = new NodoAF(tmpLista, 2, "Inventario");

	// Cuarta sección: gestión administrativa interna
	tmpLista = new Funcionalidad::IdFunc[12];
	tmpLista[0] = Funcionalidad::ORG_LABORAL;
	tmpLista[1] = Funcionalidad::CONSULTA_NOMINA;
	tmpLista[2] = Funcionalidad::CONFIG_NOMINA;
	tmpLista[3] = Funcionalidad::REGISTRAR_EMPLEADO;
	tmpLista[4] = Funcionalidad::VERIFICAR_REGISTRO;
	tmpLista[5] = Funcionalidad::CONSULTAR_EMPLEADO;
	tmpLista[6] = Funcionalidad::EDITAR_EMPLEADO;
	tmpLista[7] = Funcionalidad::BAJA_EMPLEADO;
	tmpLista[8] = Funcionalidad::CONFIG_NOMINA;
	tmpLista[9] = Funcionalidad::PROGRAMAR_HORARIOS;
	//tmpLista[9.5] = Funcionlidad::CONSULTAR_HORARIOS;
	tmpLista[10] = Funcionalidad::EDITAR_INFO_ECONOMICA;
	tmpLista[11] = Funcionalidad::PROGRAMAR_OFERTA;

	_modelo[3] = new NodoAF(tmpLista, 12, "Personal y gestión interna");

	// Quinta sección: gestión de atención al cliente
	tmpLista = new Funcionalidad::IdFunc[2];
	tmpLista[0] = Funcionalidad::BAJA_CLIENTE;
	tmpLista[1] = Funcionalidad::EFECTUAR_EMBARQUE;
	
	_modelo[4] = new NodoAF(tmpLista, 2, "Atención al público");

	// Sexta sección: operaciones
	tmpLista = new Funcionalidad::IdFunc[2];
	tmpLista[0] = Funcionalidad::INTRODUCIR_PLAN_VUELO;
	tmpLista[1] = Funcionalidad::CONSULTAR_PLAN_VUELO;

	_modelo[5] = new NodoAF(tmpLista, 2, "Operaciones");
}
