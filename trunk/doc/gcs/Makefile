## Makefile para compilar el plan de GCS

## Variables generales
GCS_TEX=gcs#		# Nombre del archivo del documento
LATEX_CMD=pdflatex#	# Comando Latex (preferiblemente pdflatex)
LATEXC=latex
DVIPDF=dvipdf
TEXIN=TEXINPUTS=..//common:$$TEXINPUTS#	# Carpetas de entrada LaTeX
# En Windows (tal vez): set TEXINPUTS=..//common:$$TEXINPUTS &&


# De forma grosera
make:
	$(TEXIN) pdflatex $(GCS_TEX)
	makeindex -s $(GCS_TEX).ist -t $(GCS_TEX).glg -o $(GCS_TEX).gls $(GCS_TEX).glo
	bibtex $(GCS_TEX)
	$(TEXIN) pdflatex $(GCS_TEX)

latex+pdf:
	$(TEXIN) $(LATEXC) casosdeuso
	$(DVIPDF) casosdeuso.dvi
	$(RM) casosdeuso.dvi

diagrepo:
	inkscape --export-pdf=repositorio.pdf repositorio.svg

clean:
	$(RM) *.log *.aux *.glo *.ist *.toc *.out *.glg *.gls *.blb *.bbl *.blg *.lof
