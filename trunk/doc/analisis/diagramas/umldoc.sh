#!/bin/sh

# Comprueba la existencia de Inkscape antes de empezar
if (type inkscape > /dev/null)
then
	echo "Usando '`inkscape --version`'"
else
	echo "Inkscape no está instalado o no es accesible. Finalizado." > 2
	exit 1
fi

# Obtiene la lista de archivos .svg del directorio
dir=`ls *.svg`

# Variable: número de conversiones realizadas
nConv=0

# Variable: número de conversiones omitidas
nConvOmitidas=0

# Recorre los archivos .svg conviertiéndolos
for archivo in $dir;
do
	# Genera el nombre del archivo .pdf
	archivoPdf="`basename $archivo .svg`.pdf"

	# Especificación de la necesidad de conversión
	function necesitaConversion {
		if [ -f $archivoPdf ]
		then
			[ `stat -c %Y $archivoPdf` -lt `stat -c %Y $archivo` ]
		else
			return 0
		fi
	}

	# Comprueba que el .svg sea más reciente que el .pdf
	if necesitaConversion
	then
		inkscape --export-pdf="$archivoPdf" $archivo

		# Comprueba que Inskacape ha terminado correctamente
		if [ $? = 0 ]
		then
			nConv=$(($nConv + 1))
		else
			echo "Se produjo un error en la conversión del archivo $archivo." > 2
		fi
	else
		nConvOmitidas=$(($nConvOmitidas + 1))
	fi
done;

# Muestra el resultado
if [ $nConv = 0 ]
then
	if [ $nConvOmitidas -gt 0 ]
	then
		echo "No ha habido cambios. Nada que hacer."
	else
		echo "Ningún archivo encontrado."
	fi
else
	echo "Se han convertido $nConv archivos satisfactoriamente ($nConvOmitidas omitidos)."
fi
