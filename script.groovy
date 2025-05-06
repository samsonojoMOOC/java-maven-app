def buildJarApp(){
    echo "building the application jar..."
    sh 'mvn package'
}

def buildImageApp(){
       echo "building the docker image..."
        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]){
            sh 'docker build -t samsonojo/demo-app:jma-2.2 .'
            sh 'echo $PASS | docker login -u $USER --password-stdin' 
            sh 'docker push samsonojo/demo-app:jma-2.2'
        }
}

def deployApp(){
    echo "deploying the application..."
}

return this
