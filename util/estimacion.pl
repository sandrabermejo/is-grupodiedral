#!/usr/bin/perl

# Programa para comprobar y obtener las tablas de los puntos de
# función (sin pretensiones y con cierta rigidez) (y no bien programado).

# Los datos se han obtenido de los apuntes de PF de Gonzalo.

use strict;
use warnings;
use Getopt::Std;

## Funciones con contenido (el punto de entrada está después de está función)
sub procesarArchivo {

	my $archivohdl = shift;

	# Inicia las variables
	my $line;
	my $nombrefunc = '¿?';
	my $fase;
	my @sumapf = (	{alta => 0, media => 0, baja => 0},
			{alta => 0, media => 0, baja => 0},
			{alta => 0, media => 0, baja => 0},
			{alta => 0, media => 0, baja => 0},
			{alta => 0, media => 0, baja => 0});

	my $tdets = 0;
	my $tretftrs = 0;

	# Recorre el archivo en busca de los especificadores
	foreach $line (<$archivohdl>)	{
		if ($line =~ m/%% Estimación. Función "(.*)"/){
			$nombrefunc = $1;
			print "\n-- Función '$1'\n";
		}
		elsif ($line =~ m/estfli{(.*)}/) {
			$fase = 1;

			die "Error: se esperaba complejidad y se encontró otro archivo o entrada" if ($tdets > 0 or $tretftrs > 0);

			print "\tFLI $1\n";
		}
		elsif ($line =~ m/estfie{(.*)}/) {
			$fase = 2;

			die "Error: se esperaba complejidad y se encontró otro archivo o entrada" if ($tdets > 0 or $tretftrs > 0);

			print "\tFIE $1\n";
		}
		elsif ($line =~ m/estee{(.*)}/) {
			$fase = 3;
			
			die "Error: se esperaba complejidad y se encontró otro archivo o entrada" if ($tdets > 0 or $tretftrs > 0);

			print "\tEE $1\n";
		}
		elsif ($line =~ m/estse{(.*)}/) {
			$fase = 4;

			die "Error: se esperaba complejidad y se encontró otro archivo o entrada" if ($tdets > 0 or $tretftrs > 0);

			print "\tSE $1\n";
		}
		elsif ($line =~ m/estce{(.*)}/) {
			$fase = 5;

			die "Error: se esperaba complejidad y se encontró otro archivo o entrada" if ($tdets > 0 or $tretftrs > 0);

			print "\tCE $1\n";
		}
		elsif ($line =~ m/rets{(\d*)}/) {
			if ($fase >= 3 or $fase == 0) {
				die "Encontrado un RET donde no procedía";
			}

			print "\t\tRET $1\n";
	
			$tretftrs += $1;
		}
		elsif ($line =~ m/ftrs{(\d*)}/) {
			if ($fase < 3) {
				die "Encontrado un FTR donde no procedía";
			}

			print "\t\tFTR $1\n";
	
			$tretftrs += $1;
		}
		elsif ($line =~ m/dets{(\d*)}/) {
			print "\t\tDET $1\n";

			$tdets += $1;
		}
		elsif ($line =~ m/\t}{(alta|baja|media)}/){
			my $complj = dameComplejidad($fase, $tdets, $tretftrs);
			
			# Informa de la coincidencia de la complejidad prevista con la escrita
			if ($complj eq $1){
				print "\tComplejidad '$1'\n\n";
			}
			else {
				print "\tLa complejidad debería ser '$complj' pero está escrito '$1'.\n\n";
			}

			# Se contabiliza un punto de función más en esta fase y complejidad
			$sumapf[$fase-1]{$complj}++;

			# Reinicia los contadores temporales
			$tdets = 0; $tretftrs = 0;
		}
		elsif ($line =~ m/\t}{(.*)}/){
			my $complj = dameComplejidad($fase, $tdets, $tretftrs);

			# No hace nada más porque muere
			die "No se reconoce '$1' como valor válido de complejidad. La complejidad esperada era '$complj'.";
		}
	}

	# Genera la tabla
	generaTabla($nombrefunc, @sumapf);
}


## Punto de entrada

# Procesa las opciones (el directorio base desde el cual trabajar)
my %cmdline=();

getopts("hd:", \%cmdline) or ayudaUso();
ayudaUso() if $cmdline{h};

chdir($cmdline{d}) or die "No se pudo cambiar el directorio de trabajo ($!)" if $cmdline{d};


# Imprime un título
print "*** Analizador de la estimación ***\n";

# Variables temporales (strict)
my $archivo;
my $line;

print "Sin archivos de entrada.\n" if $#ARGV < 0;

# Recorrido por todos los archivos aportados
foreach $archivo (@ARGV) {
	# Abre el archivo
	open my $archivohdl, $archivo or die "No se pudo abrir el archivo $archivo: $!";

	procesarArchivo($archivohdl);

	close $archivohdl;
}

# fin

## Otras funciones

