/**
 */
package org.eclipsecon.acceleo.tutorial.webapp;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappFactory
 * @model kind="package"
 * @generated
 */
public interface WebappPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "webapp";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipsecon.org/acceleo/tutorial/webapp/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "webapp";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WebappPackage eINSTANCE = org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.NamedElement <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.NamedElement
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ApplicationImpl <em>Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ApplicationImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getApplication()
	 * @generated
	 */
	int APPLICATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Router</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__ROUTER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__COLLECTIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Models</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__MODELS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Views</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION__VIEWS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPLICATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ParameterImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.OperationImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__PARAMETERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ReferenceImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.AttributeImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DEFAULT_VALUE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ModelImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__REFERENCES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__OPERATIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__APPLICATION = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.CollectionImpl <em>Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.CollectionImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getCollection()
	 * @generated
	 */
	int COLLECTION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__MODEL = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION__APPLICATION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.RouterMappingImpl <em>Router Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.RouterMappingImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getRouterMapping()
	 * @generated
	 */
	int ROUTER_MAPPING = 8;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MAPPING__PATH = 0;

	/**
	 * The feature id for the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MAPPING__VIEW = 1;

	/**
	 * The number of structural features of the '<em>Router Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.RouterImpl <em>Router</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.RouterImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getRouter()
	 * @generated
	 */
	int ROUTER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER__MAPPINGS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER__APPLICATION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Router</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.AbstractViewImpl <em>Abstract View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.AbstractViewImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getAbstractView()
	 * @generated
	 */
	int ABSTRACT_VIEW = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW__OPERATIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW__APPLICATION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_VIEW_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ModelViewImpl <em>Model View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ModelViewImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getModelView()
	 * @generated
	 */
	int MODEL_VIEW = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VIEW__NAME = ABSTRACT_VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VIEW__DESCRIPTION = ABSTRACT_VIEW__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VIEW__OPERATIONS = ABSTRACT_VIEW__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VIEW__APPLICATION = ABSTRACT_VIEW__APPLICATION;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VIEW__COLLECTION = ABSTRACT_VIEW_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_VIEW_FEATURE_COUNT = ABSTRACT_VIEW_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.StaticViewImpl <em>Static View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.StaticViewImpl
	 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getStaticView()
	 * @generated
	 */
	int STATIC_VIEW = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEW__NAME = ABSTRACT_VIEW__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEW__DESCRIPTION = ABSTRACT_VIEW__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEW__OPERATIONS = ABSTRACT_VIEW__OPERATIONS;

	/**
	 * The feature id for the '<em><b>Application</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEW__APPLICATION = ABSTRACT_VIEW__APPLICATION;

	/**
	 * The number of structural features of the '<em>Static View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VIEW_FEATURE_COUNT = ABSTRACT_VIEW_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipsecon.acceleo.tutorial.webapp.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.Application <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Application</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Application
	 * @generated
	 */
	EClass getApplication();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getRouter <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Router</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Application#getRouter()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Router();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getCollections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collections</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Application#getCollections()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Collections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getModels <em>Models</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Models</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Application#getModels()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Models();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Views</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Application#getViews()
	 * @see #getApplication()
	 * @generated
	 */
	EReference getApplication_Views();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.Operation#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Operation#getParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipsecon.acceleo.tutorial.webapp.Reference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Reference#getType()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipsecon.acceleo.tutorial.webapp.Attribute#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Attribute#getDefaultValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.Model#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Model#getAttributes()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.Model#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Model#getReferences()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_References();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.Model#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Model#getOperations()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Operations();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipsecon.acceleo.tutorial.webapp.Model#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Application</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Model#getApplication()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Application();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.Collection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Collection
	 * @generated
	 */
	EClass getCollection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipsecon.acceleo.tutorial.webapp.Collection#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Collection#getModel()
	 * @see #getCollection()
	 * @generated
	 */
	EReference getCollection_Model();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipsecon.acceleo.tutorial.webapp.Collection#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Application</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Collection#getApplication()
	 * @see #getCollection()
	 * @generated
	 */
	EReference getCollection_Application();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.RouterMapping <em>Router Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Router Mapping</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.RouterMapping
	 * @generated
	 */
	EClass getRouterMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipsecon.acceleo.tutorial.webapp.RouterMapping#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.RouterMapping#getPath()
	 * @see #getRouterMapping()
	 * @generated
	 */
	EAttribute getRouterMapping_Path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipsecon.acceleo.tutorial.webapp.RouterMapping#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>View</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.RouterMapping#getView()
	 * @see #getRouterMapping()
	 * @generated
	 */
	EReference getRouterMapping_View();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.Router <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Router</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Router
	 * @generated
	 */
	EClass getRouter();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.Router#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mappings</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Router#getMappings()
	 * @see #getRouter()
	 * @generated
	 */
	EReference getRouter_Mappings();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipsecon.acceleo.tutorial.webapp.Router#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Application</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Router#getApplication()
	 * @see #getRouter()
	 * @generated
	 */
	EReference getRouter_Application();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView <em>Abstract View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract View</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.AbstractView
	 * @generated
	 */
	EClass getAbstractView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getDescription()
	 * @see #getAbstractView()
	 * @generated
	 */
	EAttribute getAbstractView_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operations</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getOperations()
	 * @see #getAbstractView()
	 * @generated
	 */
	EReference getAbstractView_Operations();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Application</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getApplication()
	 * @see #getAbstractView()
	 * @generated
	 */
	EReference getAbstractView_Application();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.ModelView <em>Model View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model View</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.ModelView
	 * @generated
	 */
	EClass getModelView();

	/**
	 * Returns the meta object for the reference '{@link org.eclipsecon.acceleo.tutorial.webapp.ModelView#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Collection</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.ModelView#getCollection()
	 * @see #getModelView()
	 * @generated
	 */
	EReference getModelView_Collection();

	/**
	 * Returns the meta object for class '{@link org.eclipsecon.acceleo.tutorial.webapp.StaticView <em>Static View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static View</em>'.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.StaticView
	 * @generated
	 */
	EClass getStaticView();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WebappFactory getWebappFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.NamedElement <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.NamedElement
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ApplicationImpl <em>Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ApplicationImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getApplication()
		 * @generated
		 */
		EClass APPLICATION = eINSTANCE.getApplication();

		/**
		 * The meta object literal for the '<em><b>Router</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__ROUTER = eINSTANCE.getApplication_Router();

		/**
		 * The meta object literal for the '<em><b>Collections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__COLLECTIONS = eINSTANCE.getApplication_Collections();

		/**
		 * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__MODELS = eINSTANCE.getApplication_Models();

		/**
		 * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPLICATION__VIEWS = eINSTANCE.getApplication_Views();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ParameterImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.OperationImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__PARAMETERS = eINSTANCE.getOperation_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ReferenceImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__TYPE = eINSTANCE.getReference_Type();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.AttributeImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__DEFAULT_VALUE = eINSTANCE.getAttribute_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ModelImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__ATTRIBUTES = eINSTANCE.getModel_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__REFERENCES = eINSTANCE.getModel_References();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__OPERATIONS = eINSTANCE.getModel_Operations();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__APPLICATION = eINSTANCE.getModel_Application();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.CollectionImpl <em>Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.CollectionImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getCollection()
		 * @generated
		 */
		EClass COLLECTION = eINSTANCE.getCollection();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION__MODEL = eINSTANCE.getCollection_Model();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION__APPLICATION = eINSTANCE.getCollection_Application();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.RouterMappingImpl <em>Router Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.RouterMappingImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getRouterMapping()
		 * @generated
		 */
		EClass ROUTER_MAPPING = eINSTANCE.getRouterMapping();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTER_MAPPING__PATH = eINSTANCE.getRouterMapping_Path();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTER_MAPPING__VIEW = eINSTANCE.getRouterMapping_View();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.RouterImpl <em>Router</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.RouterImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getRouter()
		 * @generated
		 */
		EClass ROUTER = eINSTANCE.getRouter();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTER__MAPPINGS = eINSTANCE.getRouter_Mappings();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTER__APPLICATION = eINSTANCE.getRouter_Application();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.AbstractViewImpl <em>Abstract View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.AbstractViewImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getAbstractView()
		 * @generated
		 */
		EClass ABSTRACT_VIEW = eINSTANCE.getAbstractView();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_VIEW__DESCRIPTION = eINSTANCE.getAbstractView_Description();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_VIEW__OPERATIONS = eINSTANCE.getAbstractView_Operations();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_VIEW__APPLICATION = eINSTANCE.getAbstractView_Application();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.ModelViewImpl <em>Model View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.ModelViewImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getModelView()
		 * @generated
		 */
		EClass MODEL_VIEW = eINSTANCE.getModelView();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_VIEW__COLLECTION = eINSTANCE.getModelView_Collection();

		/**
		 * The meta object literal for the '{@link org.eclipsecon.acceleo.tutorial.webapp.impl.StaticViewImpl <em>Static View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.StaticViewImpl
		 * @see org.eclipsecon.acceleo.tutorial.webapp.impl.WebappPackageImpl#getStaticView()
		 * @generated
		 */
		EClass STATIC_VIEW = eINSTANCE.getStaticView();

	}

} //WebappPackage
