:: Convierte los archivos .svg a .pdf con inskcape

@echo off set nConv=0

for %archivo in (*.svg) do
	inkscape --export-pdf=%archivo%.pdf $archivo

	if errorlevel 0 (
		set /a nConv=%nConv% + 1
	)

echo %nConv% conversiones realizadas.
