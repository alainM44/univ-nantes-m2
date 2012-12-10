/******************************************************************************

 File Name               : Calc.c

 Date                    : 05/12/2012  14:43:14

 Author                  : E074862X

 Atelier-B Version       : 4.0

 C Translator Version    : b2c V1.0 (08/08/2007)

 B Project Name          : Calc

******************************************************************************/

/*--------------------------
   Added by the Translator
  --------------------------*/
#include <stdbool.h>
#include "Calc.h"

/*----------------------------
   CONCRETE_VARIABLES Clause
  ----------------------------*/
int Calc__reg;

/*------------------------
   INITIALISATION Clause
  ------------------------*/
void Calc__INITIALISATION(void) {
   Calc__reg = 10;
}

/*--------------------
   OPERATIONS Clause
  --------------------*/
void Calc__inc(
   int Calc__pp) {
   Calc__reg = Calc__reg +
      Calc__pp;
}



