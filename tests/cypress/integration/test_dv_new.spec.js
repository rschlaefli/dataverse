import { login } from '../util'

describe('New Dataverse', function() {
  beforeEach(function() {
    login(cy)
  })

  it('allows dataverse creation with minimal inputs', function() {
    cy.visit('/dataverse.xhtml?ownerId=1')

    cy.get('input[id="dataverseForm:name"]').should(
      'have.value',
      'Dataverse Admin Dataverse'
    )

    cy.get('input[id="dataverseForm:identifier"]').should('be.empty')

    cy.get('select[id="dataverseForm:dataverseCategory"]').should(
      'have.value',
      ''
    )

    cy.get('input[id="dataverseForm:affiliation"]').should(
      'have.value',
      'Dataverse.org'
    )

    cy.get('textarea[id="dataverseForm:description"]').should('be.empty')

    cy.get('input[id="dataverseForm:metadataRoot"]').should('be.checked')

    cy.get('input[id="dataverseForm:facetsRoot"]').should('be.checked')

    cy.contains('Create Dataverse').click()
  })
})
