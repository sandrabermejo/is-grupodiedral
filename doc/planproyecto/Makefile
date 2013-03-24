## Makefile para compilar el documento del plan de proyecto

## Variables generales
PLPR_TEX=planproyecto#	# Nombre del archivo del documento
LATEX_CMD=pdflatex#	# Comando Latex (preferiblemente pdflatex)
RM_CMD=rm#		# Comando del comando de borrado (Unix->rm, DOS->del)
TEXIN=TEXINPUTS=..//common:$$TEXINPUTS#	# Carpetas de entrada LaTeX
# En Windows (tal vez): set TEXINPUTS=..//common:$$TEXINPUTS &&

# De forma grosera
make:
	$(TEXIN) pdflatex $(PLPR_TEX)

clean:
	$(RM_CMD) -f *.log *.aux *.glo *.ist *.toc *.out *.glg *.gls *.blb *.bbl *.blg *.lof
