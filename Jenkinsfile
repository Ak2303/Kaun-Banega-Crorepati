pipeline {
    agent {
        label 'android'
     }
    stages {
        stage('build') {
            steps {
                bat "echo 'Build Finish' "
            }
        stage('Permissions') {
              // This stage is set to access some permissions in Ubuntu machine
              steps {

                sh "echo '-------------------Asking for permissions--------------------'"

                sh 'ls -la ./gradlew'
                sh 'chmod +x ./gradlew'
                sh 'ls -la ./gradlew'
              }
              post {
                success {
                  // Notify permissions granted
                  sh "echo 'Permissions granted!!'"
                }
                failure {
                  // Notify permissions denied
                  sh "echo 'Oops!! Permissions denied.'"
                }
              }
            }

        }
    }
}