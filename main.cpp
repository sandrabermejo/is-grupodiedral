/**
 * @file main.cpp
 * @author Grupo Diedral
 * @date enero de 2013
 *
 * @brief Módulo principal de la aplicación.
 */

#include "protoapp.h"

/**
 * @brief Punto de entrada de la aplicación.
 * 
 * @param argc Número de argumentos de línea de comandos.
 * @param argv Array de argumentos de línea de comandos.
 * 
 * @return Código de retorno del programa.
 */
int main(int argc, char * argv[]){

	// Crea la aplicación y la ejecuta
	ProtoApp app(argc, argv);

	if (app.iniciar())
		return app.exec();
	else
		return 0;
}
