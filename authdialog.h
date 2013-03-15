/**
 * @file authdialog.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Diálogo de acceso.
 */

#ifndef AUTHDIALOG_H
#define AUTHDIALOG_H

// Biblioteca estándar C++
#include <string>

// Biblioteca Qt
#include <QBoxLayout>
#include <QDialog>
#include <QLineEdit>
#include <QPushButton>

/**
 * @brief Diálogo de identificación de usuario.
 *
 **/
class AuthDialog : public QDialog {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"
public:
	/**
	 * @brief Constructor principal del cuadro de diálogo. Crea los controles.
	 *
	 * @param parent Componente padre (por defecto @c NULL).
	 **/
	AuthDialog(QWidget * parent = NULL);

	/*
	 * Qt destruye automáticamente los recursos solicitados (o eso dicen).
	 */

	/**
	 * @brief Devuelve el nombre de usuario introducido.
	 *
	 * @return string Cadena con el nombre de usuario introducido.
	 **/
	std::string getUsuario() const;

	/**
	 * @brief Devuelve la contraseña autodestruyendo la copia interna.
	 *
	 * @return string Cadena con la constraseña.
	 **/
	std::string getConstrasena();

	/**
	 * @brief Enumerado que describe las posibles respuestas de infoAcceso.
	 *
	 * ERROR_CONEXION = Error en la conexión con el servidor.
	 * ERROR_NOUSUARIO = Usuario o contraseña no válidos.
	 * CORRECTO = Acceso concedido.
	 */
	typedef enum {ERROR_CONEXION, ERROR_NOUSUARIO, CORRECTO} infoAcceso;

signals:
	/**
	 * @brief Señal que emite el objeto cuando un usuario intenta acceder con id y constraseña.
	 *
	 * @param infoacceso (variable de salida) Información sobre el éxito o causa de error del intento de acceso.
	 *
	 * @return void
	 **/
	void intentoAcceso(AuthDialog::infoAcceso &infoacceso);

private:
	/**
	 * @brief Configura los controles del cuadro de diálogo.
	 *
	 * @return void
	 **/
	void configurarControles();

	// Cuadro de texto del nombre de usuario
	QLineEdit * id;

	// Cuadro de texto de la contraseña
	QLineEdit * pass;

	// Botones de salir y entrar
	QPushButton * entrar;
	QPushButton * salir;

	// Distribuidores de controles
	QVBoxLayout * distrib;
	QHBoxLayout * disBotones;

private slots:
	void clickEntrar();
	void clickSalir();

};

#endif