# Devuelve la complejidad dados DET y RET (o FTRS)
sub dameComplejidad {
	my ($fase, $dets, $retftrs) = @_;

	# Si el Fichero (lo que sea)
	if ($fase == 1 or $fase == 2) {
		if ($dets >= 1 and $dets <= 19) {
			return 'baja' if $retftrs == 1;
			return 'baja' if ($retftrs >= 2 and $retftrs <= 5);
			return 'media' if $retftrs >= 6;
		}
		elsif ($dets >= 20 and $dets <= 50) {
			return 'baja' if $retftrs == 1;
			return 'media' if ($retftrs >= 2 and $retftrs <= 5);
			return 'alta' if $retftrs >= 6;
		}
		elsif ($dets >= 51) {
			return 'media' if $retftrs == 1;
			return 'alta' if ($retftrs >= 2 and $retftrs <= 5);
			return 'alta' if $retftrs >= 6;
		}
	}
	# Si es entrada o consulta externa
	elsif ($fase == 3 or $fase == 5) {
		if ($dets >= 1 and $dets <= 4) {
			return 'baja' if $retftrs == 0 or $retftrs == 1;
			return 'baja' if $retftrs == 2;
			return 'media' if $retftrs >= 3;
		}
		elsif ($dets >= 5 and $dets <= 15) {
			return 'baja' if $retftrs == 0 or $retftrs == 1;
			return 'media' if $retftrs == 2;
			return 'alta' if $retftrs >= 3;
		}
		elsif ($dets >= 16) {
			return 'media' if $retftrs == 0 or $retftrs == 1;
			return 'alta' if $retftrs == 2;
			return 'alta' if $retftrs >= 3;
		}
	}
	# Si es salida externa
	else {
		if ($dets >= 1 and $dets <= 5) {
			return 'baja' if $retftrs == 0 or $retftrs == 1;
			return 'baja' if $retftrs == 2 or $retftrs == 3;
			return 'media' if $retftrs >= 4;
		}
		elsif ($dets >= 6 and $dets <= 19) {
			return 'baja' if $retftrs == 0 or $retftrs == 1;
			return 'media' if $retftrs == 2 or $retftrs == 3;
			return 'alta' if $retftrs >= 4;
		}
		elsif ($dets >= 20) {
			return 'media' if $retftrs == 0 or $retftrs == 1;
			return 'alta' if $retftrs == 2 or $retftrs == 3;
			return 'alta' if $retftrs >= 4;
		}
	}

	# En caso contrario todos los anteriores (error)
	return 'fueraderango';
}

# Genera e imprime la tabla
sub generaTabla(){
	my ($nombrefunc, @sumapf) = @_;

	# Pesos según apuntes Gonzalo pág. 30
	my @pesos = ( {alta => 15, media => 10, baja => 7},
		{alta => 10, media => 7, baja => 5},
		{alta => 6, media => 4, baja => 3},
		{alta => 7, media => 5, baja => 4},
		{alta => 6, media => 4, baja => 3});

	# Suma ponderadamente los PF
	my @sumafase = (0, 0, 0, 0, 0);
	my $sumatotal = 0;

	for (my $i = 0; $i < $#pesos; $i++){
		$sumafase[$i] = 	$sumapf[$i]{baja} * $pesos[$i]{baja} + 
				$sumapf[$i]{media} * $pesos[$i]{media} +
				$sumapf[$i]{alta} * $pesos[$i]{alta};

		$sumatotal += $sumafase[$i];
	}

	# Imprime la tabla finalmente
	print << "FIN";
\\begin{tablapf}{$nombrefunc}{$sumatotal}
	FLI	& $sumapf[0]{baja} 	& $pesos[0]{baja} 	& $sumapf[0]{media} 	& $pesos[0]{media} 	& $sumapf[0]{alta} 	& $pesos[0]{alta} 	& $sumafase[0]	\\\\ \\hline
	FIE	& $sumapf[1]{baja}	& $pesos[1]{baja} 	& $sumapf[1]{media} 	& $pesos[1]{media} 	& $sumapf[1]{alta} 	& $pesos[1]{alta} 	& $sumafase[1]	\\\\ \\hline
	EI	& $sumapf[2]{baja}	& $pesos[2]{baja}	& $sumapf[2]{media}	& $pesos[2]{media}	& $sumapf[2]{alta}	& $pesos[2]{alta}	& $sumafase[2]	\\\\ \\hline
	EO	& $sumapf[3]{baja}	& $pesos[3]{baja}	& $sumapf[3]{media}	& $pesos[3]{media}	& $sumapf[3]{alta}	& $pesos[3]{alta}	& $sumafase[3]	\\\\ \\hline
	EQ 	& $sumapf[4]{baja}	& $pesos[4]{baja}	& $sumapf[4]{media}	& $pesos[4]{media}	& $sumapf[4]{alta}	& $pesos[4]{alta}	& $sumafase[4]
\\end{tablapf}
FIN
}



## Funciones auxiliares

# Impresión de errores (no se usa)
sub imprimerr {
	print @_;
}

# Impresión del mensaje de ayuda
sub ayudaUso {
	print << "FIN";
Programa para procesar ficheros de estimación. Proyecto IS del Grupo Diedral.
Uso: $0 [-h] [-d: directorio base]

 -h	: Muestra este mensaje de ayuda.
 -d	: Indica el directorio base (el directorio "doc/planproyecto/estimac" del proyecto).

FIN
	exit;
}
