## Makefile para crear el diagrama de casos de uso con Latex y PSTricks

## Variables generales
GI_TEX=casosgi#		# Nombre del archivo de diagrama de gestión interna
GE_TEX=casosge#		# Nombre del archivo de diagrama de gestión externa
LATEX_CMD=latex#	# Comando Latex
DVI2PDF_CMD=dvipdf#	# Comando del conversor de dvi a pdf
RM_CMD=rm#		# Comando del comando de borrado (Unix->rm, DOS->del)


make: ginterna gexterna

ginterna: gendvi_interna
	$(DVI2PDF_CMD) $(GI_TEX).dvi

gexterna: gendvi_externa
	$(DVI2PDF_CMD) $(GE_TEX).dvi

gendvi_interna:
	$(LATEX_CMD) $(GI_TEX)

gendvi_externa:
	$(LATEX_CMD) $(GE_TEX)

clean:
	$(RM_CMD) -f *.log *.aux *.out
	$(RM_CMD) -f $(GI_TEX).dvi $(GE_TEX).dvi

