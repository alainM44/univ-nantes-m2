/**
 */
package org.eclipsecon.acceleo.tutorial.webapp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Router</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.Router#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.Router#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getRouter()
 * @model
 * @generated
 */
public interface Router extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' reference list.
	 * The list contents are of type {@link org.eclipsecon.acceleo.tutorial.webapp.RouterMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' reference list.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getRouter_Mappings()
	 * @model
	 * @generated
	 */
	EList<RouterMapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Application</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getRouter <em>Router</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' container reference.
	 * @see #setApplication(Application)
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getRouter_Application()
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Application#getRouter
	 * @model opposite="router" transient="false"
	 * @generated
	 */
	Application getApplication();

	/**
	 * Sets the value of the '{@link org.eclipsecon.acceleo.tutorial.webapp.Router#getApplication <em>Application</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' container reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(Application value);

} // Router
