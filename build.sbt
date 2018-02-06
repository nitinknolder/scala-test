
name := "Scala-Test-KnolKart"

version := "0.1"

scalaVersion := "2.12.4"

coverageEnabled := true

lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.12.3",
  libraryDependencies += "log4j" % "log4j" % "1.2.17",
  libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test"

)


lazy val checkoutService = project.
  settings(
    commonSettings
  )

lazy val inventoryService = project.
  settings(
    commonSettings
  )

lazy val accountService = project.
  settings(
    commonSettings
  )
lazy val apiResources = project.
  dependsOn(checkoutService,inventoryService,accountService)
  .settings(
    commonSettings
  )

lazy val knolcartDashboard = project.
  dependsOn(apiResources).
  settings(
    commonSettings
  )

lazy val root = (project in file(".")).
  aggregate(accountService, apiResources, checkoutService, inventoryService, knolcartDashboard )




