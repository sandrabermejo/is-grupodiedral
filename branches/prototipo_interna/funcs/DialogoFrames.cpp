/**
 * @file DialogoFrames.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Cuadro de diálogo para incorporar frames.
 */

#include "DialogoFrames.h"

DialogoFrames::DialogoFrames(const char* titulo, QFrame* frame, QWidget * parent): QDialog(parent){
	setModal(true);

	setWindowTitle(QString::fromUtf8(titulo != NULL ? titulo : "ACE"));

	_layout = new QHBoxLayout();
	_layout->addWidget(frame);

	setLayout(_layout);

	connect(frame, SIGNAL(heTerminado(QDialog::DialogCode)), this, SLOT(frameHaTerminado(QDialog::DialogCode)));
}

void DialogoFrames::frameHaTerminado(QDialog::DialogCode code){
	if (code == QDialog::Accepted)
		accept();
	else
		reject();
}