def gv

pipeline {
  agent any
  parameters{
    choice(name: 'VERSION', choices: ['1.2.0', '1.3.0', '1.4.0'], description: 'version to deploy to prod')
    booleanParam(name: 'executeTest', defaultValue: true, description:'')
  }

  stages{
    stage("init"){
      steps{
        script{
            gv = load "script.groovy"
        }
      }
    }
    stage("build"){
      steps{
        script{
            gv.buildApp()
        }
      }
    }
    stage("test"){
        when {
            expression{
                params.executeTest == true
            }
        }
      steps{
        script{
            gv.testApp()
        }
      }
    }
    stage("deploy"){
      steps{
        script {
            gv.deployApp()
        }

      }
    }
  }
}
