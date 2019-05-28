describe('Root', function() {
  beforeEach(function() {
    cy.visit('/loginpage.xhtml')

    // should create a session cookie
    cy.getCookie('JSESSIONID').should('exist')

    // get the current session id from the session cookie
    cy.getCookie('JSESSIONID').then(cookie => {
      cy.get('#loginForm input[name="javax.faces.ViewState"]').then(
        viewState => {
          cy.request({
            method: 'POST',
            url: `http://localhost:8084/loginpage.xhtml;${cookie.value}`,
            form: true,
            body: {
              'javax.faces.partial.ajax': true,
              'javax.faces.source:loginForm': 'login',
              'javax.faces.partial.execute': '@all',
              'javax.faces.partial.render': '@all',
              'loginForm:login': 'loginForm:login',
              loginForm: 'loginForm',
              'loginForm:credentialsContainer:0:credValue': 'dataverseAdmin',
              'loginForm:credentialsContainer:1:sCredValue': 'admin1',
              'javax.faces.ViewState': viewState.value,
            },
          }).then(response => {
            cy.log(response)
            cy.visit('/dataverse/root')
          })
        }
      )
    })
  })

  it('works', function() {})
})
