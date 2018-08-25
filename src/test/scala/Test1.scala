import minitest.api.SourceLocation

import org.junit.Test
import org.junit.Assert._

class Test1 {
  @Test def test(): Unit = {
    assertEquals(Some("Test1.scala"), implicitly[SourceLocation].fileName)
    assertEquals(9, implicitly[SourceLocation].line)
    assertEquals(10, implicitly[SourceLocation].line)
    assertEquals(11, implicitly[SourceLocation].line)
    assertEquals(12, implicitly[SourceLocation].line)
  }
}