## Makefile para el documento de análisis

## Variables generales
AN_TEX=analisis#		# Nombre del archivo del documento
LATEX_CMD=pdflatex#	# Comando Latex (preferiblemente pdflatex)
TEXIN=TEXINPUTS=..//common:$$TEXINPUTS#	# Carpetas de entrada LaTeX
# En Windows (tal vez): set TEXINPUTS=..//common:$$TEXINPUTS &&

# De forma grosera
make:
	$(TEXIN) pdflatex $(AN_TEX)
#	makeindex -s $(AN_TEX).ist -t $(AN_TEX).glg -o $(AN_TEX).gls $(AN_TEX).glo
#	bibtex $(AN_TEX)
	$(TEXIN) pdflatex $(AN_TEX)

clean:
	$(RM) *.log *.aux *.glo *.ist *.toc *.out *.glg *.gls *.blb *.bbl *.blg *.lof
