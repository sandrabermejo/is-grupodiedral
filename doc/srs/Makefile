## Makefile para compilar el documento de las SRS

## Variables generales
SRS_TEX=srs#		# Nombre del archivo del documento
LATEX_CMD=pdflatex#	# Comando Latex (preferiblemente pdflatex)
RM_CMD=rm#		# Comando del comando de borrado (Unix->rm, DOS->del)
TEXIN=TEXINPUTS=..//common:$$TEXINPUTS#	# Carpetas de entrada LaTeX
# En Windows (tal vez): set TEXINPUTS=..//common:$$TEXINPUTS &&

# De forma grosera
make:
	$(TEXIN) pdflatex $(SRS_TEX)
	makeindex -s $(SRS_TEX).ist -t $(SRS_TEX).glg -o $(SRS_TEX).gls $(SRS_TEX).glo
	bibtex $(SRS_TEX)
	$(TEXIN) pdflatex $(SRS_TEX)

clean:
	$(RM_CMD) -f *.log *.aux *.glo *.ist *.toc *.out *.glg *.gls *.blb *.bbl *.blg *.lof
