describe('Password Reset', function() {
  it('allows the user to request a password', function() {
    cy.visit('/passwordreset.xhtml')

    cy.get('input[name="passwordReset:email"]').type(
      'dataverse@mailinator.com{enter}'
    )
  })
})
