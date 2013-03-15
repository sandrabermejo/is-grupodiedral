/**
 * @file DialogoFrames.h
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Cuadro de diálogo para incorporar frames.
 */

#ifndef FDIALOGOFRAMES_H
#define FDIALOGOFRAMES_H

// Biblioteca Qt
#include <QFrame>
#include <QDialog>
#include <QHBoxLayout>

/**
 * @brief Este diálogo permite mostrar pantallas como si fuesen cuadros de diálogo.
 *
 **/
class DialogoFrames : public QDialog {
	Q_OBJECT; // Macro de Qt para manejar "slot" y "signal"

public:
	/**
	 * @brief Crea un diálogo que alberga frames.
	 *
	 * @param titulo Título del cuadro de diálogo.
	 * @param frame QFrame a inscrustar en el cuadro de diálogo.
	 * @param parent Control padre (importante para modal) (por defecto @c NULL).
	 */
	DialogoFrames(const char * titulo, QFrame * frame, QWidget * parent = NULL);

private:
	QHBoxLayout * _layout;
private slots:
	void frameHaTerminado(QDialog::DialogCode);
};

#endif // FDIALOGFRAMES_H
