## Makefile para el documento de diseño

## Variables generales
DSN_TEX=diseno#		# Nombre del archivo del documento
LATEX_CMD=pdflatex#	# Comando Latex (preferiblemente pdflatex)
TEXIN=TEXINPUTS=..//common:$$TEXINPUTS#	# Carpetas de entrada LaTeX
# En Windows (tal vez): set TEXINPUTS=..//common:$$TEXINPUTS &&

# De forma grosera
make:
	$(TEXIN) pdflatex $(DSN_TEX)
#	makeindex -s $(DSN_TEX).ist -t $(DSN_TEX).glg -o $(DSN_TEX).gls $(DSN_TEX).glo
#	bibtex $(DSN_TEX)
	$(TEXIN) pdflatex $(DSN_TEX)

clean:
	$(RM) *.log *.aux *.glo *.ist *.toc *.out *.glg *.gls *.blb *.bbl *.blg *.lof
