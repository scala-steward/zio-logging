package zio.logging

import zio.ZIO
import zio.test._

object AppendLoggerNameSpec extends ZIOSpecDefault {

  val spec: Spec[Environment, Any] = suite("AppendLoggerNameSpec")(
    test("appendLoggerName") {
      for {
        name <- ZIO.logAnnotations.map(annotations => annotations.get(loggerNameAnnotationKey)) @@ appendLoggerName(
                  "logging"
                ) @@ appendLoggerName("zio")

      } yield assertTrue(name == Some("zio.logging"))
    }
  )
}
