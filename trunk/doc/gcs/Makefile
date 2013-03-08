## Makefile para compilar el plan de GCS

## Variables generales
GCS_TEX=gcs#		# Nombre del archivo del documento
LATEX_CMD=pdflatex#	# Comando Latex (preferiblemente pdflatex)
LATEXC=latex
DVIPDF=dvipdf

# De forma grosera
make:
	pdflatex $(GCS_TEX)
	makeindex -s $(GCS_TEX).ist -t $(GCS_TEX).glg -o $(GCS_TEX).gls $(GCS_TEX).glo
#	bibtex $(SQA_TEX)
	pdflatex $(GCS_TEX)

latex+pdf:
	$(LATEXC) casosdeuso
	$(DVIPDF) casosdeuso.dvi
	$(RM) casosdeuso.dvi

clean:
	$(RM) *.log *.aux *.glo *.ist *.toc *.out *.glg *.gls *.blb *.bbl *.blg *.lof
