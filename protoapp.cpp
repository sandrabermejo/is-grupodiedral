/**
 * @file protoapp.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Clase-aplicación del prototipo
 */

// Biblioteca Qt
#include <QMessageBox>
#include <QTextCodec>
#include <QTranslator>
#include <QIcon>
#include <QSplashScreen>

#include "protoapp.h"

ProtoApp::ProtoApp(int &argc, char* argv[]): QApplication(argc, argv) {
	// Establece la codificación de las cadenas de traducción como UTF-8 (trUft8)
	QTextCodec::setCodecForTr(QTextCodec::codecForName("UTF-8"));

	// Carga la traducción del texto propio de la biblioteca Qt
	qtraductor = new QTranslator(this);
	qtraductor->load("qt_es.qm", applicationDirPath());
	installTranslator(qtraductor);

	setApplicationName(QApplication::tr("Gestión de compañía aérea."));
	setWindowIcon(QIcon("./icono.ico"));
}

bool ProtoApp::iniciar(){
	bool ok = false;

	// Construye el cuadro de registro
	entrar = new AuthDialog();

	// Conecta la señal de intento de registro
	ProtoApp::connect(entrar, SIGNAL(intentoAcceso(AuthDialog::infoAcceso &)), this, SLOT(acceder(AuthDialog::infoAcceso&)));

	// Ejecuta el cuadro de diálogo como modal
	entrar->setModal(true);

	if (entrar->exec() == AuthDialog::Accepted){
		vprincipal = new VPrincipal(_usuario);

		// Muestra un pantalla inicial
		QPixmap pixmap("./images/splash.png");
		QSplashScreen * sps = new QSplashScreen(pixmap);
		sps->showMessage("Cargando...");
		sps->show();
		sps->finish(vprincipal);
		
		// Hace funcionar la ventana principal
		vprincipal->show();

		delete sps; sps = NULL;
		ok = true;
	}

	return ok;
}

void ProtoApp::acceder(AuthDialog::infoAcceso &infoacceso){
	_usuario = new Usuario(entrar->getUsuario());
	
	if (_usuario->solicitarAcceso(entrar->getConstrasena()))
		infoacceso = AuthDialog::CORRECTO;
	else
		infoacceso = AuthDialog::ERROR_NOUSUARIO;
}

ProtoApp::~ProtoApp(){
	/* Esta función tiene que borrar lo que no está incorporado
	 * en un control de Qt y nada más pues en caso contrario
	 * se produciría un intento de liberación de memoria doble.
	 */

	delete entrar; entrar = NULL;
	delete vprincipal; vprincipal = NULL;
	delete _usuario; _usuario = NULL;
}

