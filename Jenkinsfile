pipeline {
  agent any
  parameters{
    choice(name: 'VERSION', choices: ['1.2.0', '1.3.0', '1.4.0'], description: 'version to deploy to prod')
    booleanParam(name: 'executeTest', defaultValue: true, description:'')
  }


  stages{
    stage("build"){
      steps{
        echo 'building the application...'
        echo "building version "${NEW_VERSION}
      }
    }
    stage("test"){
        when {
            expression{
                params.executeTest == true
            }
        }
      steps{
        echo 'testing the application...'
      }
    }
    stage("deploy"){
      steps{
        echo 'deploying the application...'
        echo "deploying version: "${params.VERSION}
      }
    }
  }
}
