describe('Log In', () => {
  it('successfully authenticates a valid admin user', () => {
    // visit the log in page
    cy.visit('/loginpage.xhtml')

    // fill out the login form inputs
    cy.get('input[name="loginForm:credentialsContainer:0:credValue"]').type(
      'dataverseAdmin'
    )
    cy.get('input[name="loginForm:credentialsContainer:1:sCredValue"]').type(
      'admin1{enter}'
    )

    // should redirect to the dataverse root page
    cy.url().should('include', '/dataverse/root')

    // should create a session cookie
    cy.getCookie('JSESSIONID').should('exist')

    // should show the user name in the navbar
    cy.get('span[id=userDisplayInfoTitle]').should('contain', 'Dataverse Admin')
  })

  /* it('prevents login with an invalid username', () => {
    // visit the log in page
    cy.visit('/loginpage.xhtml')

    // fill out the login form inputs
    cy.get('input[name="loginForm:credentialsContainer:0:credValue"]').type(
      'inexistentUser'
    )
    cy.get('input[name="loginForm:credentialsContainer:1:sCredValue"]').type(
      'admin1'
    )

    // should redirect to the dataverse root page
    cy.url().should('include', '/dataverse/root')
  }) */
})
