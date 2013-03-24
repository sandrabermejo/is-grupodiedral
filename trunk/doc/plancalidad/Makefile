## Makefile para compilar el plan SQA

## Variables generales
SQA_TEX=plancalidad#		# Nombre del archivo del documento
LATEX_CMD=pdflatex#	# Comando Latex (preferiblemente pdflatex)
TEXIN=TEXINPUTS=..//common:$$TEXINPUTS#	# Carpetas de entrada LaTeX
# En Windows (tal vez): set TEXINPUTS=..//common:$$TEXINPUTS &&

# De forma grosera
make:
	$(TEXIN) pdflatex $(SQA_TEX)
	makeindex -s $(SQA_TEX).ist -t $(SQA_TEX).glg -o $(SQA_TEX).gls $(SQA_TEX).glo
	bibtex $(SQA_TEX)
	$(TEXIN) pdflatex $(SQA_TEX)

clean:
	$(RM) *.log *.aux *.glo *.ist *.toc *.out *.glg *.gls *.blb *.bbl *.blg *.lof
