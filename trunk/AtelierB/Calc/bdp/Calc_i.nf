Normalised(
THEORY MagicNumberX IS
  MagicNumber(Implementation(Calc_i))==(3.5)
END
&
THEORY UpperLevelX IS
  First_Level(Implementation(Calc_i))==(Machine(Calc));
  Level(Implementation(Calc_i))==(1);
  Upper_Level(Implementation(Calc_i))==(Machine(Calc))
END
&
THEORY LoadedStructureX IS
  Implementation(Calc_i)
END
&
THEORY ListSeesX IS
  List_Sees(Implementation(Calc_i))==(?)
END
&
THEORY ListIncludesX IS
  List_Includes(Implementation(Calc_i))==(?);
  Inherited_List_Includes(Implementation(Calc_i))==(?)
END
&
THEORY ListPromotesX IS
  List_Promotes(Implementation(Calc_i))==(?)
END
&
THEORY ListExtendsX IS
  List_Extends(Implementation(Calc_i))==(?)
END
&
THEORY ListVariablesX IS
  External_Context_List_Variables(Implementation(Calc_i))==(?);
  Context_List_Variables(Implementation(Calc_i))==(?);
  Abstract_List_Variables(Implementation(Calc_i))==(reg);
  Local_List_Variables(Implementation(Calc_i))==(?);
  List_Variables(Implementation(Calc_i))==(?);
  External_List_Variables(Implementation(Calc_i))==(?)
END
&
THEORY ListVisibleVariablesX IS
  Inherited_List_VisibleVariables(Implementation(Calc_i))==(?);
  Abstract_List_VisibleVariables(Implementation(Calc_i))==(?);
  External_List_VisibleVariables(Implementation(Calc_i))==(?);
  Expanded_List_VisibleVariables(Implementation(Calc_i))==(?);
  List_VisibleVariables(Implementation(Calc_i))==(reg);
  Internal_List_VisibleVariables(Implementation(Calc_i))==(reg)
END
&
THEORY ListInvariantX IS
  Gluing_Seen_List_Invariant(Implementation(Calc_i))==(btrue);
  Expanded_List_Invariant(Implementation(Calc_i))==(btrue);
  Abstract_List_Invariant(Implementation(Calc_i))==(reg: 0..255);
  Context_List_Invariant(Implementation(Calc_i))==(btrue);
  List_Invariant(Implementation(Calc_i))==(btrue)
END
&
THEORY ListAssertionsX IS
  Expanded_List_Assertions(Implementation(Calc_i))==(btrue);
  Abstract_List_Assertions(Implementation(Calc_i))==(btrue);
  Context_List_Assertions(Implementation(Calc_i))==(btrue);
  List_Assertions(Implementation(Calc_i))==(btrue)
END
&
THEORY ListInitialisationX IS
  Expanded_List_Initialisation(Implementation(Calc_i))==(10: INT | reg:=10);
  Context_List_Initialisation(Implementation(Calc_i))==(skip);
  List_Initialisation(Implementation(Calc_i))==(reg:=10)
END
&
THEORY ListParametersX IS
  List_Parameters(Implementation(Calc_i))==(?)
END
&
THEORY ListInstanciatedParametersX END
&
THEORY ListConstraintsX IS
  List_Constraints(Implementation(Calc_i))==(btrue);
  List_Context_Constraints(Implementation(Calc_i))==(btrue)
END
&
THEORY ListOperationsX IS
  Internal_List_Operations(Implementation(Calc_i))==(inc);
  List_Operations(Implementation(Calc_i))==(inc)
END
&
THEORY ListInputX IS
  List_Input(Implementation(Calc_i),inc)==(pp)
END
&
THEORY ListOutputX IS
  List_Output(Implementation(Calc_i),inc)==(?)
END
&
THEORY ListHeaderX IS
  List_Header(Implementation(Calc_i),inc)==(inc(pp))
END
&
THEORY ListPreconditionX IS
  Own_Precondition(Implementation(Calc_i),inc)==(btrue);
  List_Precondition(Implementation(Calc_i),inc)==(pp: 0..255 & reg+pp<255)
END
&
THEORY ListSubstitutionX IS
  Expanded_List_Substitution(Implementation(Calc_i),inc)==(pp: 0..255 & reg+pp<255 & reg+pp: INT & reg: INT & pp: INT | reg:=reg+pp);
  List_Substitution(Implementation(Calc_i),inc)==(reg:=reg+pp)
END
&
THEORY ListConstantsX IS
  List_Valuable_Constants(Implementation(Calc_i))==(?);
  Inherited_List_Constants(Implementation(Calc_i))==(?);
  List_Constants(Implementation(Calc_i))==(?)
END
&
THEORY ListSetsX IS
  Context_List_Enumerated(Implementation(Calc_i))==(?);
  Context_List_Defered(Implementation(Calc_i))==(?);
  Context_List_Sets(Implementation(Calc_i))==(?);
  List_Own_Enumerated(Implementation(Calc_i))==(?);
  List_Valuable_Sets(Implementation(Calc_i))==(?);
  Inherited_List_Enumerated(Implementation(Calc_i))==(?);
  Inherited_List_Defered(Implementation(Calc_i))==(?);
  Inherited_List_Sets(Implementation(Calc_i))==(?);
  List_Enumerated(Implementation(Calc_i))==(?);
  List_Defered(Implementation(Calc_i))==(?);
  List_Sets(Implementation(Calc_i))==(?)
END
&
THEORY ListHiddenConstantsX IS
  Abstract_List_HiddenConstants(Implementation(Calc_i))==(?);
  Expanded_List_HiddenConstants(Implementation(Calc_i))==(?);
  List_HiddenConstants(Implementation(Calc_i))==(?);
  External_List_HiddenConstants(Implementation(Calc_i))==(?)
END
&
THEORY ListPropertiesX IS
  Abstract_List_Properties(Implementation(Calc_i))==(btrue);
  Context_List_Properties(Implementation(Calc_i))==(btrue);
  Inherited_List_Properties(Implementation(Calc_i))==(btrue);
  List_Properties(Implementation(Calc_i))==(btrue)
END
&
THEORY ListValuesX IS
  Values_Subs(Implementation(Calc_i))==(aa: aa);
  List_Values(Implementation(Calc_i))==(?)
END
&
THEORY ListSeenInfoX END
&
THEORY ListIncludedOperationsX END
&
THEORY InheritedEnvX IS
  VisibleVariables(Implementation(Calc_i))==(Type(reg) == Mvv(btype(INTEGER,?,?)));
  Operations(Implementation(Calc_i))==(Type(inc) == Cst(No_type,btype(INTEGER,?,?)))
END
&
THEORY ListVisibleStaticX END
&
THEORY ListOfIdsX IS
  List_Of_Ids(Implementation(Calc_i)) == (? | ? | ? | ? | inc | ? | ? | ? | Calc_i);
  List_Of_HiddenCst_Ids(Implementation(Calc_i)) == (? | ?);
  List_Of_VisibleCst_Ids(Implementation(Calc_i)) == (?);
  List_Of_VisibleVar_Ids(Implementation(Calc_i)) == (reg | ?);
  List_Of_Ids_SeenBNU(Implementation(Calc_i)) == (?: ?)
END
&
THEORY VisibleVariablesEnvX IS
  VisibleVariables(Implementation(Calc_i)) == (Type(reg) == Mvv(btype(INTEGER,?,?)))
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
&
THEORY ListLocalOperationsX IS
  List_Local_Operations(Implementation(Calc_i))==(?)
END
&
THEORY ListLocalInputX END
&
THEORY ListLocalOutputX END
&
THEORY ListLocalHeaderX END
&
THEORY ListLocalPreconditionX END
&
THEORY ListLocalSubstitutionX END
&
THEORY TypingPredicateX IS
  TypingPredicate(Implementation(Calc_i))==(reg: INTEGER)
END
&
THEORY ImportedVariablesListX END
&
THEORY ListLocalOpInvariantX END
)
