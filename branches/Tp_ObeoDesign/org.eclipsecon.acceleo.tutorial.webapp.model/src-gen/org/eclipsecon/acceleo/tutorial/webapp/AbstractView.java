/**
 */
package org.eclipsecon.acceleo.tutorial.webapp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getAbstractView()
 * @model abstract="true"
 * @generated
 */
public interface AbstractView extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getAbstractView_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipsecon.acceleo.tutorial.webapp.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' reference list.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getAbstractView_Operations()
	 * @model
	 * @generated
	 */
	EList<Operation> getOperations();

	/**
	 * Returns the value of the '<em><b>Application</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getViews <em>Views</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' container reference.
	 * @see #setApplication(Application)
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getAbstractView_Application()
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Application#getViews
	 * @model opposite="views" transient="false"
	 * @generated
	 */
	Application getApplication();

	/**
	 * Sets the value of the '{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getApplication <em>Application</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' container reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(Application value);

} // AbstractView
