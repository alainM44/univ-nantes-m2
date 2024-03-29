# Generic make file for LaTeX: requires GNU make
#
# This makefile provides four targets: dvi, ps, pdf and clean.
# The default is "pdf".
# To make a dvi file, type "make dvi"
# To make a ps file, type "make ps".
# To make a pdf file, type "make pdf" or simply "make".
# To remove all files generated by make, type "make clean".
#
# Rouben Rostmaian <rostamian@umbc.edu>
# September 2002
#
# September 2005: Added the -o flag to dvips.  Thanks
# to Juan J. Merelo Guervós <jmerelo@geneura.ugr.es>

TEXFILE	= Rapport_Middleware_MARGUERITE_RINCE.tex


.PHONY: dvi ps pdf clean

pdf:	$(TEXFILE:.tex=.pdf)
ps:	$(TEXFILE:.tex=.ps)
dvi:	$(TEXFILE:.tex=.dvi)

%.dvi: %.tex
	( \
	latex $<; \
	while grep -q "Rerun to get cross-references right." $(<:.tex=.log); \
	do \
		latex $<; \
	done \
	)

%.ps: %.dvi
	dvips -q -t a4 $< -o $(<:.dvi=.ps)

%.pdf: %.ps
	ps2pdf -dPDFSETTINGS=/prepress $<

clean:
	@rm -f \
	$(TEXFILE:.tex=.aux) \
	$(TEXFILE:.tex=.log) \
	$(TEXFILE:.tex=.out) \
	$(TEXFILE:.tex=.dvi) \
	$(TEXFILE:.tex=.pdf) \
	$(TEXFILE:.tex=.lof) \
	$(TEXFILE:.tex=.toc) \
	$(TEXFILE:.tex=.idx) \
	$(TEXFILE:.tex=.ps)
