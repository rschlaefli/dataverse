describe('Password Reset', function() {
  it.skip('allows the user to request a password', function() {
    cy.visit('/passwordreset.xhtml')

    // TODO: this breaks due to the page being redirected
    cy.get('input[name="passwordReset:email"]').type(
      'dataverse@mailinator.com{enter}'
    )
  })
})
