package minitest.api

import scala.quoted._
import scala.tasty._

final case class SourceLocation(
  fileName: Option[String],
  filePath: Option[String],
  line: Int
)

object SourceLocation {
  implicit transparent def fromContext: SourceLocation = ~fromContextImpl(TopLevelSplice.tastyContext)

  def fromContextImpl(implicit tasty: Tasty): Expr[SourceLocation] = {
    val (fileName, path, line) = getSourceLocation
    '(SourceLocation(Some(~fileName.toExpr), Some(~path.toExpr), ~line.toExpr))
  }

  private def getSourceLocation(implicit tasty: Tasty): (String, String, Int) = {
    import tasty._
    val pos = tasty.rootPosition
    val file = pos.sourceFile
    (file.getFileName.toString, file.getParent.toString, pos.startLine + 1)
  }

}