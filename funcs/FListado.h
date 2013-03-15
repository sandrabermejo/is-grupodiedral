/**
 * @file FListado.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Implemetación genérica de listado (con posibilidad de edición).
 * @deprecated Descontinuado.
 */

#ifndef FLISTADO_H
#define FLISTADO_H

// Biblioteca Qt
#include <QBoxLayout>
#include <QTreeWidget>

/**
 * @brief Clase genérica para pantallas que utilizan listados.
 *
 */
class FListado : public QFrame {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"
public:
	/**
	 * Contructor estándar de la ventana principal.
	 *
	 * @param columnas Columnas del listado.
	 */
	FListado(std::vector<std::string> columnas);
private:
	QTreeWidget * _lista;
};

#endif
