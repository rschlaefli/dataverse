describe('Password Reset', function() {
  // TODO: this breaks due to the page being redirected
  it.skip('allows the user to request a password', function() {
    cy.visit('/passwordreset.xhtml')

    cy.get('input[name="passwordReset:email"]').type(
      'dataverse@mailinator.com{enter}'
    )
  })
})
