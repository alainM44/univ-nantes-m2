/**
 */
package org.eclipsecon.acceleo.tutorial.webapp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getRouter <em>Router</em>}</li>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getCollections <em>Collections</em>}</li>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getModels <em>Models</em>}</li>
 *   <li>{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getViews <em>Views</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getApplication()
 * @model
 * @generated
 */
public interface Application extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Router</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipsecon.acceleo.tutorial.webapp.Router#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Router</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Router</em>' containment reference.
	 * @see #setRouter(Router)
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getApplication_Router()
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Router#getApplication
	 * @model opposite="application" containment="true" required="true"
	 * @generated
	 */
	Router getRouter();

	/**
	 * Sets the value of the '{@link org.eclipsecon.acceleo.tutorial.webapp.Application#getRouter <em>Router</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Router</em>' containment reference.
	 * @see #getRouter()
	 * @generated
	 */
	void setRouter(Router value);

	/**
	 * Returns the value of the '<em><b>Collections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipsecon.acceleo.tutorial.webapp.Collection}.
	 * It is bidirectional and its opposite is '{@link org.eclipsecon.acceleo.tutorial.webapp.Collection#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collections</em>' containment reference list.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getApplication_Collections()
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Collection#getApplication
	 * @model opposite="application" containment="true"
	 * @generated
	 */
	EList<Collection> getCollections();

	/**
	 * Returns the value of the '<em><b>Models</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipsecon.acceleo.tutorial.webapp.Model}.
	 * It is bidirectional and its opposite is '{@link org.eclipsecon.acceleo.tutorial.webapp.Model#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' containment reference list.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getApplication_Models()
	 * @see org.eclipsecon.acceleo.tutorial.webapp.Model#getApplication
	 * @model opposite="application" containment="true"
	 * @generated
	 */
	EList<Model> getModels();

	/**
	 * Returns the value of the '<em><b>Views</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView}.
	 * It is bidirectional and its opposite is '{@link org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Views</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Views</em>' containment reference list.
	 * @see org.eclipsecon.acceleo.tutorial.webapp.WebappPackage#getApplication_Views()
	 * @see org.eclipsecon.acceleo.tutorial.webapp.AbstractView#getApplication
	 * @model opposite="application" containment="true"
	 * @generated
	 */
	EList<AbstractView> getViews();

} // Application
