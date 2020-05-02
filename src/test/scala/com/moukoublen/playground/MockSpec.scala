package com.moukoublen.playground

import org.scalatest._

class MockSpec extends FunSuite with DiagrammedAssertions {
  test("1+1 should be 2") {
    assert((1+1) == 2)
  }
}
