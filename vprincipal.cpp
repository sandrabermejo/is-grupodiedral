/**
 * @file vprincipal.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Ventana principal del prototipo.
 */

// Biblioteca Qt
#include <QAction>
#include <QApplication>
#include <QMenuBar>
#include <QMessageBox>
#include <QPushButton>

#include "vprincipal.h"

using namespace std;

VPrincipal::VPrincipal(const Usuario * usuario, QWidget * parent): QMainWindow(parent) {
	_usuario = usuario;

	// Inicia el bloque de funcionalidad
	_funcs = new Funcionalidad();
	_funcs->setContexto(_usuario, NULL);

	setWindowTitle(tr("Compañía aérea"));
	resize(800, 500);

	configurarContenido();
	configurarMenu();
}

void VPrincipal::configurarMenu(){
	// Crea las acciones del menú
	_acercaQt = new QAction(tr("Acerca de &Qt..."), this);
	_acercaQt->setStatusTip(tr("Muestra información sobre Qt."));

	_acercaThis = new QAction(tr("Acerca de..."), this);
	_acercaThis->setStatusTip(tr("Muestra información sobre Qt."));
	_acercaThis->setShortcut(tr("Ctrl+?"));

	// Conecta las acciones con sus funciones
	connect(_acercaQt, SIGNAL(triggered()), this, SLOT(aboutQt()));
	connect(_acercaThis, SIGNAL(triggered()), this, SLOT(aboutThis()));

	// Crea las entradas del menú
	_menuAyuda = menuBar()->addMenu(tr("Ayuda"));
	_menuAyuda->addAction(_acercaQt);
	_menuAyuda->addAction(_acercaThis);
}

void VPrincipal::configurarContenido(){
	// Crea el contenedor principal de la ventana
	_contenido = new QWidget(this);
	setCentralWidget(_contenido);

	// Crea los controles visibles
	_titulo = new QLabel(tr(("<b>" + _usuario->getNombrePila() + " " + _usuario->getApellidos() + "</b><br><i>" + _usuario->getPuesto() + "</i>").c_str()), this);
	_arbol = new QTreeWidget(this);
	_reloj = new AnalogClock(this);
	_pActiva = new QStackedWidget();

	// Añade la pantalla de inicio a la pila de intercambiables
	_pActiva->addWidget(_funcs->getFunc(Funcionalidad::INICIO)->getQtWidget(this));

	// Configura el reloj
	_reloj->setFixedSize(60, 60);
	_reloj->setSizePolicy(QSizePolicy::Fixed, QSizePolicy::Fixed);

	// Crea las distribuciones
	_relojNombre = new QHBoxLayout();
	_relojNombre->addWidget(_reloj);
	_relojNombre->addSpacing(20);
	_relojNombre->addWidget(_titulo);
	
	_dvert = new QVBoxLayout();
	_dvert->addLayout(_relojNombre);
	_dvert->addWidget(_pActiva);

	_dhoriz = new QHBoxLayout(_contenido);
	_dhoriz->addWidget(_arbol);
	_dhoriz->addLayout(_dvert);

	_contenido->setLayout(_dhoriz);

	// Configura el árbol
	configurarArbol();
}

void VPrincipal::configurarArbol(){
	// Configuraciones de tamaño
	_arbol->setMaximumWidth(200);
	_arbol->setSizePolicy(QSizePolicy::Fixed, QSizePolicy::Expanding);
	
	_arbol->setColumnCount(1);
	_arbol->setHeaderLabel(tr("Opción"));

	// Configura la captura de señales
	connect(_arbol, SIGNAL(itemSelectionChanged()), this, SLOT(arbolClick()));

	// Crea la estructura de árbol independiente de la interfaz con las credenciales del usuario
	_arbolFuncs = new ArbolFuncs(_usuario);

	// Variable para contar las cargas fallidas
	unsigned int cargasFallidas = 0;

	for (size_t nodo = 0; nodo < _arbolFuncs->tamano(); nodo++){
		vector<Funcionalidad::IdFunc> nodoFuncs = _arbolFuncs->getContenidoNodo(nodo);
		
		if (_arbolFuncs->getNombreNodo(nodo) == NULL){
			for(size_t i = 0; i < nodoFuncs.size(); i++){
				Func * actual = _funcs->getFunc(nodoFuncs[i]);
				
				if (actual != NULL)
					_arbol->insertTopLevelItem(_arbol->topLevelItemCount(),
						new QTreeWidgetItem((QTreeWidgetItem*)NULL, QStringList(QString::fromUtf8(actual->getNombreFunc().c_str()))));
				else
					cargasFallidas++;
			}
		}
		else {
			QTreeWidgetItem * categoria = new QTreeWidgetItem((QTreeWidgetItem*)NULL, QStringList(QString::fromUtf8(_arbolFuncs->getNombreNodo(nodo))));
			
			for(size_t i = 0; i < nodoFuncs.size(); i++){
				Func * actual = _funcs->getFunc(nodoFuncs[i]);

				if (actual != NULL)
					categoria->addChild(new QTreeWidgetItem((QTreeWidgetItem*)NULL, QStringList(QString::fromUtf8(actual->getNombreFunc().c_str()))));
				else
					cargasFallidas++;
			}

			_arbol->insertTopLevelItem(_arbol->topLevelItemCount(), categoria);
		}
	}
	
	if (cargasFallidas > 0)
		QMessageBox::critical(this, tr("Error"), tr("No se pudieron cargar %1 funcionalidades.").arg(cargasFallidas));
}

void VPrincipal::arbolClick(){
	// Si el caso pulsado es el mismo esta función no se ejecuta

	QTreeWidgetItem * item = _arbol->currentItem();

	// De momento las categorías no pueden tener pantalla
	if (item->childCount() >= 1)
		return;

	// Intenta buscar el índice de la opción pulsada
	
	int indice, subindice = -1;

	indice = _arbol->indexOfTopLevelItem(item);

	// Si la opción es subopción 
	if (indice == -1){
		indice = _arbol->indexOfTopLevelItem(item->parent());
		subindice = item->parent()->indexOfChild(item);
	}

	Funcionalidad::IdFunc func = _arbolFuncs->getFuncFromPos(indice, subindice);
	bool denegado = false;

	emit avisoCierre(denegado);

	if (!denegado){
		if (_funcs->getFunc(func)->activo())
			_pActiva->setCurrentIndex(_pActiva->indexOf(_funcs->getFunc(func)->getQtWidget(this)));
		else {
			_pActiva->setCurrentIndex(_pActiva->addWidget(_funcs->getFunc(func)->getQtWidget(this)));
		}
	}
}

void VPrincipal::aboutQt(){
	QMessageBox::aboutQt(this, tr("Acerca de Qt..."));
}

void VPrincipal::aboutThis(){
	QMessageBox::about(this, tr("Acerca de..."), tr("<b>Compañía aérea Burns</b><br>© Montgomery Burns, 802 a.C.<br><br><i>Airline Common Environment</i><br>© Grupo Diedral, 2012 d.C.<br><br><i align=right><a href=\"http://www.grupodiedral.es\">Grupo Diedral</a></i>"));
}

VPrincipal::~VPrincipal(){
	/* Esta función tiene que borrar lo que no está incorporado
	 * en un control de Qt y nada más pues en caso contrario
	 * se produciría un intento de liberación de memoria doble.
	 *
	 * Tampoco ha de borrar usuario porque no lo ha creado.
	 */

	delete _funcs; _funcs = NULL;
	delete _arbolFuncs; _arbolFuncs = NULL;
}