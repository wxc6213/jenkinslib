package org.devops

def Build(buildType,buildShell){
  def buildTools = ["mvn":"maven","gradle":"gradle","npm":"npm"]
  println("当前选择的构建类型为${buildType}")
  buildHome = tool buildTools[buildType]
  sh "${buildHome}/bin/${buildType} ${buildShell}"
}
