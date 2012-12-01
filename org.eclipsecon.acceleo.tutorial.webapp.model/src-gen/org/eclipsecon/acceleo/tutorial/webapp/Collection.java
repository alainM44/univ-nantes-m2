/**
 */
package org.eclipsecon.acceleo.tutorial.webapp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.Collection#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.Collection#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getCollection()
 * @model
 * @generated
 */
public interface Collection extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(Model)
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getCollection_Model()
	 * @model
	 * @generated
	 */
	Model getModel();

	/**
	 * Sets the value of the '{@link org.eclipsecon.acceleo.tutorial.webapp.Collection#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Model value);

	/**
	 * Returns the value of the '<em><b>Application</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getCollections <em>Collections</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' container reference.
	 * @see #setApplication(Application)
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getCollection_Application()
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Application#getCollections
	 * @model opposite="collections" transient="false"
	 * @generated
	 */
	Application getApplication();

	/**
	 * Sets the value of the '{@link org.eclipsecon.acceleo.tutorial.webapp.Collection#getApplication <em>Application</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' container reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(Application value);

} // Collection
