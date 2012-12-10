Normalised(
THEORY MagicNumberX IS
  MagicNumber(Machine(Calc))==(3.5)
END
&
THEORY UpperLevelX IS
  First_Level(Machine(Calc))==(Machine(Calc));
  Level(Machine(Calc))==(0)
END
&
THEORY LoadedStructureX IS
  Machine(Calc)
END
&
THEORY ListSeesX IS
  List_Sees(Machine(Calc))==(?)
END
&
THEORY ListUsesX IS
  List_Uses(Machine(Calc))==(?)
END
&
THEORY ListIncludesX IS
  Inherited_List_Includes(Machine(Calc))==(?);
  List_Includes(Machine(Calc))==(?)
END
&
THEORY ListPromotesX IS
  List_Promotes(Machine(Calc))==(?)
END
&
THEORY ListExtendsX IS
  List_Extends(Machine(Calc))==(?)
END
&
THEORY ListVariablesX IS
  External_Context_List_Variables(Machine(Calc))==(?);
  Context_List_Variables(Machine(Calc))==(?);
  Abstract_List_Variables(Machine(Calc))==(?);
  Local_List_Variables(Machine(Calc))==(reg);
  List_Variables(Machine(Calc))==(reg);
  External_List_Variables(Machine(Calc))==(reg)
END
&
THEORY ListVisibleVariablesX IS
  Inherited_List_VisibleVariables(Machine(Calc))==(?);
  Abstract_List_VisibleVariables(Machine(Calc))==(?);
  External_List_VisibleVariables(Machine(Calc))==(?);
  Expanded_List_VisibleVariables(Machine(Calc))==(?);
  List_VisibleVariables(Machine(Calc))==(?);
  Internal_List_VisibleVariables(Machine(Calc))==(?)
END
&
THEORY ListInvariantX IS
  Gluing_Seen_List_Invariant(Machine(Calc))==(btrue);
  Gluing_List_Invariant(Machine(Calc))==(btrue);
  Expanded_List_Invariant(Machine(Calc))==(btrue);
  Abstract_List_Invariant(Machine(Calc))==(btrue);
  Context_List_Invariant(Machine(Calc))==(btrue);
  List_Invariant(Machine(Calc))==(reg: 0..255)
END
&
THEORY ListAssertionsX IS
  Expanded_List_Assertions(Machine(Calc))==(btrue);
  Abstract_List_Assertions(Machine(Calc))==(btrue);
  Context_List_Assertions(Machine(Calc))==(btrue);
  List_Assertions(Machine(Calc))==(btrue)
END
&
THEORY ListInitialisationX IS
  Expanded_List_Initialisation(Machine(Calc))==(reg:=10);
  Context_List_Initialisation(Machine(Calc))==(skip);
  List_Initialisation(Machine(Calc))==(reg:=10)
END
&
THEORY ListParametersX IS
  List_Parameters(Machine(Calc))==(?)
END
&
THEORY ListInstanciatedParametersX END
&
THEORY ListConstraintsX IS
  List_Context_Constraints(Machine(Calc))==(btrue);
  List_Constraints(Machine(Calc))==(btrue)
END
&
THEORY ListOperationsX IS
  Internal_List_Operations(Machine(Calc))==(inc);
  List_Operations(Machine(Calc))==(inc)
END
&
THEORY ListInputX IS
  List_Input(Machine(Calc),inc)==(pp)
END
&
THEORY ListOutputX IS
  List_Output(Machine(Calc),inc)==(?)
END
&
THEORY ListHeaderX IS
  List_Header(Machine(Calc),inc)==(inc(pp))
END
&
THEORY ListOperationGuardX END
&
THEORY ListPreconditionX IS
  List_Precondition(Machine(Calc),inc)==(pp: 0..255 & reg+pp<255)
END
&
THEORY ListSubstitutionX IS
  Expanded_List_Substitution(Machine(Calc),inc)==(pp: 0..255 & reg+pp<255 | reg:=reg+pp);
  List_Substitution(Machine(Calc),inc)==(reg:=reg+pp)
END
&
THEORY ListConstantsX IS
  List_Valuable_Constants(Machine(Calc))==(?);
  Inherited_List_Constants(Machine(Calc))==(?);
  List_Constants(Machine(Calc))==(?)
END
&
THEORY ListSetsX IS
  Context_List_Enumerated(Machine(Calc))==(?);
  Context_List_Defered(Machine(Calc))==(?);
  Context_List_Sets(Machine(Calc))==(?);
  List_Valuable_Sets(Machine(Calc))==(?);
  Inherited_List_Enumerated(Machine(Calc))==(?);
  Inherited_List_Defered(Machine(Calc))==(?);
  Inherited_List_Sets(Machine(Calc))==(?);
  List_Enumerated(Machine(Calc))==(?);
  List_Defered(Machine(Calc))==(?);
  List_Sets(Machine(Calc))==(?)
END
&
THEORY ListHiddenConstantsX IS
  Abstract_List_HiddenConstants(Machine(Calc))==(?);
  Expanded_List_HiddenConstants(Machine(Calc))==(?);
  List_HiddenConstants(Machine(Calc))==(?);
  External_List_HiddenConstants(Machine(Calc))==(?)
END
&
THEORY ListPropertiesX IS
  Abstract_List_Properties(Machine(Calc))==(btrue);
  Context_List_Properties(Machine(Calc))==(btrue);
  Inherited_List_Properties(Machine(Calc))==(btrue);
  List_Properties(Machine(Calc))==(btrue)
END
&
THEORY ListSeenInfoX END
&
THEORY ListANYVarX IS
  List_ANY_Var(Machine(Calc),inc)==(?);
  List_ANY_Var(Machine(Calc),?)==(?)
END
&
THEORY ListOfIdsX IS
  List_Of_Ids(Machine(Calc)) == (? | ? | reg | ? | inc | ? | ? | ? | Calc);
  List_Of_HiddenCst_Ids(Machine(Calc)) == (? | ?);
  List_Of_VisibleCst_Ids(Machine(Calc)) == (?);
  List_Of_VisibleVar_Ids(Machine(Calc)) == (? | ?);
  List_Of_Ids_SeenBNU(Machine(Calc)) == (?: ?)
END
&
THEORY VariablesEnvX IS
  Variables(Machine(Calc)) == (Type(reg) == Mvl(btype(INTEGER,?,?)))
END
&
THEORY OperationsEnvX IS
  Operations(Machine(Calc)) == (Type(inc) == Cst(No_type,btype(INTEGER,?,?)))
END
&
THEORY TCIntRdX IS
  predB0 == OK;
  extended_sees == KO;
  B0check_tab == KO;
  local_op == OK;
  abstract_constants_visible_in_values == KO;
  event_b_project == KO;
  event_b_deadlockfreeness == KO;
  variant_clause_mandatory == KO
END
)
