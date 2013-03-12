## Makefile para compilar el plan SQA

## Variables generales
SQA_TEX=plancalidad#		# Nombre del archivo del documento
LATEX_CMD=pdflatex#	# Comando Latex (preferiblemente pdflatex)

# De forma grosera
make:
	pdflatex $(SQA_TEX)
	makeindex -s $(SQA_TEX).ist -t $(SQA_TEX).glg -o $(SQA_TEX).gls $(SQA_TEX).glo
	bibtex $(SQA_TEX)
	pdflatex $(SQA_TEX)

clean:
	$(RM) *.log *.aux *.glo *.ist *.toc *.out *.glg *.gls *.blb *.bbl *.blg *.lof
