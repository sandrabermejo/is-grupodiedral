/**
 * @file vprincipal.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Ventana principal del prototipo.
 */

#ifndef VPRINCIPAL_H
#define VPRINCIPAL_H

// Biblioteca Qt
#include <QBoxLayout>
#include <QLabel>
#include <QMainWindow>
#include <QMenu>
#include <QToolBox>
#include <QTreeWidget>
#include <QStackedWidget>

// Ejemplos de Qt
#include "widgets/analogclock.h"

#include "funcs/funcionalidad.h"
#include "arbolfuncs.h"
#include "usuario.h"


/**
 * @brief Ventana principal del prototipo.
 *
 * Esta implementación es fea e incómoda. Se han planteado mejores formas
 * de abordar este asunto pero parece ser que como es un prototipo hay que
 * hacerlo mal.
 *
 */
class VPrincipal : public QMainWindow {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"
public:
	/**
	 * @brief Constructor estándar de la ventana principal.
	 *
	 * @param usuario Estructura de usuario válida.
	 * @param parent Control padre. Vale 0 por omisión.
	 **/
	VPrincipal(const Usuario * usuario, QWidget* parent = 0);

	/**
	 * @brief Destructor de VPrincipal.
	 *
	 **/
	virtual ~VPrincipal();

signals:
	/**
	 * Señal emitida por la ventana principal para avisar a sus hijos de que van a ser
	 * remplazados.
	 *
	 * @param denegar @c true si se solicita permanecer activo.
	 */
	void avisoCierre(bool &denegar);

private:
	// Funciones auxiliares para configuración
	void configurarMenu();
	void configurarContenido();
	void configurarArbol();

	// Usuario
	const Usuario * _usuario;

	// Reloj
	AnalogClock * _reloj;

	// Distribuidores de controles
	QHBoxLayout * _relojNombre;
	QVBoxLayout * _dvert;
	QHBoxLayout * _dhoriz;

	// Etiqueta
	QLabel * _titulo;

	// Árbol de opciones
	QTreeWidget * _arbol;

	// Acciones y menú
	QAction * _acercaQt;
	QAction * _acercaThis;
	QMenu * _menuAyuda;

	// Contenedor de los objetos de la ventana
	QWidget * _contenido;

	// Contenedor de pantallas
	QStackedWidget * _pActiva;

	// Pantallas
	Funcionalidad * _funcs;
	ArbolFuncs * _arbolFuncs;	


private slots:
	void aboutQt();
	void aboutThis();
	void arbolClick();
};

#endif
