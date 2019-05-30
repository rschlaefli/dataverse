describe('Log In', () => {
  beforeEach(function() {
    // visit the log in page
    cy.visit('/loginpage.xhtml')

    // should create a session cookie
    cy.getCookie('JSESSIONID').should('exist')

    // fill out the login form inputs
    cy.get('input[name="loginForm:credentialsContainer:0:credValue"]').type(
      'dataverseAdmin'
    )
    cy.get('input[name="loginForm:credentialsContainer:1:sCredValue"]').type(
      'admin1'
    )
  })

  it('enables logging in with the enter key', () => {
    // press enter
    cy.get('input[name="loginForm:credentialsContainer:1:sCredValue"]').type(
      '{enter}'
    )

    // should redirect to the dataverse root page
    cy.url().should('include', '/dataverse/root')

    // should show the user name in the navbar
    cy.get('span[id=userDisplayInfoTitle]').should('contain', 'Dataverse Admin')
  })

  it('enables logging in by clicking the submit button', () => {
    // click the login button
    cy.get('button[name="loginForm:login').click()

    // should redirect to the dataverse root page
    cy.url().should('include', '/dataverse/root')

    // should show the user name in the navbar
    cy.get('span[id=userDisplayInfoTitle]').should('contain', 'Dataverse Admin')
  })
})
