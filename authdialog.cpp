/**
 * @file authdialog.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Diálogo de acceso.
 */

// Biblioteca Qt
#include <QMessageBox>
#include <QApplication>

#include "authdialog.h"

using namespace std;

AuthDialog::AuthDialog(QWidget * parent) : QDialog(parent) {
	setWindowTitle(tr("Compañía aérea"));
	setWindowOpacity(0.95);

	// Fija un tamaño inamovible para la ventana
	setFixedSize(300, 120);

	// Inicializa los componentes básicos
	id = new QLineEdit(this);
	pass = new QLineEdit(this);

	entrar = new QPushButton(tr("Entrada"));
	salir = new QPushButton(tr("Salir"));

	// Configura los controles
	configurarControles();

	// Conecta el botón entrar con la función clickEntrar
	connect(entrar, SIGNAL(clicked()), this, SLOT(clickEntrar()));
	// Conecta el botón salir con la función clickSalir
	connect(salir, SIGNAL(clicked()), this, SLOT(clickSalir()));

	// Distribuye los botones horizontalmente
	disBotones = new QHBoxLayout();
	disBotones->addWidget(salir);
	disBotones->addStretch();
	disBotones->addWidget(entrar);

	// Distribuye los objetos en la ventana
	distrib = new QVBoxLayout(this);
	distrib->addWidget(id);
	distrib->addWidget(pass);
	distrib->addLayout(disBotones);

	// Fija el botón entrar como botón por defecto y lo anticipa en el orden de tabulación
	entrar->setDefault(true);
	setTabOrder(entrar, salir);

	// Fija la distribución
	setLayout(distrib);
}

string AuthDialog::getUsuario() const {
	return id->text().toStdString();
}

string AuthDialog::getConstrasena(){
	string copia = pass->text().toStdString();
	pass->clear();
	return copia;
}

// MÉTODOS PRIVADOS

void AuthDialog::configurarControles(){
	id->setPlaceholderText(tr("Nombre de usuario"));

	pass->setPlaceholderText(tr("Constraseña"));
	pass->setEchoMode(QLineEdit::Password);
}

void AuthDialog::clickSalir(){
	reject();
}

void AuthDialog::clickEntrar(){
	infoAcceso infoacceso = ERROR_CONEXION;

	// Emite la señal de intentoAcceso
	emit intentoAcceso(infoacceso);

	switch (infoacceso){
		case CORRECTO:
			this->setResult(AuthDialog::Accepted);
			accept();
			break;
		case ERROR_NOUSUARIO:
			QMessageBox::warning(this, tr("Compañía aérea"), tr("No se encuentra el nombre de usuario o contraseña."));
			break;
		case ERROR_CONEXION:
		default:
			QMessageBox::critical(this, tr("Compañía aérea"), tr("No se pudo conectar con el servidor."));
	}
}
