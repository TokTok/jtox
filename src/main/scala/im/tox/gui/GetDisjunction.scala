package im.tox.gui

import im.tox.core.error.CoreError

import scala.language.implicitConversions
import scalaz.{ -\/, \/, \/- }

final case class GetDisjunction[T] private (disjunction: CoreError \/ T) {
  def get: T = {
    disjunction match {
      case -\/(error)   => throw new RuntimeException(error.toString)
      case \/-(success) => success
    }
  }
}

object GetDisjunction {

  @SuppressWarnings(Array("org.wartremover.warts.ImplicitConversion"))
  implicit def toGetDisjunction[T](disjunction: CoreError \/ T): GetDisjunction[T] = GetDisjunction(disjunction)

}
