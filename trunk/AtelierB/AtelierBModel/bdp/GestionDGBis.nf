Normalised(
THEORY MagicNumberX IS
  MagicNumber(Machine(GestionDGBis))==(3.5)
END
&
THEORY UpperLevelX IS
  First_Level(Machine(GestionDGBis))==(Machine(GestionDGBis));
  Level(Machine(GestionDGBis))==(0)
END
&
THEORY LoadedStructureX IS
  Machine(GestionDGBis)
END
&
THEORY ListSeesX IS
  List_Sees(Machine(GestionDGBis))==(?)
END
&
THEORY ListUsesX IS
  List_Uses(Machine(GestionDGBis))==(?)
END
&
THEORY ListIncludesX IS
  Inherited_List_Includes(Machine(GestionDGBis))==(?);
  List_Includes(Machine(GestionDGBis))==(?)
END
&
THEORY ListPromotesX IS
  List_Promotes(Machine(GestionDGBis))==(?)
END
&
THEORY ListExtendsX IS
  List_Extends(Machine(GestionDGBis))==(?)
END
&
THEORY ListVariablesX IS
  External_Context_List_Variables(Machine(GestionDGBis))==(?);
  Context_List_Variables(Machine(GestionDGBis))==(?);
  Abstract_List_Variables(Machine(GestionDGBis))==(?);
  Local_List_Variables(Machine(GestionDGBis))==(employesExistants,modifEnCours,dossiersEnCours,modificateur,date_modif,libelle,modification,createur,date_creation);
  List_Variables(Machine(GestionDGBis))==(employesExistants,modifEnCours,dossiersEnCours,modificateur,date_modif,libelle,modification,createur,date_creation);
  External_List_Variables(Machine(GestionDGBis))==(employesExistants,modifEnCours,dossiersEnCours,modificateur,date_modif,libelle,modification,createur,date_creation)
END
&
THEORY ListVisibleVariablesX IS
  Inherited_List_VisibleVariables(Machine(GestionDGBis))==(?);
  Abstract_List_VisibleVariables(Machine(GestionDGBis))==(?);
  External_List_VisibleVariables(Machine(GestionDGBis))==(?);
  Expanded_List_VisibleVariables(Machine(GestionDGBis))==(?);
  List_VisibleVariables(Machine(GestionDGBis))==(?);
  Internal_List_VisibleVariables(Machine(GestionDGBis))==(?)
END
&
THEORY ListInvariantX IS
  Gluing_Seen_List_Invariant(Machine(GestionDGBis))==(btrue);
  Gluing_List_Invariant(Machine(GestionDGBis))==(btrue);
  Expanded_List_Invariant(Machine(GestionDGBis))==(btrue);
  Abstract_List_Invariant(Machine(GestionDGBis))==(btrue);
  Context_List_Invariant(Machine(GestionDGBis))==(btrue);
  List_Invariant(Machine(GestionDGBis))==(dossiersEnCours <: ID_DOSSIERS & modifEnCours <: ID_MODIFS & employesExistants <: ID_EMPLOYES & createur: dossiersEnCours +-> employesExistants & date_creation: dossiersEnCours --> DATES & modification: modifEnCours --> dossiersEnCours & libelle: modifEnCours --> LIBELLES_TRAITEMENT & date_modif: modifEnCours --> DATES & modificateur: modifEnCours +-> employesExistants)
END
&
THEORY ListAssertionsX IS
  Expanded_List_Assertions(Machine(GestionDGBis))==(btrue);
  Abstract_List_Assertions(Machine(GestionDGBis))==(btrue);
  Context_List_Assertions(Machine(GestionDGBis))==(btrue);
  List_Assertions(Machine(GestionDGBis))==(btrue)
END
&
THEORY ListInitialisationX IS
  Expanded_List_Initialisation(Machine(GestionDGBis))==(date_creation,createur,modification,libelle,date_modif,modificateur,dossiersEnCours,modifEnCours,employesExistants:={},{},{},{},{},{},{},{},{});
  Context_List_Initialisation(Machine(GestionDGBis))==(skip);
  List_Initialisation(Machine(GestionDGBis))==(date_creation:={} || createur:={} || modification:={} || libelle:={} || date_modif:={} || modificateur:={} || dossiersEnCours:={} || modifEnCours:={} || employesExistants:={})
END
&
THEORY ListParametersX IS
  List_Parameters(Machine(GestionDGBis))==(?)
END
&
THEORY ListInstanciatedParametersX END
&
THEORY ListConstraintsX IS
  List_Context_Constraints(Machine(GestionDGBis))==(btrue);
  List_Constraints(Machine(GestionDGBis))==(btrue)
END
&
THEORY ListOperationsX IS
  Internal_List_Operations(Machine(GestionDGBis))==(ajoutEmploye,supprimerEmploye,ajouterDossier,supprimerDossier,ajouterModification);
  List_Operations(Machine(GestionDGBis))==(ajoutEmploye,supprimerEmploye,ajouterDossier,supprimerDossier,ajouterModification)
END
&
THEORY ListInputX IS
  List_Input(Machine(GestionDGBis),ajoutEmploye)==(ee);
  List_Input(Machine(GestionDGBis),supprimerEmploye)==(ee);
  List_Input(Machine(GestionDGBis),ajouterDossier)==(dd,ee,date);
  List_Input(Machine(GestionDGBis),supprimerDossier)==(dd);
  List_Input(Machine(GestionDGBis),ajouterModification)==(mm,dd,ee,ll,date)
END
&
THEORY ListOutputX IS
  List_Output(Machine(GestionDGBis),ajoutEmploye)==(?);
  List_Output(Machine(GestionDGBis),supprimerEmploye)==(?);
  List_Output(Machine(GestionDGBis),ajouterDossier)==(?);
  List_Output(Machine(GestionDGBis),supprimerDossier)==(?);
  List_Output(Machine(GestionDGBis),ajouterModification)==(?)
END
&
THEORY ListHeaderX IS
  List_Header(Machine(GestionDGBis),ajoutEmploye)==(ajoutEmploye(ee));
  List_Header(Machine(GestionDGBis),supprimerEmploye)==(supprimerEmploye(ee));
  List_Header(Machine(GestionDGBis),ajouterDossier)==(ajouterDossier(dd,ee,date));
  List_Header(Machine(GestionDGBis),supprimerDossier)==(supprimerDossier(dd));
  List_Header(Machine(GestionDGBis),ajouterModification)==(ajouterModification(mm,dd,ee,ll,date))
END
&
THEORY ListOperationGuardX IS
  List_Operation_Guard(Machine(GestionDGBis),ajoutEmploye)==(btrue);
  List_Operation_Guard(Machine(GestionDGBis),supprimerEmploye)==(btrue);
  List_Operation_Guard(Machine(GestionDGBis),ajouterDossier)==(btrue);
  List_Operation_Guard(Machine(GestionDGBis),supprimerDossier)==(#lesModifs.(lesModifs <: ID_MODIFS & lesModifs = modification~[{dd}]));
  List_Operation_Guard(Machine(GestionDGBis),ajouterModification)==(btrue)
END
&
THEORY ListPreconditionX IS
  List_Precondition(Machine(GestionDGBis),ajoutEmploye)==(ee: ID_EMPLOYES & ee/:employesExistants);
  List_Precondition(Machine(GestionDGBis),supprimerEmploye)==(ee: ID_EMPLOYES & ee: employesExistants);
  List_Precondition(Machine(GestionDGBis),ajouterDossier)==(dd: ID_DOSSIERS & dd/:dossiersEnCours & ee: ID_EMPLOYES & ee: employesExistants & date: DATES);
  List_Precondition(Machine(GestionDGBis),supprimerDossier)==(dd: ID_DOSSIERS & dd: dossiersEnCours);
  List_Precondition(Machine(GestionDGBis),ajouterModification)==(mm: ID_MODIFS & mm/:modifEnCours & dd: ID_DOSSIERS & dd: dossiersEnCours & ee: ID_EMPLOYES & ee: employesExistants & ll: LIBELLES_TRAITEMENT & date: DATES)
END
&
THEORY ListSubstitutionX IS
  Expanded_List_Substitution(Machine(GestionDGBis),ajouterModification)==(mm: ID_MODIFS & mm/:modifEnCours & dd: ID_DOSSIERS & dd: dossiersEnCours & ee: ID_EMPLOYES & ee: employesExistants & ll: LIBELLES_TRAITEMENT & date: DATES | modifEnCours,modification,modificateur,libelle,date_modif:=modifEnCours\/{mm},modification<+{mm|->dd},modificateur<+{mm|->ee},libelle<+{mm|->ll},date_modif<+{mm|->date});
  Expanded_List_Substitution(Machine(GestionDGBis),supprimerDossier)==(dd: ID_DOSSIERS & dd: dossiersEnCours | @any(lesModifs).(lesModifs <: ID_MODIFS & lesModifs = modification~[{dd}] ==> dossiersEnCours,date_creation,createur,modification,modifEnCours,libelle,date_modif,modificateur:=dossiersEnCours-{dd},{dd}<<|date_creation,{dd}<<|createur,modification|>>{dd},modifEnCours-lesModifs,lesModifs<<|libelle,lesModifs<<|date_modif,lesModifs<<|modificateur));
  Expanded_List_Substitution(Machine(GestionDGBis),ajouterDossier)==(dd: ID_DOSSIERS & dd/:dossiersEnCours & ee: ID_EMPLOYES & ee: employesExistants & date: DATES | dossiersEnCours,createur,date_creation:=dossiersEnCours\/{dd},createur<+{dd|->ee},date_creation<+{dd|->date});
  Expanded_List_Substitution(Machine(GestionDGBis),supprimerEmploye)==(ee: ID_EMPLOYES & ee: employesExistants | employesExistants,createur,modificateur:=employesExistants-{ee},createur|>>{ee},modificateur|>>{ee});
  Expanded_List_Substitution(Machine(GestionDGBis),ajoutEmploye)==(ee: ID_EMPLOYES & ee/:employesExistants | employesExistants:=employesExistants\/{ee});
  List_Substitution(Machine(GestionDGBis),ajoutEmploye)==(employesExistants:=employesExistants\/{ee});
  List_Substitution(Machine(GestionDGBis),supprimerEmploye)==(employesExistants:=employesExistants-{ee} || createur:=createur|>>{ee} || modificateur:=modificateur|>>{ee});
  List_Substitution(Machine(GestionDGBis),ajouterDossier)==(dossiersEnCours:=dossiersEnCours\/{dd} || createur(dd):=ee || date_creation(dd):=date);
  List_Substitution(Machine(GestionDGBis),supprimerDossier)==(ANY lesModifs WHERE lesModifs <: ID_MODIFS & lesModifs = modification~[{dd}] THEN dossiersEnCours:=dossiersEnCours-{dd} || date_creation:={dd}<<|date_creation || createur:={dd}<<|createur || modification:=modification|>>{dd} || modifEnCours:=modifEnCours-lesModifs || libelle:=lesModifs<<|libelle || date_modif:=lesModifs<<|date_modif || modificateur:=lesModifs<<|modificateur END);
  List_Substitution(Machine(GestionDGBis),ajouterModification)==(modifEnCours:=modifEnCours\/{mm} || modification(mm):=dd || modificateur(mm):=ee || libelle(mm):=ll || date_modif(mm):=date)
END
&
THEORY ListConstantsX IS
  List_Valuable_Constants(Machine(GestionDGBis))==(?);
  Inherited_List_Constants(Machine(GestionDGBis))==(?);
  List_Constants(Machine(GestionDGBis))==(?)
END
&
THEORY ListSetsX IS
  Set_Definition(Machine(GestionDGBis),ID_EMPLOYES)==(?);
  Context_List_Enumerated(Machine(GestionDGBis))==(?);
  Context_List_Defered(Machine(GestionDGBis))==(?);
  Context_List_Sets(Machine(GestionDGBis))==(?);
  List_Valuable_Sets(Machine(GestionDGBis))==(ID_EMPLOYES,ID_DOSSIERS,ID_MODIFS,LIBELLES_TRAITEMENT,DATES);
  Inherited_List_Enumerated(Machine(GestionDGBis))==(?);
  Inherited_List_Defered(Machine(GestionDGBis))==(?);
  Inherited_List_Sets(Machine(GestionDGBis))==(?);
  List_Enumerated(Machine(GestionDGBis))==(?);
  List_Defered(Machine(GestionDGBis))==(ID_EMPLOYES,ID_DOSSIERS,ID_MODIFS,LIBELLES_TRAITEMENT,DATES);
  List_Sets(Machine(GestionDGBis))==(ID_EMPLOYES,ID_DOSSIERS,ID_MODIFS,LIBELLES_TRAITEMENT,DATES);
  Set_Definition(Machine(GestionDGBis),ID_DOSSIERS)==(?);
  Set_Definition(Machine(GestionDGBis),ID_MODIFS)==(?);
  Set_Definition(Machine(GestionDGBis),LIBELLES_TRAITEMENT)==(?);
  Set_Definition(Machine(GestionDGBis),DATES)==(?)
END
&
THEORY ListHiddenConstantsX IS
  Abstract_List_HiddenConstants(Machine(GestionDGBis))==(?);
  Expanded_List_HiddenConstants(Machine(GestionDGBis))==(?);
  List_HiddenConstants(Machine(GestionDGBis))==(?);
  External_List_HiddenConstants(Machine(GestionDGBis))==(?)
END
&
THEORY ListPropertiesX IS
  Abstract_List_Properties(Machine(GestionDGBis))==(btrue);
  Context_List_Properties(Machine(GestionDGBis))==(btrue);
  Inherited_List_Properties(Machine(GestionDGBis))==(btrue);
  List_Properties(Machine(GestionDGBis))==(ID_EMPLOYES: FIN(INTEGER) & not(ID_EMPLOYES = {}) & ID_DOSSIERS: FIN(INTEGER) & not(ID_DOSSIERS = {}) & ID_MODIFS: FIN(INTEGER) & not(ID_MODIFS = {}) & LIBELLES_TRAITEMENT: FIN(INTEGER) & not(LIBELLES_TRAITEMENT = {}) & DATES: FIN(INTEGER) & not(DATES = {}))
END
&
THEORY ListSeenInfoX END
&
THEORY ListANYVarX IS
  List_ANY_Var(Machine(GestionDGBis),ajoutEmploye)==(?);
  List_ANY_Var(Machine(GestionDGBis),supprimerEmploye)==(?);
  List_ANY_Var(Machine(GestionDGBis),ajouterDossier)==(?);
  List_ANY_Var(Machine(GestionDGBis),supprimerDossier)==(Var(lesModifs) == SetOf(atype(ID_MODIFS,?,?)));
  List_ANY_Var(Machine(GestionDGBis),ajouterModification)==(?);
  List_ANY_Var(Machine(GestionDGBis),?)==(?)
END
&
THEORY ListOfIdsX IS
  List_Of_Ids(Machine(GestionDGBis)) == (ID_EMPLOYES,ID_DOSSIERS,ID_MODIFS,LIBELLES_TRAITEMENT,DATES | ? | employesExistants,modifEnCours,dossiersEnCours,modificateur,date_modif,libelle,modification,createur,date_creation | ? | ajoutEmploye,supprimerEmploye,ajouterDossier,supprimerDossier,ajouterModification | ? | ? | ? | GestionDGBis);
  List_Of_HiddenCst_Ids(Machine(GestionDGBis)) == (? | ?);
  List_Of_VisibleCst_Ids(Machine(GestionDGBis)) == (?);
  List_Of_VisibleVar_Ids(Machine(GestionDGBis)) == (? | ?);
  List_Of_Ids_SeenBNU(Machine(GestionDGBis)) == (?: ?)
END
&
THEORY SetsEnvX IS
  Sets(Machine(GestionDGBis)) == (Type(ID_EMPLOYES) == Cst(SetOf(atype(ID_EMPLOYES,"[ID_EMPLOYES","]ID_EMPLOYES")));Type(ID_DOSSIERS) == Cst(SetOf(atype(ID_DOSSIERS,"[ID_DOSSIERS","]ID_DOSSIERS")));Type(ID_MODIFS) == Cst(SetOf(atype(ID_MODIFS,"[ID_MODIFS","]ID_MODIFS")));Type(LIBELLES_TRAITEMENT) == Cst(SetOf(atype(LIBELLES_TRAITEMENT,"[LIBELLES_TRAITEMENT","]LIBELLES_TRAITEMENT")));Type(DATES) == Cst(SetOf(atype(DATES,"[DATES","]DATES"))))
END
&
THEORY VariablesEnvX IS
  Variables(Machine(GestionDGBis)) == (Type(employesExistants) == Mvl(SetOf(atype(ID_EMPLOYES,?,?)));Type(modifEnCours) == Mvl(SetOf(atype(ID_MODIFS,?,?)));Type(dossiersEnCours) == Mvl(SetOf(atype(ID_DOSSIERS,?,?)));Type(modificateur) == Mvl(SetOf(atype(ID_MODIFS,?,?)*atype(ID_EMPLOYES,?,?)));Type(date_modif) == Mvl(SetOf(atype(ID_MODIFS,?,?)*atype(DATES,"[DATES","]DATES")));Type(libelle) == Mvl(SetOf(atype(ID_MODIFS,?,?)*atype(LIBELLES_TRAITEMENT,"[LIBELLES_TRAITEMENT","]LIBELLES_TRAITEMENT")));Type(modification) == Mvl(SetOf(atype(ID_MODIFS,?,?)*atype(ID_DOSSIERS,?,?)));Type(createur) == Mvl(SetOf(atype(ID_DOSSIERS,?,?)*atype(ID_EMPLOYES,?,?)));Type(date_creation) == Mvl(SetOf(atype(ID_DOSSIERS,?,?)*atype(DATES,"[DATES","]DATES"))))
END
&
THEORY OperationsEnvX IS
  Operations(Machine(GestionDGBis)) == (Type(ajouterModification) == Cst(No_type,atype(ID_MODIFS,?,?)*atype(ID_DOSSIERS,?,?)*atype(ID_EMPLOYES,?,?)*atype(LIBELLES_TRAITEMENT,?,?)*atype(DATES,?,?));Type(supprimerDossier) == Cst(No_type,atype(ID_DOSSIERS,?,?));Type(ajouterDossier) == Cst(No_type,atype(ID_DOSSIERS,?,?)*atype(ID_EMPLOYES,?,?)*atype(DATES,?,?));Type(supprimerEmploye) == Cst(No_type,atype(ID_EMPLOYES,?,?));Type(ajoutEmploye) == Cst(No_type,atype(ID_EMPLOYES,?,?)))
END
&
THEORY TCIntRdX IS
  predB0 == OK;
  extended_sees == KO;
  B0check_tab == KO;
  local_op == OK;
  abstract_constants_visible_in_values == KO;
  event_b_project == OK;
  event_b_deadlockfreeness == KO;
  variant_clause_mandatory == KO
END
)
