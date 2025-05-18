#!/user/bin/env groovy

Library identifier: 'jenkins-shared-library@main', retriever: modernSCM([
    $class: 'GitSCMSource', 
    remote: 'https://github.com/samsonojoMOOC/jenkins-shared-library.git'
    credentialsId: 'github-credential'   
])
def gv

pipeline {   
    agent any
    tools {
        maven 'maven-3.9.9'
    }

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("building jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage("building and pushing image") {
            steps {
                script {
                    buildImage 'samsonojo/demo-app:jma-3.3'
                    dockerLogin()
                    dockerPush 'samsonojo/demo-app:jma-3.3'
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
