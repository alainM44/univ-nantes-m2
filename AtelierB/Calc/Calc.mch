/* Calc
 * Author: 
 * Creation date: mer. déc. 5 2012
 */
MACHINE
    Calc
VARIABLES
    reg
INVARIANT
    reg : 0..255 /* 8 bits */
INITIALISATION
    reg := 10
OPERATIONS
    inc(pp) =
    PRE
        pp : 0..255 & reg+pp < 255
    THEN
        reg := reg + pp
    END
    

END
