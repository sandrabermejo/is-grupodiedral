#!/usr/bin/perl

# Programa para procesar la revisiones de los casos de uso y las funciones
# y detectar algunos errores (sin pretensiones).

# Recorre los casos de uso y sus correspondientes funciones de SRS.

use strict;	
use warnings;
use Getopt::Std;
use Term::ANSIColor;

# Procesa las opciones (el directorio base desde el cual trabajar)
my %cmdline=();

getopts("hd:", \%cmdline) or ayudaUso();
ayudaUso() if $cmdline{h};

chdir($cmdline{d}) or die "No se pudo cambiar el directorio de trabajo ($!)" if $cmdline{d};


# Imprime un título
print "*** Registro de las revisiones CU/SRS ***";

# Hace acopio de los archivos .tex de las funciones
my @funciones = <srs/funciones/*.tex>;
my @casosuso =  <casosdeuso/casos/*.tex>;


# Primera comprobación: igual número de ellos
imprimerr("\n\nAdvertencia: el número de casos de uso no coincide con el número de funciones de la SRS.\n") if $#funciones != $#casosuso;


# Variables temporales (strict)
my $archivo;
my $line;

# Recorrido del directorio de casos de uso
foreach $archivo (@casosuso) {
	# Abre el archivo
	open FILE, $archivo or die "No se pudo abrir el archivo $archivo: $!";

	# Inicia las variables
	my $nombrecaso = $archivo;
	my $nombreimpreso = '';
	my @revisores = ();
	my @fechas = ();

	# Recorre el archivo en busca de marcas de revisión
	foreach $line (<FILE>)	{
		if ($line =~ m/Caso de uso: (.*)/){
			$nombrecaso = $1;
		}
		elsif ($line =~ m/% Revisado por (.*) el día (.*)/i) {
			push(@revisores, $1);
			push(@fechas, $2);
		}
		elsif ($line =~ m/nombre=(.*),/){
			$nombreimpreso = $1;
			last;
		}
	}

	# Imprime la información recabada
	print "\nCaso de uso '$nombrecaso':\n";

	if ($nombrecaso eq $archivo) {
		imprimerr("\tEl archivo no indica el nombre caso con un comentario.\n");
	}

	elsif (uc($nombrecaso) ne uc($nombreimpreso)){
		imprimerr("\tEl nombre del comentario y de la tabla de casos de uso no coinciden ($nombrecaso vs. $nombreimpreso).\n");
	}

	# Variable temporal
	my @revisor;

	imprimerr("\tCASO SIN REVISAR\n") if $#revisores == -1;

	for (my $i = 0; $i <= $#revisores; $i++){
		print "\tRevisado por $revisores[$i] ($fechas[$i])\n";
	}

	close FILE;

	comprobarSRS($archivo, $nombreimpreso);

}

sub comprobarSRS {
	# Toma los parámetros de la función
	my $archivo = shift;
	my $cunombreimpreso = shift;
	
	# Infiere el título del documento del de casos de uso
	my $archivosrs = substr $archivo, rindex($archivo, '/') + 1;
	$archivosrs = "srs/funciones/$archivosrs";
 
	# Intenta abrir el archivo de las SRS
	if (!open SRSFILE, $archivosrs){
		imprimerr("\tNO EXISTE EL ARCHIVO SRS CORRESPONDIENTE $archivosrs\n");
		return;
	}

	# Inicia las variables
	my @revisores = ();
	my @fechas = ();
	my $srsnombreimpreso = '';

	# Recorre el archivo en busca de marcas de revisión
	foreach $line (<SRSFILE>) 	{
		if ($line =~ m/% Revisado por (.*) el día (.*)/i) {
			push(@revisores, $1);
			push(@fechas, $2);
		}
		elsif ($line =~ m/srsfuncion{(.*)}(.*)\label{/){
			$srsnombreimpreso = $1;
			last;
		}
		elsif ($line =~ m/srsfuncion{(.*)}/){
			$srsnombreimpreso = $1;
			last;
		}
	}

	# Imprime los resultados
	my @revisor;

	imprimerr("\tLa denominación impresa del caso de uso y la función SRS difieren ($cunombreimpreso vs. $srsnombreimpreso).\n") if $cunombreimpreso ne $srsnombreimpreso;

	imprimerr("\tSRS SIN REVISAR\n") if $#revisores == -1;

	for (my $i = 0; $i <= $#revisores; $i++){
		print "\tSRS revisada por $revisores[$i] ($fechas[$i])\n";
	}	
	
	close(SRSFILE);
}



## Funciones auxiliares

# Impresión de errores
sub imprimerr {
	#print color('red'), @_, color('reset');
	print @_;
}

# Impresión del mensaje de ayuda
sub ayudaUso {
	print << "FIN";
Programa para procesar revisiones. Proyecto IS del Grupo Diedral.
Uso: $0 [-h] [-d: directorio base]

 -h	: Muestra este mensaje de ayuda.
 -d	: Indica el directorio base (el directorio "doc" del proyecto).

FIN
	exit;
}

sub main::HELP_MESSAGE() {

}

# Información estándar sobre la versión (getopt)
sub main::VERSION_MESSAGE() {
	print "Comprobador de revisiones CU/SRS. Proyecto IS. Grupo Diedral (2012-2013) v1.1";
}
