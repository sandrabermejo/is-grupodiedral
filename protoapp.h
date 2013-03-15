/**
 * @file protoapp.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase-aplicación del prototipo
 */

#ifndef PROTOAPP_H
#define PROTOAPP_H

// Biblioteca Qt
#include <QApplication>

#include "usuario.h"
#include "vprincipal.h"
#include "authdialog.h"


/**
 * @brief Clase que se identifica con la aplicación del prototipo.
 */
class ProtoApp : public QApplication {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"
public:
	/**
	 * @brief Constructor estándar de ProtoApp.
	 *
	 * @param argc Número de parámetros de la línea de comandos.
	 * @param argv Vector de parámetros de la línea de comandos.
	 **/
	ProtoApp(int &argc, char * argv[]);

	/**
	 * @brief Prepara la ejecución de la aplicación, obteniendo la información de usuario.
	 * <p> Está función debe ser llamada siempre antes que exec().
	 *
	 * @return bool Resultado de la ejecución, @c true indica que la ejecución puede continuar con seguridad.
	 * 
	 **/
	bool iniciar();

	/*
	 * Qt destruye automáticamente los objetos reservados asociados a clases Qt.
	 */

	/**
	 * @brief Destructor de ProtoApp
	 *
	 **/
	~ProtoApp();

private:
	/**
	 * Traductor para las cadenas incorporadas de Qt.
	 */
	QTranslator * qtraductor;

	/**
	 * Cuadro de diálogo de acceso.
	 */
	AuthDialog * entrar;

	/**
	 * Ventana principal
	 */
	VPrincipal * vprincipal;

	/**
	 * Usuario principal de la aplicación
	 */
	Usuario * _usuario;

private slots:
	void acceder(AuthDialog::infoAcceso &);
};

#endif
