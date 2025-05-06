def gv

pipeline {   
    agent any
    tools {
        maven 'maven-3.9.9'
    }
    stages {
        stage("init stage") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build-jar") {
            steps {
                script {
                    gv.buildJarApp()

                }
            }
        }
                stage("build image") {
            steps {
                script {
                 gv.buildImageApp()

                }
   
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()

                }
   
            }
        }

              
    }
} 
