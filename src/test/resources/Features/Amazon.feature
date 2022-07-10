Feature: feature on assignment

  #Scenario: Checking out with a product with a valid postal code
    #Given Open Chrome browser
    #Then Go to amazon.in
    #Then Login into the amazon
    #Then Search for shoes from search bar
    #Then click on the first product from the result
    #Then Add shoes to cart and proceed to checkout with a valid address
    #Then Close the browser

  Scenario: Checking out with a product with a valid postal code
    Given Open Chrome browser
    Then Go to amazon.in
    Then Login into the amazon
    Then Search for shoes from search bar
    Then click on the first product from the result
    Then Add shoes to cart and proceed to checkout with a Invalid address
    Then Close the browser