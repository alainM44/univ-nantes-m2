Normalised(
THEORY MagicNumberX IS
  MagicNumber(Machine(GestionDossiers))==(3.5)
END
&
THEORY UpperLevelX IS
  First_Level(Machine(GestionDossiers))==(Machine(GestionDossiers));
  Level(Machine(GestionDossiers))==(0)
END
&
THEORY LoadedStructureX IS
  Machine(GestionDossiers)
END
&
THEORY ListSeesX IS
  List_Sees(Machine(GestionDossiers))==(?)
END
&
THEORY ListUsesX IS
  List_Uses(Machine(GestionDossiers))==(?)
END
&
THEORY ListIncludesX IS
  Inherited_List_Includes(Machine(GestionDossiers))==(?);
  List_Includes(Machine(GestionDossiers))==(?)
END
&
THEORY ListPromotesX IS
  List_Promotes(Machine(GestionDossiers))==(?)
END
&
THEORY ListExtendsX IS
  List_Extends(Machine(GestionDossiers))==(?)
END
&
THEORY ListVariablesX IS
  External_Context_List_Variables(Machine(GestionDossiers))==(?);
  Context_List_Variables(Machine(GestionDossiers))==(?);
  Abstract_List_Variables(Machine(GestionDossiers))==(?);
  Local_List_Variables(Machine(GestionDossiers))==(employesExistants,modifEnCours,dossiersEnCours,modificateur,date_modif,libelle,modification,createur,date_creation);
  List_Variables(Machine(GestionDossiers))==(employesExistants,modifEnCours,dossiersEnCours,modificateur,date_modif,libelle,modification,createur,date_creation);
  External_List_Variables(Machine(GestionDossiers))==(employesExistants,modifEnCours,dossiersEnCours,modificateur,date_modif,libelle,modification,createur,date_creation)
END
&
THEORY ListVisibleVariablesX IS
  Inherited_List_VisibleVariables(Machine(GestionDossiers))==(?);
  Abstract_List_VisibleVariables(Machine(GestionDossiers))==(?);
  External_List_VisibleVariables(Machine(GestionDossiers))==(?);
  Expanded_List_VisibleVariables(Machine(GestionDossiers))==(?);
  List_VisibleVariables(Machine(GestionDossiers))==(?);
  Internal_List_VisibleVariables(Machine(GestionDossiers))==(?)
END
&
THEORY ListInvariantX IS
  Gluing_Seen_List_Invariant(Machine(GestionDossiers))==(btrue);
  Gluing_List_Invariant(Machine(GestionDossiers))==(btrue);
  Expanded_List_Invariant(Machine(GestionDossiers))==(btrue);
  Abstract_List_Invariant(Machine(GestionDossiers))==(btrue);
  Context_List_Invariant(Machine(GestionDossiers))==(btrue);
  List_Invariant(Machine(GestionDossiers))==(dossiersEnCours <: ID_DOSSIERS & modifEnCours <: ID_MODIFS & employesExistants <: ID_EMPLOYES & createur: dossiersEnCours +-> employesExistants & date_creation: dossiersEnCours --> DATES & modification: modifEnCours --> dossiersEnCours & libelle: modifEnCours --> LIBELLES_TRAITEMENT & date_modif: modifEnCours --> DATES & modificateur: modifEnCours +-> employesExistants)
END
&
THEORY ListAssertionsX IS
  Expanded_List_Assertions(Machine(GestionDossiers))==(btrue);
  Abstract_List_Assertions(Machine(GestionDossiers))==(btrue);
  Context_List_Assertions(Machine(GestionDossiers))==(btrue);
  List_Assertions(Machine(GestionDossiers))==(btrue)
END
&
THEORY ListInitialisationX IS
  Expanded_List_Initialisation(Machine(GestionDossiers))==(date_creation,createur,modification,libelle,date_modif,modificateur,dossiersEnCours,modifEnCours,employesExistants:={},{},{},{},{},{},{},{},{});
  Context_List_Initialisation(Machine(GestionDossiers))==(skip);
  List_Initialisation(Machine(GestionDossiers))==(date_creation:={} || createur:={} || modification:={} || libelle:={} || date_modif:={} || modificateur:={} || dossiersEnCours:={} || modifEnCours:={} || employesExistants:={})
END
&
THEORY ListParametersX IS
  List_Parameters(Machine(GestionDossiers))==(?)
END
&
THEORY ListInstanciatedParametersX END
&
THEORY ListConstraintsX IS
  List_Context_Constraints(Machine(GestionDossiers))==(btrue);
  List_Constraints(Machine(GestionDossiers))==(btrue)
END
&
THEORY ListOperationsX IS
  Internal_List_Operations(Machine(GestionDossiers))==(ajoutEmploye,supprimerEmploye,ajouterDossier,supprimerDossier,ajouterModification);
  List_Operations(Machine(GestionDossiers))==(ajoutEmploye,supprimerEmploye,ajouterDossier,supprimerDossier,ajouterModification)
END
&
THEORY ListInputX IS
  List_Input(Machine(GestionDossiers),ajoutEmploye)==(ee);
  List_Input(Machine(GestionDossiers),supprimerEmploye)==(ee);
  List_Input(Machine(GestionDossiers),ajouterDossier)==(dd,ee,date);
  List_Input(Machine(GestionDossiers),supprimerDossier)==(dd);
  List_Input(Machine(GestionDossiers),ajouterModification)==(mm,dd,ee,ll,date)
END
&
THEORY ListOutputX IS
  List_Output(Machine(GestionDossiers),ajoutEmploye)==(?);
  List_Output(Machine(GestionDossiers),supprimerEmploye)==(?);
  List_Output(Machine(GestionDossiers),ajouterDossier)==(?);
  List_Output(Machine(GestionDossiers),supprimerDossier)==(?);
  List_Output(Machine(GestionDossiers),ajouterModification)==(?)
END
&
THEORY ListHeaderX IS
  List_Header(Machine(GestionDossiers),ajoutEmploye)==(ajoutEmploye(ee));
  List_Header(Machine(GestionDossiers),supprimerEmploye)==(supprimerEmploye(ee));
  List_Header(Machine(GestionDossiers),ajouterDossier)==(ajouterDossier(dd,ee,date));
  List_Header(Machine(GestionDossiers),supprimerDossier)==(supprimerDossier(dd));
  List_Header(Machine(GestionDossiers),ajouterModification)==(ajouterModification(mm,dd,ee,ll,date))
END
&
THEORY ListOperationGuardX END
&
THEORY ListPreconditionX IS
  List_Precondition(Machine(GestionDossiers),ajoutEmploye)==(ee: ID_EMPLOYES & ee/:employesExistants);
  List_Precondition(Machine(GestionDossiers),supprimerEmploye)==(ee: ID_EMPLOYES & ee: employesExistants);
  List_Precondition(Machine(GestionDossiers),ajouterDossier)==(dd: ID_DOSSIERS & dd/:dossiersEnCours & ee: ID_EMPLOYES & ee: employesExistants & date: DATES);
  List_Precondition(Machine(GestionDossiers),supprimerDossier)==(dd: ID_DOSSIERS & dd: dossiersEnCours);
  List_Precondition(Machine(GestionDossiers),ajouterModification)==(mm: ID_MODIFS & mm/:modifEnCours & dd: ID_DOSSIERS & dd: dossiersEnCours & ee: ID_EMPLOYES & ee: employesExistants & ll: LIBELLES_TRAITEMENT & date: DATES)
END
&
THEORY ListSubstitutionX IS
  Expanded_List_Substitution(Machine(GestionDossiers),ajouterModification)==(mm: ID_MODIFS & mm/:modifEnCours & dd: ID_DOSSIERS & dd: dossiersEnCours & ee: ID_EMPLOYES & ee: employesExistants & ll: LIBELLES_TRAITEMENT & date: DATES | modifEnCours,modification,modificateur,libelle,date_modif:=modifEnCours\/{mm},modification<+{mm|->dd},modificateur<+{mm|->ee},libelle<+{mm|->ll},date_modif<+{mm|->date});
  Expanded_List_Substitution(Machine(GestionDossiers),supprimerDossier)==(dd: ID_DOSSIERS & dd: dossiersEnCours | @lesModifs.(lesModifs <: ID_MODIFS & lesModifs = modification~[{dd}] ==> dossiersEnCours,date_creation,createur,modification,modifEnCours,libelle,date_modif,modificateur:=dossiersEnCours-{dd},{dd}<<|date_creation,{dd}<<|createur,modification|>>{dd},modifEnCours-lesModifs,lesModifs<<|libelle,lesModifs<<|date_modif,lesModifs<<|modificateur));
  Expanded_List_Substitution(Machine(GestionDossiers),ajouterDossier)==(dd: ID_DOSSIERS & dd/:dossiersEnCours & ee: ID_EMPLOYES & ee: employesExistants & date: DATES | dossiersEnCours,createur,date_creation:=dossiersEnCours\/{dd},createur<+{dd|->ee},date_creation<+{dd|->date});
  Expanded_List_Substitution(Machine(GestionDossiers),supprimerEmploye)==(ee: ID_EMPLOYES & ee: employesExistants | employesExistants,createur,modificateur:=employesExistants-{ee},createur|>>{ee},modificateur|>>{ee});
  Expanded_List_Substitution(Machine(GestionDossiers),ajoutEmploye)==(ee: ID_EMPLOYES & ee/:employesExistants | employesExistants:=employesExistants\/{ee});
  List_Substitution(Machine(GestionDossiers),ajoutEmploye)==(employesExistants:=employesExistants\/{ee});
  List_Substitution(Machine(GestionDossiers),supprimerEmploye)==(employesExistants:=employesExistants-{ee} || createur:=createur|>>{ee} || modificateur:=modificateur|>>{ee});
  List_Substitution(Machine(GestionDossiers),ajouterDossier)==(dossiersEnCours:=dossiersEnCours\/{dd} || createur(dd):=ee || date_creation(dd):=date);
  List_Substitution(Machine(GestionDossiers),supprimerDossier)==(ANY lesModifs WHERE lesModifs <: ID_MODIFS & lesModifs = modification~[{dd}] THEN dossiersEnCours:=dossiersEnCours-{dd} || date_creation:={dd}<<|date_creation || createur:={dd}<<|createur || modification:=modification|>>{dd} || modifEnCours:=modifEnCours-lesModifs || libelle:=lesModifs<<|libelle || date_modif:=lesModifs<<|date_modif || modificateur:=lesModifs<<|modificateur END);
  List_Substitution(Machine(GestionDossiers),ajouterModification)==(modifEnCours:=modifEnCours\/{mm} || modification(mm):=dd || modificateur(mm):=ee || libelle(mm):=ll || date_modif(mm):=date)
END
&
THEORY ListConstantsX IS
  List_Valuable_Constants(Machine(GestionDossiers))==(?);
  Inherited_List_Constants(Machine(GestionDossiers))==(?);
  List_Constants(Machine(GestionDossiers))==(?)
END
&
THEORY ListSetsX IS
  Set_Definition(Machine(GestionDossiers),ID_EMPLOYES)==(?);
  Context_List_Enumerated(Machine(GestionDossiers))==(?);
  Context_List_Defered(Machine(GestionDossiers))==(?);
  Context_List_Sets(Machine(GestionDossiers))==(?);
  List_Valuable_Sets(Machine(GestionDossiers))==(ID_EMPLOYES,ID_DOSSIERS,ID_MODIFS,LIBELLES_TRAITEMENT,DATES);
  Inherited_List_Enumerated(Machine(GestionDossiers))==(?);
  Inherited_List_Defered(Machine(GestionDossiers))==(?);
  Inherited_List_Sets(Machine(GestionDossiers))==(?);
  List_Enumerated(Machine(GestionDossiers))==(?);
  List_Defered(Machine(GestionDossiers))==(ID_EMPLOYES,ID_DOSSIERS,ID_MODIFS,LIBELLES_TRAITEMENT,DATES);
  List_Sets(Machine(GestionDossiers))==(ID_EMPLOYES,ID_DOSSIERS,ID_MODIFS,LIBELLES_TRAITEMENT,DATES);
  Set_Definition(Machine(GestionDossiers),ID_DOSSIERS)==(?);
  Set_Definition(Machine(GestionDossiers),ID_MODIFS)==(?);
  Set_Definition(Machine(GestionDossiers),LIBELLES_TRAITEMENT)==(?);
  Set_Definition(Machine(GestionDossiers),DATES)==(?)
END
&
THEORY ListHiddenConstantsX IS
  Abstract_List_HiddenConstants(Machine(GestionDossiers))==(?);
  Expanded_List_HiddenConstants(Machine(GestionDossiers))==(?);
  List_HiddenConstants(Machine(GestionDossiers))==(?);
  External_List_HiddenConstants(Machine(GestionDossiers))==(?)
END
&
THEORY ListPropertiesX IS
  Abstract_List_Properties(Machine(GestionDossiers))==(btrue);
  Context_List_Properties(Machine(GestionDossiers))==(btrue);
  Inherited_List_Properties(Machine(GestionDossiers))==(btrue);
  List_Properties(Machine(GestionDossiers))==(ID_EMPLOYES: FIN(INTEGER) & not(ID_EMPLOYES = {}) & ID_DOSSIERS: FIN(INTEGER) & not(ID_DOSSIERS = {}) & ID_MODIFS: FIN(INTEGER) & not(ID_MODIFS = {}) & LIBELLES_TRAITEMENT: FIN(INTEGER) & not(LIBELLES_TRAITEMENT = {}) & DATES: FIN(INTEGER) & not(DATES = {}))
END
&
THEORY ListSeenInfoX END
&
THEORY ListANYVarX IS
  List_ANY_Var(Machine(GestionDossiers),ajoutEmploye)==(?);
  List_ANY_Var(Machine(GestionDossiers),supprimerEmploye)==(?);
  List_ANY_Var(Machine(GestionDossiers),ajouterDossier)==(?);
  List_ANY_Var(Machine(GestionDossiers),supprimerDossier)==(Var(lesModifs) == SetOf(atype(ID_MODIFS,?,?)));
  List_ANY_Var(Machine(GestionDossiers),ajouterModification)==(?);
  List_ANY_Var(Machine(GestionDossiers),?)==(?)
END
&
THEORY ListOfIdsX IS
  List_Of_Ids(Machine(GestionDossiers)) == (ID_EMPLOYES,ID_DOSSIERS,ID_MODIFS,LIBELLES_TRAITEMENT,DATES | ? | employesExistants,modifEnCours,dossiersEnCours,modificateur,date_modif,libelle,modification,createur,date_creation | ? | ajoutEmploye,supprimerEmploye,ajouterDossier,supprimerDossier,ajouterModification | ? | ? | ? | GestionDossiers);
  List_Of_HiddenCst_Ids(Machine(GestionDossiers)) == (? | ?);
  List_Of_VisibleCst_Ids(Machine(GestionDossiers)) == (?);
  List_Of_VisibleVar_Ids(Machine(GestionDossiers)) == (? | ?);
  List_Of_Ids_SeenBNU(Machine(GestionDossiers)) == (?: ?)
END
&
THEORY SetsEnvX IS
  Sets(Machine(GestionDossiers)) == (Type(ID_EMPLOYES) == Cst(SetOf(atype(ID_EMPLOYES,"[ID_EMPLOYES","]ID_EMPLOYES")));Type(ID_DOSSIERS) == Cst(SetOf(atype(ID_DOSSIERS,"[ID_DOSSIERS","]ID_DOSSIERS")));Type(ID_MODIFS) == Cst(SetOf(atype(ID_MODIFS,"[ID_MODIFS","]ID_MODIFS")));Type(LIBELLES_TRAITEMENT) == Cst(SetOf(atype(LIBELLES_TRAITEMENT,"[LIBELLES_TRAITEMENT","]LIBELLES_TRAITEMENT")));Type(DATES) == Cst(SetOf(atype(DATES,"[DATES","]DATES"))))
END
&
THEORY VariablesEnvX IS
  Variables(Machine(GestionDossiers)) == (Type(employesExistants) == Mvl(SetOf(atype(ID_EMPLOYES,?,?)));Type(modifEnCours) == Mvl(SetOf(atype(ID_MODIFS,?,?)));Type(dossiersEnCours) == Mvl(SetOf(atype(ID_DOSSIERS,?,?)));Type(modificateur) == Mvl(SetOf(atype(ID_MODIFS,?,?)*atype(ID_EMPLOYES,?,?)));Type(date_modif) == Mvl(SetOf(atype(ID_MODIFS,?,?)*atype(DATES,"[DATES","]DATES")));Type(libelle) == Mvl(SetOf(atype(ID_MODIFS,?,?)*atype(LIBELLES_TRAITEMENT,"[LIBELLES_TRAITEMENT","]LIBELLES_TRAITEMENT")));Type(modification) == Mvl(SetOf(atype(ID_MODIFS,?,?)*atype(ID_DOSSIERS,?,?)));Type(createur) == Mvl(SetOf(atype(ID_DOSSIERS,?,?)*atype(ID_EMPLOYES,?,?)));Type(date_creation) == Mvl(SetOf(atype(ID_DOSSIERS,?,?)*atype(DATES,"[DATES","]DATES"))))
END
&
THEORY OperationsEnvX IS
  Operations(Machine(GestionDossiers)) == (Type(ajouterModification) == Cst(No_type,atype(ID_MODIFS,?,?)*atype(ID_DOSSIERS,?,?)*atype(ID_EMPLOYES,?,?)*atype(LIBELLES_TRAITEMENT,?,?)*atype(DATES,?,?));Type(supprimerDossier) == Cst(No_type,atype(ID_DOSSIERS,?,?));Type(ajouterDossier) == Cst(No_type,atype(ID_DOSSIERS,?,?)*atype(ID_EMPLOYES,?,?)*atype(DATES,?,?));Type(supprimerEmploye) == Cst(No_type,atype(ID_EMPLOYES,?,?));Type(ajoutEmploye) == Cst(No_type,atype(ID_EMPLOYES,?,?)))
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
